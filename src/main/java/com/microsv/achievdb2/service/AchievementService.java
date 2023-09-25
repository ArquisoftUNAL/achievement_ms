package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.pojo.AchievementPOJO;
import com.microsv.achievdb2.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
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

}
