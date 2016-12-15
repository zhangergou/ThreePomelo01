package com.weixingwang.threepomelo.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.AllInRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class MyAllInActivity extends BaseActivity{

    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_earnings;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout swrf = (PullToRefreshLayout) findViewById(R.id.my_all_in_swrf);
        recycl = (RecyclerView) findViewById(R.id.my_all_in_recyle);
        refrush(swrf);
        setTitle("我的收益");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new AllInRecyAdapter(MyAllInActivity.this,recycl,list,
                R.layout.all_in_recycle_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
