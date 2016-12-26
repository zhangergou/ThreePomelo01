package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.RegestGetQuBean;
import com.weixingwang.threepomelo.bean.RegestGetShengBean;
import com.weixingwang.threepomelo.bean.RegestGetShiBean;
import com.weixingwang.threepomelo.bean.RegestRecommendBean;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class RegestActivity extends BaseActivity implements View.OnFocusChangeListener {

    private CircleImageView circleIv;
    private Dialog dialog;
    /***
     * 使用照相机拍照获取图片
     */
    public static final int SELECT_PIC_BY_TACK_PHOTO = 1;
    /***
     * 使用相册中的图片
     */
    public static final int SELECT_PIC_BY_PICK_PHOTO = 2;

    /***
     * 从Intent获取图片路径的KEY
     */
    public static final String KEY_PHOTO_PATH = "photo_path";
    private Uri photoUri;
    private ListView lvSheng;
    private List<String> listsh = new ArrayList<>();
    private List<String> listsi = new ArrayList<>();
    private List<String> listq = new ArrayList<>();
    private List<RegestGetShengBean.ProvinceListEntity> listSheng = new ArrayList<>();
    private List<RegestGetShiBean.CityListEntity> listShi = new ArrayList<>();
    private List<RegestGetQuBean.AreaListEntity> listQu = new ArrayList<>();
    private int pos = 0;
    private LinearLayout linSheng;
    private LinearLayout linShi;
    private LinearLayout linQu;
    private ListView lvShi;
    private ListView lvQu;
    private TextView tvSheng;
    private TextView tvShi;
    private TextView tvQu;
    private PopupWindow popupWindowSheng;
    private PopupWindow popupWindowShi;
    private PopupWindow popupWindowQu;
    private EditText etRecommend;
    private ArrayAdapter<String> adapterShi;
    private ArrayAdapter<String> adapterQu;
    private EditText passwordOne;
    private EditText passwordTwo;
    private EditText etName;
    private EditText etIDCode;
    private HashMap<String,File> mapFile=new HashMap<>();
    private HashMap<String, File> hashMap;
    private String mobile;
    private String codeRecomm=null;
    private String province_code=null;
    private String city_code=null;
    private String area_code=null;
    @Override
    protected int getLayoutId() {
        return R.layout.regest_lyout;
    }

    @Override
    protected void initView() {
        circleIv = (CircleImageView) findViewById(R.id.iv_regest_icon);
        linSheng = (LinearLayout) findViewById(R.id.regest_lin_sheng);
        linShi = (LinearLayout) findViewById(R.id.regest_lin_shi);
        linQu = (LinearLayout) findViewById(R.id.regest_lin_qu);
        tvSheng = (TextView) findViewById(R.id.tv_regest_sheng);
        tvShi = (TextView) findViewById(R.id.tv_regest_shi);
        tvQu = (TextView) findViewById(R.id.tv_regest_qu);
        etRecommend = (EditText) findViewById(R.id.regest_et_recommend);
        passwordOne = (EditText) findViewById(R.id.et_regest_password_one);
        passwordTwo = (EditText) findViewById(R.id.et_regest_password_two);
        etName = (EditText) findViewById(R.id.tv_regesty_name);
        etIDCode = (EditText) findViewById(R.id.et_regest_id_num);
        setTitle("会员注册");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        getShengList();

        //省
        View inflateSheng = View.inflate(this, R.layout.pop_sheng_item, null);
        lvSheng = (ListView) inflateSheng.findViewById(R.id.regest_lv_sheng);
        popupWindowSheng = DialogUtils.showPopupWindow(this, inflateSheng);

        //市
        View inflateShi = View.inflate(this, R.layout.pop_shi_item, null);
        lvShi = (ListView) inflateShi.findViewById(R.id.regest_lv_shi);
        popupWindowShi = DialogUtils.showPopupWindow(this, inflateShi);
        //区
        View inflateQu = View.inflate(this, R.layout.pop_qu_item, null);
        lvQu = (ListView) inflateQu.findViewById(R.id.regest_lv_qu);
        popupWindowQu = DialogUtils.showPopupWindow(this, inflateQu);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.btn_regest_up_icon).setOnClickListener(this);
        linSheng.setOnClickListener(this);
        linShi.setOnClickListener(this);
        linQu.setOnClickListener(this);
        etRecommend.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regest_up_icon:
                //弹出dialog
                showImageDialog();
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
            case R.id.regest_lin_sheng:
                popupWindowSheng.showAsDropDown(linSheng);
                break;
            case R.id.regest_lin_shi:
                popupWindowShi.showAsDropDown(linShi);
                break;
            case R.id.regest_lin_qu:
                popupWindowQu.showAsDropDown(linQu);
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 1);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 1);
    }

    private void showImageDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, "img_input", circleIv, photoUri, 1);
        }
    }

    //获取省列表
    public void getShengList() {
        OkHttpUtils.get(UrlUtils.SHENG_Url, null, RegestGetShengBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShengBean bean = (RegestGetShengBean) obj;
                    if (bean.isSuccess()) {
                        listSheng.clear();
                        listSheng.addAll(bean.getProvince_list());
                        setShengAdapter();
                    } else {
                        ToastUtils.toast(RegestActivity.this, bean.getError_msg());
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

    private void setShengAdapter() {
        listsh.clear();
        for (int i = 0; i < listSheng.size(); i++) {
            listsh.add(listSheng.get(i).getName());
        }
        lvSheng.setAdapter(new ArrayAdapter<String>(RegestActivity.this, android.R.layout.simple_list_item_1, listsh));
        lvSheng.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowSheng.dismiss();
                tvSheng.setText(listsh.get(position));
                tvShi.setText("- 城市 -");
                tvQu.setText("- 区域 -");
                getShiList(listSheng.get(position).getCode());

            }
        });

    }


    //获取市列表
    public void getShiList(String code) {
        province_code=code;
        HashMap<String, String> map = new HashMap<>();
        map.put("province_code", code);
        OkHttpUtils.get(UrlUtils.SHI_Url, null, RegestGetShiBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShiBean bean = (RegestGetShiBean) obj;
                    if (bean.isSuccess()) {
                        listShi.clear();
                        listShi.addAll(bean.getCity_list());
                        setShiAdapter();
                    } else {
                        ToastUtils.toast(RegestActivity.this, bean.getError_msg());
                        tvSheng.setText("- 省份 -");
                        tvShi.setText("- 城市 -");
                        tvQu.setText("- 区域 -");
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

    private void setShiAdapter() {
        listsi.clear();
        for (int i = 0; i < listShi.size(); i++) {
            listsi.add(listShi.get(i).getName());
        }
        adapterShi = new ArrayAdapter<>(RegestActivity.this, android.R.layout.simple_list_item_1, listsi);
        lvShi.setAdapter(adapterShi);
        lvShi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowShi.dismiss();
                tvShi.setText(listsi.get(position));
                getQuList(listShi.get(position).getCode());

            }
        });
    }

    //获取区域列表
    public void getQuList(String code) {
        city_code=code;
        HashMap<String, String> map = new HashMap<>();
        map.put("city_code", code);
        OkHttpUtils.get(UrlUtils.QU_Url, null, RegestGetQuBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetQuBean bean = (RegestGetQuBean) obj;
                    if (bean.isSuccess()) {
                        listQu.clear();
                        listQu.addAll(bean.getArea_list());
                        setQuAdapter();
                    } else {
                        ToastUtils.toast(RegestActivity.this, bean.getError_msg());
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

    private void setQuAdapter() {
        listq.clear();
        for (int i = 0; i < listQu.size(); i++) {
            listq.add(listQu.get(i).getName());
        }
        adapterQu = new ArrayAdapter<>(RegestActivity.this, android.R.layout.simple_list_item_1, listq);
        lvQu.setAdapter(adapterQu);
        lvQu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowQu.dismiss();
                tvQu.setText(listq.get(position));
                area_code=listQu.get(position).getCode();
            }
        });
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String recommendCode = etRecommend.getText().toString().trim();
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
                        ToastUtils.toast(RegestActivity.this, "你的推荐人是" + bean.getName());
                        codeRecomm=bean.getId();
                    } else {
                        ToastUtils.toast(RegestActivity.this, bean.getError_msg());
                        etRecommend.setText("");
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

    //提交注册信息
    public void regest(View v) {
        String passOne = passwordOne.getText().toString().trim();
        String passTwo = passwordTwo.getText().toString().trim();
        if (TextUtils.isEmpty(passOne) || TextUtils.isEmpty(passTwo)) {
            ToastUtils.toast(this,"创建密码不能为空!");
            passwordOne.setText("");
            passwordTwo.setText("");
            return;
        }
        if(!TextUtils.equals(passOne,passTwo)){
            ToastUtils.toast(this,"两次输入密码不一致");
            passwordTwo.setText("");
            return;
        }

        if(passOne.length()<6){
            ToastUtils.toast(this,"密码不得少于6位");
            passwordOne.setText("");
            passwordTwo.setText("");
            return;
        }
        String recom = etRecommend.getText().toString().trim();
        if(TextUtils.isEmpty(recom)){
            ToastUtils.toast(this,"推荐人的ID或电话号码不能为空!");
            return;
        }

        String sheng = tvSheng.getText().toString();
        String shi = tvShi.getText().toString();
        String qu = tvQu.getText().toString();
        if(TextUtils.equals("- 省份 -",sheng)||TextUtils.equals("- 城市 -",shi)
                ||TextUtils.equals("- 区域 -",qu)){
            ToastUtils.toast(this,"请选择所在区域");
            return;
        }
        String name = etName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            ToastUtils.toast(this,"真实姓名不能为空!");
            return;
        }
        String regxt="(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
        String idCode = etIDCode.getText().toString().trim();
        if(TextUtils.isEmpty(idCode)){
            ToastUtils.toast(this,"身份证号不能为空!");
            return;
        }
        if(!idCode.matches(regxt)){
            ToastUtils.toast(this,"身份证号输入不正确,请重新输入...");
            etIDCode.setText("");
            return;
        }
        showLoading();
        HashMap<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("parent_id",codeRecomm);
        map.put("password",passOne);
        map.put("province_code",province_code);
        map.put("city_code",city_code);
        map.put("area_code",area_code);
        map.put("rel_name",name);
        map.put("id_no",idCode);

        OkHttpUtils.putImages(UrlUtils.REGEST_Url, null, LoginBean.class, hashMap, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                closeLoading();
                if(obj!=null){
                    LoginBean bean= (LoginBean) obj;
                    if(bean.isSuccess()){

                        ShearPreferenceUtils.putToken(RegestActivity.this,bean.getToken());
                        startActivity(new Intent(RegestActivity.this,LoginActivity.class));
                        finish();
                    }else {
                        ToastUtils.toast(RegestActivity.this,bean.getError_msg());
                    }
                }else{
                    noData();
                }
            }

            @Override
            public void error(Exception e) {
                closeLoading();
                netError();
            }
        },map);
    }
}
