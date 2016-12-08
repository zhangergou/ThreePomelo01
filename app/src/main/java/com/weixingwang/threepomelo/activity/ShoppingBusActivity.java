package com.weixingwang.threepomelo.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.ShoppingBusRecylAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShoppingBusActivity extends BaseActivity {

    private SwipeRefreshLayout swrf;
    private RecyclerView recycV;
    private MyScrollView sw;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.shopping_bus_activity_layout;
    }

    @Override
    protected void initView() {
        swrf = (SwipeRefreshLayout) findViewById(R.id.shop_bus_swrf);
        recycV = (RecyclerView) findViewById(R.id.shop_bus_recycle);
        sw = (MyScrollView) findViewById(R.id.shopping_bus_scrow);
        setTitle("购物车");
        isShowBack(true);
        setSwColor(swrf);
        isReflash(sw);

    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        int item = R.layout.shopping_bus_recyle_item;
        recycV.setAdapter(new ShoppingBusRecylAdapter(ShoppingBusActivity.this,recycV,list,item,1));
    }

    @Override
    protected void initLisener() {

    }
}