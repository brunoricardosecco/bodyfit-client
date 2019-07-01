package com.bodyfit.dto;

import com.bodyfit.model.Bodybuilder;

public class BodyBuilderDTO {
    private Boolean success;
    private String errorMessage;
    private Bodybuilder bodybuilder;

    @Override
    public String toString() {
        return "BodybuilderDTO{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", bodybuilder=" + bodybuilder +
                '}';
    }

    public BodyBuilderDTO() {

    }

    public BodyBuilderDTO(Boolean success, String errorMessage, Bodybuilder bodybuilder) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.bodybuilder = bodybuilder;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Bodybuilder getBodybuilder() {
        return bodybuilder;
    }

    public void setBodybuilder(Bodybuilder bodybuilder) {
        this.bodybuilder = bodybuilder;
    }
}
