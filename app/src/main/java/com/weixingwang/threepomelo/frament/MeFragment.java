package com.weixingwang.threepomelo.frament;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.CreateShopActivity;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MeFragment extends BaseFragment {
    private View view;

    @Override
    protected int getLayoutId() {
        return R.layout.me_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        setTitle("个人中心");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {
        view.findViewById(R.id.lin_creat_shop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_creat_shop:
                startActivity(new Intent(getActivity(),CreateShopActivity.class));
            break;
        }
    }
}
