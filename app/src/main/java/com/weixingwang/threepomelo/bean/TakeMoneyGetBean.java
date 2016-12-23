package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class TakeMoneyGetBean {

    /**
     * error_msg :
     * user_info : {"area_name":"如皋市","is_dl":"2","rel_name":"王飞","area_code":"320682","mobile":"15862777477","total12":"0","city_code":"320600","u_area_code":"320583","total24":"20800000","province_code":"320000","province_name":"江苏省","shop_id":"0","city_name":"南通市","face":"2016/11/19/y8zVZoVl2K3NFlTBt7NHv7GH.jpg","cdate":"2016-11-19 11:39:07","id_no":"320682198108065331","ax24":"0","ax12":"0","integral":"9134","parent_id":"1322","total6":"0","id":"1333","ax6":"0","status":"1"}
     * withdraw_info : {"sxf":"500","bank_branch":"长青沙支行","uid":"1333","bank":"中国邮政","cdate":"2016-12-08 08:53:36","flag":"1","money":"190000","rel_name":"王飞","id":"1743","bank_no":"6217993000201755488","status":"1"}
     * success : true
     */
    private String error_msg;
    private UserInfoEntity user_info;
    private WithdrawInfoEntity withdraw_info;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setUser_info(UserInfoEntity user_info) {
        this.user_info = user_info;
    }

    public void setWithdraw_info(WithdrawInfoEntity withdraw_info) {
        this.withdraw_info = withdraw_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public UserInfoEntity getUser_info() {
        return user_info;
    }

    public WithdrawInfoEntity getWithdraw_info() {
        return withdraw_info;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class UserInfoEntity {
        /**
         * area_name : 如皋市
         * is_dl : 2
         * rel_name : 王飞
         * area_code : 320682
         * mobile : 15862777477
         * total12 : 0
         * city_code : 320600
         * u_area_code : 320583
         * total24 : 20800000
         * province_code : 320000
         * province_name : 江苏省
         * shop_id : 0
         * city_name : 南通市
         * face : 2016/11/19/y8zVZoVl2K3NFlTBt7NHv7GH.jpg
         * cdate : 2016-11-19 11:39:07
         * id_no : 320682198108065331
         * ax24 : 0
         * ax12 : 0
         * integral : 9134
         * parent_id : 1322
         * total6 : 0
         * id : 1333
         * ax6 : 0
         * status : 1
         */
        private String area_name;
        private String is_dl;
        private String rel_name;
        private String area_code;
        private String mobile;
        private String total12;
        private String city_code;
        private String u_area_code;
        private String total24;
        private String province_code;
        private String province_name;
        private String shop_id;
        private String city_name;
        private String face;
        private String cdate;
        private String id_no;
        private String ax24;
        private String ax12;
        private String integral;
        private String parent_id;
        private String total6;
        private String id;
        private String ax6;
        private String status;

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public void setIs_dl(String is_dl) {
            this.is_dl = is_dl;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setTotal12(String total12) {
            this.total12 = total12;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public void setU_area_code(String u_area_code) {
            this.u_area_code = u_area_code;
        }

        public void setTotal24(String total24) {
            this.total24 = total24;
        }

        public void setProvince_code(String province_code) {
            this.province_code = province_code;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setId_no(String id_no) {
            this.id_no = id_no;
        }

        public void setAx24(String ax24) {
            this.ax24 = ax24;
        }

        public void setAx12(String ax12) {
            this.ax12 = ax12;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public void setTotal6(String total6) {
            this.total6 = total6;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setAx6(String ax6) {
            this.ax6 = ax6;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArea_name() {
            return area_name;
        }

        public String getIs_dl() {
            return is_dl;
        }

        public String getRel_name() {
            return rel_name;
        }

        public String getArea_code() {
            return area_code;
        }

        public String getMobile() {
            return mobile;
        }

        public String getTotal12() {
            return total12;
        }

        public String getCity_code() {
            return city_code;
        }

        public String getU_area_code() {
            return u_area_code;
        }

        public String getTotal24() {
            return total24;
        }

        public String getProvince_code() {
            return province_code;
        }

        public String getProvince_name() {
            return province_name;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public String getFace() {
            return face;
        }

        public String getCdate() {
            return cdate;
        }

        public String getId_no() {
            return id_no;
        }

        public String getAx24() {
            return ax24;
        }

        public String getAx12() {
            return ax12;
        }

        public String getIntegral() {
            return integral;
        }

        public String getParent_id() {
            return parent_id;
        }

        public String getTotal6() {
            return total6;
        }

        public String getId() {
            return id;
        }

        public String getAx6() {
            return ax6;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class WithdrawInfoEntity {
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
