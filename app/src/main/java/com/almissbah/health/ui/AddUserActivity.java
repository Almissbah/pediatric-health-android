package com.almissbah.health.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.almissbah.health.api.retrofit.requests.AddUserRequest;
import com.khalid.health.R;

public class AddUserActivity extends AppCompatActivity {
Button btn_login;
EditText edt_name,edt_baby_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
         btn_login=findViewById(R.id.btn_login);
         edt_name=findViewById(R.id.edt_name);
         edt_baby_name=findViewById(R.id.edt_baby_name);
         btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddUserRequest addUserRequest=new AddUserRequest();
                addUserRequest.setName(edt_name.getText().toString());
                addUserRequest.setBaby_name(edt_baby_name.getText().toString());
                Intent intent=new Intent(AddUserActivity.this,PickAgeActivity.class);
                intent.putExtra(PickAgeActivity.EXT,addUserRequest);
                startActivity(intent);
                finish();
            }
        });
    }
}
