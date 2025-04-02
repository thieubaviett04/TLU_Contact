package com.example.tlucontact2;

import java.io.Serializable;

public class Staff implements Serializable {
    private String name;
    private String position;
    private String phone;
    private String email;
    private String unit;

    public Staff(String name, String position, String phone, String email, String unit) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUnit() {
        return unit;
    }
}