package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microsv.achievdb2.pojo.AchievementPOJO;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/{hab_id}")
    public List<Achievement> getAllAchievementsByHabit(@PathVariable String hab_id) {
        return achievementService.getAllAchievementsByHabit(hab_id);
    }

    @PostMapping(value = { "/create-ach" })
    public void createAchievement(@RequestBody AchievementPOJO body) {
        Achievement achievement = achievementService.makeAchievement(body);
        achievementService.save(achievement);
    }

    @DeleteMapping("/{ach_id}")
    public void deleteAchievement(@PathVariable Long ach_id) {
        achievementService.deleteAchievement(ach_id);
    }

    @PatchMapping("/{ach_id}")
    public ResponseEntity<Achievement> updateAchievement(@PathVariable Long ach_id,
            @RequestBody AchievementPOJO body) {
        Achievement achievement = achievementService.updateAchievement(ach_id, body);
        achievementService.save(achievement);
        return ResponseEntity.ok(achievement);
    }

}
