package com.microsv.achievdb2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Milestone")
public class Milestone {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "mil_id")
    private String id;

    @Column(name = "mil_streak")
    @NonNull
    private Integer streak;

    @Column(name = "mil_date")
    @NonNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "ach_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Achievement achievement;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
