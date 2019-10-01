package com.almissbah.health.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.almissbah.health.PrefManager;
import com.almissbah.health.api.ApiCallBack;
import com.almissbah.health.api.AppApiHelper;
import com.almissbah.health.api.retrofit.requests.GetUserInfoRequest;
import com.almissbah.health.api.retrofit.responses.GetUserInfoResponse;
import com.almissbah.health.model.User;
import com.almissbah.health.model.Vaccination;
import com.khalid.health.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private User user;
    TextView tv_weight,tv_length,tv_diet,tv_age;
    LinearLayout linearLayout;
    Button btn_exit;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=MainActivity.this;
        linearLayout=findViewById(R.id.linearLayout);
        tv_weight=findViewById(R.id.tv_weight);
        tv_length=findViewById(R.id.tv_length);
        tv_diet=findViewById(R.id.tv_diet);
        tv_age=findViewById(R.id.tv_age);
        btn_exit=findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        user=new PrefManager(MainActivity.this).getUser();
        if(user!=null){
            AppApiHelper appApiHelper = new AppApiHelper();
            showLoading();
            GetUserInfoRequest request = new GetUserInfoRequest();
            request.setUser_id(user.getId());
            request.setAge_info_id(user.getCurrentAgeInfo().getId());
            appApiHelper.getInfo(request, new ApiCallBack<GetUserInfoResponse>() {
                @Override
                public void onSuccess(GetUserInfoResponse object) {
                    ArrayList<Vaccination> list = object.getAppSystemData().getVaccinations();
                    tv_weight.setText(list.get(0).getWeight());
                    tv_length.setText(list.get(0).getLength());
                    tv_diet.setText(list.get(0).getDiet());
                    tv_age.setText(user.getBaby_name()+" ("+user.getCurrentAgeInfo().getTitle()+") ");
                    linearLayout.removeAllViews();
                    for(int i=0;i< list.size();i++){
                        CheckBox checkBox=new CheckBox(MainActivity.this);
                        checkBox.setText(list.get(i).getName());
                        checkBox.setChecked(true);
                        checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                        checkBox.setEnabled(false);
                        linearLayout.addView(checkBox);
                    }
                    hideLoading();

                }

                @Override
                public void onFail() {
                    hideLoading();
                    Toast.makeText(context,"Connection Error",Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
