package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;

public class MilestoneResponsePOJO {

    public String message;

    public Milestone data;

    public MilestoneResponsePOJO(String message, Milestone data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Milestone getData() {
        return data;
    }

    public void setData(Milestone data) {
        this.data = data;
    }
}
