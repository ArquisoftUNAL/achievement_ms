package com.microsv.achievdb2.pojo;

public class MilestonePOJO {
    public int streak;
    public long achId;

    public MilestonePOJO(int streak, long achId) {
        this.streak = streak;
        this.achId = achId;
    }

    public MilestonePOJO() {
    }

    public int getStreak() {
        return streak;
    }

    public long getAchId() {
        return achId;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setHabId(long archId) {
        this.achId = archId;
    }
}
