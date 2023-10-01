package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;

import java.util.List;

public class PatchPairPOJO {

    public Achievement achievement;

    public List<Milestone> milestoneList;

    public PatchPairPOJO(Achievement achievement, List<Milestone> milestoneList) {
        this.achievement = achievement;
        this.milestoneList = milestoneList;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }
}
