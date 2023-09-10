package com.microsv.achievdb2.model;

import jakarta.persistence.*;

@Entity
@Table(name="achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ach_id")
    private long id;

    @Column(name = "ach_name")
    private String name;

    @Column(name = "ach_current_streak")
    private Integer currentStreak;

    @Column(name = "ach_highest_streak")
    private Integer highestStreak;

    @Column(name="hab_id")
    private long habit;

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

    public long getHabit() {
        return habit;
    }

    public void setHabit(long habit) {
        this.habit = habit;
    }
}
