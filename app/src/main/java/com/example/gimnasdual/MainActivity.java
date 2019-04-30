package com.example.gimnasdual;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String KEY_LASTMESSAGE = "KEY";
    private String KEY_SHAREDPREF = "1";

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
                if(loginIsOpen){
                    if(!mEt_user.getText().equals("") || !mEt_password.getText().equals("")){
                        saveMessage();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    Toast.makeText(MainActivity.this, "Usuari o contraseña incorrectes", Toast.LENGTH_SHORT).show();
                }
                else {
                    mEt_user.setText("");
                    saveMessage();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void loadViews() {
        mLl_loginFields = findViewById(R.id.login_ll_loginFields);
        mBtn_open = findViewById(R.id.login_btn_open);
        mEt_user = findViewById(R.id.login_et_user);
        mEt_password = findViewById(R.id.login_et_password);

        mBtn_enter = findViewById(R.id.login_btn_enter);

        getSavedMessage();

    }
    public void saveMessage(){
        if (!mEt_user.getText().toString().equals("")){
            Context context = getApplicationContext();
            SharedPreferences sharedPref = context.getSharedPreferences(KEY_LASTMESSAGE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(KEY_SHAREDPREF, mEt_user.getText().toString());
            editor.commit();
        }
    }
    public void getSavedMessage(){
        Context context = getApplicationContext();

        SharedPreferences sharedPref = context.getSharedPreferences(KEY_LASTMESSAGE, Context.MODE_PRIVATE);
        String lastMessage = sharedPref.getString(KEY_SHAREDPREF, "");

        if (!lastMessage.equals("")){
            mEt_user.setText(lastMessage);
        }
    }
}