package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;

import java.util.List;

public class PatchResponsePairPOJO {

    public List<Achievement> achievement;

    public List<Milestone> milestoneList;

    public PatchResponsePairPOJO(List<Achievement> achievement, List<Milestone> milestoneList) {
        this.achievement = achievement;
        this.milestoneList = milestoneList;
    }

    public List<Achievement> getAchievement() {
        return achievement;
    }

    public void setAchievement(List<Achievement> achievement) {
        this.achievement = achievement;
    }

    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }
}
