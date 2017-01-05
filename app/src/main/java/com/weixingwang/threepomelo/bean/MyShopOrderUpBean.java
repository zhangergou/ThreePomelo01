package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderUpBean {

    /**
     * error_msg :
     * success : true
     * orders : [{"shop_id":"47","total":"0","cdate":"2016-12-19 15:26:34","num":"0","id":"822","status":"1"},{"shop_id":"47","sdate":"2016-12-19 14:58:46","total":"8000000","cdate":"2016-12-05 15:02:19","num":"6","adate":"2016-12-19 15:54:36","id":"643","pic":"","status":"3"},{"shop_id":"47","sdate":"2016-12-03 16:46:57","total":"1000000","cdate":"2016-12-03 16:46:00","num":"1","adate":"2016-12-04 21:29:20","remark":"","id":"575","pic":"2016/12/04/588xGtUwH3RTxI9I73HvfMRQ.jpg","status":"3"},{"shop_id":"47","sdate":"2016-12-02 20:37:12","total":"500000","cdate":"2016-12-02 20:36:52","num":"1","adate":"2016-12-03 17:20:32","remark":"","id":"465","pic":"2016/12/02/qaOlqdIyX5fhWJx50OIRjmJP.jpg","status":"3"},{"shop_id":"47","sdate":"2016-12-01 22:48:46","total":"2000000","cdate":"2016-12-01 22:46:40","num":"1","adate":"2016-12-02 22:52:00","remark":"","id":"487","pic":"2016/12/02/8aTFJNj7lp0tioNDIuNrDUBA.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-30 18:41:13","total":"1000000","cdate":"2016-11-30 18:39:20","num":"1","adate":"2016-12-01 18:04:32","remark":"","id":"384","pic":"2016/12/01/NgEz4vKLeXaIM97sSweknEIR.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-30 17:26:50","total":"1000000","cdate":"2016-11-30 17:26:22","num":"1","adate":"2016-12-01 17:38:48","remark":"","id":"290","pic":"2016/11/30/1nxb5a1rC93iqsrSc8LCTYrD.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-30 13:07:18","total":"1000000","cdate":"2016-11-30 13:05:59","num":"1","adate":"2016-12-01 16:17:55","remark":"","id":"273","pic":"2016/11/30/qEFgNSkPbc0oofRwSdza0AV8.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-29 15:28:19","total":"1000000","cdate":"2016-11-29 15:19:16","num":"2","adate":"2016-11-30 22:52:55","remark":"","id":"237","pic":"2016/11/29/gy8RxdaZkXl6eahaLa2IszSs.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-28 17:23:53","total":"7000000","cdate":"2016-11-28 17:15:10","num":"4","adate":"2016-11-29 17:33:50","remark":"","id":"194","pic":"2016/11/28/YPthbhigtqXJ0UMMaR4Bbe6z.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-24 13:15:13","total":"1000000","cdate":"2016-11-24 13:14:45","num":"1","adate":"2016-11-25 17:08:09","remark":"","id":"118","pic":"2016/11/24/J40pnY2HOP32c5iagqZvbz5i.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-23 17:14:50","total":"1000000","cdate":"2016-11-23 17:11:57","num":"1","adate":"2016-11-24 17:59:15","remark":"转错，另外又转了300，请查收","id":"106","pic":"2016/11/23/TuXExrJ5A3FVYbG0QDyx38dY.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-21 14:50:55","total":"1000000","cdate":"2016-11-21 14:50:08","num":"1","adate":"2016-11-21 15:09:19","remark":"","id":"59","pic":"2016/11/21/74eQLrARFUy8CRjTeqHJ1OY2.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-21 13:31:06","total":"1000000","cdate":"2016-11-21 13:29:08","num":"1","adate":"2016-11-21 13:46:43","remark":"","id":"56","pic":"2016/11/21/qODqA9ZZxNsNC6JlYacL09Kl.jpg","status":"3"},{"shop_id":"47","sdate":"2016-11-20 13:10:01","total":"100000","cdate":"2016-11-20 13:06:19","num":"1","adate":"2016-11-20 13:11:32","remark":"","id":"47","pic":"2016/11/20/I0WNbN7AGNJmlIbl4mV0boH8.jpg","status":"3"}]
     */
    private String error_msg;
    private boolean success;
    private List<OrdersEntity> orders;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public static class OrdersEntity {
        /**
         * shop_id : 47
         * total : 0
         * cdate : 2016-12-19 15:26:34
         * num : 0
         * id : 822
         * status : 1
         */
        private String shop_id;
        private String total;
        private String cdate;
        private String num;
        private String id;
        private String status;
        private String pic;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
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

        public void setId(String id) {
            this.id = id;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShop_id() {
            return shop_id;
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

        public String getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }
    }
}
