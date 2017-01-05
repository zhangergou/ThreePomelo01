package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class LoginBean {


    /**
     * error_msg :
     * success : true
     * token : uIyBe4mjcbCyq5KZu9x7loZ6pZWwt57gh4Seog==
     */
    private String error_msg;
    private boolean success;
    private String token;
    private int user_order_id;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public int getUser_order_id() {
        return user_order_id;
    }

    public void setUser_order_id(int user_order_id) {
        this.user_order_id = user_order_id;
    }
}
