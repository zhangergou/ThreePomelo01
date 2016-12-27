package com.weixingwang.threepomelo.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderManagerAddActivity extends BaseActivity {

    private EditText etId;
    private EditText etName;
    private EditText etMoney;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_order;
    }

    @Override
    protected void initView() {
        etId = (EditText) findViewById(R.id.add_my_shop_order_et);
        etName = (EditText) findViewById(R.id.add_my_shop_order_et_name);
        etMoney = (EditText) findViewById(R.id.add_my_shop_order_et_money);
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
            default:
                super.onClick(v);
                break;
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
        HashMap<String, String> map = new HashMap<>();
        map.put("user_flag", id);
        map.put("price",money);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_CREAT_Url, ShearPreferenceUtils.getToken(MyShopOrderManagerAddActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

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
