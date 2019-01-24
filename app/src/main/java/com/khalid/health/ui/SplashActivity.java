package com.khalid.health.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.khalid.health.PrefManager;
import com.khalid.health.R;
import com.khalid.health.api.ApiCallBack;
import com.khalid.health.api.AppApiHelper;
import com.khalid.health.api.retrofit.requests.InitAppRequest;
import com.khalid.health.api.retrofit.responses.InitAppResponse;
import com.khalid.health.model.User;

public class SplashActivity extends BaseActivity {

    private String TAG="SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


      //  showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppApiHelper appApiHelper = new AppApiHelper();
                        appApiHelper.initApp(new InitAppRequest(), new ApiCallBack<InitAppResponse>() {
                            @Override
                            public void onSuccess(InitAppResponse object) {
                                new PrefManager(SplashActivity.this).saveAppData(object.getAppSystemData());
                                User user = new PrefManager(SplashActivity.this).getUser();
                                Log.d(TAG,object.getAppSystemData().toString());
                                if(user==null){
                                    Intent intent=new Intent(SplashActivity.this,AddUserActivity.class);
                                    startActivity(intent);
                                }else{
                                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                                finish();
                            }

                            @Override
                            public void onFail() {
                                showError();
                            }
                        });
                    }
                });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }
}
