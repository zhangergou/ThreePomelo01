package com.weixingwang.threepomelo.activity;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class AccountManagerActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void initView() {
        setTitle("我的账户");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
