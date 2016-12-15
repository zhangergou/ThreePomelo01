package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MoneyLogFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.TakeOutMoneyRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class MoneyLogFragment extends BaseFragment {

    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    private PullToRefreshLayout swrf;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_money_log;
    }

    @Override
    protected void initView(View v) {
        swrf = (PullToRefreshLayout) v.findViewById(R.id.fragment_money_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_money_recyle);
        refrush(swrf);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new MoneyLogFragmentRecyAdapter(getActivity(),recycl,list,
                R.layout.fragment_money_recyle_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
