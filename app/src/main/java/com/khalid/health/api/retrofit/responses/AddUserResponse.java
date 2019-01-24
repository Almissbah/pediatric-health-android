package com.khalid.health.api.retrofit.responses;

import com.google.gson.annotations.SerializedName;
import com.khalid.health.model.User;

public class AddUserResponse extends AppResponse {
    @SerializedName("data")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
