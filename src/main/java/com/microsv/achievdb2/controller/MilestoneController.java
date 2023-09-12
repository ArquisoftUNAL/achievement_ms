package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.MilestonePOJO;
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
    public List<Milestone> getAllMilestonesByAchievement(@PathVariable int ach_id) {
        return milestoneService.getAllMilestonesByAchievement(ach_id);
    }

    @PostMapping(value = { "/create-mil" })
    public void createMilestone(@RequestBody MilestonePOJO body) {
        Achievement achievement = achievementService.findById(body.achId);
        Milestone milestone = milestoneService.makeMilestone(body.num, achievement);
        milestoneService.save(milestone);
    }

}
