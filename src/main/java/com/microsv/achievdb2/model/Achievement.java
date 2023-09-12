package com.microsv.achievdb2.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

@Entity
@Table(name = "Achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ach_id")
    private long id;

    @Column(name = "ach_name")
    @NonNull
    private String name;

    @Column(name = "ach_current_streak")
    @NonNull
    private Integer currentStreak;

    @Column(name = "ach_highest_streak")
    @NonNull
    private Integer highestStreak;

    @Column(name = "hab_id")
    @NonNull
    private String habit;

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Integer currentStreak) {
        this.currentStreak = currentStreak;
    }

    public Integer getHighestStreak() {
        return highestStreak;
    }

    public void setHighestStreak(Integer highestStreak) {
        this.highestStreak = highestStreak;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
