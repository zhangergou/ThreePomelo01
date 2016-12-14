package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/14.
 */
public class MyOrderAllTotalBean {
    /**
     * success : true
     * error_msg :
     * all_total : 2000000
     */

    private boolean success;
    private String error_msg;
    private int all_total;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public int getAll_total() {
        return all_total;
    }

    public void setAll_total(int all_total) {
        this.all_total = all_total;
    }
}
