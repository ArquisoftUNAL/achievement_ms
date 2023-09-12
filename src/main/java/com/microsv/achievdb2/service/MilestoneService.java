package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.MilestonePOJO;
import com.microsv.achievdb2.repository.AchievementRepository;
import com.microsv.achievdb2.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MilestoneService {

    private MilestoneRepository milestoneRepository;
    private AchievementRepository achievementRepository;

    public MilestoneService(MilestoneRepository milestoneRepository, AchievementRepository achievementRepository) {
        this.milestoneRepository = milestoneRepository;
        this.achievementRepository = achievementRepository;
    }

    public List<Milestone> getAllMilestonesByAchievement(long ach_id) {
        return milestoneRepository.getAllMilestonesByAchievement(ach_id);
    }

    public void save(Milestone milestone) {
        milestoneRepository.save(milestone);
    }

    public void deleteMilestone(Long mil_id) {
        milestoneRepository.deleteById(mil_id);
    }

    public Milestone updateMilestone(Long mil_id, MilestonePOJO milestonePOJO) {
        Milestone milestone = milestoneRepository.findById(mil_id).orElse(null);

        if (milestone == null) {
            return null;
        }

        // Get reference to achievement
        Achievement achievement = achievementRepository.findById(milestonePOJO.getAchId()).orElse(null);
        milestone.setAchievement(achievement);
        milestone.setDate(new Date());
        milestone.setStreak(milestone.getStreak());
        return milestone;
    }

    public Milestone makeMilestone(MilestonePOJO milestonePOJO) {

        // Get reference to achievement
        Achievement achievement = achievementRepository.findById(milestonePOJO.getAchId()).orElse(null);

        Milestone milestone = new Milestone();
        milestone.setStreak(milestonePOJO.getStreak());
        milestone.setDate(new Date());
        milestone.setAchieved(false);
        milestone.setAchievement(achievement);
        return milestone;
    }

}
