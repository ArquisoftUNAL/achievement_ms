package com.microsv.achievdb2.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Achievement")
public class Achievement {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ach_id")
    private String id;

    @Column(name = "ach_name")
    @NonNull
    private String name;

    @Column(name = "ach_current_streak")
    @NonNull
    private Double currentStreak;

    @Column(name = "ach_highest_streak")
    @NonNull
    private Double highestStreak;

    @Column(name = "ach_last_collection")
    @NonNull
    private LocalDate lastCollection;

    @Column(name = "hab_id")
    @NonNull
    private String habit;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Double currentStreak) {
        this.currentStreak = currentStreak;
    }

    public Double getHighestStreak() {
        return highestStreak;
    }

    public void setHighestStreak(Double highestStreak) {
        this.highestStreak = highestStreak;
    }

    public LocalDate getLastCollection() { return lastCollection; }

    public void setLastCollection(LocalDate lastCollection) { this.lastCollection = lastCollection; }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
