package com.example.gimnasdual;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gimnasdual.data.ResponseSoci;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String nomUsuariChat = "";
    private String KEY_LASTMESSAGE = "KEY";
    private String KEY_SHAREDPREF = "1";
    int idSociAGuardar;
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
        mBtn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEt_user.setText("");
                saveMessage();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("isSoci", false);
                startActivity(intent);
            }
        });
        mBtn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEt_user.getText().toString().equals("") && !mEt_password.getText().toString().equals("")) {
                    getSoci(v);
                } else {
                    Toast.makeText(MainActivity.this, "Hi han camps buits!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadViews() {
        mBtn_open = findViewById(R.id.login_btn_offline);
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
            editor.putString("2", nomUsuariChat);
            editor.putString("3", String.valueOf(idSociAGuardar));
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

    public void getSoci (View view) {
        //mEt_user.getText().toString(), mEt_password.getText().toString()
        String username = mEt_user.getText().toString();
        String pass = mEt_password.getText().toString();
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.doLoginSocis(username, pass)
                .enqueue(new Callback<List<ResponseSoci>>() {
                    //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                    //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                    @Override
                    public void onResponse(Call<List<ResponseSoci>> call, Response<List<ResponseSoci>> response) {
                        if (response.isSuccessful()) {
                            if(response.body().size() > 0) {
                                nomUsuariChat = response.body().get(0).getNom();
                                idSociAGuardar = (int) response.body().get(0).getId();
                                saveMessage();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.putExtra("isSoci", true);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Usuari o contrasenya incorrectes!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseSoci>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}