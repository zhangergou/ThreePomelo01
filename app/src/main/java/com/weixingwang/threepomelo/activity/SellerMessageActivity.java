package com.weixingwang.threepomelo.activity;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class SellerMessageActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.seller_message_layout;
    }

    @Override
    protected void initView() {
        setTitle("店铺详情");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
