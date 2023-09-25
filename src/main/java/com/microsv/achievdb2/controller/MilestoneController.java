package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.*;
import com.microsv.achievdb2.service.AchievementService;
import com.microsv.achievdb2.service.MilestoneService;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<MilestoneListResponsePOJO> getAllMilestonesByAchievement(@PathVariable String ach_id) {
        return new ResponseEntity<>(new MilestoneListResponsePOJO("Milestones found", milestoneService.getAllMilestonesByAchievement(ach_id)), HttpStatus.OK);
    }

    @PostMapping(value = { "/create-mil" })
    public ResponseEntity<MessageResponsePOJO> createMilestone(@RequestBody MilestonePOJO body) {
        Milestone milestone = milestoneService.makeMilestone(body);
        if (milestone == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: could not create milestone"), HttpStatus.BAD_REQUEST);
        }
        milestoneService.save(milestone);
        return new ResponseEntity<>(new MessageResponsePOJO("Milestone created"), HttpStatus.CREATED);
    }

    @DeleteMapping("/del-mil")
    public ResponseEntity<MessageResponsePOJO> deleteMilestione(@RequestHeader ("mil-id") String mil_id) {
        if (milestoneService.findById(mil_id)==null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Milestone does not exist"), HttpStatus.NOT_FOUND);
        }
        milestoneService.deleteMilestone(mil_id);
        return new ResponseEntity<>(new MessageResponsePOJO("Milestone deleted"), HttpStatus.OK);
    }

    @PatchMapping("/patch-mil")
    public ResponseEntity<MilestoneResponsePOJO> updateMilestone(
            @RequestHeader ("mil-id") String mil_id,
            @RequestBody MilestonePOJO body) {
        if (milestoneService.findById(mil_id)==null) {
            return new ResponseEntity<>(new MilestoneResponsePOJO("Milestone does not exist", null), HttpStatus.NOT_FOUND);
        }
        Milestone milestone = milestoneService.updateMilestone(mil_id, body);
        milestoneService.save(milestone);
        return new ResponseEntity<>(new MilestoneResponsePOJO("Milestone updated", milestone), HttpStatus.OK);
    }

}
