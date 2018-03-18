package com.youngfeng.androidclient.http;

/**
 * Http response
 *
 * @author Scott Smith 2018-03-18 19:36
 */
public class HttpResponse<T> {
    private long code;
    private String msg;
    private T data;

    public static final long CODE_SUCCESS = 0;
    public static final long CODE_USER_NOT_EXIST = 1;
    public static final long CODE_USER_PWD_ERR = 2;
    public static final long CODE_USER_HAS_EXIST = 3;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
