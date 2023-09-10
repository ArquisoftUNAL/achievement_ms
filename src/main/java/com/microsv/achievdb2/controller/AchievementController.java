package com.microsv.achievdb2.controller;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Achievement> getAllAchievementsByHabit(@PathVariable long hab_id) {
        return achievementService.getAllAchievementsByHabit(hab_id);
    }

    @PostMapping( value = {"/create-ach"})
    public void createAchievement(@RequestBody String name, long habId) {
        Achievement achievement = achievementService.makeAchievement(name, habId);
        achievementService.save(achievement);
    }

}
