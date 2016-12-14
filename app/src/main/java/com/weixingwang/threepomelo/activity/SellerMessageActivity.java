package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;

import java.util.ArrayList;
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

    @Override
    protected int getLayoutId() {
        return R.layout.seller_message_layout;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.seller_message_vp);
        linIndecitor = (LinearLayout) findViewById(R.id.seller_message_indcitor_lin);
        tvPhoneCode = (TextView) findViewById(R.id.seller_message_tv_phone_code);
        setTitle("店铺详情");
        isShowBack(true);
    }

    @Override
    protected void initData() {
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
}
