package com.weixingwang.threepomelo.frament;

import android.view.View;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MeFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.me_frament_layout;
    }

    @Override
    protected void initView(View view) {
        setTitle("个人中心");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
