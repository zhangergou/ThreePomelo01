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
    //用户信息获取
    public static String PERSEN_INFOR_Url =MAIN_Url+ "/Apiuser/information_revise";
    //用户信息修改
    public static String PERSEN_INFOR_REVERSE_Url =MAIN_Url+ "/Apiuser/save_information_revise";
    //商铺详情
    public static String SELLER_INFOR_Url = MAIN_Url+"/Apiftontend/shop_detail";
   //获取商家的入驻信息
    public static String SHOP_IN_INFOR_Url =MAIN_Url+ "/Apiuser/register_shop";
    //获取商铺类型
    public static String SHOP_TYPE_Url = MAIN_Url+"/Apiftontend/get_shop_type";
    //商铺入驻
    public static String SHOP_IN__UP_Url = MAIN_Url+"/Apiuser/save_register_shop";
    //用户向日葵列表
    public static String PERSON_SUN_Url =MAIN_Url+ "/Apiuser/user_heart_loaddata";
    //商家向日葵列表
    public static String SHOP_SUN_Url = MAIN_Url+"/Apiuser/shop_heart_loaddata";
    //用户各系列向日葵总数
    public static String TOTAL_SUN_Url = MAIN_Url+"/Apiuser/heart_count";
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
    //用户向日葵列表
//    public static String SHOP_MY_ORDER_Url = "http://139.224.222.18:8080/Apiuser/Orderinfo/orderlist";
}
