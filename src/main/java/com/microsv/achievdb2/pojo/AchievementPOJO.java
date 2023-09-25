package com.microsv.achievdb2.pojo;

public class AchievementPOJO {
    public String name;
    public String habId;

    public Double currentStreak;

    public Double highestStreak;

    public AchievementPOJO(String name, String habId) {
        this.name = name;
        this.habId = habId;
    }

    public AchievementPOJO(String name, String habId, Double currentStreak, Double highestStreak) {
        this.name = name;
        this.habId = habId;
        this.currentStreak = currentStreak;
        this.highestStreak = highestStreak;
    }

    public AchievementPOJO() {
    }

    public String getName() {
        return name;
    }

    public String getHabId() {
        return habId;
    }

    public Double getCurrentStreak() {
        return currentStreak;
    }

    public Double getHighestStreak() {
        return highestStreak;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHabId(String habId) {
        this.habId = habId;
    }

    public void setCurrentStreak(Double currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setHighestStreak(Double highestStreak) {
        this.highestStreak = highestStreak;
    }
}
