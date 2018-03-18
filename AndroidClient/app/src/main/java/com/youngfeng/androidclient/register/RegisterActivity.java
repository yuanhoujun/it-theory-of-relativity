package com.youngfeng.androidclient.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.youngfeng.androidclient.MainActivity;
import com.youngfeng.androidclient.R;
import com.youngfeng.androidclient.common.BaseActivity;
import com.youngfeng.androidclient.domain.User;
import com.youngfeng.androidclient.http.HttpResponse;
import com.youngfeng.androidclient.http.RetrofitManager;
import com.youngfeng.androidclient.login.LoginActivity;
import com.youngfeng.androidclient.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Register activity.
 *
 * @author Scott Smith 2018-03-18 16:24
 */
public class RegisterActivity extends BaseActivity {
    private EditText mUsernameEdit;
    private EditText mPwdEdit;
    private EditText mConfirmPwdEdit;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsernameEdit = findViewById(R.id.edit_username);
        mPwdEdit = findViewById(R.id.edit_pwd);
        mConfirmPwdEdit = findViewById(R.id.edit_confirm_pwd);

        mRegisterBtn = findViewById(R.id.btn_register);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameEdit.getText().toString();

                if(TextUtils.isEmpty(username)) {
                    promptError("请输入用户名");
                    return;
                }

                String pwd = mPwdEdit.getText().toString();
                if(TextUtils.isEmpty(pwd)) {
                    promptError("请输入密码");
                    return;
                }

                String confirmPwd = mConfirmPwdEdit.getText().toString();
                if(TextUtils.isEmpty(confirmPwd)) {
                    promptError("请输入确认密码");
                    return;
                }

                if(!pwd.equals(confirmPwd)) {
                    promptError("两次密码输入不一致");
                    return;
                }

                register(username, pwd);
            }
        });
    }

    private void register(String username, String pwd) {
        Retrofit retrofit = RetrofitManager.createDefault();
        UserService userService = retrofit.create(UserService.class);
        Call<HttpResponse<User>> call = userService.register(username, pwd);

        showLoading(true);
        call.enqueue(new Callback<HttpResponse<User>>() {
            @Override
            public void onResponse(Call<HttpResponse<User>> call, Response<HttpResponse<User>> response) {
                showLoading(false);

                // 例子代码，暂时忽略空值判断
                if(HttpResponse.CODE_SUCCESS != response.body().getCode()) {
                    promptError(response.body().getMsg() + "");
                } else {
                    promptError("注册成功", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
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
