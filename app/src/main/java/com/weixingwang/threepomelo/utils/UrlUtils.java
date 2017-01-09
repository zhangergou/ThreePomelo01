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
    //我的团队——我的会员 列表
    public static String TEAM_VIP_Url = MAIN_Url+"/Apiuser/my_team_user";
    //我的团队——直属商家 列表
    public static String TEAM_SHOP_Url = MAIN_Url+"/Apiuser/my_team_shop";
    //我的团队——二级商家 列表
    public static String TEAM_ER_SHOP_Url = MAIN_Url+"/Apiuser/my_team_shop2";
    //资金日志列表
    public static String MONEY_LOG_Url = MAIN_Url+"/Apiuser/money_log_list_loaddata";
    //提现日志列表
    public static String TAKE_MONEY_LOG_Url =MAIN_Url+ "/Apiuser/list_withdraw_loaddata";
    //获取上一次提现信息
    public static String GET_TAKE_MONEY_INFOR_Url = MAIN_Url+"/Apiuser/withdraw";
    //提现
    public static String TAKE_MONEY_Url = MAIN_Url+"/Apiuser/save_withdraw";
    //提现手机验证码
    public static String TAKE_MONEY_CODE_Url = MAIN_Url+"/Apiuser/sendsms";
    //收益列表
    public static String ALL_IN_Url = MAIN_Url+"/Apiuser/my_income_loaddata";
    //我的商铺
    public static String MY_SHOP_Url = MAIN_Url+"/Apishop/shop_info";
    //我的商铺--订单管理列表
    public static String MY_SHOP_ORDER_Url = MAIN_Url+"/Apishop/list_orders_loaddata";
    //我的商铺--创建订单
    public static String MY_SHOP_ORDER_CREAT_Url = MAIN_Url+"/Apishop/save_order";
    //我的商铺--订单详情列表
    public static String MY_SHOP_ORDER_DATA_LIST_Url = MAIN_Url+"/Apishop/list_order_audit_loaddata";
    //我的商铺--订单详情
    public static String MY_SHOP_ORDER_DATA_Url = MAIN_Url+"/Apishop/order_detail";
    //我的商铺--订单管理--删除订单
    public static String MY_SHOP_ORDER_DELETE_Url = MAIN_Url+"/Apishop/del_order";
    //我的商铺--修改商铺信息
    public static String XIU_GAI_Url = MAIN_Url+"/Apishop/save_shop_info";
    //我的商铺--提交主订单
    public static String TI_JIAO_ORDER_Url = MAIN_Url+"/Apishop/tijiao_order";
    //首页轮播图
    public static String HOME_LUN_Url = MAIN_Url+"/Apiftontend/get_turns_imgs";
    //商城--商品列表
    public static String SHOP_GOODS_Url = MAIN_Url+"/Apiftontend/get_goods_list";
    //商城--商品详情
    public static String SHOP_GOODS_INFOR_Url = MAIN_Url+"/Apiftontend/good_detail";
    //商城--加入购物车
    public static String SHOP_ADD_BUS_Url = MAIN_Url+"/Apiuser/add_cart";
    //商城--获取购物车列表
    public static String SHOP_BUS_Url = MAIN_Url+"/Apiuser/list_cart";
    //商城--改变购物车数量
    public static String SHOP_BUS_CONUT_Url = MAIN_Url+"/Apiuser/change_cart";
    //商城--删除购物车
    public static String SHOP_BUS_DELETE_GOODS_Url = MAIN_Url+"/Apiuser/delete_cart";
    //商城--收货地址列表
    public static String SHOP_ADDRESS_LIST_Url = MAIN_Url+"/Apiuser/list_address";
    //商城--设置默认收货地址
    public static String SHOP_SET_DEF_ADDRESS_Url = MAIN_Url+"/Apiuser/default_address";
   //商城--删除收货地址
    public static String SHOP_DELE_ADDRESS_Url = MAIN_Url+"/Apiuser/delete_address";
    //商城--修改收货地址
    public static String SHOP_EDIT_ADDRESS_Url = MAIN_Url+"/Apiuser/edit_address";
    //商城-- 新增收货地址
    public static String SHOP_ADD_ADDRESS_Url = MAIN_Url+"/Apiuser/add_address";
    //商城--保存商城订单 通过购物车
    public static String SHOP_SAVE_ORDER_Url = MAIN_Url+"/Apiuser/save_orderByCart";
    //商城--确认订单
    public static String SHOP_SURE_ORDER_Url = MAIN_Url+"/Apiuser/get_orderinfo";
    //商城--获取默认收货地址
    public static String SHOP_DEF_ADDRESS_Url = MAIN_Url+"/Apiuser/get_default_address";
    //商城--立即购买 接口
    public static String SHOP_NOW_PAY_Url = MAIN_Url+"/Apiuser/order_pay";
    //商城--获取微信预支付码
    public static String SHOP_GET_PAY_CODE_Url = MAIN_Url+"/Apiwxpay/wxpay";
    //每日数据
    public static String EVERYDAY_DATA_Url ="http://sky.asmzs.com/information";
    //商城订单
    public static String SHOP_ORDERS_Url = MAIN_Url+"/Apiuser/get_user_order";
}
