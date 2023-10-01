package com.microsv.achievdb2.pojo;

public class PatchResponsePOJO {

    public String message;

    public PatchResponsePairPOJO data;

    public PatchResponsePOJO(String message, PatchResponsePairPOJO data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PatchResponsePairPOJO getData() {
        return data;
    }

    public void setData(PatchResponsePairPOJO data) {
        this.data = data;
    }
}
