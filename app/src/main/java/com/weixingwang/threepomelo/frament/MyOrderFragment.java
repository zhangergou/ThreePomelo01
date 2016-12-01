package com.weixingwang.threepomelo.frament;

import android.view.View;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MyOrderFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.my_order_frament_layout;
    }

    @Override
    protected void initView(View view) {
        setTitle("我的订单");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
