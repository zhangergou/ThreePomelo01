package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.CreatShopRecyleAdapter;
import com.weixingwang.threepomelo.bean.CreatShopInBean;
import com.weixingwang.threepomelo.bean.HomeShopListBean;
import com.weixingwang.threepomelo.bean.HomeShopTypeBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.PersonCenterBean;
import com.weixingwang.threepomelo.bean.RegestGetQuBean;
import com.weixingwang.threepomelo.bean.RegestGetShengBean;
import com.weixingwang.threepomelo.bean.RegestGetShiBean;
import com.weixingwang.threepomelo.bean.RegestRecommendBean;
import com.weixingwang.threepomelo.utils.AddressUtils;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.LoseFouseUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ThreeAreaUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/6 0006.
 */
public class CreateShopActivity extends BaseActivity implements View.OnFocusChangeListener {

    private Dialog dialog;
    private Uri photoUri;
    private ImageView imageView, ivLog, ivLicence, ivAnswer, ivId;
    private List<String> listType = new ArrayList<>();
    private List<String> listSheng = new ArrayList<>();
    private List<String> listShi = new ArrayList<>();
    private List<String> listQu = new ArrayList<>();
    private List<String> listShopType = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private LinearLayout linType, linCyte, linSheng, linQu, linSellType;
    private PopupWindow popupWindowType;
    private RecyclerView rvUpImage;
    private CreatShopRecyleAdapter recyleAdapter;
    private int image = 0;
    private EditText etShopName, etLearId;
    private TextView tvShopType;
    private TextView tvProvice;
    private TextView tvCity;
    private TextView tvArea;
    private EditText etAddress;
    private EditText etPhone;
    private EditText etTime;
    private TextView etLat;
    private TextView etLng;
    private EditText etSgopSay;
    private TextView tvShoppingType;
    private String province_code;
    private String city_code;
    private String area_code;
    private String shopType;
    private MyScrollView sw;
    private LinearLayout upShopImage;
    private PopupWindow popupWindowSheng;
    private PopupWindow popupWindowShi;
    private PopupWindow popupWindowQu;
    private PopupWindow popupWindowShopType;
    private ListView lvtype;
    private ListView lvSheng;
    private ListView lvShi;
    private ListView lvQu;
    private ListView lvShopType;
    private HashMap<Integer, String> putString = new HashMap<>();
    private HashMap<String, File> putFile = new HashMap<>();
    private int pos = -1;
    private String codeRecomm;
    private EditText etPersonName;
    private String lat;
    private String lng;

    @Override
    protected int getLayoutId() {
        return R.layout.create_shop_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.create_shop_pull);
        refrush(pull);
        sw = (MyScrollView) findViewById(R.id.create_shop_sw);
        ivLog = (ImageView) findViewById(R.id.create_iv_log_icon);
        ivLicence = (ImageView) findViewById(R.id.create_iv_licence_icon);
        ivAnswer = (ImageView) findViewById(R.id.create_iv_answer_icon);
        ivId = (ImageView) findViewById(R.id.create_iv_id_icon);

        rvUpImage = (RecyclerView) findViewById(R.id.rv_cread_shop_up_image);

        upShopImage = (LinearLayout) findViewById(R.id.lin_cread_shop_up_image);
        linType = (LinearLayout) findViewById(R.id.creat_lin_choese_type);
        linSheng = (LinearLayout) findViewById(R.id.creat_lin_choese_sheng);
        linCyte = (LinearLayout) findViewById(R.id.creat_lin_choese_cyte);
        linQu = (LinearLayout) findViewById(R.id.creat_lin_choese_qu);
        linSellType = (LinearLayout) findViewById(R.id.creat_lin_choese_sell_type);


