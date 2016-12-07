package com.weixingwang.threepomelo.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyOrderAdapter;
import com.weixingwang.threepomelo.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class MyOrderFragment extends BaseFragment {
    private RecyclerView rcv;
    private ArrayList<String> list = new ArrayList<>();
    private HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
   // private MyOrderAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.my_order_frament_layout;
    }
    @Override
    protected void initView(View view) {
        setTitle("我的订单");
        rcv = (RecyclerView)view.findViewById(R.id.re);
        //Recyclerview线性排列
        rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));//从零开始往下
        setTitle("我的订单");
        for (int i = 0; i < 30; i++) {
            map.put(i,false);
            list.add("数据"+i);
        }
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
       rcv.setLayoutManager(gridLayoutManager);
        final MyOrderAdapter adapter = new MyOrderAdapter(getContext(), list,map);
       rcv.setAdapter(adapter);
        adapter.setClickListener(new MyOrderAdapter.One() {
            private int postion;
            @Override
            public void setOne( int postion) {
                this.postion = postion;

                map.put(postion,!map.get(postion));
                adapter.notifyDataSetChanged();
            }
        });

    }
    @Override
    protected void initData() {

    }
    @Override
    protected void initLisener() {
    }
}
