package com.example.android.tourguideapp.Models;

import java.io.Serializable;

public class StatuePark implements Serializable {
    private String name;
    private String street;
    private int imageResId;

    public StatuePark() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
