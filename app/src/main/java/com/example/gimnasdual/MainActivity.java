package com.example.gimnasdual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLl_loginFields;
    Button mBtn_open;
    boolean loginIsOpen = false;
    EditText mEt_user;
    EditText mEt_password;

    Button mBtn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadViews();
        loadClickListeners();
    }

    private void loadClickListeners() {
        // Expand login view
        mBtn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginIsOpen) {
                    ViewGroup.LayoutParams params = mLl_loginFields.getLayoutParams();
                    params.width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    params.height = 0;
                    mLl_loginFields.setLayoutParams(params);
                    loginIsOpen = false;
                } else {
                    ViewGroup.LayoutParams params = mLl_loginFields.getLayoutParams();
                    params.width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    mLl_loginFields.setLayoutParams(params);
                    loginIsOpen = true;
                }
            }
        });
        // Enter the application
        mBtn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadViews() {
        mLl_loginFields = findViewById(R.id.login_ll_loginFields);
        mBtn_open = findViewById(R.id.login_btn_open);
        mEt_user = findViewById(R.id.login_et_user);
        mEt_password = findViewById(R.id.login_et_password);

        mBtn_enter = findViewById(R.id.login_btn_enter);
    }
}