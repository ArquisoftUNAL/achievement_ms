package com.microsv.achievdb2.pojo;

import java.time.LocalDate;

public class StreakPOJO {

    public LocalDate date_start;

    public LocalDate date_end;

    public double data;

    public StreakPOJO(LocalDate date_start, LocalDate date_end, double data) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.data = data;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
}
