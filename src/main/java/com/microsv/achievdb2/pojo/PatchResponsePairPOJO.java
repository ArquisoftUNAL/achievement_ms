package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;

import java.util.List;

public class PatchResponsePairPOJO {

    public List<Achievement> achievementList;

    public List<Milestone> milestoneList;

    public PatchResponsePairPOJO(List<Achievement> achievementList, List<Milestone> milestoneList) {
        this.achievementList = achievementList;
        this.milestoneList = milestoneList;
    }

    public List<Achievement> getAchievement() {
        return achievementList;
    }

    public void setAchievement(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }
}
