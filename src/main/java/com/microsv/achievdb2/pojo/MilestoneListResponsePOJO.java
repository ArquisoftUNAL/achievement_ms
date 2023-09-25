package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;

import java.util.List;

public class MilestoneListResponsePOJO {

    public String message;

    public List<Milestone> data;

    public MilestoneListResponsePOJO(String message, List<Milestone> data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Milestone> getData() {
        return data;
    }

    public void setData(List<Milestone> data) {
        this.data = data;
    }
}
