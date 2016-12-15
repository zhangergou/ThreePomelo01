package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShopMessageActivity extends BaseActivity  {

    private ViewPager viewPager;
    private LinearLayout linIndictor;
    private List<ImageView> list=new ArrayList<>();
    private int pos;
    @Override
    protected int getLayoutId() {
        return R.layout.shop_message_layout;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.shop_message_vp);
        linIndictor = (LinearLayout) findViewById(R.id.shop_message_indcitor_lin);
        setTitle("商品详情");
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
            LinearLayout.LayoutParams prams=new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            prams.leftMargin=10;
            imageView.setLayoutParams(prams);
            linIndictor.addView(imageView);
        }
        linIndictor.getChildAt(0).setSelected(true);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.lin_shop_details_have_shopping).setOnClickListener(this);
        findViewById(R.id.lin_shop_details_dianpu).setOnClickListener(this);
        findViewById(R.id.btn_plus_shopbus).setOnClickListener(this);
        findViewById(R.id.shop_message_now_shopping).setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_shop_details_have_shopping :
                startActivity(new Intent(ShopMessageActivity.this,ShoppingBusActivity.class));
            break;
            case R.id.lin_shop_details_dianpu :
                startActivity(new Intent(ShopMessageActivity.this,SellerMessageActivity.class));
                break;
            case R.id.btn_plus_shopbus :
                ToastUtils.toast(this,"待做...........");
                break;
            case R.id.shop_message_now_shopping :
                startActivity(new Intent(ShopMessageActivity.this,SureMyOrderActivity.class));
                break;
            default:
                super.onClick(v);
                break;
        }
    }
    @Override
    public void onPageSelected(int position) {
        linIndictor.getChildAt(pos).setSelected(false);
        linIndictor.getChildAt(position).setSelected(true);
        pos=position;
    }

}
