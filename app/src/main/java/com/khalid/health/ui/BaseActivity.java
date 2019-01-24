package com.khalid.health.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    ProgressDialog dialog ;

    void showLoading(){ dialog = ProgressDialog.show(this, "",
            "Loading. Please wait...", true);
    }
    void hideLoading(){
        dialog.dismiss();
    }
    void showError(){
        Toast.makeText(BaseActivity.this,"Connection Error",Toast.LENGTH_LONG).show();
    }
}
