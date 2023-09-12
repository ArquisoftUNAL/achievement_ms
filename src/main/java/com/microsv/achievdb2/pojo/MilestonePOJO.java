package com.microsv.achievdb2.pojo;

public class MilestonePOJO {
    public int num;
    public long achId;

    public MilestonePOJO(int num, long achId) {
        this.num = num;
        this.achId = achId;
    }

    public MilestonePOJO() {
    }

    public int getNum() {
        return num;
    }

    public long getAchId() {
        return achId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setHabId(long archId) {
        this.achId = archId;
    }
}