        etShopName = (EditText) findViewById(R.id.creat_shop_et_name);
        etLearId = (EditText) findViewById(R.id.creat_shop_et_say_id);
        tvShopType = (TextView) findViewById(R.id.creat_shop_et_type);
        tvProvice = (TextView) findViewById(R.id.creat_shop_tv_provice);
        tvCity = (TextView) findViewById(R.id.creat_shop_tv_city);
        tvArea = (TextView) findViewById(R.id.creat_shop_tv_area);
        etAddress = (EditText) findViewById(R.id.creat_shop_et_address);
        etPhone = (EditText) findViewById(R.id.creat_shop_et_phone);
        etTime = (EditText) findViewById(R.id.creat_shop_et_time);
        etLat = (TextView) findViewById(R.id.creat_shop_et_lat);
        etLng = (TextView) findViewById(R.id.creat_shop_et_lng);
        etSgopSay = (EditText) findViewById(R.id.creat_shop_et_shop_say);
        etPersonName = (EditText) findViewById(R.id.creat_shop_et_person_name);
        tvShoppingType = (TextView) findViewById(R.id.creat_shop_et_shopping_type);
        setTitle("商家入驻");
        isShowBack(true);
        closeLoadMore(true);

    }

    @Override
    protected void initData() {

        getData();

        recyleAdapter = new CreatShopRecyleAdapter(this, rvUpImage, list,
                R.layout.create_shop_re_up_image_item, 1);
        rvUpImage.setAdapter(recyleAdapter);
        showCreateDialog();
        getType();
        getShopType();
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

        View viewPopShopType = View.inflate(this, R.layout.pop_shop_type_item, null);
        lvShopType = (ListView) viewPopShopType.findViewById(R.id.create_lv_shop_type);
        popupWindowShopType = DialogUtils.showPopupWindow(this, viewPopShopType);
    }

    @Override
    protected void initLisener() {

        findViewById(R.id.creat_btn_up_log).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_licence).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_answer).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_id).setOnClickListener(this);
        findViewById(R.id.btn_create_shop_up).setOnClickListener(this);
        findViewById(R.id.btn_create_shop_cancel).setOnClickListener(this);
        findViewById(R.id.iv_in_map).setOnClickListener(this);

        etLearId.setOnFocusChangeListener(this);
        upShopImage.setOnClickListener(this);
        linType.setOnClickListener(this);
        linSheng.setOnClickListener(this);
        linCyte.setOnClickListener(this);
        linQu.setOnClickListener(this);
        linSellType.setOnClickListener(this);
        recyleAdapter.setOnClickItemView(new BaseRecyleAdapter.OnClickItemView() {
            @Override
            public void onItem(int postion) {
                list.remove(postion);
                recyleAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.creat_lin_choese_type:
                popupWindowType.showAsDropDown(linType);
                break;
            case R.id.creat_lin_choese_sheng:
                popupWindowSheng.showAsDropDown(linSheng);
                getSheng();
                break;
            case R.id.creat_lin_choese_cyte:
                popupWindowShi.showAsDropDown(linCyte);
                break;
            case R.id.creat_lin_choese_qu:
                popupWindowQu.showAsDropDown(linQu);
                break;
            case R.id.creat_lin_choese_sell_type:
                popupWindowShopType.showAsDropDown(linSellType);
                break;
            case R.id.creat_btn_up_log:
                pos = 0;
                putString.put(0, "img_input");
                imageView = ivLog;
                dialog.show();
                break;
            case R.id.creat_btn_up_licence:
                putString.put(1, "license");
                pos = 1;
                imageView = ivLicence;
                dialog.show();
                break;
            case R.id.creat_btn_up_answer:
                putString.put(2, "cns1");
                pos = 2;
                imageView = ivAnswer;
                dialog.show();
                break;
            case R.id.creat_btn_up_id:
                putString.put(3, "sfz1");
                pos = 3;
                imageView = ivId;
                dialog.show();
                break;
            case R.id.lin_cread_shop_up_image:
                image = 1;
                dialog.show();
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
            case R.id.btn_create_shop_up:
                //提交
                upAllData();

                break;
            case R.id.btn_create_shop_cancel:
                ToastUtils.toast(this, "取消,取消,取消");
                break;
            case R.id.iv_in_map:
                Intent intent = new Intent(CreateShopActivity.this, TencentMapAvtivity.class);
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);
                startActivityForResult(intent, 5);
                break;
            default:
                super.onClick(v);
                break;
        }

    }

    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 2);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (image == 1) {

                String uri = CreamerAndAlbumUtils.getPhoto(this, requestCode, data, photoUri, 1);
                if (list.size() < 5) {
                    list.add(list.size(), uri);
                    recyleAdapter.notifyDataSetChanged();
                } else {
                    ToastUtils.toast(this, "最多只能上传5张哦...");
                }
                image = 0;
            } else {
                for (int i = 0; i < putString.size(); i++) {
                    Set<Map.Entry<Integer, String>> entries = putString.entrySet();
                    Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, String> next = iterator.next();
                        Integer key = next.getKey();
                        if (pos == key) {
                            HashMap<String, File> hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, putString.get(key), imageView, photoUri, 1);
                            putFile.putAll(hashMap);
                        }
                    }

                }
            }

        }
        if (resultCode == 5) {
            lat = data.getStringExtra("lat");
            lng = data.getStringExtra("lng");
            etLat.setText(lat);
            etLng.setText(lng);
        }
    }

    private void getData() {
        showLoading();
        OkHttpUtils.get(UrlUtils.SHOP_IN_INFOR_Url, ShearPreferenceUtils.getToken(this),
                CreatShopInBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            CreatShopInBean bean = (CreatShopInBean) obj;
                            if (bean.isSuccess()) {

                                setData(bean);
                            } else {
                                ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                        closeLoading();
                    }
                });
    }

    private void setData(CreatShopInBean data) {
        String status = data.getShop_info().getStatus();
        if (!TextUtils.isEmpty(status)) {
            if (TextUtils.equals(status, "-1")) {
                //拒绝
                detData(data, -1);
            } else if (TextUtils.equals(status, "1")) {
                //等待审核
                detData(data, 1);
            } else {

            }

        }
    }

    private void detData(CreatShopInBean data, int i) {
        CreatShopInBean.ShopInfoEntity shop_info = data.getShop_info();
        if (shop_info != null) {
            if (!TextUtils.isEmpty(shop_info.getLogo())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/upload/logo/" + shop_info.getLogo())
                        .into(ivLog);
            }
            if (!TextUtils.isEmpty(shop_info.getLicense())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/license/" + shop_info.getLicense())
                        .into(ivLicence);
            }
            if (!TextUtils.isEmpty(shop_info.getCns1())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/csn/" + shop_info.getCns1())
                        .into(ivAnswer);
            }
            if (!TextUtils.isEmpty(shop_info.getSfz1())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/sfz/" + shop_info.getSfz1())
                        .into(ivId);
            }
            if (!TextUtils.isEmpty(shop_info.getShop_name())) {
                etShopName.setText(shop_info.getShop_name());
            }
            if (!TextUtils.isEmpty(shop_info.getParent_uid())) {
                etLearId.setText(shop_info.getParent_uid());
            }
            if (!TextUtils.isEmpty(shop_info.getProvince_code())) {
                province_code = shop_info.getProvince_code();
            }
            if (!TextUtils.isEmpty(shop_info.getProvince_name())) {
                tvProvice.setText(shop_info.getProvince_name());
            }
            if (!TextUtils.isEmpty(shop_info.getCity_code())) {
                city_code = shop_info.getCity_code();
            }
            if (!TextUtils.isEmpty(shop_info.getCity_name())) {
                tvCity.setText(shop_info.getCity_name());
            }
            if (!TextUtils.isEmpty(shop_info.getArea_code())) {
                area_code = shop_info.getArea_code();
            }
            if (!TextUtils.isEmpty(shop_info.getArea_name())) {
                tvArea.setText(shop_info.getArea_name());
            }
            if (!TextUtils.isEmpty(shop_info.getAddress())) {
                etAddress.setText(shop_info.getAddress());
            }

            if (!TextUtils.isEmpty(shop_info.getPerson())) {
                etPersonName.setText(shop_info.getPerson());
            }

            if (!TextUtils.isEmpty(shop_info.getPhone())) {
                etPhone.setText(shop_info.getPhone());
            }
            if (!TextUtils.isEmpty(shop_info.getBusiness_time())) {
                etTime.setText(shop_info.getBusiness_time());
            }
            if (!TextUtils.isEmpty(shop_info.getLat())) {
                lat = shop_info.getLat();
                etLat.setText(shop_info.getLat());
            }
            if (!TextUtils.isEmpty(shop_info.getLng())) {
                lng = shop_info.getLng();
                etLng.setText(shop_info.getLng());
            }
            if (!TextUtils.isEmpty(shop_info.getPercent())) {
                tvShoppingType.setText(shop_info.getPercent());
            }
            if (!TextUtils.isEmpty(shop_info.getType())) {
                shopType = shop_info.getType();
            }
            if (!TextUtils.isEmpty(shop_info.getDesc())) {
                etSgopSay.setText(shop_info.getDesc());
            }
            if (i == 1) {
                LoseFouseUtils.disableSubControls(sw);
                upShopImage.setEnabled(false);
                upShopImage.setClickable(false);
                linType.setEnabled(false);
                linType.setClickable(false);
                linSheng.setEnabled(false);
                linSheng.setClickable(false);
                linCyte.setEnabled(false);
                linCyte.setClickable(false);
                linQu.setEnabled(false);
                linQu.setClickable(false);
                linSellType.setEnabled(false);
                linSellType.setClickable(false);
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
                                ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
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
                        ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
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
                tvProvice.setText(province_list.get(position).getName());
                tvCity.setText("");
                tvArea.setText("");
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
                            ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());

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
                tvCity.setText(city_list.get(position).getName());
                tvArea.setText("");
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
                            ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
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
                tvArea.setText(area_list.get(position).getName());
                area_code = area_list.get(position).getCode();

            }
        });
    }

    public void getShopType() {
        for (int i = 0; i < ArrayUtils.shopingType.length; i++) {
            listShopType.add(ArrayUtils.shopingType[i]);
        }
        ThreeAreaUtils.getArea(this, lvShopType, listShopType);
        lvShopType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowShopType.dismiss();

                tvShoppingType.setText(listShopType.get(position));

            }
        });
    }

    private void upAllData() {
        String nameS = etShopName.getText().toString().trim();
        if (TextUtils.isEmpty(nameS)) {
            ToastUtils.toast(this, "商家名不能为空!");
            return;
        }
        String lId = etLearId.getText().toString().trim();
        if (TextUtils.isEmpty(lId)) {
            ToastUtils.toast(this, "请输入邀请人电话或id!");
            return;
        }
        String shopT = tvShopType.getText().toString().trim();
        if (TextUtils.isEmpty(shopT)) {
            ToastUtils.toast(this, "请选择店铺类型!");
            return;
        }
        String provice = tvProvice.getText().toString().trim();
        if (TextUtils.isEmpty(provice)) {
            ToastUtils.toast(this, "请选择店铺所在省份!");
            return;
        }
        String city = tvCity.getText().toString().trim();
        if (TextUtils.isEmpty(city)) {
            ToastUtils.toast(this, "请选择店铺所在城市!");
            return;
        }
        String area = tvArea.getText().toString().trim();
        if (TextUtils.isEmpty(area)) {
            ToastUtils.toast(this, "请选择店铺所在区域!");
            return;
        }
        String addre = etAddress.getText().toString().trim();
        if (TextUtils.isEmpty(addre)) {
            ToastUtils.toast(this, "请输入详细地址!");
            return;
        }
        String person = etPersonName.getText().toString().trim();
        if (TextUtils.isEmpty(person)) {
            ToastUtils.toast(this, "请输入店铺联系人名称!");
            return;
        }
        String pho = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(pho)) {
            ToastUtils.toast(this, "请输入商家电话!");
            return;
        }
        String tim = etTime.getText().toString().trim();
        if (TextUtils.isEmpty(tim)) {
            ToastUtils.toast(this, "请输入营业时间!");
            return;
        }
        String la = etLat.getText().toString().trim();
        String ln = etLng.getText().toString().trim();
        if (TextUtils.isEmpty(la) || TextUtils.isEmpty(ln)) {
            ToastUtils.toast(this, "请在地图上选择店铺所在的位置!");
            return;
        }
        String shoppingT = tvShoppingType.getText().toString().trim();
        if (TextUtils.isEmpty(shoppingT)) {
            ToastUtils.toast(this, "请选择店铺的分销类型!");
            return;
        }

        String say = etSgopSay.getText().toString().trim();
        if (TextUtils.isEmpty(say)) {
            ToastUtils.toast(this, "请输入店铺的简介!");
            return;
        }
        if (putFile.size() < 4) {
            ToastUtils.toast(this, "请继续上传照片!");
            return;
        }
