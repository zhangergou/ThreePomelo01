package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class RegestRecommendBean {

    /**
     * error_msg :
     * success : true
     * name : 姚斌
     * id : 1316
     */
    private String error_msg;
    private boolean success;
    private String name;
    private String id;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
