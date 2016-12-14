package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public class HomeShopTypeBean {

    /**
     * area_name : 黄浦区
     * error_msg :
     * success : true
     * area_code : 310101
     * shop_type_list : [{"color":"#eb6d4e","icon":"glass","name":"美食","id":"1","status":"1"},{"color":"#7891e4","icon":"building","name":"酒店","id":"2","status":"1"},{"color":"#51d2af","icon":"train","name":"生活旅行","id":"3","status":"1"},{"color":"#04c1e7","icon":"cart-plus","name":"超市","id":"4","status":"1"},{"color":"#61c2ed","icon":"car","name":"汽车","id":"5","status":"1"},{"color":"#f7b755","icon":"camera","name":"手机数码","id":"6","status":"1"},{"color":"#17ab55","icon":"music","name":"休闲娱乐","id":"7","status":"1"},{"color":"#f08c59","icon":"leanpub","name":"生活服务","id":"8","status":"1"},{"color":"#ff8c59","icon":"desktop","name":"电脑办公","id":"9","status":"1"},{"color":"#7d95e5","icon":"fax","name":"家用电器","id":"10","status":"1"},{"color":"#e37470","icon":"child","name":"母婴童装","id":"11","status":"1"},{"color":"#f7ba5b","icon":"eye","name":"个户化妆","id":"12","status":"1"},{"color":"#2c8871","icon":"archive","name":"鞋靴箱包","id":"13","status":"1"},{"color":"#ec2a4a","icon":"fire","name":"潮流服装","id":"14","status":"1"},{"color":"#bbcd23","icon":"diamond","name":"奢侈礼品","id":"15","status":"1"},{"color":"#f8ab94","icon":"sun-o","name":"钟表珠宝","id":"16","status":"1"},{"color":"#eb5e16","icon":"gamepad","name":"玩具乐器","id":"17","status":"1"},{"color":"#7891e4","icon":"leaf","name":"内衣配饰","id":"18","status":"1"},{"color":"#51d2af","icon":"umbrella","name":"家居家纺","id":"19","status":"1"},{"color":"#04c1e7","icon":"medkit","name":"滋补养生","id":"20","status":"1"},{"icon":"home","name":"家装建材","id":"21","status":"1"},{"icon":"cart-plus","name":"教育培训","id":"22","status":"1"},{"icon":"tags","name":"户外活动","id":"23","status":"1"},{"icon":"volume-up","name":"花鸟文娱","id":"24","status":"1"}]
     */
    private String area_name;
    private String error_msg;
    private boolean success;
    private String area_code;
    private List<ShopTypeListEntity> shop_type_list;

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public void setShop_type_list(List<ShopTypeListEntity> shop_type_list) {
        this.shop_type_list = shop_type_list;
    }

    public String getArea_name() {
        return area_name;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getArea_code() {
        return area_code;
    }

    public List<ShopTypeListEntity> getShop_type_list() {
        return shop_type_list;
    }

    public static class ShopTypeListEntity {
        /**
         * color : #eb6d4e
         * icon : glass
         * name : 美食
         * id : 1
         * status : 1
         */
        private String color;
        private String icon;
        private String name;
        private String id;
        private String status;

        public void setColor(String color) {
            this.color = color;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getColor() {
            return color;
        }

        public String getIcon() {
            return icon;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }
    }
}
