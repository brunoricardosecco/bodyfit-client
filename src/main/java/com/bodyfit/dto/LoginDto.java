package com.bodyfit.dto;

import com.bodyfit.model.Instructor;

public class LoginDto {
    private Boolean success;
    private String errorMessage;
    private Instructor instructor;

    @Override
    public String toString() {
        return "LoginDto{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public LoginDto () {

    }

    public LoginDto(Boolean success, String message, Instructor instructor) {
        this.success = success;
        this.errorMessage = message;
        this.instructor = instructor;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setMessage(String message) {
        this.errorMessage = message;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
