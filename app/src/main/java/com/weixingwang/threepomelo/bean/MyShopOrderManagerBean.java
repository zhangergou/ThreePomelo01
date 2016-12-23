package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderManagerBean {

    /**
     * error_msg :
     * list_orders : [{"shop_id":"47","uid":"555","cdate":"2016-12-19 15:29:49","rel_name":"杨洋","price":"10000","mobile":"18914970292","id":"1071","oid":"822","status":"1"},{"shop_id":"47","uid":"555","cdate":"2016-12-19 15:26:34","rel_name":"杨洋","price":"10000","mobile":"18914970292","id":"1069","oid":"822","status":"1"},{"shop_id":"47","uid":"1446","cdate":"2016-12-05 17:03:03","rel_name":"周永康","price":"2000000","mobile":"18652429812","id":"858","oid":"643","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-12-05 17:02:47","rel_name":"陈燕","price":"1000000","mobile":"13912688061","id":"857","oid":"643","status":"3"},{"shop_id":"47","uid":"1316","cdate":"2016-12-05 15:07:03","rel_name":"姚斌","price":"1000000","mobile":"15051691989","id":"848","oid":"643","status":"3"},{"shop_id":"47","uid":"1446","cdate":"2016-12-05 15:04:26","rel_name":"周永康","price":"2000000","mobile":"18652429812","id":"847","oid":"643","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-12-05 15:03:25","rel_name":"陈燕","price":"1000000","mobile":"13912688061","id":"846","oid":"643","status":"3"},{"shop_id":"47","uid":"1870","cdate":"2016-12-05 15:02:19","rel_name":"周永凡","price":"1000000","mobile":"13962653256","id":"845","oid":"643","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-12-03 16:46:00","rel_name":"陈燕","price":"1000000","mobile":"13912688061","id":"763","oid":"575","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-12-02 22:46:40","rel_name":"陈燕","price":"2000000","mobile":"13912688061","id":"666","oid":"487","status":"3"},{"shop_id":"47","uid":"1609","cdate":"2016-12-02 20:36:52","rel_name":"陈先明","price":"500000","mobile":"13151178017","id":"642","oid":"465","status":"3"},{"shop_id":"47","uid":"1316","cdate":"2016-11-30 18:39:20","rel_name":"姚斌","price":"1000000","mobile":"15051691989","id":"550","oid":"384","status":"3"},{"shop_id":"47","uid":"1661","cdate":"2016-11-30 17:26:22","rel_name":"昝宗魁","price":"1000000","mobile":"13405141955","id":"427","oid":"290","status":"3"},{"shop_id":"47","uid":"1651","cdate":"2016-11-30 13:05:59","rel_name":"严峰","price":"1000000","mobile":"13862640152","id":"403","oid":"273","status":"3"},{"shop_id":"47","uid":"1609","cdate":"2016-11-29 15:27:38","rel_name":"陈先明","price":"500000","mobile":"13151178017","id":"358","oid":"237","status":"3"},{"shop_id":"47","uid":"1615","cdate":"2016-11-29 15:19:16","rel_name":"陈先娇","price":"500000","mobile":"15962631449","id":"357","oid":"237","status":"3"},{"shop_id":"47","uid":"1463","cdate":"2016-11-28 17:15:57","rel_name":"陈燕","price":"4000000","mobile":"13912688061","id":"307","oid":"194","status":"3"},{"shop_id":"47","uid":"1446","cdate":"2016-11-28 17:15:36","rel_name":"周永康","price":"1000000","mobile":"18652429812","id":"306","oid":"194","status":"3"},{"shop_id":"47","uid":"1316","cdate":"2016-11-28 17:15:22","rel_name":"姚斌","price":"1000000","mobile":"15051691989","id":"305","oid":"194","status":"3"},{"shop_id":"47","uid":"555","cdate":"2016-11-28 17:15:10","rel_name":"杨洋","price":"1000000","mobile":"18914970292","id":"304","oid":"194","status":"3"}]
     * success : true
     */
    private String error_msg;
    private List<ListOrdersEntity> list_orders;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setList_orders(List<ListOrdersEntity> list_orders) {
        this.list_orders = list_orders;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<ListOrdersEntity> getList_orders() {
        return list_orders;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ListOrdersEntity {
        /**
         * shop_id : 47
         * uid : 555
         * cdate : 2016-12-19 15:29:49
         * rel_name : 杨洋
         * price : 10000
         * mobile : 18914970292
         * id : 1071
         * oid : 822
         * status : 1
         */
        private String shop_id;
        private String uid;
        private String cdate;
        private String rel_name;
        private String price;
        private String mobile;
        private String id;
        private String oid;
        private String status;

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShop_id() {
            return shop_id;
        }

        public String getUid() {
            return uid;
        }

        public String getCdate() {
            return cdate;
        }

        public String getRel_name() {
            return rel_name;
        }

        public String getPrice() {
            return price;
        }

        public String getMobile() {
            return mobile;
        }

        public String getId() {
            return id;
        }

        public String getOid() {
            return oid;
        }

        public String getStatus() {
            return status;
        }
    }
}
