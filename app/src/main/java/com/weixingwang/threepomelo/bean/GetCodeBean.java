package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class GetCodeBean {

    /**
     * error_msg :
     * success : true
     * yzm : 830528
     */
    private String error_msg;
    private boolean success;
    private int yzm;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setYzm(int yzm) {
        this.yzm = yzm;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getYzm() {
        return yzm;
    }
}
