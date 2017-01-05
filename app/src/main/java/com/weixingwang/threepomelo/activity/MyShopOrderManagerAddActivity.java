package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderManagerAddActivity extends BaseActivity {

    private EditText etId;
    private EditText etName;
    private EditText etMoney;
    private ImageView ivZheng;
    private Dialog dialogBtom;
    private Uri photoUri;
    private HashMap<Integer, String> putString = new HashMap<>();
    private HashMap<String, File> putFile = new HashMap<>();
    private int pos=-1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_order;
    }

    @Override
    protected void initView() {
        etId = (EditText) findViewById(R.id.add_my_shop_order_et);
        etName = (EditText) findViewById(R.id.add_my_shop_order_et_name);
        etMoney = (EditText) findViewById(R.id.add_my_shop_order_et_money);
        ivZheng = (ImageView) findViewById(R.id.add_my_shop_order_iv_zheng);
        setTitle("添加订单");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.add_my_shop_order_iv_no).setOnClickListener(this);
        findViewById(R.id.add_my_shop_order_iv_ok).setOnClickListener(this);
        findViewById(R.id.add_my_shop_order_iv_up).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_my_shop_order_iv_no:
                finish();
                break;
            case R.id.add_my_shop_order_iv_ok:
                upData();
                break;
            case R.id.add_my_shop_order_iv_up:
                pos=0;
                putString.put(0,"GW");
                showDia();
                break;
            case R.id.cread_log_icon_dia:
                //打开相机
                dialogBtom.dismiss();
                openCramerer();
                break;
            case R.id.loca_icon_log_dia:
                //打开相册
                dialogBtom.dismiss();
                openCramererFile();
                break;
            case R.id.dialog_cancle_log:
                dialogBtom.dismiss();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void showDia() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialogBtom = DialogUtils.diaBottm(this, inflate, true);
        dialogBtom.show();
    }
    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 6);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 6);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            for (int i = 0; i < putString.size(); i++) {
                Set<Map.Entry<Integer, String>> entries = putString.entrySet();
                Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, String> next = iterator.next();
                    Integer key = next.getKey();
                    if (pos == key) {
                        HashMap<String, File> hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, putString.get(key), ivZheng, photoUri, 1);
                        putFile.putAll(hashMap);
                    }

                }
            }

        }
    }

    private void upData() {
        String id = etId.getText().toString().trim();
        String money = etMoney.getText().toString().trim();
        if(TextUtils.isEmpty(id)){
            ToastUtils.toast(this,"手机号/ID不能为空");
            return;
        }
        if(TextUtils.isEmpty(money)){
            ToastUtils.toast(this,"金额不能为空");
            return;
        }
        if(pos==-1){
            ToastUtils.toast(this,"请上传购物凭证");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("user_flag", id);
        map.put("price",money);
        OkHttpUtils.putImages(UrlUtils.MY_SHOP_ORDER_CREAT_Url, ShearPreferenceUtils.getToken(MyShopOrderManagerAddActivity.this),
                LoginBean.class,putFile, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(MyShopOrderManagerAddActivity.this,"添加成功");
                                etMoney.setText("");
                            } else {
                                ToastUtils.toast(MyShopOrderManagerAddActivity.this, bean.getError_msg());
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
