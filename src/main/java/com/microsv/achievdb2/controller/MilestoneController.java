package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.AchievementPOJO;
import com.microsv.achievdb2.pojo.MilestonePOJO;
import com.microsv.achievdb2.service.AchievementService;
import com.microsv.achievdb2.service.MilestoneService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    public MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/{ach_id}")
    public List<Milestone> getAllMilestonesByAchievement(@PathVariable int ach_id) {
        return milestoneService.getAllMilestonesByAchievement(ach_id);
    }

    @PostMapping(value = { "/create-mil" })
    public void createMilestone(@RequestBody MilestonePOJO body) {
        Milestone milestone = milestoneService.makeMilestone(body);
        milestoneService.save(milestone);
    }

    @DeleteMapping("/{mil_id}")
    public ResponseEntity<?> deleteMilestione(@PathVariable Long mil_id) {
        if (milestoneService.findById(mil_id)==null) {
            return null;
        }
        milestoneService.deleteMilestone(mil_id);
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @PatchMapping("/{mil_id}")
    public ResponseEntity<Milestone> upd(
            @PathVariable Long mil_id,
            @RequestBody MilestonePOJO body) {
        if (milestoneService.findById(mil_id)==null) {
            return null;
        }
        Milestone milestone = milestoneService.updateMilestone(mil_id, body);
        milestoneService.save(milestone);
        return ResponseEntity.ok(milestone);
    }

}
