package com.microsv.achievdb2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="milestones")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="mil_id")
    private long id;

    @Column(name="mil_streak")
    private Integer streak;

    @Column(name="mil_date")
    private Date date;

    @Column(name="mil_achieved")
    private boolean achieved;

    @ManyToOne
    @JoinColumn(name="ach_id")
    private Achievement achievement;

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
