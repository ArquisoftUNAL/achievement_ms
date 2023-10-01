package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.AchievementPOJO;
import com.microsv.achievdb2.pojo.MilestonePOJO;
import com.microsv.achievdb2.pojo.PatchPairPOJO;
import com.microsv.achievdb2.pojo.PatchStreakPOJO;
import com.microsv.achievdb2.repository.AchievementRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
public class AchievementService {

    private AchievementRepository achievementRepository;
    private MilestoneService milestoneService;

    public AchievementService(AchievementRepository achievementRepository, MilestoneService milestoneService) {
        this.achievementRepository = achievementRepository;
        this.milestoneService = milestoneService;
    }

    public Achievement findById(String id) {
        return achievementRepository.findById(id).orElse(null);
    }

    public List<Achievement> getAllAchievementsByHabit(String hab_id, int page, int per_page) {
        return achievementRepository.getAllAchievementsByHabit(hab_id,(page-1)*per_page, per_page);
    }

    public List<Achievement> getAllAchievementsByHabit(String hab_id) {
        return achievementRepository.getAllAchievementsByHabit(hab_id);
    }

    public Achievement updateAchievement(String ach_id, AchievementPOJO achievementPOJO) {
        Achievement achievement = findById(ach_id);
        achievement.setName(achievementPOJO.getName() != null ? achievementPOJO.getName() : achievement.getName());
        achievement
                .setCurrentStreak(achievementPOJO.getCurrentStreak() != null ? achievementPOJO.getCurrentStreak() : achievement.getCurrentStreak());
        achievement
                .setHighestStreak(achievementPOJO.getHighestStreak() != null ? achievementPOJO.getHighestStreak() : achievement.getHighestStreak());
        achievement.setLastCollection(LocalDate.now());

        return achievement;
    }

    public void deleteAchievement(String ach_id) {
        achievementRepository.deleteById(ach_id);
    }

