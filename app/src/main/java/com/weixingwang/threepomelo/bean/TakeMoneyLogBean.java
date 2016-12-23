package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class TakeMoneyLogBean {

    /**
     * error_msg :
     * withdraw_list : [{"sxf":"500","bank_branch":"长青沙支行","uid":"1333","bank":"中国邮政","cdate":"2016-12-08 08:53:36","flag":"1","money":"190000","rel_name":"王飞","id":"1743","bank_no":"6217993000201755488","status":"1"},{"sxf":"500","bank_branch":"长青沙支行","uid":"1333","bank":"中国邮政","cdate":"2016-12-07 07:22:15","flag":"1","money":"360000","rel_name":"王飞","id":"1433","bank_no":"6217993000201755488","status":"1"},{"sxf":"500","bank_branch":"长青沙支行","uid":"1333","bank":"中国邮政","cdate":"2016-12-06 08:37:14","flag":"1","money":"430000","rel_name":"王飞","id":"1290","bank_no":"6217993000201755488","status":"1"},{"sxf":"0","uid":"1333","cdate":"2016-12-05 09:11:30","flag":"2","money":"260000","rel_name":"潘芳","adate":"2016-12-07 15:48:47","remark":"","id":"1088","alipay_no":"pf143k@163.com","status":"2"},{"sxf":"0","uid":"1333","cdate":"2016-12-04 08:02:47","flag":"2","money":"1380000","rel_name":"潘芳","adate":"2016-12-06 15:23:34","remark":"","id":"854","alipay_no":"pf143k@163.com","status":"2"},{"sxf":"0","uid":"1333","cdate":"2016-12-03 07:02:05","flag":"2","money":"840000","rel_name":"潘芳","adate":"2016-12-05 10:22:06","remark":"","id":"667","alipay_no":"pf143k@163.com","status":"2"},{"sxf":"0","uid":"1333","cdate":"2016-12-02 07:12:21","flag":"2","money":"1140000","rel_name":"潘芳","adate":"2016-12-04 10:56:33","remark":"","id":"536","alipay_no":"pf143k@163.com","status":"2"},{"sxf":"500","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-12-02 19:38:16","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-12-01 07:02:33","money":"630000","id":"424","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-12-02 11:30:26","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-30 07:21:34","money":"920000","id":"344","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-12-01 01:01:17","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-29 21:31:59","money":"90000","id":"334","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-30 23:19:58","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-29 08:35:57","money":"750000","id":"270","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-30 22:28:51","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-28 18:16:08","money":"140000","id":"259","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-30 10:08:01","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-28 07:54:18","money":"690000","id":"213","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-28 21:20:50","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-27 15:25:50","money":"150000","id":"202","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-28 16:22:50","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-27 08:33:02","money":"270000","id":"176","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-27 15:53:09","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-26 08:50:26","money":"170000","id":"148","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-26 20:21:56","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-25 06:48:02","money":"260000","id":"103","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-26 12:29:09","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-24 18:10:07","money":"70000","id":"95","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-25 17:27:18","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-24 09:51:12","money":"320000","id":"86","status":"2"},{"sxf":"0","bank_branch":"长青沙支行","flag":"1","rel_name":"王飞","adate":"2016-11-24 17:37:23","remark":"","bank_no":"6217993000201755488","uid":"1333","bank":"中国邮政","cdate":"2016-11-23 09:06:07","money":"330000","id":"59","status":"2"}]
     * success : true
     */
    private String error_msg;
    private List<WithdrawListEntity> withdraw_list;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setWithdraw_list(List<WithdrawListEntity> withdraw_list) {
        this.withdraw_list = withdraw_list;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<WithdrawListEntity> getWithdraw_list() {
        return withdraw_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class WithdrawListEntity {
        /**
         * sxf : 500
         * bank_branch : 长青沙支行
         * uid : 1333
         * bank : 中国邮政
         * cdate : 2016-12-08 08:53:36
         * flag : 1
         * money : 190000
         * rel_name : 王飞
         * id : 1743
         * bank_no : 6217993000201755488
         * status : 1
         */
        private String sxf;
        private String bank_branch;
        private String uid;
        private String bank;
        private String cdate;
        private String flag;
        private String money;
        private String rel_name;
        private String id;
        private String bank_no;
        private String status;

        public void setSxf(String sxf) {
            this.sxf = sxf;
        }

        public void setBank_branch(String bank_branch) {
            this.bank_branch = bank_branch;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setBank_no(String bank_no) {
            this.bank_no = bank_no;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSxf() {
            return sxf;
        }

        public String getBank_branch() {
            return bank_branch;
        }

        public String getUid() {
            return uid;
        }

        public String getBank() {
            return bank;
        }

        public String getCdate() {
            return cdate;
        }

        public String getFlag() {
            return flag;
        }

        public String getMoney() {
            return money;
        }

        public String getRel_name() {
            return rel_name;
        }

        public String getId() {
            return id;
        }

        public String getBank_no() {
            return bank_no;
        }

        public String getStatus() {
            return status;
        }
    }
}
