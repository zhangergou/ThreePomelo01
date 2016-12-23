package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tencent.mapsdk.raster.model.Circle;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.CreatShopInBean;
import com.weixingwang.threepomelo.bean.HomeShopTypeBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.RegestGetQuBean;
import com.weixingwang.threepomelo.bean.RegestGetShengBean;
import com.weixingwang.threepomelo.bean.RegestGetShiBean;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ThreeAreaUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopDataActivity extends BaseActivity {
    private int image = 0;
    private ImageView ivLog;
    private EditText tvShopName;
    private EditText tvAddress;
    private EditText tvName;
    private EditText tvPhone;
    private EditText tvTime;
    private EditText tvSay;
    private TextView tvShopType;
    private TextView tvSheng;
    private TextView tvShi;
    private TextView tvQu;
    private TextView tvLat;
    private TextView tvLng;
    private String province_code;
    private String city_code;
    private String area_code;
    private String lng;
    private String lat;
    private TextView tvXi;
    private String shopType;
    private Dialog dialog;
    private ListView lvtype;
    private ListView lvSheng;
    private ListView lvShi;
    private PopupWindow popupWindowType;
    private PopupWindow popupWindowSheng;
    private PopupWindow popupWindowShi;
    private PopupWindow popupWindowQu;
    private ListView lvQu;
    private ListView lvShopType;
    private PopupWindow popupWindowShopType;
    private List<String> listType = new ArrayList<>();
    private List<String> listSheng = new ArrayList<>();
    private List<String> listShi = new ArrayList<>();
    private List<String> listQu = new ArrayList<>();
    private HashMap<Integer, String> putString = new HashMap<>();
    private HashMap<String, File> putFile = new HashMap<>();
    private Uri photoUri;
    private int pos = -1;
    private LinearLayout linType;
    private LinearLayout linSheng;
    private LinearLayout linCyte;
    private LinearLayout linQu;

    @Override
    protected int getLayoutId() {
        return R.layout.my_shop_data_layout;
    }

    @Override
    protected void initView() {
        ivLog = (CircleImageView) findViewById(R.id.xiu_gai_create_iv_log_icon_p);
        tvShopName = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_name);
        tvAddress = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_address);
        tvName = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_person_name);
        tvPhone = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_phone);
        tvTime = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_time);
        tvSay = (EditText) findViewById(R.id.xiu_gai_creat_shop_et_shop_say);
        tvShopType = (TextView) findViewById(R.id.xiu_gai_creat_shop_et_type);
        tvSheng = (TextView) findViewById(R.id.xiu_gai_creat_shop_tv_provice);
        tvShi = (TextView) findViewById(R.id.xiu_gai_creat_shop_tv_city);
        tvQu = (TextView) findViewById(R.id.xiu_gai_creat_shop_tv_area);
        tvLat = (TextView) findViewById(R.id.xiu_gai_creat_shop_et_lat);
        tvLng = (TextView) findViewById(R.id.xiu_gai_creat_shop_et_lng);
        tvXi = (TextView) findViewById(R.id.xiu_gai_creat_shop_et_shopping_type);

        linType = (LinearLayout) findViewById(R.id.xiu_gai_creat_lin_choese_type);
        linSheng = (LinearLayout) findViewById(R.id.xiu_gai_creat_lin_choese_sheng);
        linCyte = (LinearLayout) findViewById(R.id.xiu_gai_creat_lin_choese_cyte);
        linQu = (LinearLayout) findViewById(R.id.xiu_gai_creat_lin_choese_qu);

        setTitle("商铺管理");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        getData();
        showCreateDialog();

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.xiu_gai_creat_btn_up_log).setOnClickListener(this);
        findViewById(R.id.xiu_gai_iv_in_map).setOnClickListener(this);
        findViewById(R.id.xiu_gai_btn_create_shop_up).setOnClickListener(this);
        findViewById(R.id.xiu_gai_btn_create_shop_cancel).setOnClickListener(this);

        linType .setOnClickListener(this);
        linSheng .setOnClickListener(this);
        linCyte.setOnClickListener(this);
        linQu.setOnClickListener(this);
    }
    private void showCreateDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);


        View viewPopType = View.inflate(this, R.layout.pop_type_item, null);
        lvtype = (ListView) viewPopType.findViewById(R.id.creat_lv_type);
        popupWindowType = DialogUtils.showPopupWindow(this, viewPopType);


        View viewPopSheng = View.inflate(this, R.layout.pop_sheng_item, null);
        lvSheng = (ListView) viewPopSheng.findViewById(R.id.regest_lv_sheng);
        popupWindowSheng = DialogUtils.showPopupWindow(this, viewPopSheng);

        View viewPopShi = View.inflate(this, R.layout.pop_shi_item, null);
        lvShi = (ListView) viewPopShi.findViewById(R.id.regest_lv_shi);
        popupWindowShi = DialogUtils.showPopupWindow(this, viewPopShi);

        View viewPopQu = View.inflate(this, R.layout.pop_qu_item, null);
        lvQu = (ListView) viewPopQu.findViewById(R.id.regest_lv_qu);
        popupWindowQu = DialogUtils.showPopupWindow(this, viewPopQu);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiu_gai_creat_btn_up_log:
                pos=0;
                putString.put(0, "img_input");
                dialog.show();
                break;
            case R.id.xiu_gai_creat_lin_choese_type:
                getType();
                popupWindowType.showAsDropDown(linType);

                break;
            case R.id.xiu_gai_creat_lin_choese_sheng:
                popupWindowSheng.showAsDropDown(linSheng);
                getSheng();
                break;
            case R.id.xiu_gai_creat_lin_choese_cyte:
                popupWindowShi.showAsDropDown(linCyte);
                break;
            case R.id.xiu_gai_creat_lin_choese_qu:
                popupWindowQu.showAsDropDown(linQu);
                break;
            case R.id.xiu_gai_iv_in_map:
                Intent intent = new Intent(MyShopDataActivity.this, TencentMapAvtivity.class);
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);
                startActivityForResult(intent, 5);
                break;
            case R.id.xiu_gai_btn_create_shop_up:
                upInfor();
                break;
            case R.id.xiu_gai_btn_create_shop_cancel:
                finish();
                break;
            case R.id.cread_log_icon_dia:
                //打开相机
                dialog.dismiss();
                openCramerer();
                break;
            case R.id.loca_icon_log_dia:
                //打开相册
                dialog.dismiss();
                openCramererFile();
                break;
            case R.id.dialog_cancle_log:
                dialog.dismiss();

                break;
            default:
                super.onClick(v);
                break;
        }
    }
    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 4);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
