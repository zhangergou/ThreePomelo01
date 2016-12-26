package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.AccountMassageBean;
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
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class AccountManagerActivity extends BaseActivity {

    private Dialog dialog;
    private Uri photoUri;
    private CircleImageView ivCirIcon;
    private List<String> listGroup = new ArrayList<>();
    private ListView lvSheng;
    private PopupWindow popupWindow;
    private TextView tvSheng;
    private TextView tvShi;
    private TextView tvQu;
    private String sheng_code="";
    private String city_code="";
    private TextView tvName;
    private TextView tvPhone;
    private String qu_code="";
    private HashMap<String, File> hashMap;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.account_my_pull);
        refrush(pull);
        ivCirIcon = (CircleImageView) findViewById(R.id.iv_account_my_icon);
        tvSheng = (TextView) findViewById(R.id.account_new_provice);
        tvShi = (TextView) findViewById(R.id.account_new_city);
        tvQu = (TextView) findViewById(R.id.account_new_area);
        tvName = (TextView) findViewById(R.id.account_tv_name);
        tvPhone = (TextView) findViewById(R.id.account_tv_phone);
        setTitle("我的账户");
        isShowBack(true);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        initMyDialog();
        netWork();
    }

    private void netWork() {
        showLoading();
        OkHttpUtils.get(UrlUtils.PERSEN_INFOR_Url, ShearPreferenceUtils.getToken(AccountManagerActivity.this),
                AccountMassageBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                closeLoading();
                if (obj != null) {
                    AccountMassageBean bean = (AccountMassageBean) obj;
                    if (bean.isSuccess()) {
                        setData(bean);
                    } else {
                        ToastUtils.toast(AccountManagerActivity.this, bean.getError_msg());
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
        });
    }

    private void setData(AccountMassageBean bean) {
        AccountMassageBean.UserInfoEntity user_info = bean.getUser_info();
        if(!TextUtils.isEmpty(user_info.getRel_name())){
            tvName.setText(user_info.getRel_name());
        }
        if(!TextUtils.isEmpty(user_info.getMobile())){
            tvPhone.setText(user_info.getMobile());
        }
        if(!TextUtils.isEmpty(user_info.getProvince_name())){

            tvSheng.setText(user_info.getProvince_name());
        }
        if(!TextUtils.isEmpty(user_info.getProvince_code())){

            sheng_code= user_info.getProvince_code();
        }

        if(!TextUtils.isEmpty(user_info.getCity_name())){
            tvShi.setText(user_info.getCity_name());
        }
        if(!TextUtils.isEmpty(user_info.getCity_code())){
            city_code= user_info.getCity_code();
        }
        if(!TextUtils.isEmpty(user_info.getArea_name())){
            tvQu.setText(user_info.getArea_name());
        }
        if(!TextUtils.isEmpty(user_info.getArea_code())){
           qu_code= user_info.getArea_code();
        }
        if(!TextUtils.isEmpty(user_info.getFace())){
            Glide.with(this).load(UrlUtils.MAIN_Url+user_info.getFace())
                    .into(ivCirIcon);
        }
    }

    private void initMyDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.account_revise_password).setOnClickListener(this);
        findViewById(R.id.account_revise_ok).setOnClickListener(this);
        findViewById(R.id.account_revise_cancel).setOnClickListener(this);
        findViewById(R.id.iv_account_up_icon).setOnClickListener(this);

        tvSheng.setOnClickListener(this);
        tvShi.setOnClickListener(this);
        tvQu.setOnClickListener(this);


        View viewPop = View.inflate(this, R.layout.pop_sheng_item, null);
        lvSheng = (ListView) viewPop.findViewById(R.id.regest_lv_sheng);
        popupWindow = DialogUtils.showPopupWindow(this, viewPop);
        lvSheng.setAdapter(new ArrayAdapter<String>(AccountManagerActivity.this,
                android.R.layout.simple_list_item_1, listGroup));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_account_up_icon:
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
            case R.id.account_new_provice:
                getData();
                popupWindow.showAsDropDown(tvSheng);
                break;
            case R.id.account_new_city:
                getShiList(sheng_code);
                popupWindow.showAsDropDown(tvShi);
                break;
            case R.id.account_new_area:
                getQuList(city_code);
                popupWindow.showAsDropDown(tvQu);
                break;
            case R.id.account_revise_password:
                String phone = tvPhone.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){
                    ToastUtils.toast(this,"电话不能为空");
                    return;
                }
                Intent intent = new Intent(AccountManagerActivity.this, SetPasswordActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra("mobile", phone);
                startActivity(intent);
                break;
            case R.id.account_revise_ok:

                upInfor();
                break;
            case R.id.account_revise_cancel:
                finish();
                break;
            default:
                super.onClick(v);
                break;
        }
    }
    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 3);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, "img_input", ivCirIcon, photoUri, 3);
        }

    }
    //省
    private void getData() {
        OkHttpUtils.get(UrlUtils.SHENG_Url, null, RegestGetShengBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShengBean bean = (RegestGetShengBean) obj;
                    if (bean.isSuccess()) {
                       
                       
                        setShengAdapter(bean.getProvince_list());
                    } else {
                        ToastUtils.toast(AccountManagerActivity.this, bean.getError_msg());
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
        listGroup.clear();
        for (int i = 0; i < province_list.size(); i++) {
            listGroup.add(province_list.get(i).getName());
        }
        ThreeAreaUtils.getArea(AccountManagerActivity.this,lvSheng,listGroup);
        lvSheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSheng.setText(listGroup.get(position));
                popupWindow.dismiss();
                sheng_code =province_list.get(position).getCode();
                tvShi.setText("- 城市 -");
                tvQu.setText("- 区域 -");
            }
        });
    }
    //市
    private void getShiList(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("province_code", code);
        OkHttpUtils.get(UrlUtils.SHI_Url, null, RegestGetShiBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShiBean bean = (RegestGetShiBean) obj;
                    if (bean.isSuccess()) {
                        setShiAdapter(bean.getCity_list());
                    } else {
                        ToastUtils.toast(AccountManagerActivity.this, bean.getError_msg());
                        popupWindow.dismiss();
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

    private void setShiAdapter(final List<RegestGetShiBean.CityListEntity> city_list) {
        listGroup.clear();
        for (int i = 0; i < city_list.size(); i++) {
            listGroup.add(city_list.get(i).getName());
        }

        lvSheng.setAdapter(new ArrayAdapter<String>(AccountManagerActivity.this, android.R.layout.simple_list_item_1, listGroup));
        lvSheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvShi.setText(listGroup.get(position));
                city_code = city_list.get(position).getCode();
                popupWindow.dismiss();
                tvQu.setText("- 区域 -");

            }
        });
    }
    //区
    private void getQuList(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("city_code", code);
        OkHttpUtils.get(UrlUtils.QU_Url, null, RegestGetQuBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetQuBean bean = (RegestGetQuBean) obj;
                    if (bean.isSuccess()) {
                        setQuAdapter(bean.getArea_list());
                    } else {
                        ToastUtils.toast(AccountManagerActivity.this, bean.getError_msg());
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

    private void setQuAdapter(final List<RegestGetQuBean.AreaListEntity> area_list) {
        listGroup.clear();
        for (int i = 0; i < area_list.size(); i++) {
            listGroup.add(area_list.get(i).getName());
        }
        lvSheng.setAdapter(new ArrayAdapter<String>(AccountManagerActivity.this, android.R.layout.simple_list_item_1, listGroup));
        lvSheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvQu.setText(listGroup.get(position));
                qu_code =area_list.get(position).getCode();
                popupWindow.dismiss();

//                area_code = listQu.get(position).getCode();
//                initRecleData(area_code);
            }
        });
    }

    private void upInfor() {
        HashMap<String, String> map = new HashMap<>();
        map.put("province_code", sheng_code);
        map.put("city_code", city_code);
        map.put("area_code", qu_code);
        OkHttpUtils.putImages(UrlUtils.PERSEN_INFOR_REVERSE_Url, ShearPreferenceUtils.getToken(AccountManagerActivity.this),
                LoginBean.class, hashMap,new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    LoginBean bean = (LoginBean) obj;
                    if (bean.isSuccess()) {
                        ToastUtils.toast(AccountManagerActivity.this, "上传成功");
                    } else {
                        ToastUtils.toast(AccountManagerActivity.this, bean.getError_msg());
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
        netWork();
        super.onRefresh(pullToRefreshLayout);
    }
}
