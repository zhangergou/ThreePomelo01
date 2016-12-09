package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class RegestGetShiBean {

    /**
     * error_msg :
     * success : true
     * city_list : [{"code":"130100","provincecode":"130000","name":"石家庄市","id":"2"},{"code":"130200","provincecode":"130000","name":"唐山市","id":"3"},{"code":"130300","provincecode":"130000","name":"秦皇岛市","id":"4"},{"code":"130400","provincecode":"130000","name":"邯郸市","id":"5"},{"code":"130500","provincecode":"130000","name":"邢台市","id":"6"},{"code":"130600","provincecode":"130000","name":"保定市","id":"7"},{"code":"130700","provincecode":"130000","name":"张家口市","id":"8"},{"code":"130800","provincecode":"130000","name":"承德市","id":"9"},{"code":"130900","provincecode":"130000","name":"沧州市","id":"10"},{"code":"131000","provincecode":"130000","name":"廊坊市","id":"11"},{"code":"131100","provincecode":"130000","name":"衡水市","id":"12"}]
     */
    private String error_msg;
    private boolean success;
    private List<CityListEntity> city_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCity_list(List<CityListEntity> city_list) {
        this.city_list = city_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<CityListEntity> getCity_list() {
        return city_list;
    }

    public static class CityListEntity {
        /**
         * code : 130100
         * provincecode : 130000
         * name : 石家庄市
         * id : 2
         */
        private String code;
        private String provincecode;
        private String name;
        private String id;

        public void setCode(String code) {
            this.code = code;
        }

        public void setProvincecode(String provincecode) {
            this.provincecode = provincecode;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public String getProvincecode() {
            return provincecode;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
