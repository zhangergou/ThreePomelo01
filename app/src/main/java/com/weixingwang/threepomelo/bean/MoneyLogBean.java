package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class MoneyLogBean {

    /**
     * error_msg :
     * money_log_list : [{"uid":"1333","cdate":"2016-12-08 08:53:36","money":"-190000","remark":"用户提现","id":"6710","type":"1"},{"uid":"1333","cdate":"2016-12-08 07:09:41","money":"193440","remark":"向日葵激励(会员)","id":"6110","type":"2"},{"uid":"1333","cdate":"2016-12-07 07:22:15","money":"-360000","remark":"用户提现","id":"5761","type":"1"},{"uid":"1333","cdate":"2016-12-07 07:06:37","money":"328640","remark":"向日葵激励(会员)","id":"5291","type":"2"},{"uid":"1333","cdate":"2016-12-06 19:40:32","money":"12000","remark":"服务商下级业务员推荐奖励","id":"5216","type":"7"},{"uid":"1333","cdate":"2016-12-06 19:02:36","money":"18000","remark":"服务商下级业务员推荐奖励","id":"5180","type":"7"},{"uid":"1333","cdate":"2016-12-06 08:37:14","money":"-430000","remark":"用户提现","id":"4983","type":"1"},{"uid":"1333","cdate":"2016-12-06 01:09:18","money":"415584","remark":"向日葵激励(会员)","id":"4480","type":"2"},{"uid":"1333","cdate":"2016-12-05 20:39:46","money":"3000","remark":"服务商推荐商家奖励","id":"4367","type":"5"},{"uid":"1333","cdate":"2016-12-05 20:39:46","money":"1500","remark":"推荐客户奖励","id":"4366","type":"3"},{"uid":"1333","cdate":"2016-12-05 19:42:37","money":"600","remark":"服务商下级业务员推荐奖励","id":"4328","type":"7"},{"uid":"1333","cdate":"2016-12-05 19:13:15","money":"7800","remark":"服务商推荐商家奖励","id":"4283","type":"5"},{"uid":"1333","cdate":"2016-12-05 09:11:30","money":"-260000","remark":"用户提现","id":"4208","type":"1"},{"uid":"1333","cdate":"2016-12-05 05:07:16","money":"260000","remark":"向日葵激励(会员)","id":"3778","type":"2"},{"uid":"1333","cdate":"2016-12-04 08:02:47","money":"-1380000","remark":"用户提现","id":"3499","type":"1"},{"uid":"1333","cdate":"2016-12-04 07:28:31","money":"986752","remark":"向日葵激励(会员)","id":"3143","type":"2"},{"uid":"1333","cdate":"2016-12-03 17:32:24","money":"12000","remark":"服务商下级业务员推荐奖励","id":"3075","type":"7"},{"uid":"1333","cdate":"2016-12-03 17:32:11","money":"24000","remark":"服务商推荐商家奖励","id":"3072","type":"5"},{"uid":"1333","cdate":"2016-12-03 17:32:11","money":"12000","remark":"推荐客户奖励","id":"3071","type":"3"},{"uid":"1333","cdate":"2016-12-03 17:22:20","money":"12000","remark":"服务商下级业务员推荐奖励","id":"3048","type":"7"}]
     * success : true
     */
    private String error_msg;
    private List<MoneyLogListEntity> money_log_list;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setMoney_log_list(List<MoneyLogListEntity> money_log_list) {
        this.money_log_list = money_log_list;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<MoneyLogListEntity> getMoney_log_list() {
        return money_log_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class MoneyLogListEntity {
        /**
         * uid : 1333
         * cdate : 2016-12-08 08:53:36
         * money : -190000
         * remark : 用户提现
         * id : 6710
         * type : 1
         */
        private String uid;
        private String cdate;
        private String money;
        private String remark;
        private String id;
        private String type;

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUid() {
            return uid;
        }

        public String getCdate() {
            return cdate;
        }

        public String getMoney() {
            return money;
        }

        public String getRemark() {
            return remark;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }
    }
}
