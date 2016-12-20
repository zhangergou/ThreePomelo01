package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16 0016.
 */
public class CreatShopInBean {

    /**
     * shop_info : {"area_name":"昆山市","city_code":"320500","parent_mobile":"15051691989","province_code":"320000","type":"2","percent":"6","baidu_lat":"333","uid":"555","city_name":"苏州市","total":"0","parent_uid":"1316","logo":"2016/12/16/RAkGh7hKejaYYeep33DfgbxU.jpg","id":"188","lat":"111","business_time":"business_time","address":"address","lng":"222","area_code":"320583","cns1":"2016/12/16/kTQ0uOky6JIiJZMJ1mrADkNF.jpg","shop_name":"老马棋牌室","province_name":"江苏省","license":"2016/12/16/DRZKMzR3AB9h8RsNB2c0HRPb.jpg","cdate":"2016-12-16 10:31:48","baidu_lng":"444","phone":"phone","person":"person","ax":"0","desc":"desc","sfz1":"2016/12/16/Nq5UHlwrEMRz1CxxMGgV5s5x.jpg","status":"1"}
     * error_msg :
     * user_info : {"area_name":"路南区","is_dl":"1","rel_name":"杨洋","area_code":"130202","mobile":"18914970292","total12":"0","city_code":"130200","u_area_code":"320583","total24":"2000000","province_code":"130000","province_name":"河北省","shop_id":"0","city_name":"唐山市","face":"2016/12/15/wV3WRWTcoIJAwp5CpxnwRy7F.jpg","cdate":"2016-11-21 09:55:47","id_no":"320583888888888888","ax24":"0","ax12":"0","integral":"7977800","parent_id":"1316","total6":"0","id":"555","ax6":"0","status":"1"}
     * success : true
     */
    private ShopInfoEntity shop_info;
    private String error_msg;
    private UserInfoEntity user_info;
    private boolean success;


    public void setShop_info(ShopInfoEntity shop_info) {
        this.shop_info = shop_info;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setUser_info(UserInfoEntity user_info) {
        this.user_info = user_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ShopInfoEntity getShop_info() {
        return shop_info;
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

    public static class ShopInfoEntity {
        /**
         * area_name : 昆山市
         * city_code : 320500
         * parent_mobile : 15051691989
         * province_code : 320000
         * type : 2
         * percent : 6
         * baidu_lat : 333
         * uid : 555
         * city_name : 苏州市
         * total : 0
         * parent_uid : 1316
         * logo : 2016/12/16/RAkGh7hKejaYYeep33DfgbxU.jpg
         * id : 188
         * lat : 111
         * business_time : business_time
         * address : address
         * lng : 222
         * area_code : 320583
         * cns1 : 2016/12/16/kTQ0uOky6JIiJZMJ1mrADkNF.jpg
         * shop_name : 老马棋牌室
         * province_name : 江苏省
         * license : 2016/12/16/DRZKMzR3AB9h8RsNB2c0HRPb.jpg
         * cdate : 2016-12-16 10:31:48
         * baidu_lng : 444
         * phone : phone
         * person : person
         * ax : 0
         * desc : desc
         * sfz1 : 2016/12/16/Nq5UHlwrEMRz1CxxMGgV5s5x.jpg
         * status : 1
         */
        private String area_name;
        private String city_code;
        private String parent_mobile;
        private String province_code;
        private String type;
        private String percent;
        private String baidu_lat;
        private String uid;
        private String city_name;
        private String total;
        private String parent_uid;
        private String logo;
        private String id;
        private String lat;
        private String business_time;
        private String address;
        private String lng;
        private String area_code;
        private String cns1;
        private String shop_name;
        private String province_name;
        private String license;
        private String cdate;
        private String baidu_lng;
        private String phone;
        private String person;
        private String ax;
        private String desc;
        private String sfz1;
        private String status;

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public void setParent_mobile(String parent_mobile) {
            this.parent_mobile = parent_mobile;
        }

        public void setProvince_code(String province_code) {
            this.province_code = province_code;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public void setBaidu_lat(String baidu_lat) {
            this.baidu_lat = baidu_lat;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setParent_uid(String parent_uid) {
            this.parent_uid = parent_uid;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public void setBusiness_time(String business_time) {
            this.business_time = business_time;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public void setCns1(String cns1) {
            this.cns1 = cns1;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setBaidu_lng(String baidu_lng) {
            this.baidu_lng = baidu_lng;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public void setAx(String ax) {
            this.ax = ax;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setSfz1(String sfz1) {
            this.sfz1 = sfz1;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArea_name() {
            return area_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public String getParent_mobile() {
            return parent_mobile;
        }

        public String getProvince_code() {
            return province_code;
        }

        public String getType() {
            return type;
        }

        public String getPercent() {
            return percent;
        }

        public String getBaidu_lat() {
            return baidu_lat;
        }

        public String getUid() {
            return uid;
        }

        public String getCity_name() {
            return city_name;
        }

        public String getTotal() {
            return total;
        }

        public String getParent_uid() {
            return parent_uid;
        }

        public String getLogo() {
            return logo;
        }

        public String getId() {
            return id;
        }

        public String getLat() {
            return lat;
        }

        public String getBusiness_time() {
            return business_time;
        }

        public String getAddress() {
            return address;
        }

        public String getLng() {
            return lng;
        }

        public String getArea_code() {
            return area_code;
        }

        public String getCns1() {
            return cns1;
        }

        public String getShop_name() {
            return shop_name;
        }

        public String getProvince_name() {
            return province_name;
        }

        public String getLicense() {
            return license;
        }

        public String getCdate() {
            return cdate;
        }

        public String getBaidu_lng() {
            return baidu_lng;
        }

        public String getPhone() {
            return phone;
        }

        public String getPerson() {
            return person;
        }

        public String getAx() {
            return ax;
        }

        public String getDesc() {
            return desc;
        }

        public String getSfz1() {
            return sfz1;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class UserInfoEntity {
        /**
         * area_name : 路南区
         * is_dl : 1
         * rel_name : 杨洋
         * area_code : 130202
         * mobile : 18914970292
         * total12 : 0
         * city_code : 130200
         * u_area_code : 320583
         * total24 : 2000000
         * province_code : 130000
         * province_name : 河北省
         * shop_id : 0
         * city_name : 唐山市
         * face : 2016/12/15/wV3WRWTcoIJAwp5CpxnwRy7F.jpg
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
