package com.example.android.tourguideapp.Models;

import java.io.Serializable;

public class Church implements Serializable {
    private String name;
    private String phone;
    private String street;

    public Church() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
