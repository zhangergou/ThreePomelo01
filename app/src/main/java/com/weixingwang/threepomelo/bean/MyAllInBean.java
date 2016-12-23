package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class MyAllInBean {

    /**
     * error_msg :
     * success : true
     * my_income_list : [{"uid":"1333","cdate":"2016-12-08 07:09:41","money":"193440","remark":"向日葵激励(会员)","id":"6110","type":"2"},{"uid":"1333","cdate":"2016-12-07 07:06:37","money":"328640","remark":"向日葵激励(会员)","id":"5291","type":"2"},{"uid":"1333","cdate":"2016-12-06 19:40:32","money":"12000","remark":"服务商下级业务员推荐奖励","id":"5216","type":"7"},{"uid":"1333","cdate":"2016-12-06 19:02:36","money":"18000","remark":"服务商下级业务员推荐奖励","id":"5180","type":"7"},{"uid":"1333","cdate":"2016-12-06 01:09:18","money":"415584","remark":"向日葵激励(会员)","id":"4480","type":"2"},{"uid":"1333","cdate":"2016-12-05 20:39:46","money":"3000","remark":"服务商推荐商家奖励","id":"4367","type":"5"},{"uid":"1333","cdate":"2016-12-05 20:39:46","money":"1500","remark":"推荐客户奖励","id":"4366","type":"3"},{"uid":"1333","cdate":"2016-12-05 19:42:37","money":"600","remark":"服务商下级业务员推荐奖励","id":"4328","type":"7"},{"uid":"1333","cdate":"2016-12-05 19:13:15","money":"7800","remark":"服务商推荐商家奖励","id":"4283","type":"5"},{"uid":"1333","cdate":"2016-12-05 05:07:16","money":"260000","remark":"向日葵激励(会员)","id":"3778","type":"2"},{"uid":"1333","cdate":"2016-12-04 07:28:31","money":"986752","remark":"向日葵激励(会员)","id":"3143","type":"2"},{"uid":"1333","cdate":"2016-12-03 17:32:24","money":"12000","remark":"服务商下级业务员推荐奖励","id":"3075","type":"7"},{"uid":"1333","cdate":"2016-12-03 17:32:11","money":"24000","remark":"服务商推荐商家奖励","id":"3072","type":"5"},{"uid":"1333","cdate":"2016-12-03 17:32:11","money":"12000","remark":"推荐客户奖励","id":"3071","type":"3"},{"uid":"1333","cdate":"2016-12-03 17:22:20","money":"12000","remark":"服务商下级业务员推荐奖励","id":"3048","type":"7"},{"uid":"1333","cdate":"2016-12-03 17:20:21","money":"18000","remark":"服务商下级业务员推荐奖励","id":"3032","type":"7"},{"uid":"1333","cdate":"2016-12-03 17:16:00","money":"180000","remark":"服务商推荐商家奖励","id":"2993","type":"5"},{"uid":"1333","cdate":"2016-12-03 17:16:00","money":"90000","remark":"推荐客户奖励","id":"2992","type":"3"},{"uid":"1333","cdate":"2016-12-03 17:13:29","money":"12000","remark":"服务商下级业务员推荐奖励","id":"2987","type":"7"},{"uid":"1333","cdate":"2016-12-03 17:13:13","money":"18000","remark":"服务商下级业务员推荐奖励","id":"2984","type":"7"}]
     */
    private String error_msg;
    private boolean success;
    private List<MyIncomeListEntity> my_income_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMy_income_list(List<MyIncomeListEntity> my_income_list) {
        this.my_income_list = my_income_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<MyIncomeListEntity> getMy_income_list() {
        return my_income_list;
    }

    public static class MyIncomeListEntity {
        /**
         * uid : 1333
         * cdate : 2016-12-08 07:09:41
         * money : 193440
         * remark : 向日葵激励(会员)
         * id : 6110
         * type : 2
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
