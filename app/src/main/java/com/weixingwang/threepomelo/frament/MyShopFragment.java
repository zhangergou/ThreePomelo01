package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyShopFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.MyVIPFragmentRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class MyShopFragment extends BaseFragment {
    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.my_shop_fragment;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.my_shop_fragment_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.my_shop_fragment_recyle);
       refrush(swrf);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new MyShopFragmentRecyAdapter(getActivity(),recycl,list,
                R.layout.fragment_my_shop_recycl_item,1));

    }

    @Override
    protected void initLisener() {

    }
}

