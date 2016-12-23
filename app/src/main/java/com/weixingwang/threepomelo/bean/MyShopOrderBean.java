package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public class MyShopOrderBean {

    /**
     * error_msg :
     * success : true
     * order_list : [{"shop_id":"47","uid":"555","cdate":"2016-11-28 17:15:10","rel_name":"杨洋","price":"1000000","mobile":"18914970292","id":"304","oid":"194","status":"3"},{"shop_id":"47","uid":"1316","cdate":"2016-11-28 17:15:22","rel_name":"姚斌","price":"1000000","mobile":"15051691989","id":"305","oid":"194","status":"3"},{"shop_id":"47","uid":"1446","cdate":"2016-11-28 17:15:36","rel_name":"周永康","price":"1000000","mobile":"18652429812","id":"306","oid":"194","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-11-28 17:15:57","rel_name":"陈燕","price":"4000000","mobile":"13912688061","id":"307","oid":"194","status":"3"}]
     * order : {"shop_id":"47","sdate":"2016-11-28 17:23:53","total":"7000000","cdate":"2016-11-28 17:15:10","num":"4","adate":"2016-11-29 17:33:50","remark":"","id":"194","pic":"2016/11/28/YPthbhigtqXJ0UMMaR4Bbe6z.jpg","percent":"6","status":"3"}
     */
    private String error_msg;
    private boolean success;
    private List<OrderListEntity> order_list;
    private OrderEntity order;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setOrder_list(List<OrderListEntity> order_list) {
        this.order_list = order_list;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
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

    public OrderEntity getOrder() {
        return order;
    }

    public static class OrderListEntity {
        /**
         * shop_id : 47
         * uid : 555
         * cdate : 2016-11-28 17:15:10
         * rel_name : 杨洋
         * price : 1000000
         * mobile : 18914970292
         * id : 304
         * oid : 194
         * status : 3
         */
        private String shop_id;
        private String uid;
        private String cdate;
        private String rel_name;
        private String price;
        private String mobile;
        private String id;
        private String oid;
        private String status;

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
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

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getUid() {
            return uid;
        }

        public String getCdate() {
            return cdate;
        }

        public String getRel_name() {
            return rel_name;
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

        public String getStatus() {
            return status;
        }
    }

    public static class OrderEntity {
        /**
         * shop_id : 47
         * sdate : 2016-11-28 17:23:53
         * total : 7000000
         * cdate : 2016-11-28 17:15:10
         * num : 4
         * adate : 2016-11-29 17:33:50
         * remark :
         * id : 194
         * pic : 2016/11/28/YPthbhigtqXJ0UMMaR4Bbe6z.jpg
         * percent : 6
         * status : 3
         */
        private String shop_id;
        private String sdate;
        private String total;
        private String cdate;
        private String num;
        private String adate;
        private String remark;
        private String id;
        private String pic;
        private String percent;
        private String status;

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setSdate(String sdate) {
            this.sdate = sdate;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setAdate(String adate) {
            this.adate = adate;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getSdate() {
            return sdate;
        }

        public String getTotal() {
            return total;
        }

        public String getCdate() {
            return cdate;
        }

        public String getNum() {
            return num;
        }

        public String getAdate() {
            return adate;
        }

        public String getRemark() {
            return remark;
        }

        public String getId() {
            return id;
        }

        public String getPic() {
            return pic;
        }

        public String getPercent() {
            return percent;
        }

        public String getStatus() {
            return status;
        }
    }
}
