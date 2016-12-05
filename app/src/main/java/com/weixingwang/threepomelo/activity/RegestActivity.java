package com.weixingwang.threepomelo.activity;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class RegestActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.regest_lyout;
    }

    @Override
    protected void initView() {
        setTitle("会员注册");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
