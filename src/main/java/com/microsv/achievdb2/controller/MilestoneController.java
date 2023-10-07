package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.pojo.*;
import com.microsv.achievdb2.service.AchievementService;
import com.microsv.achievdb2.service.MilestoneService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{ach_id}/{page}/{per_page}")
    public ResponseEntity<MilestoneListResponsePOJO> getAllMilestonesByAchievement(@PathVariable String ach_id, @PathVariable int page, @PathVariable int per_page) {
        return new ResponseEntity<>(new MilestoneListResponsePOJO("Milestones found", milestoneService.getAllMilestonesByAchievement(ach_id,page,per_page)), HttpStatus.OK);
    }

    @PostMapping(value = { "/create-mil" })
    public ResponseEntity<MessageResponsePOJO> createMilestone(@RequestBody MilestonePOJO body) {
        if (achievementService.findById(body.getAchId())==null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: achievement not found"),HttpStatus.NOT_FOUND);
        }
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
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Milestone does not exist"), HttpStatus.NOT_FOUND);
        }
        milestoneService.deleteMilestone(mil_id);
        return new ResponseEntity<>(new MessageResponsePOJO("Milestone deleted"), HttpStatus.OK);
    }

    @PatchMapping("/patch-mil")
    public ResponseEntity<MilestoneResponsePOJO> updateMilestone(
            @RequestHeader ("mil-id") String mil_id,
            @RequestBody MilestonePOJO body) {
        if (milestoneService.findById(mil_id)==null) {
            return new ResponseEntity<>(new MilestoneResponsePOJO("Error: Milestone does not exist", null), HttpStatus.NOT_FOUND);
        }
        Milestone milestone = milestoneService.updateMilestone(mil_id, body);
        milestoneService.save(milestone);
        return new ResponseEntity<>(new MilestoneResponsePOJO("Milestone updated", milestone), HttpStatus.OK);
    }

    @GetMapping("/find/mil")
    public ResponseEntity<?> findMilestoneById(@RequestHeader String mil_id) {
        Milestone milestone = milestoneService.findById(mil_id);
        if (milestone == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Milestone does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new MilestoneResponsePOJO("Milestone found", milestone), HttpStatus.OK);
    }

    @GetMapping("/findby-mil/ach")
    public ResponseEntity<?> findAchievementByMilestone(@RequestHeader String mil_id) {
        Milestone milestone = milestoneService.findById(mil_id);
        if (milestone == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Milestone does not exist"), HttpStatus.NOT_FOUND);
        }
        Achievement achievement = milestone.getAchievement();
        if (achievement == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Achievement does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AchievementResponsePOJO("Achievement found", achievement), HttpStatus.OK);
    }

    @GetMapping("/findby-mil/hab-id")
    public ResponseEntity<?> findHabIdByMilestone(@RequestHeader String mil_id) {
        Milestone milestone = milestoneService.findById(mil_id);
        if (milestone == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Milestone does not exist"), HttpStatus.NOT_FOUND);
        }
        Achievement achievement = milestone.getAchievement();
        if (achievement == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: Achievement does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new StringResponsePOJO("Achievement found", achievement.getHabit()), HttpStatus.OK);
    }

}
