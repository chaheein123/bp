package com.example.ian.baypeoples.exception;

import java.util.Date;

public class ApplicationErrors {
    public String message;
    public Date date;
    public String code;

    public ApplicationErrors(String message, String code) {
        this.message = message;
        this.date = new Date();
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
