package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.SureMyOrderRecyleAdapter;
import com.weixingwang.threepomelo.bean.AddressListBean;
import com.weixingwang.threepomelo.bean.DefultAddressBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.SureOrderBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class SureMyOrderActivity extends BaseActivity {

    private String order_id;
    private TextView tvPerson;
    private TextView tvPhone;
    private TextView tvAddress;
    private TextView tvSunCount;
    private TextView tvSunMoney;
    private TextView tvPayMoney;
    private EditText etSay;
    private RecyclerView re;
    private int chose = 0;
    private ImageView ivChose;
    private SureOrderBean.OrderInfoEntity order_info;
    private double integral;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_order;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.sure_order_pull);
        tvPerson = (TextView) findViewById(R.id.tv_sure_order_arder_person);
        tvPhone = (TextView) findViewById(R.id.tv_sure_order_arder_phone);
        tvAddress = (TextView) findViewById(R.id.tv_sure_order_arder_address);
        tvSunCount = (TextView) findViewById(R.id.tv_sure_order_sun_count);
        tvSunMoney = (TextView) findViewById(R.id.tv_sure_order_pay_money);
        tvPayMoney = (TextView) findViewById(R.id.tv_sure_order_end_money);
        etSay = (EditText) findViewById(R.id.et_sure_order_say);
        re = (RecyclerView) findViewById(R.id.sure_order_recyl);
        ivChose = (ImageView) findViewById(R.id.iv_sure_order_chose);
        refrush(pull);
        closeLoadMore(true);
        setTitle("订单确认");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        order_id = getIntent().getStringExtra("order_id");
        getAddress();

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.sure_ral_add_address).setOnClickListener(this);
        findViewById(R.id.iv_sure_shopping_now).setOnClickListener(this);
        ivChose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sure_ral_add_address:
                startActivity(new Intent(SureMyOrderActivity.this, AddAdressActivity.class));
                break;
            case R.id.iv_sure_shopping_now:
                startActivity(new Intent(SureMyOrderActivity.this, PayActivity.class));
                break;
            case R.id.iv_sure_order_chose:
                if (chose == 0) {
                    chose = 1;
                    ivChose.setSelected(true);
                    double tal = Double.parseDouble(order_info.getTotal_price());
                    if (tal > integral) {
                        tvPayMoney.setText((tal - integral) / 100 + "");
                    } else {
                        tvPayMoney.setText(0 + "");
                    }

                } else {
                    chose = 0;
                    ivChose.setSelected(false);
                    int i = Integer.parseInt(order_info.getTotal_price());
                    tvPayMoney.setText(i / 100 + "");
                }
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void getAddress() {
        showLoading();
        OkHttpUtils.get(UrlUtils.SHOP_DEF_ADDRESS_Url, ShearPreferenceUtils.getToken(SureMyOrderActivity.this),
                DefultAddressBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {

                        if (obj != null) {
                            DefultAddressBean bean = (DefultAddressBean) obj;
                            if (bean.isSuccess()) {
                                putData(bean);
                                getData();
                            } else {
                                ToastUtils.toast(SureMyOrderActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(SureMyOrderActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void putData(DefultAddressBean bean) {
        DefultAddressBean.DefaultAddressEntity address_info = bean.getDefault_address();
        if (address_info != null) {
            if (!TextUtils.isEmpty(address_info.getPerson())) {
                tvPerson.setText(address_info.getPerson());
            }
            if (!TextUtils.isEmpty(address_info.getPhone())) {
                tvPhone.setText(address_info.getPhone());
            }
            if (!TextUtils.isEmpty(address_info.getAddress())) {
                tvAddress.setText(address_info.getAddress());
            }

        }
        DefultAddressBean.UserInfoEntity user_info = bean.getUser_info();
        if (user_info != null) {
            if (!TextUtils.isEmpty(user_info.getIntegral())) {
                tvSunCount.setText(user_info.getIntegral());
                integral = Double.parseDouble(user_info.getIntegral());
            }
        }
    }

    private void getData() {

        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", order_id);
        OkHttpUtils.get(UrlUtils.SHOP_SURE_ORDER_Url, ShearPreferenceUtils.getToken(SureMyOrderActivity.this),
                SureOrderBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            SureOrderBean bean = (SureOrderBean) obj;
                            if (bean.isSuccess()) {
                                setData(bean);
                            } else {
                                ToastUtils.toast(SureMyOrderActivity.this, bean.getError_msg());
                            }
                        } else {
                            closeLoading();
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(SureMyOrderActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    private void setData(SureOrderBean data) {

        order_info = data.getOrder_info();
        if (order_info != null) {
            if (!TextUtils.isEmpty(order_info.getTotal_price())) {
                double i = Double.parseDouble(order_info.getTotal_price());
                tvPayMoney.setText(i / 100 + "");
                if (integral >=i) {
                    tvSunMoney.setText(i / 100 + "");
                }else
                    tvSunMoney.setText(integral / 100 + "");
            }
        }
        List<SureOrderBean.GoodsListEntity> goods_list = data.getGoods_list();
        if (goods_list != null) {
            re.setAdapter(new SureMyOrderRecyleAdapter(SureMyOrderActivity.this, re, goods_list,
                    R.layout.sure_order_recy_item, 1));
        }

    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getAddress();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getAddress();
    }
}
