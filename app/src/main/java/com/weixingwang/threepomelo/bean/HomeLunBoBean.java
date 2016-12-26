package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
public class HomeLunBoBean {

    /**
     * error_msg :
     * success : true
     * img_list : [{"path":"statics/images/banner.jpg"},{"path":"statics/images/banner1.jpg"},{"path":"statics/images/banner2.jpg"}]
     */
    private String error_msg;
    private boolean success;
    private List<ImgListEntity> img_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setImg_list(List<ImgListEntity> img_list) {
        this.img_list = img_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ImgListEntity> getImg_list() {
        return img_list;
    }

    public static class ImgListEntity {
        /**
         * path : statics/images/banner.jpg
         */
        private String path;

        public void setPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
