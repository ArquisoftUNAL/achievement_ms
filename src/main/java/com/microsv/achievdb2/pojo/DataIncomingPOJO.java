package com.microsv.achievdb2.pojo;

import java.sql.Date;

public class DataIncomingPOJO {
    public Date dateCollected;
    public String habId;

    public DataIncomingPOJO(String habId, Date dateCollected) {
        this.dateCollected = dateCollected;
        this.habId = habId;
    }

    public DataIncomingPOJO() {
    }

    public String getHabId() {
        return habId;
    }

    public Date getDataCollected() {
        return dateCollected;
    }

    public void setDataCollected(Date dateCollected) {
        this.dateCollected = dateCollected;
    }

    public void setHabId(String habId) {
        this.habId = habId;
    }
}
