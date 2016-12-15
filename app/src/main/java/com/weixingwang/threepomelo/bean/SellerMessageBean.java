package com.weixingwang.threepomelo.bean;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class SellerMessageBean {

    /**
     * error_msg :
     * shop_detail : {"type_name":"超市","city_code":"320500","parent_mobile":"00000000000","adate":"2016-11-19 15:10:19","remark":"","province_code":"320000","type":"4","percent":"24","baidu_lat":"31.482486","uid":"1314","total":"106000","parent_uid":"1","logo":"2016/11/19/Se3z5RdtnFniMi6aSTo4ohdH.jpg","id":"43","lat":"31.476351","business_time":"24小时","address":"巴城镇学院路999号","lng":" 120.863021","area_code":"320583","cns1":"2016/11/19/mvibdVjDXhhfCWQB5r6vGvJ0.jpg","ar_name":"昆山市","shop_name":"浦东软件园烟酒店","license":"2016/11/19/0BydSUfazJa50OYNULw6u3HN.jpg","cdate":"2016-11-19 13:35:13","baidu_lng":"120.869505","phone":"36823413","p_name":"江苏省","person":"华仔","ax":"0","c_name":"苏州市","desc":"服务非常好啊，真的不错","sfz1":"2016/11/19/GGxB9FOWBwxeShifZZV1mc2S.jpg","status":"2"}
     * success : true
     */
    private String error_msg;
    private ShopDetailEntity shop_detail;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setShop_detail(ShopDetailEntity shop_detail) {
        this.shop_detail = shop_detail;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public ShopDetailEntity getShop_detail() {
        return shop_detail;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ShopDetailEntity {
        /**
         * type_name : 超市
         * city_code : 320500
         * parent_mobile : 00000000000
         * adate : 2016-11-19 15:10:19
         * remark :
         * province_code : 320000
         * type : 4
         * percent : 24
         * baidu_lat : 31.482486
         * uid : 1314
         * total : 106000
         * parent_uid : 1
         * logo : 2016/11/19/Se3z5RdtnFniMi6aSTo4ohdH.jpg
         * id : 43
         * lat : 31.476351
         * business_time : 24小时
         * address : 巴城镇学院路999号
         * lng :  120.863021
         * area_code : 320583
         * cns1 : 2016/11/19/mvibdVjDXhhfCWQB5r6vGvJ0.jpg
         * ar_name : 昆山市
         * shop_name : 浦东软件园烟酒店
         * license : 2016/11/19/0BydSUfazJa50OYNULw6u3HN.jpg
         * cdate : 2016-11-19 13:35:13
         * baidu_lng : 120.869505
         * phone : 36823413
         * p_name : 江苏省
         * person : 华仔
         * ax : 0
         * c_name : 苏州市
         * desc : 服务非常好啊，真的不错
         * sfz1 : 2016/11/19/GGxB9FOWBwxeShifZZV1mc2S.jpg
         * status : 2
         */
        private String type_name;
        private String city_code;
        private String parent_mobile;
        private String adate;
        private String remark;
        private String province_code;
        private String type;
        private String percent;
        private String baidu_lat;
        private String uid;
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
        private String ar_name;
        private String shop_name;
        private String license;
        private String cdate;
        private String baidu_lng;
        private String phone;
        private String p_name;
        private String person;
        private String ax;
        private String c_name;
        private String desc;
        private String sfz1;
        private String status;

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public void setParent_mobile(String parent_mobile) {
            this.parent_mobile = parent_mobile;
        }

        public void setAdate(String adate) {
            this.adate = adate;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public void setAr_name(String ar_name) {
            this.ar_name = ar_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
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

        public void setP_name(String p_name) {
            this.p_name = p_name;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public void setAx(String ax) {
            this.ax = ax;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
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

        public String getType_name() {
            return type_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public String getParent_mobile() {
            return parent_mobile;
        }

        public String getAdate() {
            return adate;
        }

        public String getRemark() {
            return remark;
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

        public String getAr_name() {
            return ar_name;
        }

        public String getShop_name() {
            return shop_name;
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

        public String getP_name() {
            return p_name;
        }

        public String getPerson() {
            return person;
        }

        public String getAx() {
            return ax;
        }

        public String getC_name() {
            return c_name;
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
}
