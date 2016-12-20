package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
public class SunFlowerCountPersonBean {

    /**
     * error_msg :
     * success : true
     * user_heart_list : [{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3779","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3768","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3767","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3766","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3765","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3764","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3763","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3762","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3761","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3769","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3770","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3778","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3777","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3776","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3775","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3774","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3773","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3772","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3771","percent":"24","status":"1"},{"return_integral":"13816","uid":"555","cdate":"2016-11-29 17:33:50","id":"3760","percent":"24","status":"1"}]
     */
    private String error_msg;
    private boolean success;
    private List<UserHeartListEntity> user_heart_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUser_heart_list(List<UserHeartListEntity> user_heart_list) {
        this.user_heart_list = user_heart_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<UserHeartListEntity> getUser_heart_list() {
        return user_heart_list;
    }

    public static class UserHeartListEntity {
        /**
         * return_integral : 13816
         * uid : 555
         * cdate : 2016-11-29 17:33:50
         * id : 3779
         * percent : 24
         * status : 1
         */
        private String return_integral;
        private String uid;
        private String cdate;
        private String id;
        private String percent;
        private String status;

        public void setReturn_integral(String return_integral) {
            this.return_integral = return_integral;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getUid() {
            return uid;
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
