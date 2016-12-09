package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class RegestGetQuBean {

    /**
     * error_msg :
     * success : true
     * area_list : [{"code":"131001","citycode":"131000","name":"市辖区","id":"197"},{"code":"131002","citycode":"131000","name":"安次区","id":"198"},{"code":"131003","citycode":"131000","name":"广阳区","id":"199"},{"code":"131022","citycode":"131000","name":"固安县","id":"200"},{"code":"131023","citycode":"131000","name":"永清县","id":"201"},{"code":"131024","citycode":"131000","name":"香河县","id":"202"},{"code":"131025","citycode":"131000","name":"大城县","id":"203"},{"code":"131026","citycode":"131000","name":"文安县","id":"204"},{"code":"131028","citycode":"131000","name":"大厂回族自治县","id":"205"},{"code":"131081","citycode":"131000","name":"霸州市","id":"206"},{"code":"131082","citycode":"131000","name":"三河市","id":"207"}]
     */
    private String error_msg;
    private boolean success;
    private List<AreaListEntity> area_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setArea_list(List<AreaListEntity> area_list) {
        this.area_list = area_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<AreaListEntity> getArea_list() {
        return area_list;
    }

    public static class AreaListEntity {
        /**
         * code : 131001
         * citycode : 131000
         * name : 市辖区
         * id : 197
         */
        private String code;
        private String citycode;
        private String name;
        private String id;

        public void setCode(String code) {
            this.code = code;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
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

        public String getCitycode() {
            return citycode;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