//        Toast.makeText(CreateShopActivity.this, "putFile.size()="+putFile.size(), Toast.LENGTH_SHORT).show();
//        Set<Map.Entry<String, File>> entries = putFile.entrySet();
//        Iterator<Map.Entry<String, File>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, File> next = iterator.next();
//            ToastUtils.toast(this,next.getKey());
//        }
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("shop_name", nameS);
        map.put("parent_flag", codeRecomm);
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
        map.put("percent", shoppingT);
        map.put("desc", say);
        OkHttpUtils.putImages(UrlUtils.SHOP_IN__UP_Url, ShearPreferenceUtils.getToken(CreateShopActivity.this),
                LoginBean.class, putFile, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(CreateShopActivity.this, "成功");
                            } else {
                                ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        netError();
                    }
                }, map);


    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String recommendCode = etLearId.getText().toString().trim();
        if (!hasFocus || !TextUtils.isEmpty(recommendCode)) {
            editTextIsTrue(recommendCode);
        }
    }


    private void editTextIsTrue(final String recommendCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keywords", recommendCode);
        OkHttpUtils.get(UrlUtils.RECOMMEND_Url, null, RegestRecommendBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestRecommendBean bean = (RegestRecommendBean) obj;
                    if (bean.isSuccess()) {
                        ToastUtils.toast(CreateShopActivity.this, "你的推荐人是" + bean.getName());
                        codeRecomm = bean.getId();

                    } else {
                        ToastUtils.toast(CreateShopActivity.this, bean.getError_msg());
                        etLearId.setText("");
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

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getData();
        super.onRefresh(pullToRefreshLayout);
    }
}















































































































