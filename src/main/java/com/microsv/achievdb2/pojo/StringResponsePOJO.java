package com.microsv.achievdb2.pojo;

public class StringResponsePOJO {

    public String message;

    public String data;

    public StringResponsePOJO(String message, String data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
