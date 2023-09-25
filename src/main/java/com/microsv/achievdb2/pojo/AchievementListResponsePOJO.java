package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;

import java.util.List;

public class AchievementListResponsePOJO {

    public String message;

    public List<Achievement> data;

    public AchievementListResponsePOJO(String message, List<Achievement> data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Achievement> getData() {
        return data;
    }

    public void setData(List<Achievement> data) {
        this.data = data;
    }
}
