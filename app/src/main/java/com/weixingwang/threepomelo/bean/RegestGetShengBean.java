package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class RegestGetShengBean {

    /**
     * error_msg :
     * success : true
     * province_list : [{"code":"110000","name":"北京市","id":"1"},{"code":"120000","name":"天津市","id":"2"},{"code":"130000","name":"河北省","id":"3"},{"code":"140000","name":"山西省","id":"4"},{"code":"150000","name":"内蒙古","id":"5"},{"code":"210000","name":"辽宁省","id":"6"},{"code":"220000","name":"吉林省","id":"7"},{"code":"230000","name":"黑龙江","id":"8"},{"code":"310000","name":"上海市","id":"9"},{"code":"320000","name":"江苏省","id":"10"},{"code":"330000","name":"浙江省","id":"11"},{"code":"340000","name":"安徽省","id":"12"},{"code":"350000","name":"福建省","id":"13"},{"code":"360000","name":"江西省","id":"14"},{"code":"370000","name":"山东省","id":"15"},{"code":"410000","name":"河南省","id":"16"},{"code":"420000","name":"湖北省","id":"17"},{"code":"430000","name":"湖南省","id":"18"},{"code":"440000","name":"广东省","id":"19"},{"code":"450000","name":"广  西","id":"20"},{"code":"460000","name":"海南省","id":"21"},{"code":"500000","name":"重庆市","id":"22"},{"code":"510000","name":"四川省","id":"23"},{"code":"520000","name":"贵州省","id":"24"},{"code":"530000","name":"云南省","id":"25"},{"code":"540000","name":"西  藏","id":"26"},{"code":"610000","name":"陕西省","id":"27"},{"code":"620000","name":"甘肃省","id":"28"},{"code":"630000","name":"青海省","id":"29"},{"code":"640000","name":"宁  夏","id":"30"},{"code":"650000","name":"新  疆","id":"31"},{"code":"710000","name":"台湾省","id":"32"},{"code":"810000","name":"香  港","id":"33"},{"code":"820000","name":"澳  门","id":"34"}]
     */
    private String error_msg;
    private boolean success;
    private List<ProvinceListEntity> province_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setProvince_list(List<ProvinceListEntity> province_list) {
        this.province_list = province_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ProvinceListEntity> getProvince_list() {
        return province_list;
    }

    public static class ProvinceListEntity {
        /**
         * code : 110000
         * name : 北京市
         * id : 1
         */
        private String code;
        private String name;
        private String id;

        public void setCode(String code) {
            this.code = code;
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

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
