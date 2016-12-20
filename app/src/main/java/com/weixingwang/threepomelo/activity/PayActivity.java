package com.weixingwang.threepomelo.activity;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/16 0016.
 */
public class PayActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.pay_layout;
    }

    @Override
    protected void initView() {
        setTitle("收银台");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    protected void initLisener() {

    }
}
