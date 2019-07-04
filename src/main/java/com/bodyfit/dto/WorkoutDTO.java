package com.bodyfit.dto;

import com.bodyfit.model.Workout;

import java.util.ArrayList;

public class WorkoutDTO {
    private boolean success;
    private String errorMessage;
    private ArrayList<Workout> workouts;

    public WorkoutDTO(Boolean success, String errorMessage, ArrayList<Workout> workouts) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.workouts = workouts;
    }

    public WorkoutDTO() {

    }

    @Override
    public String toString() {
        return "WorkoutDTO{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", workout=" + workouts +
                '}';
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

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

}
