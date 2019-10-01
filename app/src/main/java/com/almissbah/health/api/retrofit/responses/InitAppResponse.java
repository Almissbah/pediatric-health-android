package com.almissbah.health.api.retrofit.responses;


import com.google.gson.annotations.SerializedName;

public class InitAppResponse extends AppResponse {
    @SerializedName("data")
    AppSystemData appSystemData;

    public String getMessage() {
        return message;
    }

    public AppSystemData getAppSystemData() {
        return appSystemData;
    }

    public void setAppSystemData(AppSystemData appSystemData) {
        this.appSystemData = appSystemData;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }


}
