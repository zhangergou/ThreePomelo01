package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class SureMyOrderActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_order;
    }

    @Override
    protected void initView() {
        setTitle("订单确认");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.sure_ral_add_address).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sure_ral_add_address:
                startActivity(new Intent(SureMyOrderActivity.this,AddAdressActivity.class));
                break;
            default:
                super.onClick(v);
                break;
        }
    }
}
