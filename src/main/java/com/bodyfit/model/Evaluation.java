package com.bodyfit.model;

public class Evaluation {
    private Integer id;
    private String date_time;
    private Integer id_bodybuilder;
    private String name;

    public Evaluation(Integer id, String date_time, Integer id_bodybuilder, String name) {
        this.id = id;
        this.date_time = date_time;
        this.id_bodybuilder = id_bodybuilder;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() { return date_time; }

    public void setDateTime(String date_time) { this.date_time = date_time; }

    public Integer getIdBodybuilder() {
        return id_bodybuilder;
    }

    public void setIdBodybuilder(Integer id_bodybuilder) {
        this.id_bodybuilder = id_bodybuilder;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
