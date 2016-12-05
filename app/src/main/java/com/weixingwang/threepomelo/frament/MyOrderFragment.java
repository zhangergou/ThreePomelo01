package com.weixingwang.threepomelo.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyOrderAdapter;
import com.weixingwang.threepomelo.utils.OkHttpUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MyOrderFragment extends BaseFragment {
    private RecyclerView rcv;
    private ArrayList<String> list = new ArrayList<>();
    private MyOrderAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.my_order_frament_layout;
    }

    @Override
    protected void initView(View view) {
       // setTitle("我的订单");
       rcv = (RecyclerView)view.findViewById(R.id.recyclerview);
        //Recyclerview线性排列
        rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));//从零开始往下
        adapter=new MyOrderAdapter(getActivity(),list);
        rcv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        for(int i=0;i<20;i++){
            list.add("item"+i);
        }
    }

    @Override
    protected void initLisener() {
    }


}
