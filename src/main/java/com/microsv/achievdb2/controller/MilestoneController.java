package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.service.AchievementService;
import com.microsv.achievdb2.service.MilestoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;
    private final AchievementService achievementService;

    public MilestoneController(MilestoneService milestoneService, AchievementService achievementService) {
        this.milestoneService = milestoneService;
        this.achievementService = achievementService;
    }

    @GetMapping("/{ach_id}")
    public List<Milestone> getAllMilestonesByAchievement(@PathVariable long ach_id) {
        return milestoneService.getAllMilestonesByAchievement(ach_id);
    }

    @PostMapping( value = {"/create-mil"})
    public void createMilestone(@RequestBody int num, long achId) {
        Achievement achievement = achievementService.findById(achId);
        Milestone milestone = milestoneService.makeMilestone(num, achievement);
        milestoneService.save(milestone);
    }

}
