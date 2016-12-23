package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class MyTeamVIPBean {

    /**
     * my_team_list : [{"team_total":"2000000","rel_name":"周永凡","mobile":"13962653256","id":"1870"},{"team_total":"500000","rel_name":"陈先娇","mobile":"15962631449","id":"1615"},{"team_total":"1000000","rel_name":"陈先明","mobile":"13151178017","id":"1609"},{"team_total":"9000000","rel_name":"周永康","mobile":"18652429812","id":"1446"}]
     * error_msg :
     * success : true
     */
    private List<MyTeamListEntity> my_team_list;
    private String error_msg;
    private boolean success;

    public void setMy_team_list(List<MyTeamListEntity> my_team_list) {
        this.my_team_list = my_team_list;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MyTeamListEntity> getMy_team_list() {
        return my_team_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class MyTeamListEntity {
        /**
         * team_total : 2000000
         * rel_name : 周永凡
         * mobile : 13962653256
         * id : 1870
         */
        private String team_total;
        private String rel_name;
        private String mobile;
        private String id;
        private String name;
        private String shop_name;
        private String total;

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setTeam_total(String team_total) {
            this.team_total = team_total;
        }

        public void setRel_name(String rel_name) {
            this.rel_name = rel_name;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTeam_total() {
            return team_total;
        }

        public String getRel_name() {
            return rel_name;
        }

        public String getMobile() {
            return mobile;
        }

        public String getId() {
            return id;
        }
    }
}
