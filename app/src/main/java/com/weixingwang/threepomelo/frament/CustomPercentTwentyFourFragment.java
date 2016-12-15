package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.CoustomPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.CustomPercentTwentyFourFragmentRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class CustomPercentTwentyFourFragment extends BaseFragment {
    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.custom_percent_twenty_four_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.custom_fragment_percent_twenty_four_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.custom_fragment_percent_twenty_four_recyle);
       refrush(swrf);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new CustomPercentTwentyFourFragmentRecyAdapter(getActivity(),recycl,list,
                R.layout.fragment_costom_sunflower_percent_three_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
