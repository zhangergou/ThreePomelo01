package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.SellerMessageBean;
import com.weixingwang.threepomelo.utils.APPUtils;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class SellerMessageActivity extends BaseActivity {

    private ViewPager viewPager;
    private LinearLayout linIndecitor;
    private List<ImageView> list = new ArrayList<>();
    private int pos;
    private TextView tvPhoneCode;
    private String shop_id;
    private TextView tvAddress;
    private TextView tvSellerName;
    private TextView tvTime;
    private TextView tvSay;
    private RatingBar ratingBar;
    private String log;
    private String lat;
    private String address;

    @Override
    protected int getLayoutId() {
        return R.layout.seller_message_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.seller_tv_use_pull);
        refrush(pull);
        viewPager = (ViewPager) findViewById(R.id.seller_message_vp);
        linIndecitor = (LinearLayout) findViewById(R.id.seller_message_indcitor_lin);
        tvPhoneCode = (TextView) findViewById(R.id.seller_message_tv_phone_code);
        tvAddress = (TextView) findViewById(R.id.seller_tv_address);
        tvSellerName = (TextView) findViewById(R.id.seller_tv_name);
        tvTime = (TextView) findViewById(R.id.seller_tv_use_data);
        tvSay = (TextView) findViewById(R.id.seller_tv_seller_say);
        ratingBar = (RatingBar) findViewById(R.id.seller_rb_start_count);
        setTitle("店铺详情");
        isShowBack(true);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        shop_id = intent.getStringExtra("shop_id");
        getData();

        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundColor(ArrayUtils.color[i]);
            list.add(imageView);
        }
        viewPager.setAdapter(new HomeFragmentPagerAdapter(list));
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.indector_selector);
            LinearLayout.LayoutParams prams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            prams.leftMargin = 10;
            imageView.setLayoutParams(prams);
            linIndecitor.addView(imageView);
        }
        linIndecitor.getChildAt(0).setSelected(true);
    }

    @Override
    protected void initLisener() {
        viewPager.addOnPageChangeListener(this);
        findViewById(R.id.iv_seller_message_call).setOnClickListener(this);
        findViewById(R.id.iv_seller_message_go).setOnClickListener(this);
    }

    @Override
    public void onPageSelected(int position) {
        linIndecitor.getChildAt(pos).setSelected(false);
        linIndecitor.getChildAt(position).setSelected(true);
        pos = position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_seller_message_call:
                callPhone();
                break;
            case R.id.iv_seller_message_go:
                callMap();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void callMap() {
        if(APPUtils.isAvilible(this,"com.baidu.BaiduMap")||
                APPUtils.isAvilible(this, "com.autonavi.minimap")||
                APPUtils.isAvilible(this, "com.google.android.apps.maps")||
                APPUtils.isAvilible( this,"com.tencent.map")){
            Uri mUri = Uri.parse("geo:"+lat+","+log+"?"+"q="+address);
            //android.intent.action.VIEW
            String actionView = Intent.ACTION_VIEW;
            Intent mIntent = new Intent(actionView,mUri);
            startActivity(mIntent);
        }else{
            ToastUtils.toast(this, "手机还没有没有安装地图,请下载安装后导航...");
            return;
        }
    }

    private void callPhone() {
        String phone = tvPhoneCode.getText().toString().trim();
        if(TextUtils.isEmpty(phone)){
            ToastUtils.toast(this,"号码待上传");
            return;
        }
        Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
        startActivity(intent);
    }

    private void getData() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("shop_id", shop_id);
        OkHttpUtils.get(UrlUtils.SELLER_INFOR_Url, ShearPreferenceUtils.getToken(SellerMessageActivity.this),
                SellerMessageBean.class,new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            SellerMessageBean bean = (SellerMessageBean) obj;
                            if (bean.isSuccess()) {
                               setData(bean);
                            } else {
                                ToastUtils.toast(SellerMessageActivity.this, bean.getError_msg());
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

    private void setData(SellerMessageBean bean) {
        SellerMessageBean.ShopDetailEntity shop_detail = bean.getShop_detail();

        if(!TextUtils.isEmpty(shop_detail.getShop_name())){

            tvSellerName.setText(shop_detail.getShop_name());
        }
        if(!TextUtils.isEmpty(shop_detail.getAddress())){
            address =shop_detail.getAddress();
            tvAddress.setText(shop_detail.getAddress());
        }

        if(!TextUtils.isEmpty(shop_detail.getPhone())){
            tvPhoneCode.setText(shop_detail.getPhone());
        }
        if(!TextUtils.isEmpty(shop_detail.getBusiness_time())){
            tvTime.setText(shop_detail.getBusiness_time());
        }
        if(!TextUtils.isEmpty(shop_detail.getDesc())){
            tvSay.setText(shop_detail.getDesc());
        }
        if(!TextUtils.isEmpty(shop_detail.getLat())){
            lat=shop_detail.getLat();
        }
        if(!TextUtils.isEmpty(shop_detail.getLng())){
            log=shop_detail.getLng();
        }
        ratingBar.setProgress(6);

    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getData();
        super.onRefresh(pullToRefreshLayout);
    }
}
