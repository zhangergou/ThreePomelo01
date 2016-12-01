package com.weixingwang.threepomelo.applacation;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class MyApplocation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Crash crash = Crash.getInstence();
        crash.init(getApplicationContext());
    }
}
