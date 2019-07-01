package com.bodyfit.dto;

import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;

public class LoginDto {
    private Boolean success;
    private String errorMessage;
    private Bodybuilder bodybuilder;

    @Override
    public String toString() {
        return "LoginDto{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", bodybuilder=" + bodybuilder +
                '}';
    }

    public LoginDto () {

    }

    public LoginDto(Boolean success, String message, Bodybuilder bodybuilder) {
        this.success = success;
        this.errorMessage = message;
        this.bodybuilder = bodybuilder;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setMessage(String message) {
        this.errorMessage = message;
    }

    public Bodybuilder getBodybuilder() {
        return bodybuilder;
    }

    public void setBodybuilder(Bodybuilder bodybuilder) {
        this.bodybuilder = bodybuilder;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
