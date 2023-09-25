package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.pojo.AchievementListResponsePOJO;
import com.microsv.achievdb2.pojo.AchievementResponsePOJO;
import com.microsv.achievdb2.pojo.MessageResponsePOJO;
import com.microsv.achievdb2.service.AchievementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microsv.achievdb2.pojo.AchievementPOJO;

@CrossOrigin
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/{hab_id}")
    public ResponseEntity<AchievementListResponsePOJO> getAllAchievementsByHabit(@PathVariable String hab_id) {
        return new ResponseEntity<>(new AchievementListResponsePOJO("Achievements found", achievementService.getAllAchievementsByHabit(hab_id)), HttpStatus.OK);
    }

    @PostMapping(value = { "/create-ach" })
    public ResponseEntity<MessageResponsePOJO> createAchievement(@RequestBody AchievementPOJO body) {
        Achievement achievement = achievementService.makeAchievement(body);
        if (achievement == null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Error: could not create achievement"), HttpStatus.BAD_REQUEST);
        }
        achievementService.save(achievement);
        return new ResponseEntity<>(new MessageResponsePOJO("Achievement created"), HttpStatus.CREATED);
    }

    @DeleteMapping("/del-ach")
    public ResponseEntity<MessageResponsePOJO> deleteAchievement(@RequestHeader ("ach-id") String ach_id) {
        if (achievementService.findById(ach_id)==null) {
            return new ResponseEntity<>(new MessageResponsePOJO("Achievement does not exist"), HttpStatus.NOT_FOUND);
        }
        achievementService.deleteAchievement(ach_id);
        return new ResponseEntity<>(new MessageResponsePOJO("Achievement deleted"), HttpStatus.OK);
    }

    @PatchMapping("/patch-ach")
    public ResponseEntity<AchievementResponsePOJO> updateAchievement(@RequestHeader ("ach-id") String ach_id,
                                                                     @RequestBody AchievementPOJO body) {
        if (achievementService.findById(ach_id)==null) {
            return new ResponseEntity<>(new AchievementResponsePOJO("Achievement does not exist", null), HttpStatus.NOT_FOUND);
        }
        Achievement achievement = achievementService.updateAchievement(ach_id, body);
        achievementService.save(achievement);
        return new ResponseEntity<>(new AchievementResponsePOJO("Achievement updated", achievement), HttpStatus.OK);
    }

    @PatchMapping("/patch-streak/{retain_streak}")
    public ResponseEntity<AchievementResponsePOJO> updateStreak(@RequestHeader ("ach-id") String ach_id, @PathVariable String retain_streak) {
        if (achievementService.findById(ach_id)==null) {
            return new ResponseEntity<>(new AchievementResponsePOJO("Achievement does not exist", null), HttpStatus.NOT_FOUND);
        }
        Achievement achievement = achievementService.updateStreak(ach_id, Boolean.parseBoolean(retain_streak));
        achievementService.save(achievement);
        return new ResponseEntity<>(new AchievementResponsePOJO("Streak updated", achievement), HttpStatus.OK);
    }
}
