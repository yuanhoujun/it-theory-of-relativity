package com.youngfeng.server.model;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response {
    private int code = CODE_SUCCESS;
    private String msg;
    private Object data;

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_USER_NOT_EXIST = 1;
    public static final int CODE_USER_PWD_ERR = 2;
    public static final int CODE_USER_HAS_EXIST = 3;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}