package com.bodyfit.model;

public class Bodybuilder {
    private Integer id;
    private String name;
    private String cpf;
    private String birth_date;
    private Boolean status;
    private String last_paid;
    private String phone;
    private String code;

    public Bodybuilder(Integer id, String name, String cpf, String birth_date, boolean status, String last_paid, String phone, String code) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
        this.status = status;
        this.last_paid = last_paid;
        this.phone = phone;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLast_paid() {
        return last_paid;
    }

    public void setLast_paid(String last_paid) {
        this.last_paid = last_paid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
