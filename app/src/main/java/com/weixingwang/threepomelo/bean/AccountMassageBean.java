package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class AccountMassageBean {


    /**
     * error_msg :
     * user_info : {"area_name":"昆山市","is_dl":"1","rel_name":"杨洋","area_code":"320583","mobile":"18914970292","total12":"0","city_code":"320500","u_area_code":"320583","total24":"2000000","province_code":"320000","province_name":"江苏省","shop_id":"0","city_name":"苏州市","face":"2016/11/22/Z2grjTUKHkTrIQPtfoNKMWux.jpg","cdate":"2016-11-21 09:55:47","id_no":"320583888888888888","ax24":"0","ax12":"0","integral":"7977800","parent_id":"1316","total6":"0","id":"555","ax6":"0","status":"1"}
     * success : true
     * provinces_list : [{"code":"110000","name":"北京市","id":"1"},{"code":"120000","name":"天津市","id":"2"},{"code":"130000","name":"河北省","id":"3"},{"code":"140000","name":"山西省","id":"4"},{"code":"150000","name":"内蒙古","id":"5"},{"code":"210000","name":"辽宁省","id":"6"},{"code":"220000","name":"吉林省","id":"7"},{"code":"230000","name":"黑龙江","id":"8"},{"code":"310000","name":"上海市","id":"9"},{"code":"320000","name":"江苏省","id":"10"},{"code":"330000","name":"浙江省","id":"11"},{"code":"340000","name":"安徽省","id":"12"},{"code":"350000","name":"福建省","id":"13"},{"code":"360000","name":"江西省","id":"14"},{"code":"370000","name":"山东省","id":"15"},{"code":"410000","name":"河南省","id":"16"},{"code":"420000","name":"湖北省","id":"17"},{"code":"430000","name":"湖南省","id":"18"},{"code":"440000","name":"广东省","id":"19"},{"code":"450000","name":"广  西","id":"20"},{"code":"460000","name":"海南省","id":"21"},{"code":"500000","name":"重庆市","id":"22"},{"code":"510000","name":"四川省","id":"23"},{"code":"520000","name":"贵州省","id":"24"},{"code":"530000","name":"云南省","id":"25"},{"code":"540000","name":"西  藏","id":"26"},{"code":"610000","name":"陕西省","id":"27"},{"code":"620000","name":"甘肃省","id":"28"},{"code":"630000","name":"青海省","id":"29"},{"code":"640000","name":"宁  夏","id":"30"},{"code":"650000","name":"新  疆","id":"31"},{"code":"710000","name":"台湾省","id":"32"},{"code":"810000","name":"香  港","id":"33"},{"code":"820000","name":"澳  门","id":"34"}]
     * area_list : [{"code":"320501","citycode":"320500","name":"市辖区","id":"845"},{"code":"320502","citycode":"320500","name":"沧浪区","id":"846"},{"code":"320503","citycode":"320500","name":"平江区","id":"847"},{"code":"320504","citycode":"320500","name":"金阊区","id":"848"},{"code":"320505","citycode":"320500","name":"虎丘区","id":"849"},{"code":"320506","citycode":"320500","name":"吴中区","id":"850"},{"code":"320507","citycode":"320500","name":"相城区","id":"851"},{"code":"320581","citycode":"320500","name":"常熟市","id":"852"},{"code":"320582","citycode":"320500","name":"张家港市","id":"853"},{"code":"320583","citycode":"320500","name":"昆山市","id":"854"},{"code":"320584","citycode":"320500","name":"吴江市","id":"855"},{"code":"320585","citycode":"320500","name":"太仓市","id":"856"}]
     * city_list : [{"code":"320100","provincecode":"320000","name":"南京市","id":"74"},{"code":"320200","provincecode":"320000","name":"无锡市","id":"75"},{"code":"320300","provincecode":"320000","name":"徐州市","id":"76"},{"code":"320400","provincecode":"320000","name":"常州市","id":"77"},{"code":"320500","provincecode":"320000","name":"苏州市","id":"78"},{"code":"320600","provincecode":"320000","name":"南通市","id":"79"},{"code":"320700","provincecode":"320000","name":"连云港市","id":"80"},{"code":"320800","provincecode":"320000","name":"淮安市","id":"81"},{"code":"320900","provincecode":"320000","name":"盐城市","id":"82"},{"code":"321000","provincecode":"320000","name":"扬州市","id":"83"},{"code":"321100","provincecode":"320000","name":"镇江市","id":"84"},{"code":"321200","provincecode":"320000","name":"泰州市","id":"85"},{"code":"321300","provincecode":"320000","name":"宿迁市","id":"86"}]
     */
    private String error_msg;
    private UserInfoEntity user_info;
    private boolean success;
    private List<ProvincesListEntity> provinces_list;
    private List<AreaListEntity> area_list;
    private List<CityListEntity> city_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setUser_info(UserInfoEntity user_info) {
        this.user_info = user_info;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setProvinces_list(List<ProvincesListEntity> provinces_list) {
        this.provinces_list = provinces_list;
    }

    public void setArea_list(List<AreaListEntity> area_list) {
        this.area_list = area_list;
    }

    public void setCity_list(List<CityListEntity> city_list) {
        this.city_list = city_list;
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

    public List<ProvincesListEntity> getProvinces_list() {
        return provinces_list;
    }

    public List<AreaListEntity> getArea_list() {
        return area_list;
    }

    public List<CityListEntity> getCity_list() {
        return city_list;
    }

    public static class UserInfoEntity {
        /**
         * area_name : 昆山市
         * is_dl : 1
         * rel_name : 杨洋
         * area_code : 320583
         * mobile : 18914970292
         * total12 : 0
         * city_code : 320500
         * u_area_code : 320583
         * total24 : 2000000
         * province_code : 320000
         * province_name : 江苏省
         * shop_id : 0
         * city_name : 苏州市
         * face : 2016/11/22/Z2grjTUKHkTrIQPtfoNKMWux.jpg
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

    public static class ProvincesListEntity {
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

    public static class AreaListEntity {
        /**
         * code : 320501
         * citycode : 320500
         * name : 市辖区
         * id : 845
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

    public static class CityListEntity {
        /**
         * code : 320100
         * provincecode : 320000
         * name : 南京市
         * id : 74
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
