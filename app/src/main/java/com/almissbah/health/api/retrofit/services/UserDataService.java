package com.almissbah.health.api.retrofit.services;

import com.almissbah.health.api.retrofit.responses.AddUserResponse;
import com.almissbah.health.api.retrofit.responses.GetUserInfoResponse;
import com.almissbah.health.api.retrofit.responses.InitAppResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserDataService {

    @POST("App.php")
    Call<AddUserResponse> addUser(@Query("json") String data);

    @POST("App.php")
    Call<GetUserInfoResponse> getInfo(@Query("json") String data);

    @GET("App.php")
    Call<InitAppResponse> initApp(@Query("json") String data);

}
