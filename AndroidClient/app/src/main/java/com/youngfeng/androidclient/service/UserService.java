package com.youngfeng.androidclient.service;

import com.youngfeng.androidclient.domain.User;
import com.youngfeng.androidclient.http.HttpResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 用户操作接口
 *
 * @author Scott Smith 2018-03-18 11:36
 */
public interface UserService {

    @FormUrlEncoded
    @POST("user/login")
    Call<HttpResponse<User>> login(@Field("username") String username, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("user/register")
    Call<HttpResponse<User>> register(@Field("username") String username, @Field("pwd") String pwd);
}
