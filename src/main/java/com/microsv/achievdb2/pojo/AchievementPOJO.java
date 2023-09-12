package com.microsv.achievdb2.pojo;

public class AchievementPOJO {
    public String name;
    public String habId;

    public AchievementPOJO(String name, String habId) {
        this.name = name;
        this.habId = habId;
    }

    public AchievementPOJO() {
    }

    public String getName() {
        return name;
    }

    public String getHabId() {
        return habId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHabId(String habId) {
        this.habId = habId;
    }
}
