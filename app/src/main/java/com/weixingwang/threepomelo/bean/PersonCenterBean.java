package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class PersonCenterBean {

    /**
     * error_msg :
     * user_info : {"area_name":"昆山市","is_dl":"1","rel_name":"杨洋","area_code":"320583","mobile":"18914970292","total12":"0","city_code":"320500","u_area_code":"320583","total24":"2000000","province_code":"320000","province_name":"江苏省","shop_id":"0","city_name":"苏州市","face":"2016/11/22/Z2grjTUKHkTrIQPtfoNKMWux.jpg","cdate":"2016-11-21 09:55:47","id_no":"320583888888888888","ax24":"0","ax12":"0","integral":"7977800","parent_id":"1316","total6":"0","id":"555","ax6":"0","status":"1"}
     * success : true
     * sum_count : 40
     */
    private String error_msg;
    private UserInfoEntity user_info;
    private boolean success;
    private String sum_count;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setUser_info(UserInfoEntity user_info) {
        this.user_info = user_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setSum_count(String sum_count) {
        this.sum_count = sum_count;
    }

    public String getError_msg() {
        return error_msg;
    }

    public UserInfoEntity getUser_info() {
        return user_info;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getSum_count() {
        return sum_count;
    }

    public static class UserInfoEntity {
        /**
         * area_name : 昆山市
         * is_dl : 1
         * rel_name : 杨洋
         * area_code : 320583
         * mobile : 18914970292
         * total12 : 0
         * city_code : 320500
         * u_area_code : 320583
         * total24 : 2000000
         * province_code : 320000
         * province_name : 江苏省
         * shop_id : 0
         * city_name : 苏州市
         * face : 2016/11/22/Z2grjTUKHkTrIQPtfoNKMWux.jpg
         * cdate : 2016-11-21 09:55:47
         * id_no : 320583888888888888
         * ax24 : 0
         * ax12 : 0
         * integral : 7977800
         * parent_id : 1316
         * total6 : 0
         * id : 555
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
}
