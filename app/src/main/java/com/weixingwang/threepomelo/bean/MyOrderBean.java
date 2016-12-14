package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
public class MyOrderBean {

    /**
     * error_msg :
     * order_list : [{"address":"开发区前进东路208号联彩中心501室（世茂广场对面）","cdate":"2016-11-28 17:15:10","id":"304","mobile":"18914970292","oid":"194","price":"1000000","shop_id":"47","shop_name":"昆山艾尚美装饰工程有限公司","status":"3","uid":"555"},{"address":"开发区前进东路208号联彩中心501室（世茂广场对面）","cdate":"2016-11-21 14:50:08","id":"134","mobile":"18914970292","oid":"59","price":"1000000","shop_id":"47","shop_name":"昆山艾尚美装饰工程有限公司","status":"3","uid":"555"}]
     * success : true
     */

    private String error_msg;
    private boolean success;
    /**
     * address : 开发区前进东路208号联彩中心501室（世茂广场对面）
     * cdate : 2016-11-28 17:15:10
     * id : 304
     * mobile : 18914970292
     * oid : 194
     * price : 1000000
     * shop_id : 47
     * shop_name : 昆山艾尚美装饰工程有限公司
     * status : 3
     * uid : 555
     */

    private java.util.List<OrderListBean> order_list;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<OrderListBean> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderListBean> order_list) {
        this.order_list = order_list;
    }

    public static class OrderListBean {
        private String address;
        private String cdate;
        private String id;
        private String mobile;
        private String oid;
        private String price;
        private String shop_id;
        private String shop_name;
        private String status;
        private String uid;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCdate() {
            return cdate;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

}
