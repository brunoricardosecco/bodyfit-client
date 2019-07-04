package com.bodyfit.model;

public class Workout {
    private Integer id;
    private Integer series;
    private Integer repetition;
    private Double weight;
    private Integer id_exercise;
    private Integer id_workout;

    public Workout(Integer id, Integer series, Integer repetition, Double weight, Integer id_exercise, Integer id_workout) {
        this.id = id;
        this.series = series;
        this.repetition = repetition;
        this.weight = weight;
        this.id_exercise = id_exercise;
        this.id_workout = id_workout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getId_exercise() {
        return id_exercise;
    }

    public void setId_exercise(Integer id_exercise) {
        this.id_exercise = id_exercise;
    }

    public Integer getId_workout() {
        return id_workout;
    }

    public void setId_workout(Integer id_workout) {
        this.id_workout = id_workout;
    }
}
