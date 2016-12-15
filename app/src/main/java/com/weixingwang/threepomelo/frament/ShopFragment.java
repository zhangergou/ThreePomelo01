package com.weixingwang.threepomelo.frament;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.ShoppingBusActivity;
import com.weixingwang.threepomelo.adapter.ShopFragmentRecyclAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class ShopFragment extends BaseFragment {


    private RecyclerView recl;
    private ArrayList<String> list=new ArrayList<>();
    private View view;

    @Override
    protected int getLayoutId() {
        return R.layout.shop_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        PullToRefreshLayout swrf= (PullToRefreshLayout) view.findViewById(R.id.shop_fragment_swf);
        recl = (RecyclerView) view.findViewById(R.id.shop_fragment_recl);
        setTitle("在线商城");
        refrush(swrf);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recl.setAdapter(new ShopFragmentRecyclAdapter(getActivity(),recl,list,
                R.layout.shop_frament_recyle_item,1));
    }

    @Override
    protected void initLisener() {
        view.findViewById(R.id.rla_come_in_shopping_bus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rla_come_in_shopping_bus:
                startActivity(new Intent(getActivity(), ShoppingBusActivity.class));
            break;
        }
    }
}
