package com.weixingwang.threepomelo.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyOrderAdapter;
import com.weixingwang.threepomelo.bean.MyOrderAllTotalBean;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class MyOrderFragment extends BaseFragment {
    private RecyclerView rcv;
    private ArrayList<MyOrderBean.OrderListBean> list = new ArrayList<>();
    private HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
    private MyOrderAdapter adapter;
    public static final int REQUEST_SECOND=1;
    private TextView tv_result;
    private TextView lei_ji_xiao_fei;
    @Override
    protected int getLayoutId() {
        return R.layout.my_order_frament_layout;
    }
    @Override
    protected void initView(View view) {
        //token值的获取
    //String token = ShearPreferenceUtils.getToken(getActivity());

        setTitle("我的订单");
        rcv = (RecyclerView)view.findViewById(R.id.re);
        lei_ji_xiao_fei= (TextView) view.findViewById(R.id.lei_ji_xiao_fei);
        //Recyclerview线性排列
        rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));//从零开始往下
        setTitle("我的订单");

        OkHttpUtils.get(UrlUtils.MyOrder_Url,"uIyBe4mjcWmzhY/MsLaHmoSKvd2wp56YhZdwog==", MyOrderBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj!=null){
                    MyOrderBean bean= (MyOrderBean) obj;
                    if(bean.isSuccess()){
                        list.addAll(bean.getOrder_list());
                        System.out.println(list.size() + "---------------------------");
                        for (int i = 0; i <= list.size(); i++) {
                            map.put(i, false);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }else {
                    Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void error(Exception e) {
                Toast.makeText(getActivity(),"网络错误，请重新请求",Toast.LENGTH_LONG).show();
            }
        });
        OkHttpUtils.get(UrlUtils.MyOrderAllTotal_Url,"uIyBe4mjcWmzhY/MsLaHmoSKvd2wp56YhZdwog==", MyOrderAllTotalBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj!=null){
                    MyOrderAllTotalBean  alltotalbean= (MyOrderAllTotalBean) obj;
                    if(alltotalbean.isSuccess()){
                        lei_ji_xiao_fei.setText(alltotalbean.getAll_total()+"");
                    }
                }else {
                    Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void error(Exception e) {
                Toast.makeText(getActivity(),"网络错误，请重新请求",Toast.LENGTH_LONG).show();
            }
        });

        //System.out.println(list.size()+"-----------");
        adapter = new MyOrderAdapter(getContext(), list, map);
        adapter.setClickListener(new MyOrderAdapter.One() {
            private int postion;

            @Override
            public void setOne(int postion) {
                this.postion = postion;
                map.put(postion, !map.get(postion));
                adapter.notifyDataSetChanged();
            }
        });
        rcv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));//从零开始往下
        rcv.setAdapter(adapter);
    }



    @Override
    protected void initData() {

    }
    @Override
    protected void initLisener() {
    }
}