//            if (image == 1) {
//
//                String uri = CreamerAndAlbumUtils.getPhoto(this, requestCode, data, photoUri, 1);
//                if (list.size() < 5) {
//                    list.add(list.size(), uri);
//                    recyleAdapter.notifyDataSetChanged();
//                } else {
//                    ToastUtils.toast(this, "最多只能上传5张哦...");
//                }
//                image = 0;
//            } else {
                for (int i = 0; i < putString.size(); i++) {
                    Set<Map.Entry<Integer, String>> entries = putString.entrySet();
                    Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, String> next = iterator.next();
                        Integer key = next.getKey();
                        if (pos == key) {
                            HashMap<String, File> hashMap = CreamerAndAlbumUtils.putMap(this,
                                    requestCode, data, putString.get(key), ivLog, photoUri, 1);
                            putFile.putAll(hashMap);
                        }
                    }

//                }
            }

        }
        if (resultCode == 5) {
            lat = data.getStringExtra("lat");
            lng = data.getStringExtra("lng");
            tvLat.setText(lat);
            tvLng.setText(lng);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == Activity.RESULT_OK) {
//            for (int i = 0; i < putString.size(); i++) {
//                Set<Map.Entry<Integer, String>> entries = putString.entrySet();
//                Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<Integer, String> next = iterator.next();
//                    Integer key = next.getKey();
//                    if (pos == key) {
//                        HashMap<String, File> hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, putString.get(key), ivLog, photoUri, 4);
//                       // putFile.putAll(hashMap);
//                    }
//                }
//
//            }
//
//        }
//
//        if (resultCode == 5) {
//            lat = data.getStringExtra("lat");
//            lng = data.getStringExtra("lng");
//            tvLat.setText(lat);
//            tvLng.setText(lng);
//        }
//    }
    private void getData() {
        OkHttpUtils.get(UrlUtils.SHOP_IN_INFOR_Url, ShearPreferenceUtils.getToken(this),
                CreatShopInBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            CreatShopInBean bean = (CreatShopInBean) obj;
                            if (bean.isSuccess()) {
                                setData(bean);
                            } else {
                                ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                });

    }


    private void setData(CreatShopInBean data) {
        CreatShopInBean.ShopInfoEntity shop_info = data.getShop_info();
        if (shop_info != null) {
            if (!TextUtils.isEmpty(shop_info.getLogo())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/logo/" + shop_info.getLogo())
                        .into(ivLog);
            }
            if (!TextUtils.isEmpty(shop_info.getShop_name())) {
                tvShopName.setText(shop_info.getShop_name());
            }
            if (!TextUtils.isEmpty(shop_info.getProvince_code())) {
                province_code = shop_info.getProvince_code();
            }
            if (!TextUtils.isEmpty(shop_info.getProvince_name())) {
                tvSheng.setText(shop_info.getProvince_name());
            }
            if (!TextUtils.isEmpty(shop_info.getCity_code())) {
                city_code = shop_info.getCity_code();
            }
            if (!TextUtils.isEmpty(shop_info.getCity_name())) {
                tvShi.setText(shop_info.getCity_name());
            }
            if (!TextUtils.isEmpty(shop_info.getArea_code())) {
                area_code = shop_info.getArea_code();
            }
            if (!TextUtils.isEmpty(shop_info.getArea_name())) {
                tvQu.setText(shop_info.getArea_name());
            }
            if (!TextUtils.isEmpty(shop_info.getAddress())) {
                tvAddress.setText(shop_info.getAddress());
            }

            if (!TextUtils.isEmpty(shop_info.getPerson())) {
                tvName.setText(shop_info.getPerson());
            }

            if (!TextUtils.isEmpty(shop_info.getPhone())) {
                tvPhone.setText(shop_info.getPhone());
            }
            if (!TextUtils.isEmpty(shop_info.getBusiness_time())) {
                tvTime.setText(shop_info.getBusiness_time());
            }
            if (!TextUtils.isEmpty(shop_info.getLat())) {
                lat = shop_info.getLat();
                tvLat.setText(shop_info.getLat());
            }
            if (!TextUtils.isEmpty(shop_info.getLng())) {
                lng = shop_info.getLng();
                tvLng.setText(shop_info.getLng());
            }
            if (!TextUtils.isEmpty(shop_info.getPercent())) {
                tvXi.setText("分销类型  "+shop_info.getPercent()+"  系列");
            }
            if (!TextUtils.isEmpty(shop_info.getType())) {
                shopType = shop_info.getType();
                getType();
            }
            if (!TextUtils.isEmpty(shop_info.getDesc())) {
                tvSay.setText(shop_info.getDesc());
            }
        }
    }
    private void getType() {
        OkHttpUtils.get(UrlUtils.SHOP_TYPE_Url, null,
                HomeShopTypeBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            HomeShopTypeBean bean = (HomeShopTypeBean) obj;
                            if (bean.isSuccess()) {
                                setType(bean);
                            } else {
                                ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                });
    }

    private void setType(HomeShopTypeBean bean) {
        final List<HomeShopTypeBean.ShopTypeListEntity> shop_type_list = bean.getShop_type_list();

        if (!TextUtils.isEmpty(shopType)) {
            for (int i = 0; i < shop_type_list.size(); i++) {
                listType.add(shop_type_list.get(i).getName());
                if (TextUtils.equals(shopType, shop_type_list.get(i).getId())) {
                    tvShopType.setText(shop_type_list.get(i).getName());
                }
            }
        } else {
            for (int i = 0; i < shop_type_list.size(); i++) {
                listType.add(shop_type_list.get(i).getName());
            }
        }
        ThreeAreaUtils.getArea(this, lvtype, listType);
        lvtype.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowType.dismiss();
                tvShopType.setText(shop_type_list.get(position).getName());
                shopType = shop_type_list.get(position).getId();
                listType.add(shop_type_list.get(position).getName());
            }
        });
    }

    private void getSheng() {
        OkHttpUtils.get(UrlUtils.SHENG_Url, null, RegestGetShengBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShengBean bean = (RegestGetShengBean) obj;
                    if (bean.isSuccess()) {
                        setShengAdapter(bean.getProvince_list());
                    } else {
                        ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());
                    }
                } else {
                    noData();
                }

            }

            @Override
            public void error(Exception e) {
                netError();
            }
        });

    }

    private void setShengAdapter(final List<RegestGetShengBean.ProvinceListEntity> province_list) {
        listSheng.clear();
        for (int i = 0; i < province_list.size(); i++) {
            listSheng.add(province_list.get(i).getName());
        }
        ThreeAreaUtils.getArea(this, lvSheng, listSheng);
        lvSheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowSheng.dismiss();
                province_code = province_list.get(position).getCode();
                tvSheng.setText(province_list.get(position).getName());
                tvShi.setText("");
                tvQu.setText("");
                getShiList();
            }
        });
    }

    private void getShiList() {
        if (!TextUtils.isEmpty(province_code)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("province_code", province_code);
            OkHttpUtils.get(UrlUtils.SHI_Url, null, RegestGetShiBean.class, new OkHttpUtils.CallBackUtils() {
                @Override
                public void sucess(Object obj) {
                    if (obj != null) {
                        RegestGetShiBean bean = (RegestGetShiBean) obj;
                        if (bean.isSuccess()) {

                            setShiAdapter(bean.getCity_list());
                        } else {
                            ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());

                        }

                    } else {
                        noData();
                    }

                }

                @Override
                public void error(Exception e) {
                    netError();
                }
            }, map);
        }
    }

    private void setShiAdapter(final List<RegestGetShiBean.CityListEntity> city_list) {

        listShi.clear();
        for (int i = 0; i < city_list.size(); i++) {
            listShi.add(city_list.get(i).getName());
        }
        ThreeAreaUtils.getArea(this, lvShi, listShi);
        lvShi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowShi.dismiss();
                city_code = city_list.get(position).getCode();
                tvShi.setText(city_list.get(position).getName());
                tvQu.setText("");
                getQuList();

            }
        });
    }

    //区
    private void getQuList() {
        if (!TextUtils.isEmpty(city_code)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("city_code", city_code);
            OkHttpUtils.get(UrlUtils.QU_Url, null, RegestGetQuBean.class, new OkHttpUtils.CallBackUtils() {
                @Override
                public void sucess(Object obj) {
                    if (obj != null) {
                        RegestGetQuBean bean = (RegestGetQuBean) obj;
                        if (bean.isSuccess()) {
                            setQuAdapter(bean.getArea_list());
                        } else {
                            ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());
                        }
                    } else {
                        noData();
                    }

                }

                @Override
                public void error(Exception e) {
                    netError();
                }
            }, map);
        }

    }

    private void setQuAdapter(final List<RegestGetQuBean.AreaListEntity> area_list) {
        listQu.clear();
        for (int i = 0; i < area_list.size(); i++) {
            listQu.add(area_list.get(i).getName());
        }
        ThreeAreaUtils.getArea(this, lvQu, listQu);
        lvQu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowQu.dismiss();
                tvQu.setText(area_list.get(position).getName());
                area_code = area_list.get(position).getCode();

            }
        });
    }

    private void upInfor() {
        String nameS = tvShopName.getText().toString().trim();
        if (TextUtils.isEmpty(nameS)) {
            ToastUtils.toast(this, "商家名不能为空!");
            return;
        }

        String shopT = tvShopType.getText().toString().trim();
        if (TextUtils.isEmpty(shopT)) {
            ToastUtils.toast(this, "请选择店铺类型!");
            return;
        }
        String provice = tvSheng.getText().toString().trim();
        if (TextUtils.isEmpty(provice)) {
            ToastUtils.toast(this, "请选择店铺所在省份!");
            return;
        }
        String city = tvShi.getText().toString().trim();
        if (TextUtils.isEmpty(city)) {
            ToastUtils.toast(this, "请选择店铺所在城市!");
            return;
        }
        String area = tvQu.getText().toString().trim();
        if (TextUtils.isEmpty(area)) {
            ToastUtils.toast(this, "请选择店铺所在区域!");
            return;
        }
        String addre = tvAddress.getText().toString().trim();
        if (TextUtils.isEmpty(addre)) {
            ToastUtils.toast(this, "请输入详细地址!");
            return;
        }
        String person = tvName.getText().toString().trim();
        if (TextUtils.isEmpty(person)) {
            ToastUtils.toast(this, "请输入店铺联系人名称!");
            return;
        }
        String pho = tvPhone.getText().toString().trim();
        if (TextUtils.isEmpty(pho)) {
            ToastUtils.toast(this, "请输入商家电话!");
            return;
        }
        String tim = tvTime.getText().toString().trim();
        if (TextUtils.isEmpty(tim)) {
            ToastUtils.toast(this, "请输入营业时间!");
            return;
        }
        String la = tvLat.getText().toString().trim();
        String ln = tvLng.getText().toString().trim();
        if (TextUtils.isEmpty(la) || TextUtils.isEmpty(ln)) {
            ToastUtils.toast(this, "请在地图上选择店铺所在的位置!");
            return;
        }
        String say = tvSay.getText().toString().trim();
        if (TextUtils.isEmpty(say)) {
            ToastUtils.toast(this, "请输入店铺的简介!");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("shop_name", nameS);
        map.put("type", shopType);
        map.put("province_code", province_code);
        map.put("city_code", city_code);
        map.put("area_code", area_code);
        map.put("address", addre);
        map.put("person", person);
        map.put("phone", pho);
        map.put("business_time", tim);
        map.put("lat", la);
        map.put("lng", ln);
        map.put("desc", say);
        OkHttpUtils.putImages(UrlUtils.XIU_GAI_Url, ShearPreferenceUtils.getToken(MyShopDataActivity.this),
                LoginBean.class,putFile, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(MyShopDataActivity.this,"修改成功");
                            } else {
                                ToastUtils.toast(MyShopDataActivity.this, bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                },map);
    }
}
