package com.weixingwang.threepomelo.utils;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class UrlUtils {

    public static String MAIN_Url = "http://106.14.57.99:7070";
    //获取图片的公共地址http://139.224.222.18:8080/attachs/
    public static String getImgUrl = MAIN_Url+"/upload/logo/";
    //获取注册验证码
    /* 获取验证码 */
    public static String getCodeUrl = MAIN_Url+"/Apiftontend/get_yzm";
    //获取忘记密码验证码
    public static String getFORGETCodeUrl = MAIN_Url+"/Apiftontend/get_yzm_forget";
    //修改密码
    public static String XIU_GAI_PASSWORD_Url = MAIN_Url+"/Apiftontend/change_pwd";
    //token自动登录
    public static String TOKEN_LOGIN_Url = MAIN_Url+"/Apiftontend/token_check";
    //密码登录
    public static String PASWORD_LOGIN_Url = MAIN_Url+"/Apiftontend/check_login";
    //省列表url
    public static String SHENG_Url = MAIN_Url+"/Apiftontend/get_province";
    //城市列表url
    public static String SHI_Url = MAIN_Url+"/Apiftontend/get_city";
    //区域列表url
    public static String QU_Url = MAIN_Url+"/Apiftontend/get_area";
    //推荐人ID url
    public static String RECOMMEND_Url = MAIN_Url+"/Apiftontend/get_naid_by_keywords";
    //密码重置(提交数据)
    public static String REGEST_Url = MAIN_Url+"/Apiftontend/save_register";
    //订单列表
    public static String MyOrder_Url = MAIN_Url+"/Apiuser/list_orders_loaddata";
    //订单列表->所有消费
    public static String MyOrderAllTotal_Url = MAIN_Url+"/Apiuser/list_orders";
//    //包含token直接跳转到主页面
//    public static String HAVE_TOKEN_Url = "http://139.224.222.18:8080/Apipublic/Apilogin/test_token";
//    //VIP会员中心
//    public static String VIP_CENTER_Url = "http://139.224.222.18:8080/Apiuser/Userinfo/mainpage";
//    //在线商城
//    public static String ONLINE_SHOP_Url = "http://139.224.222.18:8080/Apipublic/ApiPmall/getshops";
    //获取商铺的类型list
    public static String HOME_AREA_CODE_Url =MAIN_Url+ "/Apiftontend/index";
     //获取商铺的列表
    public static String HOME_SHOP_LIST_Url = MAIN_Url+"/Apiftontend/index_loaddata";
    //用户中心
    public static String PERSEN_CENTER_Url = MAIN_Url+"/Apiuser/index";
//    //城市列表
//    public static String ONLINE_SHOP_CITY_Url = "http://139.224.222.18:8080/Apipublic/ApiPmall/getcity";
//    //商家分类
//    public static String ONLINE_SHOP_CLASS_Url = "http://139.224.222.18:8080/Apipublic/ApiPmall/getshopscate";
//    //区域列表
//    public static String ONLINE_SHOP_AREA_Url = "http://139.224.222.18:8080/Apipublic/ApiPmall/getarea";
//    //商家详情页
//    public static String SHOP_MESSAGE_Url = "http://139.224.222.18:8080/Apipublic/ApiPshop/shopdetail";
//    //商品详情页
//    public static String SHOP_GOODS_MESSAGE_Url = "http://139.224.222.18:8080/Apipublic/ApiPshop/goodsdetail";
//    //我的订单
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";

}
