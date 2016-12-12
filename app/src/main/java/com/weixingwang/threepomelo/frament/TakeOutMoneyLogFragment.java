package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.TakeOutMoneyRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class TakeOutMoneyLogFragment extends BaseFragment {

    private SwipeRefreshLayout swrf;
    private MyScrollView scrollView;
    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_take_out_money_layout;
    }

    @Override
    protected void initView(View v) {
        swrf = (SwipeRefreshLayout) v.findViewById(R.id.fragment_take_out_swrf);
        scrollView = (MyScrollView) v.findViewById(R.id.fragment_take_out_scro);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_take_out_recyle);
        setSwColor(swrf);
        isReflash(scrollView);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new TakeOutMoneyRecyAdapter(getActivity(),recycl,list,
                R.layout.take_out_recyle_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
