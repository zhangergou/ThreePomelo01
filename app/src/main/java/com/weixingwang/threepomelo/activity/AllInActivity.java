package com.weixingwang.threepomelo.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.AllInRecyAdapter;
import com.weixingwang.threepomelo.adapter.MyShopFragmentRecyAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class AllInActivity extends BaseActivity{

    private SwipeRefreshLayout swrf;
    private MyScrollView scrollView;
    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_earnings;
    }

    @Override
    protected void initView() {
        swrf = (SwipeRefreshLayout) findViewById(R.id.my_all_in_swrf);
        scrollView = (MyScrollView) findViewById(R.id.my_all_in_scro);
        recycl = (RecyclerView) findViewById(R.id.my_all_in_recyle);
        setSwColor(swrf);
        isReflash(scrollView);
        setTitle("我的收益");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new AllInRecyAdapter(AllInActivity.this,recycl,list,
                R.layout.all_in_recycle_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
