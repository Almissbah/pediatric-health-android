package com.khalid.health.api;


import android.util.Log;

import com.google.gson.Gson;
import com.khalid.health.api.retrofit.RetrofitClientInstance;
import com.khalid.health.api.retrofit.requests.AddUserRequest;
import com.khalid.health.api.retrofit.requests.GetUserInfoRequest;
import com.khalid.health.api.retrofit.requests.InitAppRequest;
import com.khalid.health.api.retrofit.responses.AddUserResponse;
import com.khalid.health.api.retrofit.responses.AppResponse;
import com.khalid.health.api.retrofit.responses.GetUserInfoResponse;
import com.khalid.health.api.retrofit.responses.InitAppResponse;
import com.khalid.health.api.retrofit.services.UserDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppApiHelper {
    private static final String TAG = "AppApiHelper";
    Retrofit retrofit;
    UserDataService userDataService;
    public AppApiHelper() {
        retrofit = RetrofitClientInstance.getRetrofitInstance();
        userDataService = retrofit.create(UserDataService.class);
    }

    public void initApp(InitAppRequest request, final ApiCallBack<InitAppResponse> apiCallBack) {
        final Call<InitAppResponse> call =
                userDataService.initApp(request.toString());
        Log.i(TAG, "initApp() ," + call.request().toString());
        call.enqueue(new Callback<InitAppResponse>() {
            @Override
            public void onResponse(Call<InitAppResponse> call, Response<InitAppResponse> response) {
                Log.i(TAG, "onResponse() ," + response.toString());
                Log.i(TAG, "onResponse() body ," + new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    apiCallBack.onSuccess(response.body());
                } else {
                    apiCallBack.onFail( );
                }
            }

            @Override
            public void onFailure(Call<InitAppResponse> call, Throwable t) {
                Log.i(TAG, "onFailure() ," + t.getMessage());
                // loginCall.enqueue(this);
                apiCallBack.onFail();

            }
        });
    }


    public void getInfo(GetUserInfoRequest request, final ApiCallBack<GetUserInfoResponse> apiCallBack) {
        final Call<GetUserInfoResponse> call =
                userDataService.getInfo(request.toString());
        call.enqueue(new Callback<GetUserInfoResponse>() {
            @Override
            public void onResponse(Call<GetUserInfoResponse> call, Response<GetUserInfoResponse> response) {
                Log.i(TAG, "onResponse() ," + response.toString());
                Log.i(TAG, "onResponse() body ," + new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    apiCallBack.onSuccess(response.body());
                } else {
                    apiCallBack.onFail( );
                }
            }

            @Override
            public void onFailure(Call<GetUserInfoResponse> call, Throwable t) {
                Log.i(TAG, "onFailure() ," + t.getMessage());
                // loginCall.enqueue(this);
                apiCallBack.onFail();

            }
        });
    }


    public void addUser(AddUserRequest addUserRequest, final ApiCallBack<AddUserResponse> apiCallBack) {
        String request = addUserRequest.toString();
        final Call<AddUserResponse> call =
                userDataService.addUser(request);
        call.enqueue(new Callback<AddUserResponse>() {
            @Override
            public void onResponse(Call<AddUserResponse> call, Response<AddUserResponse> response) {
                Log.i(TAG, "onResponse() ," + response.toString());
                Log.i(TAG, "onResponse() body ," + new Gson().toJson(response.body()));
                if (response.isSuccessful()&&response.body().getUser().getId()!=0) {
                    apiCallBack.onSuccess(response.body());
                } else {
                    apiCallBack.onFail( );
                }
            }

            @Override
            public void onFailure(Call<AddUserResponse> call, Throwable t) {
                Log.i(TAG, "onFailure() ," + t.getMessage());
                // loginCall.enqueue(this);
                apiCallBack.onFail();
            }
        });
    }

}
