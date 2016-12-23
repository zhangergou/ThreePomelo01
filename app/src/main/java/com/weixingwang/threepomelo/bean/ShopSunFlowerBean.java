package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class ShopSunFlowerBean {

    /**
     * error_msg :
     * success : true
     * shop_heart_list : [{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26604","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26592","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26591","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26590","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26589","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26588","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26587","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26586","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26585","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26593","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26594","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26595","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26603","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26602","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26601","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26600","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26599","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26598","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26597","percent":"6","status":"1"},{"return_integral":"0","shop_id":"47","cdate":"2016-12-19 15:54:36","id":"26596","percent":"6","status":"1"}]
     */
    private String error_msg;
    private boolean success;
    private List<ShopHeartListEntity> shop_heart_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setShop_heart_list(List<ShopHeartListEntity> shop_heart_list) {
        this.shop_heart_list = shop_heart_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ShopHeartListEntity> getShop_heart_list() {
        return shop_heart_list;
    }

    public static class ShopHeartListEntity {
        /**
         * return_integral : 0
         * shop_id : 47
         * cdate : 2016-12-19 15:54:36
         * id : 26604
         * percent : 6
         * status : 1
         */
        private String return_integral;
        private String shop_id;
        private String cdate;
        private String id;
        private String percent;
        private String status;

        public void setReturn_integral(String return_integral) {
            this.return_integral = return_integral;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReturn_integral() {
            return return_integral;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getCdate() {
            return cdate;
        }

        public String getId() {
            return id;
        }

        public String getPercent() {
            return percent;
        }

        public String getStatus() {
            return status;
        }
    }
}
