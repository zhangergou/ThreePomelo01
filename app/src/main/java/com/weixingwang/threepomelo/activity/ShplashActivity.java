package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.os.SystemClock;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.MobileNetUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

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
                                ToastUtils.toast(ShplashActivity.this,bean.getError_msg());
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

    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(!MobileNetUtils.isNetworkConnected(ShplashActivity.this)){
                            ToastUtils.toast(ShplashActivity.this,"网络不可用,请检查网络!");

                            startActivity(new Intent(ShplashActivity.this,LoginActivity.class));
                            finish();
                            return;
                        }
                        netWork();
                    }
                });
            }
        }).start();
    }
}
