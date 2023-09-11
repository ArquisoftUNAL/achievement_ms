package com.microsv.achievdb2.service;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.repository.AchievementRepository;
import com.microsv.achievdb2.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MilestoneService {

    private MilestoneRepository milestoneRepository;

    public MilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public List<Milestone> getAllMilestonesByAchievement(long ach_id) {
        return milestoneRepository.getAllMilestonesByAchievement(ach_id);
    }

    public void save(Milestone milestone) {
        milestoneRepository.save(milestone);
    }

    public Milestone makeMilestone(int num, Achievement achievement) {
        Milestone milestone = new Milestone();
        milestone.setStreak(num);
        milestone.setDate(new Date());
        milestone.setAchieved(false);
        milestone.setAchievement(achievement);
        return milestone;
    }

}
