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

    private final MilestoneRepository milestoneRepository;
    private final AchievementRepository achievementRepository;

    public MilestoneService(MilestoneRepository milestoneRepository, AchievementRepository achievementRepository) {
        this.milestoneRepository = milestoneRepository;
        this.achievementRepository = achievementRepository;
    }

    public Milestone findById(String id) {
        return milestoneRepository.findById(id).orElse(null);
    }

    public List<Milestone> getAllMilestonesByAchievement(String ach_id) {
        return milestoneRepository.getAllMilestonesByAchievement(ach_id);
    }

    public void save(Milestone milestone) {
        milestoneRepository.save(milestone);
    }

    public void deleteMilestone(String mil_id) {
        milestoneRepository.deleteById(mil_id);
    }

    public Milestone updateMilestone(String mil_id, MilestonePOJO milestonePOJO) {
        Milestone milestone = findById(mil_id);
        milestone.setDate(milestonePOJO.getDate());
        milestone.setStreak(milestone.getStreak());
        return milestone;
    }

    public Milestone makeMilestone(MilestonePOJO milestonePOJO) {

        // Get reference to achievement
        Achievement achievement = achievementRepository.findById(milestonePOJO.getAchId()).orElse(null);

        Milestone milestone = new Milestone();
        milestone.setStreak(milestonePOJO.getStreak());
        milestone.setDate(milestonePOJO.getDate());
        milestone.setAchievement(achievement);
        return milestone;
    }

}
