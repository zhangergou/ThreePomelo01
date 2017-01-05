package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4 0004.
 */
public class SureOrderBean {

    /**
     * address_info : {}
     * error_msg :
     * goods_list : [{"good_num":"1","gg_id":"16","good_price":"38800","good_unit":"张","good_gmxz":"购买须知1","uo_id":"70","good_demo":"商品详情商品详情商品详情商品详情","gg_name":"规格1","good_id":"7","id":"78","good_name":"商品名称2","good_logo":"21b6bb7f944bc9d0fbe8fdd3187c1773.JPG"}]
     * user_info : {"area_name":"和平区","is_dl":"1","rel_name":"周永康","area_code":"120101","mobile":"15962634187","total12":"0","city_code":"120100","u_area_code":"320583","total24":"1129000","province_code":"120000","province_name":"天津市","shop_id":"47","city_name":"天津市","face":"2016/12/31/58eXOaZsWk0TliwpqO6XN8v7.png","cdate":"2016-11-20 11:49:29","id_no":"32088219880910383X","ax24":"0","ax12":"0","integral":"159968","parent_id":"1316","total6":"0","id":"1354","ax6":"0","status":"1"}
     * success : true
     * order_info : {"need_pay":"38800","uid":"1354","use_integral":"0","cdate":"2017-01-04 11:20:14","total_price":"38800","id":"70","status":"1"}
     */
    private AddressInfoEntity address_info;
    private String error_msg;
    private List<GoodsListEntity> goods_list;
    private UserInfoEntity user_info;
    private boolean success;
    private OrderInfoEntity order_info;

    public void setAddress_info(AddressInfoEntity address_info) {
        this.address_info = address_info;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setGoods_list(List<GoodsListEntity> goods_list) {
        this.goods_list = goods_list;
    }

    public void setUser_info(UserInfoEntity user_info) {
        this.user_info = user_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setOrder_info(OrderInfoEntity order_info) {
        this.order_info = order_info;
    }

    public AddressInfoEntity getAddress_info() {
        return address_info;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<GoodsListEntity> getGoods_list() {
        return goods_list;
    }

    public UserInfoEntity getUser_info() {
        return user_info;
    }

    public boolean isSuccess() {
        return success;
    }

    public OrderInfoEntity getOrder_info() {
        return order_info;
    }

    public static class AddressInfoEntity {
        private String id;
        private String address;
        private String person;
        private String phone;
        private String zip;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    public static class GoodsListEntity {
        /**
         * good_num : 1
         * gg_id : 16
         * good_price : 38800
         * good_unit : 张
         * good_gmxz : 购买须知1
         * uo_id : 70
         * good_demo : 商品详情商品详情商品详情商品详情
         * gg_name : 规格1
         * good_id : 7
         * id : 78
         * good_name : 商品名称2
         * good_logo : 21b6bb7f944bc9d0fbe8fdd3187c1773.JPG
         */
        private String good_num;
        private String gg_id;
        private String good_price;
        private String good_unit;
        private String good_gmxz;
        private String uo_id;
        private String good_demo;
        private String gg_name;
        private String good_id;
        private String id;
        private String good_name;
        private String good_logo;

        public void setGood_num(String good_num) {
            this.good_num = good_num;
        }

        public void setGg_id(String gg_id) {
            this.gg_id = gg_id;
        }

        public void setGood_price(String good_price) {
            this.good_price = good_price;
        }

        public void setGood_unit(String good_unit) {
            this.good_unit = good_unit;
        }

        public void setGood_gmxz(String good_gmxz) {
            this.good_gmxz = good_gmxz;
        }

        public void setUo_id(String uo_id) {
            this.uo_id = uo_id;
        }

        public void setGood_demo(String good_demo) {
            this.good_demo = good_demo;
        }

        public void setGg_name(String gg_name) {
            this.gg_name = gg_name;
        }

        public void setGood_id(String good_id) {
            this.good_id = good_id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setGood_name(String good_name) {
            this.good_name = good_name;
        }

        public void setGood_logo(String good_logo) {
            this.good_logo = good_logo;
        }

        public String getGood_num() {
            return good_num;
        }

        public String getGg_id() {
            return gg_id;
        }

        public String getGood_price() {
            return good_price;
        }

        public String getGood_unit() {
            return good_unit;
        }

        public String getGood_gmxz() {
            return good_gmxz;
        }

        public String getUo_id() {
            return uo_id;
        }

        public String getGood_demo() {
            return good_demo;
        }

        public String getGg_name() {
            return gg_name;
        }

        public String getGood_id() {
            return good_id;
        }

        public String getId() {
            return id;
        }

        public String getGood_name() {
            return good_name;
        }

        public String getGood_logo() {
            return good_logo;
        }
    }

    public static class UserInfoEntity {
        /**
         * area_name : 和平区
         * is_dl : 1
         * rel_name : 周永康
         * area_code : 120101
         * mobile : 15962634187
         * total12 : 0
         * city_code : 120100
         * u_area_code : 320583
         * total24 : 1129000
         * province_code : 120000
         * province_name : 天津市
         * shop_id : 47
         * city_name : 天津市
         * face : 2016/12/31/58eXOaZsWk0TliwpqO6XN8v7.png
         * cdate : 2016-11-20 11:49:29
         * id_no : 32088219880910383X
         * ax24 : 0
         * ax12 : 0
         * integral : 159968
         * parent_id : 1316
         * total6 : 0
         * id : 1354
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

    public static class OrderInfoEntity {
        /**
         * need_pay : 38800
         * uid : 1354
         * use_integral : 0
         * cdate : 2017-01-04 11:20:14
         * total_price : 38800
         * id : 70
         * status : 1
         */
        private String need_pay;
        private String uid;
        private String use_integral;
        private String cdate;
        private String total_price;
        private String id;
        private String status;

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

        public void setId(String id) {
            this.id = id;
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

        public String getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }
    }
}
