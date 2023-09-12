package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.AchievementPOJO;
import com.microsv.achievdb2.pojo.DataIncomingPOJO;
import com.microsv.achievdb2.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    private AchievementRepository achievementRepository;
    private MilestoneService milestoneService;

    public AchievementService(AchievementRepository achievementRepository, MilestoneService milestoneService) {
        this.achievementRepository = achievementRepository;
        this.milestoneService = milestoneService;
    }

    public Achievement findById(long id) {
        return achievementRepository.findById(id).orElse(null);
    }

    public List<Achievement> getAllAchievementsByHabit(String hab_id) {
        return achievementRepository.getAllAchievementsByHabit(hab_id);
    }

    public Achievement updateAchievement(Long ach_id, AchievementPOJO achievementPOJO) {
        Achievement achievement = findById(ach_id);
        achievement.setName(achievementPOJO.getName() != null ? achievementPOJO.getName() : achievement.getName());
        achievement
                .setHabit(achievementPOJO.getHabId() != null ? achievementPOJO.getHabId() : achievement.getHabit());

        return achievement;
    }

    public void dataCollected(DataIncomingPOJO body) {
        List<Achievement> achievements = getAllAchievementsByHabit(body.getHabId());

        for (Achievement achievement : achievements) {

            Milestone milestone = new Milestone();
            milestone.setDate(body.getDataCollected());
            milestone.setAchievement(achievement);

            if (achievement.getCurrentStreak() == 0) {
                achievement.setCurrentStreak(1);
                achievement.setHighestStreak(1);
                milestone.setStreak(1);
            } else {
                achievement.setCurrentStreak(achievement.getCurrentStreak() + 1);
                milestone.setStreak(achievement.getCurrentStreak());
                if (achievement.getCurrentStreak() > achievement.getHighestStreak()) {
                    achievement.setHighestStreak(achievement.getCurrentStreak());
                    milestone.setStreak(achievement.getCurrentStreak());
                }
            }

            save(achievement);
            milestoneService.save(milestone);
        }
    }

    public void deleteAchievement(Long ach_id) {
        achievementRepository.deleteById(ach_id);
    }

    public void save(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public Achievement makeAchievement(AchievementPOJO achievementPOJO) {
        Achievement achievement = new Achievement();
        achievement.setName(achievementPOJO.getName());
        achievement.setCurrentStreak(0);
        achievement.setHighestStreak(0);
        achievement.setHabit(achievementPOJO.getHabId());
        return achievement;
    }

}
