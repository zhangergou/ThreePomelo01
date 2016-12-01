package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.os.SystemClock;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class ShplashActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.sphlash_activity_layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ShplashActivity.this,LoginActivity.class));
                        finish();
                    }
                });
            }
        }).start();

    }

    @Override
    protected void initLisener() {

    }
}
