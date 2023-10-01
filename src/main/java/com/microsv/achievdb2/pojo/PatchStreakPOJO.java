package com.microsv.achievdb2.pojo;

public class PatchStreakPOJO {

    public String hab_id;

    public String freq_type;

    public StreakPOJO streak;

    public PatchStreakPOJO(String hab_id, String freq_type, StreakPOJO streak) {
        this.hab_id = hab_id;
        this.freq_type = freq_type;
        this.streak = streak;
    }

    public String getHab_id() {
        return hab_id;
    }

    public void setHab_id(String hab_id) {
        this.hab_id = hab_id;
    }

    public String getFreq_type() {
        return freq_type;
    }

    public void setFreq_type(String freq_type) {
        this.freq_type = freq_type;
    }

    public StreakPOJO getStreak() {
        return streak;
    }

    public void setStreak(StreakPOJO streak) {
        this.streak = streak;
    }
}
