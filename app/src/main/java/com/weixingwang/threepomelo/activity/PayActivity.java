package com.weixingwang.threepomelo.activity;

import android.view.View;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.PayCodeBean;
import com.weixingwang.threepomelo.bean.UpOrderPaySunBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/16 0016.
 */
public class PayActivity extends BaseActivity {

    private String pay_code = "";
    private String order_id;

    @Override
    protected int getLayoutId() {
        return R.layout.pay_layout;
    }

    @Override
    protected void initView() {
        setTitle("收银台");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        order_id = getIntent().getStringExtra("order_id");
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.pay_weixin).setOnClickListener(this);
        findViewById(R.id.pay_aili).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay_weixin:
                pay_code = "wechatpay";
                pay();
                break;
            case R.id.pay_aili:
                pay_code = "alipay";
                pay();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void pay() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("pay_code", pay_code);
        map.put("order_id", order_id);
        OkHttpUtils.get(UrlUtils.SHOP_GET_PAY_CODE_Url, ShearPreferenceUtils.getToken(PayActivity.this),
                PayCodeBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            PayCodeBean bean = (PayCodeBean) obj;
                            if (bean.isSuccess()) {
                                goData(bean);
                            } else {
                                ToastUtils.toast(PayActivity.this, bean.getError_msg());
                            }
                        } else {
                            closeLoading();
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(PayActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    private void goData(PayCodeBean bean) {
        ToastUtils.toast(this,bean.getPay_info());
    }
}
