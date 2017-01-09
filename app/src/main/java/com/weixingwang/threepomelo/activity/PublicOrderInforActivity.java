package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.SureMyOrderRecyleAdapter;
import com.weixingwang.threepomelo.bean.DefultAddressBean;
import com.weixingwang.threepomelo.bean.SureOrderBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
public class PublicOrderInforActivity extends BaseActivity {

    private TextView tvPerson;
    private TextView tvPhone;
    private TextView tvAddress;
    private TextView tvPayState;
    private TextView tvSongState;
    private TextView tvOrderCorde;
    private RecyclerView re;
    private String order_id;
    private String state;
    private ImageView ivOk;
    private String corde;
    private String pos;

    @Override
    protected int getLayoutId() {
        return R.layout.public_order_infor;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.public_order_infor_pull);
        tvPerson = (TextView) findViewById(R.id.tv_public_order_infor_arder_person);
        tvPhone = (TextView) findViewById(R.id.tv_public_order_infor_arder_phone);
        tvAddress = (TextView) findViewById(R.id.tv_public_order_infor_arder_address);
        tvPayState = (TextView) findViewById(R.id.public_order_infor_tv_state);
        tvSongState = (TextView) findViewById(R.id.public_order_infor_tv_song_state);
        tvOrderCorde = (TextView) findViewById(R.id.public_order_infor_tv_cord_state);
        re = (RecyclerView) findViewById(R.id.public_order_infor_recyl);
        ivOk = (ImageView) findViewById(R.id.public_order_infor_iv_pay_state);
        refrush(pull);
        closeLoadMore(true);
        setTitle("订单详情");
        isShowBack(true);

    }

    @Override
    protected void initData() {
        order_id = getIntent().getStringExtra("order_id");
        state = getIntent().getStringExtra("state");
        corde = getIntent().getStringExtra("corde");
        pos = getIntent().getStringExtra("pos");
        if(TextUtils.equals(state,"3")){
            tvPayState.setText("支付成功");
            tvSongState.setText("努力派送中!");
            tvOrderCorde.setText(corde);
            ivOk.setVisibility(View.GONE);
        }else if(TextUtils.equals(state,"2")){
            tvPayState.setText("等待支付....");
            tvSongState.setText("等待支付....");
            tvOrderCorde.setText(corde);
            ivOk.setVisibility(View.VISIBLE);
        }else if(TextUtils.equals(state,"-1")){
            tvPayState.setText("订单异常");
            tvSongState.setText("订单异常");
            tvOrderCorde.setText(corde);
            ivOk.setVisibility(View.GONE);
        }else if(TextUtils.equals(state,"1")){
            tvPayState.setText("等待支付....");
            tvSongState.setText("等待支付....");
            tvOrderCorde.setText(corde);
            ivOk.setVisibility(View.VISIBLE);
        }
        getAddress();

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.public_order_infor_iv_pay_state).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.public_order_infor_iv_pay_state:
                Intent intent =null;
                if(TextUtils.equals(state,"2")){
                    intent = new Intent(PublicOrderInforActivity.this, PayActivity.class);
                    intent.putExtra("order_id",order_id);
                    startActivity(intent);
                }
                if(TextUtils.equals(state,"1")){
                    intent = new Intent(PublicOrderInforActivity.this, SureMyOrderActivity.class);
                    intent.putExtra("order_id",order_id);
                    startActivity(intent);
                }
            break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void getAddress() {
        showLoading();
        OkHttpUtils.get(UrlUtils.SHOP_DEF_ADDRESS_Url, ShearPreferenceUtils.getToken(PublicOrderInforActivity.this),
                DefultAddressBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {

                        if (obj != null) {
                            DefultAddressBean bean = (DefultAddressBean) obj;
                            if (bean.isSuccess()) {
                                putData(bean);
                                getData();
                            } else {
                                ToastUtils.toast(PublicOrderInforActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(PublicOrderInforActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
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

    }


    private void getData() {

        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", order_id);
        OkHttpUtils.get(UrlUtils.SHOP_SURE_ORDER_Url, ShearPreferenceUtils.getToken(PublicOrderInforActivity.this),
                SureOrderBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            SureOrderBean bean = (SureOrderBean) obj;
                            if (bean.isSuccess()) {
                                setData(bean);
                            } else {
                                ToastUtils.toast(PublicOrderInforActivity.this, bean.getError_msg());
                            }
                        } else {
                            closeLoading();
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(PublicOrderInforActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    private void setData(SureOrderBean data) {

        List<SureOrderBean.GoodsListEntity> goods_list = data.getGoods_list();
        if (goods_list != null) {
            re.setAdapter(new SureMyOrderRecyleAdapter(PublicOrderInforActivity.this, re, goods_list,
                    R.layout.sure_order_recy_item, 1));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(TextUtils.equals(pos,"5")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(PublicOrderInforActivity.this,MainActivity.class));
                        }
                    });
                }
            }).start();
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getAddress();
        super.onRefresh(pullToRefreshLayout);
    }
}
