package com.microsv.achievdb2.pojo;

import com.microsv.achievdb2.model.Achievement;

public class AchievementResponsePOJO {

    public String message;

    public Achievement data;

    public AchievementResponsePOJO(String message, Achievement data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Achievement getData() {
        return data;
    }

    public void setData(Achievement data) {
        this.data = data;
    }
}
