package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.pojo.AchievementPOJO;
import com.microsv.achievdb2.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    private AchievementRepository achievementRepository;

    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public Achievement findById(long id) {
        return achievementRepository.findById(id).orElse(null);
    }

    public List<Achievement> getAllAchievementsByHabit(String hab_id) {
        return achievementRepository.getAllAchievementsByHabit(hab_id);
    }

    public Achievement updateAchievement(Long ach_id, AchievementPOJO body) {
        Achievement achievement = findById(ach_id);
        achievement.setName(body.name == null ? body.name : achievement.getName());
        achievement.setHabit(body.habId == null ? body.habId : achievement.getHabit());
        return achievement;
    }

    public void deleteAchievement(Long ach_id) {
        achievementRepository.deleteById(ach_id);
    }

    public void save(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public Achievement makeAchievement(AchievementPOJO body) {
        Achievement achievement = new Achievement();
        achievement.setName(body.name);
        achievement.setCurrentStreak(0);
        achievement.setHighestStreak(0);
        achievement.setHabit(body.habId);
        return achievement;
    }

}
