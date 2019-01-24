package com.khalid.health.api.retrofit.requests;

import com.google.gson.Gson;

public class GetUserInfoRequest {
    String method = "getInfo";
    int user_id;
    int age_info_id;

    public int getAge_info_id() {
        return age_info_id;
    }

    public void setAge_info_id(int age_info_id) {
        this.age_info_id = age_info_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
