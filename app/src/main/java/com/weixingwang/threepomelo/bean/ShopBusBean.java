package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
public class ShopBusBean {

    /**
     * error_msg :
     * list_cart : [{"flag":"1","gg_old_price":"30000","type_id":"5","num":"1","gg_kc":"200","demo":"商品详情商品详情商品详情商品详情","percent":"12","cart_id":"24","buy_num":"0","unit":"张","cdate":"2016-12-29 14:13:50","gmxz":"购买须知1","kc":"444","gg_name":"规格3","logo":"21b6bb7f944bc9d0fbe8fdd3187c1773.JPG","id":"7","scroe":"10","gg_price":"18900","good_name":"商品名称2","cart_cdate":"2017-01-03 09:14:16"},{"flag":"1","gg_old_price":"30000","type_id":"2","num":"1","gg_kc":"300","demo":"可爱的玩具，小孩、女生都喜欢","percent":"12","cart_id":"23","buy_num":"0","unit":"只","cdate":"2016-12-29 14:11:06","gmxz":"3岁以上小孩玩","kc":"400","gg_name":"1.2 米","logo":"862531b102f9e71e05fe798c840133d9.png","id":"6","scroe":"10","gg_price":"24900","good_name":"维尼小熊","cart_cdate":"2017-01-03 09:14:01"},{"flag":"1","gg_old_price":"50000","type_id":"1","num":"1","gg_kc":"400","demo":"可享受各种线下福利","percent":"24","cart_id":"22","buy_num":"0","unit":"只","cdate":"2016-12-31 09:13:34","gmxz":"限量","kc":"0","gg_name":"金牌会员纪念章","logo":"7bd6f4336b13b14de95397c4632b5575.jpg","id":"8","scroe":"10","gg_price":"38800","good_name":"官方纪念章","cart_cdate":"2017-01-03 09:13:53"}]
     * success : true
     */
    private String error_msg;
    private List<ListCartEntity> list_cart;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setList_cart(List<ListCartEntity> list_cart) {
        this.list_cart = list_cart;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<ListCartEntity> getList_cart() {
        return list_cart;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ListCartEntity {
        /**
         * flag : 1
         * gg_old_price : 30000
         * type_id : 5
         * num : 1
         * gg_kc : 200
         * demo : 商品详情商品详情商品详情商品详情
         * percent : 12
         * cart_id : 24
         * buy_num : 0
         * unit : 张
         * cdate : 2016-12-29 14:13:50
         * gmxz : 购买须知1
         * kc : 444
         * gg_name : 规格3
         * logo : 21b6bb7f944bc9d0fbe8fdd3187c1773.JPG
         * id : 7
         * scroe : 10
         * gg_price : 18900
         * good_name : 商品名称2
         * cart_cdate : 2017-01-03 09:14:16
         */
        private String flag;
        private String gg_old_price;
        private String type_id;
        private String num;
        private String gg_kc;
        private String demo;
        private String percent;
        private String cart_id;
        private String buy_num;
        private String unit;
        private String cdate;
        private String gmxz;
        private String kc;
        private String gg_name;
        private String logo;
        private String id;
        private String scroe;
        private String gg_price;
        private String good_name;
        private String cart_cdate;

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public void setGg_old_price(String gg_old_price) {
            this.gg_old_price = gg_old_price;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setGg_kc(String gg_kc) {
            this.gg_kc = gg_kc;
        }

        public void setDemo(String demo) {
            this.demo = demo;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }

        public void setBuy_num(String buy_num) {
            this.buy_num = buy_num;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setGmxz(String gmxz) {
            this.gmxz = gmxz;
        }

        public void setKc(String kc) {
            this.kc = kc;
        }

        public void setGg_name(String gg_name) {
            this.gg_name = gg_name;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setScroe(String scroe) {
            this.scroe = scroe;
        }

        public void setGg_price(String gg_price) {
            this.gg_price = gg_price;
        }

        public void setGood_name(String good_name) {
            this.good_name = good_name;
        }

        public void setCart_cdate(String cart_cdate) {
            this.cart_cdate = cart_cdate;
        }

        public String getFlag() {
            return flag;
        }

        public String getGg_old_price() {
            return gg_old_price;
        }

        public String getType_id() {
            return type_id;
        }

        public String getNum() {
            return num;
        }

        public String getGg_kc() {
            return gg_kc;
        }

        public String getDemo() {
            return demo;
        }

        public String getPercent() {
            return percent;
        }

        public String getCart_id() {
            return cart_id;
        }

        public String getBuy_num() {
            return buy_num;
        }

        public String getUnit() {
            return unit;
        }

        public String getCdate() {
            return cdate;
        }

        public String getGmxz() {
            return gmxz;
        }

        public String getKc() {
            return kc;
        }

        public String getGg_name() {
            return gg_name;
        }

        public String getLogo() {
            return logo;
        }

        public String getId() {
            return id;
        }

        public String getScroe() {
            return scroe;
        }

        public String getGg_price() {
            return gg_price;
        }

        public String getGood_name() {
            return good_name;
        }

        public String getCart_cdate() {
            return cart_cdate;
        }
    }
}
