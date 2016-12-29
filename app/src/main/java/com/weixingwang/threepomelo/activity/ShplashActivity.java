package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BasePagerAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.MobileNetUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class ShplashActivity extends BaseActivity {

    private ViewPager vp;
    private LinearLayout lin;
    private ImageView iv;
    private List<ImageView> list=new ArrayList<>();
    private int pos;
    private ImageView ivAll;

    @Override
    protected int getLayoutId() {
        return R.layout.sphlash_activity_layout;
    }

    @Override
    protected void initView() {
        vp = (ViewPager) findViewById(R.id.sphlash_vp);
        lin = (LinearLayout) findViewById(R.id.sphlash_lin);
        iv = (ImageView) findViewById(R.id.sphlash_iv);
        ivAll = (ImageView) findViewById(R.id.sphlash_iv_all);
    }

    @Override
    protected void initData() {
        int count = ShearPreferenceUtils.getInt(this);
        if(count!=1){
            ShearPreferenceUtils.putInt(this,1);
            for (int i = 0; i < ArrayUtils.splashImage.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(ArrayUtils.splashImage[i]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                list.add(imageView);
            }

            for (int i = 0; i < list.size(); i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.sphlash_indector_selector);
                LinearLayout.LayoutParams prams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                prams.leftMargin = 10;
                imageView.setLayoutParams(prams);
                lin.addView(imageView);
            }
            vp.setAdapter(new BasePagerAdapter(list));
            lin.getChildAt(0).setSelected(true);
            vp.addOnPageChangeListener(this);

        }else {
            ivAll.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            netWork();
                        }
                    });
                }
            }).start();

        }
    }

    private void netWork() {

        OkHttpUtils.get(UrlUtils.TOKEN_LOGIN_Url, ShearPreferenceUtils.getToken(this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if(obj!=null){
                            LoginBean bean= (LoginBean) obj;
                            if(bean.isSuccess()){
                                ToastUtils.toast(ShplashActivity.this,"登录成功");
                                startActivity(new Intent(ShplashActivity.this,MainActivity.class));
                                finish();
                            }else {
                                startActivity(new Intent(ShplashActivity.this,LoginActivity.class));
                                finish();
                            }
                        }else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                        startActivity(new Intent(ShplashActivity.this,LoginActivity.class));
                        finish();
                    }
                });
    }

    @Override
    protected void initLisener() {
        iv.setOnClickListener(this);
    }


    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        lin.getChildAt(pos).setSelected(false);
        lin.getChildAt(position).setSelected(true);
        pos=position;
        if(position==list.size()-1){
            iv.setVisibility(View.VISIBLE);
        }else {
            iv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        netWork();
    }
}
