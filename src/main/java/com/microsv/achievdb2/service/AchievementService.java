package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    private AchievementRepository achievementRepository;

    public Achievement findById(long id) {
        return achievementRepository.findById(id).orElse( null );
    }

    public List<Achievement> getAllAchievementsByHabit(long hab_id) {
        return achievementRepository.getAllAchievementsByHabit(hab_id);
    }

    public void save(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public Achievement makeAchievement(String name, long habId) {
        Achievement achievement = new Achievement();
        achievement.setName(name);
        achievement.setCurrentStreak(0);
        achievement.setHighestStreak(0);
        achievement.setHabit(habId);
        return achievement;
    }

}
