package com.weixingwang.threepomelo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
public class ShopMessageBean {

    /**
     * error_msg :
     * good_detail : {"type_name":"床上用品","flag":"1","type_id":"5","demo":"商品详情商品详情商品详情商品详情","percent":"12","unit":"张","buy_num":"0","cdate":"2016-12-29 14:13:50","kc":"444","gmxz":"购买须知1","logo":"21b6bb7f944bc9d0fbe8fdd3187c1773.JPG","id":"7","scroe":"10","good_name":"商品名称2"}
     * success : true
     * pic_list : [{"folder":"1_20161229141226_1482992000000","m_pic":"2afacedd78cd8d70da1eafbdb7891d2b.jpg","id":"19","pic":"2afacedd78cd8d70da1eafbdb7891d2b.jpg","good_id":"7"},{"folder":"1_20161229165423_1483001722000","m_pic":"e47f72aa8da3f3b6315bcdab808a3ec9_thumb.jpg","id":"20","pic":"e47f72aa8da3f3b6315bcdab808a3ec9.jpg","good_id":"7"}]
     * gg_list : [{"gg_old_price":"30000","gg_name":"规格3","id":"14","good_id":"7","gg_price":"18900"},{"gg_old_price":"30000","gg_name":"规格yy","id":"15","good_id":"7","gg_price":"18900"},{"gg_old_price":"50000","gg_name":"规格1","id":"16","good_id":"7","gg_price":"38800"}]
     */
    private String error_msg;
    private GoodDetailEntity good_detail;
    private boolean success;
    private List<PicListEntity> pic_list;
    private List<GgListEntity> gg_list;

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setGood_detail(GoodDetailEntity good_detail) {
        this.good_detail = good_detail;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setPic_list(List<PicListEntity> pic_list) {
        this.pic_list = pic_list;
    }

    public void setGg_list(List<GgListEntity> gg_list) {
        this.gg_list = gg_list;
    }

    public String getError_msg() {
        return error_msg;
    }

    public GoodDetailEntity getGood_detail() {
        return good_detail;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<PicListEntity> getPic_list() {
        return pic_list;
    }

    public List<GgListEntity> getGg_list() {
        return gg_list;
    }

    public static class GoodDetailEntity {
        /**
         * type_name : 床上用品
         * flag : 1
         * type_id : 5
         * demo : 商品详情商品详情商品详情商品详情
         * percent : 12
         * unit : 张
         * buy_num : 0
         * cdate : 2016-12-29 14:13:50
         * kc : 444
         * gmxz : 购买须知1
         * logo : 21b6bb7f944bc9d0fbe8fdd3187c1773.JPG
         * id : 7
         * scroe : 10
         * good_name : 商品名称2
         */
        private String type_name;
        private String flag;
        private String type_id;
        private String demo;
        private String percent;
        private String unit;
        private String buy_num;
        private String cdate;
        private String kc;
        private String gmxz;
        private String logo;
        private String id;
        private String scroe;
        private String good_name;

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public void setDemo(String demo) {
            this.demo = demo;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setBuy_num(String buy_num) {
            this.buy_num = buy_num;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public void setKc(String kc) {
            this.kc = kc;
        }

        public void setGmxz(String gmxz) {
            this.gmxz = gmxz;
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

        public void setGood_name(String good_name) {
            this.good_name = good_name;
        }

        public String getType_name() {
            return type_name;
        }

        public String getFlag() {
            return flag;
        }

        public String getType_id() {
            return type_id;
        }

        public String getDemo() {
            return demo;
        }

        public String getPercent() {
            return percent;
        }

        public String getUnit() {
            return unit;
        }

        public String getBuy_num() {
            return buy_num;
        }

        public String getCdate() {
            return cdate;
        }

        public String getKc() {
            return kc;
        }

        public String getGmxz() {
            return gmxz;
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

        public String getGood_name() {
            return good_name;
        }
    }

    public static class PicListEntity {
        /**
         * folder : 1_20161229141226_1482992000000
         * m_pic : 2afacedd78cd8d70da1eafbdb7891d2b.jpg
         * id : 19
         * pic : 2afacedd78cd8d70da1eafbdb7891d2b.jpg
         * good_id : 7
         */
        private String folder;
        private String m_pic;
        private String id;
        private String pic;
        private String good_id;

        public void setFolder(String folder) {
            this.folder = folder;
        }

        public void setM_pic(String m_pic) {
            this.m_pic = m_pic;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setGood_id(String good_id) {
            this.good_id = good_id;
        }

        public String getFolder() {
            return folder;
        }

        public String getM_pic() {
            return m_pic;
        }

        public String getId() {
            return id;
        }

        public String getPic() {
            return pic;
        }

        public String getGood_id() {
            return good_id;
        }
    }

    public static class GgListEntity {
        /**
         * gg_old_price : 30000
         * gg_name : 规格3
         * id : 14
         * good_id : 7
         * gg_price : 18900
         */
        private String gg_old_price;
        private String gg_name;
        private String id;
        private String good_id;
        private String gg_price;

        public void setGg_old_price(String gg_old_price) {
            this.gg_old_price = gg_old_price;
        }

        public void setGg_name(String gg_name) {
            this.gg_name = gg_name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setGood_id(String good_id) {
            this.good_id = good_id;
        }

        public void setGg_price(String gg_price) {
            this.gg_price = gg_price;
        }

        public String getGg_old_price() {
            return gg_old_price;
        }

        public String getGg_name() {
            return gg_name;
        }

        public String getId() {
            return id;
        }

        public String getGood_id() {
            return good_id;
        }

        public String getGg_price() {
            return gg_price;
        }
    }
}
