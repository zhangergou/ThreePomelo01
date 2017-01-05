package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
public class MyOrderBean {


    /**
     * error_msg :
     * success : true
     * order_list : [{"shop_id":"73","uid":"1354","address":"巴城湖滨中路1575号 ","cdate":"2016-11-27 17:01:01","phone":"13451699031","price":"129000","mobile":"15962634187","id":"267","oid":"164","shop_name":"欣丰蟹楼","status":"3"},{"shop_id":"47","uid":"1354","address":"开发区前进东路208号联彩中心501室（世茂广场对面）","cdate":"2016-11-23 17:11:57","phone":"15962634187","price":"1000000","mobile":"15962634187","id":"198","oid":"106","shop_name":"昆山艾尚美装饰工程有限公司","status":"3"}]
     */
    private String error_msg;
    private boolean success;
    private List<OrderListEntity> order_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setOrder_list(List<OrderListEntity> order_list) {
        this.order_list = order_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<OrderListEntity> getOrder_list() {
        return order_list;
    }

    public static class OrderListEntity {
        /**
         * shop_id : 73
         * uid : 1354
         * address : 巴城湖滨中路1575号
         * cdate : 2016-11-27 17:01:01
         * phone : 13451699031
         * price : 129000
         * mobile : 15962634187
         * id : 267
         * oid : 164
         * shop_name : 欣丰蟹楼
         * status : 3
         */
        private String shop_id;
        private String uid;
        private String address;
        private String cdate;
        private String phone;
        private String price;
        private String mobile;
        private String id;
        private String oid;
        private String shop_name;
        private String status;

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getUid() {
            return uid;
        }

        public String getAddress() {
            return address;
        }

        public String getCdate() {
            return cdate;
        }

        public String getPhone() {
            return phone;
        }

        public String getPrice() {
            return price;
        }

        public String getMobile() {
            return mobile;
        }

        public String getId() {
            return id;
        }

        public String getOid() {
            return oid;
        }

        public String getShop_name() {
            return shop_name;
        }

        public String getStatus() {
            return status;
        }
    }
}
