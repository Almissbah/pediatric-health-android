package com.almissbah.health.model;

import com.google.gson.Gson;

public class User {
    int id;
    String name;
    String baby_name;

    AgeInfo currentAgeInfo;

    public AgeInfo getCurrentAgeInfo() {
        return currentAgeInfo;
    }

    public void setCurrentAgeInfo(AgeInfo currentAgeInfo) {
        this.currentAgeInfo = currentAgeInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaby_name() {
        return baby_name;
    }

    public void setBaby_name(String baby_name) {
        this.baby_name = baby_name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
