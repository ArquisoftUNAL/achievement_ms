package com.microsv.achievdb2.pojo;

import java.time.LocalDate;
import java.util.Date;

public class MilestonePOJO {
    public int streak;
    public String achId;

    public LocalDate date;

    public MilestonePOJO(int streak, String achId, LocalDate date) {
        this.streak = streak;
        this.achId = achId;
        this.date = date;
    }

    public MilestonePOJO() {
    }

    public int getStreak() {
        return streak;
    }

    public String getAchId() {
        return achId;
    }

    public LocalDate getDate() { return date; }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setHabId(String archId) {
        this.achId = archId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
