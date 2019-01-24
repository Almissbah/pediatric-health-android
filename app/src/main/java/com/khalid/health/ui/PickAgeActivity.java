package com.khalid.health.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.khalid.health.AgeAdapter;
import com.khalid.health.MyNotificationPublisher;
import com.khalid.health.PrefManager;
import com.khalid.health.R;
import com.khalid.health.api.ApiCallBack;
import com.khalid.health.api.AppApiHelper;
import com.khalid.health.api.retrofit.requests.AddUserRequest;
import com.khalid.health.api.retrofit.responses.AddUserResponse;
import com.khalid.health.model.AgeInfo;
import com.khalid.health.model.User;

import java.util.ArrayList;

public class PickAgeActivity extends BaseActivity implements AgeAdapter.AdapterCallback {
    AddUserRequest addUserRequest;
    public static String EXT = "ext";
    RecyclerView rv_ages;
    private String TAG="PickAgeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_age);
        rv_ages=findViewById(R.id.rv_ages);

        addUserRequest = (AddUserRequest) getIntent().getSerializableExtra(EXT);
        rv_ages.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<AgeInfo> list = new PrefManager(PickAgeActivity.this).getAppData().getAgeInfos();
        Log.d(TAG,""+list.size());
        rv_ages.setAdapter(new AgeAdapter(list,this));
    }

    @Override
    public void onCallback(final AgeInfo ageInfo) {
        AppApiHelper appApiHelper = new AppApiHelper();
        addUserRequest.setAge_info_id(ageInfo.getId());
        showLoading();
        appApiHelper.addUser(addUserRequest, new ApiCallBack<AddUserResponse>() {
            @Override
            public void onSuccess(AddUserResponse object) {
                User user=new User();
                user.setId(object.getUser().getId());
                user.setName(addUserRequest.getBaby_name());
                user.setBaby_name(addUserRequest.getBaby_name());
                user.setCurrentAgeInfo(ageInfo);
                new PrefManager(PickAgeActivity.this).saveUser(user);
                long delay=user.getCurrentAgeInfo().getDays_until_next();
                MyNotificationPublisher.scheduleNotification(PickAgeActivity.this,delay);
                hideLoading();
                Intent intent=new Intent(PickAgeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFail() {
                hideLoading();
                Toast.makeText(PickAgeActivity.this,"Connection Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
