package com.almissbah.health.api.retrofit.requests;
import com.google.gson.Gson;

import java.io.Serializable;

public class AddUserRequest implements Serializable {
    String method = "addUser";
    int age_info_id;
    String name = "";
    String baby_name = "";

    public int getAge_info_id() {
        return age_info_id;
    }

    public void setAge_info_id(int age_info_id) {
        this.age_info_id = age_info_id;
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

    public String toString() {
        return new Gson().toJson(this).toString();
    }
}