    public void save(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public Achievement makeAchievement(AchievementPOJO achievementPOJO) {
        Achievement achievement = new Achievement();
        String name = achievementPOJO.getName();
        String habId = achievementPOJO.getHabId();
        if (name == null || habId == null) {
            return null;
        }
        achievement.setName(name);
        achievement.setCurrentStreak(0.0);
        achievement.setHighestStreak(0.0);
        achievement.setLastCollection(LocalDate.now());
        achievement.setHabit(habId);
        return achievement;
    }

    public Achievement updateStreak(String ach_id, boolean retain_streak) {
        Achievement achievement = findById(ach_id);
        if (retain_streak) {
            achievement.setCurrentStreak(achievement.getCurrentStreak()+1);
            if (achievement.getHighestStreak() < achievement.getCurrentStreak()) {
                achievement.setHighestStreak(achievement.getCurrentStreak());
            }
        } else {
            achievement.setCurrentStreak(0.0);
        }
        achievement.setLastCollection(LocalDate.now());

        return achievement;
    }

    // Ckeck habit recurrency. If streak not broken, check if new current streak qualifies for a milestone to create it,
    // then update streak
    public PatchPairPOJO patchStreak(Achievement achievement, PatchStreakPOJO update_info) {
        List<Milestone> milestoneList = Collections.<Milestone>emptyList();
        switch (update_info.getFreq_type()) {
            case "daily" -> {
                if (LocalDate.now().compareTo(update_info.getStreak().getDate_end()) < 2) {
                    double newStreak = update_info.getStreak().getData();
                    double oldStreak = achievement.getCurrentStreak();
                    double[] milestoneObjectiveList = {2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0, 1000.0};
                    for (double i : milestoneObjectiveList) {
                        if (oldStreak < i && newStreak >= i) {
                            Milestone milestone = milestoneService.makeMilestone(new MilestonePOJO((int) i, achievement.getId(), update_info.getStreak().getDate_end()));
                            milestoneService.save(milestone);
                            milestoneList.add(milestone);
                        }
                    }
                    achievement.setCurrentStreak(update_info.getStreak().getData());
                    if (achievement.getHighestStreak() < achievement.getCurrentStreak()) {
                        achievement.setHighestStreak(achievement.getCurrentStreak());
                    }
                } else {
                    achievement.setCurrentStreak(0.0);
                }
            }
            case "weekly" -> {
                int weekday = update_info.getStreak().getDate_end().getDayOfWeek().getValue();
                if (!LocalDate.now().isAfter(update_info.getStreak().getDate_end().plusDays(15 - weekday))) {
                    double newStreak = update_info.getStreak().getData();
                    double oldStreak = achievement.getCurrentStreak();
                    double[] milestoneObjectiveList = {2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0, 1000.0};
                    for (double i : milestoneObjectiveList) {
                        if (oldStreak < i && newStreak >= i) {
                            Milestone milestone = milestoneService.makeMilestone(new MilestonePOJO((int) i, achievement.getId(), update_info.getStreak().getDate_end()));
                            milestoneService.save(milestone);
                            milestoneList.add(milestone);
                        }
                    }
                    achievement.setCurrentStreak(update_info.getStreak().getData());
                    if (achievement.getHighestStreak() < achievement.getCurrentStreak()) {
                        achievement.setHighestStreak(achievement.getCurrentStreak());
                    }
                } else {
                    achievement.setCurrentStreak(0.0);
                }
            }
            case "monthly" -> {
                int monthDay = update_info.getStreak().getDate_end().getDayOfMonth();
                if (!LocalDate.now().isAfter(update_info.getStreak().getDate_end().plusMonths(2).minusDays(monthDay - 1))) {
                    double newStreak = update_info.getStreak().getData();
                    double oldStreak = achievement.getCurrentStreak();
                    double[] milestoneObjectiveList = {2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0, 1000.0};
                    for (double i : milestoneObjectiveList) {
                        if (oldStreak < i && newStreak >= i) {
                            Milestone milestone = milestoneService.makeMilestone(new MilestonePOJO((int) i, achievement.getId(), update_info.getStreak().getDate_end()));
                            milestoneService.save(milestone);
                            milestoneList.add(milestone);
                        }
                    }
                    achievement.setCurrentStreak(update_info.getStreak().getData());
                    if (achievement.getHighestStreak() < achievement.getCurrentStreak()) {
                        achievement.setHighestStreak(achievement.getCurrentStreak());
                    }
                } else {
                    achievement.setCurrentStreak(0.0);
                }
            }
            case "yearly" -> {
                int monthDay = update_info.getStreak().getDate_end().getDayOfMonth();
                int monthOfYear = update_info.getStreak().getDate_end().getMonthValue();
                if (!LocalDate.now().isAfter(update_info.getStreak().getDate_end().plusYears(2).minusDays(monthDay - 1).minusMonths(monthOfYear - 1))) {
                    double newStreak = update_info.getStreak().getData();
                    double oldStreak = achievement.getCurrentStreak();
                    double[] milestoneObjectiveList = {2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0, 500.0, 1000.0};
                    for (double i : milestoneObjectiveList) {
                        if (oldStreak < i && newStreak >= i) {
                            Milestone milestone = milestoneService.makeMilestone(new MilestonePOJO((int) i, achievement.getId(), update_info.getStreak().getDate_end()));
                            milestoneService.save(milestone);
                            milestoneList.add(milestone);
                        }
                    }
                    achievement.setCurrentStreak(update_info.getStreak().getData());
                    if (achievement.getHighestStreak() < achievement.getCurrentStreak()) {
                        achievement.setHighestStreak(achievement.getCurrentStreak());
                    }
                } else {
                    achievement.setCurrentStreak(0.0);
                }
            }
        }
        return new PatchPairPOJO(achievement, milestoneList);
    }

}
