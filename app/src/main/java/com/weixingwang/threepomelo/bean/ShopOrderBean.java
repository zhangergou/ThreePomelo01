package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
public class ShopOrderBean {

    /**
     * error_msg :
     * success : true
     * order_list : [{"need_pay":"68800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:47:40","total_price":"68800","goods_pty":"1","id":"190","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:39:34","total_price":"38800","goods_pty":"1","id":"189","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"36578","uid":"1354","use_integral":"2222","cdate":"2017-01-06 16:36:46","total_price":"38800","goods_pty":"1","id":"188","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:32:27","total_price":"38800","goods_pty":"1","id":"187","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"0","uid":"1354","use_integral":"68800","cdate":"2017-01-06 16:28:44","total_price":"68800","goods_pty":"1","id":"186","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"3"},{"need_pay":"50","uid":"1354","use_integral":"38750","cdate":"2017-01-06 16:16:39","total_price":"38800","goods_pty":"1","id":"185","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:15:19","total_price":"38800","goods_pty":"1","id":"184","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"1"},{"need_pay":"16600","uid":"1354","use_integral":"22200","cdate":"2017-01-06 16:12:12","total_price":"38800","goods_pty":"1","id":"183","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"109900","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:11:00","total_price":"109900","goods_pty":"1","id":"182","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"68800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:08:52","total_price":"68800","goods_pty":"1","id":"181","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"16600","uid":"1354","use_integral":"22200","cdate":"2017-01-06 16:08:05","total_price":"38800","goods_pty":"1","id":"180","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:07:19","total_price":"38800","goods_pty":"1","id":"179","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"68800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:05:11","total_price":"68800","goods_pty":"1","id":"178","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"68800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:04:05","total_price":"68800","goods_pty":"1","id":"177","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"36600","uid":"1354","use_integral":"2200","cdate":"2017-01-06 16:03:35","total_price":"38800","goods_pty":"1","id":"176","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"68800","uid":"1354","use_integral":"0","cdate":"2017-01-06 16:01:13","total_price":"68800","goods_pty":"1","id":"175","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-06 15:59:42","total_price":"38800","goods_pty":"1","id":"174","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"36600","uid":"1354","use_integral":"2200","cdate":"2017-01-06 15:58:42","total_price":"38800","goods_pty":"1","id":"173","good_logo":"7bd6f4336b13b14de95397c4632b5575.jpg","status":"2"},{"need_pay":"0","uid":"1354","use_integral":"18900","cdate":"2017-01-06 15:51:00","total_price":"18900","goods_pty":"1","id":"172","good_logo":"21b6bb7f944bc9d0fbe8fdd3187c1773.JPG","status":"3"},{"need_pay":"0","uid":"1354","use_integral":"255300","cdate":"2017-01-06 15:49:42","total_price":"255300","goods_pty":"5","id":"171","good_logo":"21b6bb7f944bc9d0fbe8fdd3187c1773.JPG","status":"3"}]
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
         * need_pay : 68800
         * uid : 1354
         * use_integral : 0
         * cdate : 2017-01-06 16:47:40
         * total_price : 68800
         * goods_pty : 1
         * id : 190
         * good_logo : 7bd6f4336b13b14de95397c4632b5575.jpg
         * status : 2
         */
        private String need_pay;
        private String uid;
        private String use_integral;
        private String cdate;
        private String total_price;
        private String goods_pty;
        private String id;
        private String good_logo;
        private String good_name;
        private String status;

        public String getGood_name() {
            return good_name;
        }

        public void setGood_name(String good_name) {
            this.good_name = good_name;
        }

        public void setNeed_pay(String need_pay) {
            this.need_pay = need_pay;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setUse_integral(String use_integral) {
            this.use_integral = use_integral;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public void setGoods_pty(String goods_pty) {
            this.goods_pty = goods_pty;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setGood_logo(String good_logo) {
            this.good_logo = good_logo;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNeed_pay() {
            return need_pay;
        }

        public String getUid() {
            return uid;
        }

        public String getUse_integral() {
            return use_integral;
        }

        public String getCdate() {
            return cdate;
        }

        public String getTotal_price() {
            return total_price;
        }

        public String getGoods_pty() {
            return goods_pty;
        }

        public String getId() {
            return id;
        }

        public String getGood_logo() {
            return good_logo;
        }

        public String getStatus() {
            return status;
        }
    }
}
