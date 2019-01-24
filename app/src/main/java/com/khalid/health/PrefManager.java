package com.khalid.health;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.khalid.health.api.retrofit.responses.AppSystemData;
import com.khalid.health.model.User;

public class PrefManager {
    static String MY_PREFS_NAME="PrefManager";
    static String USER_DATA="USER_DATA";
    static String APP_DATA="APP_DATA";
    Context mCtx;

    public PrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

   public void saveAppData(AppSystemData appSystemData){
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(APP_DATA, appSystemData.toString());
        editor.apply();
    }

    public AppSystemData getAppData(){
        SharedPreferences prefs =  mCtx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String restoredText = prefs.getString(APP_DATA, null);
        return new Gson().fromJson(restoredText,AppSystemData.class);
    }


    public  void saveUser(User user){
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(USER_DATA, user.toString());
        editor.apply();
    }

    public User getUser(){
        SharedPreferences prefs =  mCtx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String restoredText = prefs.getString(USER_DATA, null);
        return new Gson().fromJson(restoredText,User.class);
    }
}
