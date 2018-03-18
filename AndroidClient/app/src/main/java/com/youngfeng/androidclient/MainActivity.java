package com.youngfeng.androidclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.youngfeng.androidclient.domain.User;
import com.youngfeng.androidclient.http.RetrofitManager;
import com.youngfeng.androidclient.service.UserService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_USER = "user";
    private TextView mUsernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameText = findViewById(R.id.text_username);

        User user = (User) getIntent().getSerializableExtra(KEY_USER);
        if(null != user) {
            mUsernameText.setText(user.getName());
        }
    }
}
