package com.khalid.health.api.retrofit.responses;


import com.google.gson.annotations.SerializedName;

public class GetUserInfoResponse extends AppResponse {
    @SerializedName("data")
    AppSystemData appSystemData;

    public AppSystemData getAppSystemData() {
        return appSystemData;
    }

    public void setAppSystemData(AppSystemData appSystemData) {
        this.appSystemData = appSystemData;
    }
}
