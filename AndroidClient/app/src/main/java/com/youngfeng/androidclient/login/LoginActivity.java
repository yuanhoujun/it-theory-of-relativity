package com.youngfeng.androidclient.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.youngfeng.androidclient.MainActivity;
import com.youngfeng.androidclient.R;
import com.youngfeng.androidclient.common.BaseActivity;
import com.youngfeng.androidclient.domain.User;
import com.youngfeng.androidclient.http.HttpResponse;
import com.youngfeng.androidclient.http.RetrofitManager;
import com.youngfeng.androidclient.register.RegisterActivity;
import com.youngfeng.androidclient.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Login Activity
 *
 * @author Scott Smith 2018-03-18 12:58
 */
public class LoginActivity extends BaseActivity {
    private EditText mUsernameEdit;
    private EditText mPwdEdit;
    private Button mLoginBtn;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameEdit = findViewById(R.id.edit_username);
        mPwdEdit = findViewById(R.id.edit_pwd);
        mLoginBtn = findViewById(R.id.btn_login);
        mRegisterBtn = findViewById(R.id.btn_register);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(mUsernameEdit.getText().toString(), mPwdEdit.getText().toString());
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String username, String pwd) {
        Retrofit retrofit = RetrofitManager.createDefault();
        UserService userService = retrofit.create(UserService.class);
        Call<HttpResponse<User>> call = userService.login(username, pwd);

        showLoading(true);
        call.enqueue(new Callback<HttpResponse<User>>() {
            @Override
            public void onResponse(Call<HttpResponse<User>> call, Response<HttpResponse<User>> response) {
                showLoading(false);

                // 例子代码，暂时忽略空值判断
                if(HttpResponse.CODE_SUCCESS != response.body().getCode()) {
                    promptError(response.body().getMsg() + "");
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(MainActivity.KEY_USER, response.body().getData());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<HttpResponse<User>> call, Throwable t) {
                showLoading(false);

                promptError(t.getMessage() + "");
            }
        });
    }
}
