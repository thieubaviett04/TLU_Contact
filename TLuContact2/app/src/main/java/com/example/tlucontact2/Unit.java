package com.example.tlucontact2;

import java.io.Serializable;

public class Unit implements Serializable {
    private String name;
    private String phone;
    private String address;

    public Unit(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}