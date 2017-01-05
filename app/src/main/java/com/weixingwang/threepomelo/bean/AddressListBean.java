package com.weixingwang.threepomelo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */
public class AddressListBean {

    /**
     * error_msg :
     * list_address : [{"uid":"1354","default":"1","address":"怀旧金曲咯哦哦","phone":"5555","person":"咯嘛","id":"17"},{"uid":"1354","default":"-1","address":"怀旧金曲咯哦哦","phone":"5555","person":"咯嘛","id":"16"},{"uid":"1354","default":"-1","address":"怀旧金曲咯哦哦路兔兔","phone":"5555","person":"咯嘛啦啦啦","id":"15"},{"uid":"1354","default":"-1","address":"怀旧金曲咯哦哦","phone":"5555","person":"咯嘛","id":"13"}]
     * success : true
     */
    private String error_msg;
    private List<ListAddressEntity> list_address;
    private boolean success;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setList_address(List<ListAddressEntity> list_address) {
        this.list_address = list_address;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_msg() {
        return error_msg;
    }

    public List<ListAddressEntity> getList_address() {
        return list_address;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ListAddressEntity {
        /**
         * uid : 1354
         * default : 1
         * address : 怀旧金曲咯哦哦
         * phone : 5555
         * person : 咯嘛
         * id : 17
         */
        private String uid;
        @SerializedName("default")
        private String defaultX;
        private String address;
        private String phone;
        private String person;
        private String id;

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setDefaultX(String defaultX) {
            this.defaultX = defaultX;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public String getDefaultX() {
            return defaultX;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        public String getPerson() {
            return person;
        }

        public String getId() {
            return id;
        }
    }
}
