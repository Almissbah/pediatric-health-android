package com.khalid.health.api.retrofit.requests;

import com.google.gson.Gson;

public class InitAppRequest {
    String method = "initApp";

    public String toString() {
        return new Gson().toJson(this);
    }
}
