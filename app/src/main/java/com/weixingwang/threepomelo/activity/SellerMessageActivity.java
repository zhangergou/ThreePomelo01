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

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.SellerMessageBean;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

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

    @Override
    protected int getLayoutId() {
        return R.layout.seller_message_layout;
    }

    @Override
    protected void initView() {
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
            default:
                super.onClick(v);
                break;
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
        HashMap<String, String> map = new HashMap<>();
        map.put("shop_id", shop_id);
        OkHttpUtils.get(UrlUtils.SELLER_INFOR_Url, ShearPreferenceUtils.getToken(SellerMessageActivity.this),
                SellerMessageBean.class,new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
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
                        netError();
                    }
                }, map);
    }

    private void setData(SellerMessageBean bean) {
        SellerMessageBean.ShopDetailEntity shop_detail = bean.getShop_detail();

        if(!TextUtils.isEmpty(shop_detail.getShop_name())){
            tvSellerName.setText(shop_detail.getShop_name());
        }
        if(!TextUtils.isEmpty(shop_detail.getAddress())||!TextUtils.isEmpty(shop_detail.getP_name())
                ||!TextUtils.isEmpty(shop_detail.getC_name())||!TextUtils.isEmpty(shop_detail.getAr_name())){
            tvAddress.setText(shop_detail.getP_name()+shop_detail.getC_name()+
                    shop_detail.getAr_name()+shop_detail.getAddress());
        }
        if(!TextUtils.isEmpty(shop_detail.getPhone())){
            tvPhoneCode.setText(shop_detail.getPhone());
        }
        if(!TextUtils.isEmpty(shop_detail.getBusiness_time())){
            tvTime.setText("营业时间  "+shop_detail.getBusiness_time());
        }
        if(!TextUtils.isEmpty(shop_detail.getDesc())){
            tvSay.setText(shop_detail.getDesc());
        }
        ratingBar.setProgress(6);

    }
}
