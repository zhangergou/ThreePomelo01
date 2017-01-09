package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
public class PayCodeBean {


    /**
     * error_msg :
     * pay_info : weixin://wxpay/bizpayurl?pr=900wuHX
     * success : true
     * pay_code : wechatCodePay
     */
    private String error_msg;
    private String pay_info;
    private boolean success;
    private String pay_code;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public String getPay_info() {
        return pay_info;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getPay_code() {
        return pay_code;
    }
}
