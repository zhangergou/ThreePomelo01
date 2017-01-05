package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
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
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderFragment extends BaseFragment {
    private RecyclerView rcv;
    private List<MyOrderBean.OrderListEntity> order_list;
    private List<MyOrderBean.OrderListEntity> list=new ArrayList<>();
    private TextView lei_ji_xiao_fei;
    private int  page=1;
    private String s_date="";
    private String e_date="";
   // private MyScrollView sw;
    @Override
    protected int getLayoutId() {
        return R.layout.my_order_frament_layout;
    }
    @Override
    protected void initView(View view) {
        rcv = (RecyclerView)view.findViewById(R.id.re);
        lei_ji_xiao_fei= (TextView) view.findViewById(R.id.lei_ji_xiao_fei);
        PullToRefreshLayout swrf= (PullToRefreshLayout) view.findViewById(R.id.home_fragment_swf);

        refrush(swrf);
        //设置头部
        setTitle("我的订单");

    }
    @Override
    protected void initData() {

        getData();

    }
    @Override
    protected void initLisener() {
    }


    private void getData() {
        showLoading();
        OkHttpUtils.get(UrlUtils.MyOrderAllTotal_Url,ShearPreferenceUtils.getToken(getActivity()), MyOrderAllTotalBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj!=null){
                    MyOrderAllTotalBean  alltotalbean= (MyOrderAllTotalBean) obj;
                    if(alltotalbean.isSuccess()){
                        if(!TextUtils.isEmpty(alltotalbean.getAll_total()+"")){
                            lei_ji_xiao_fei.setText(alltotalbean.getAll_total()/100+"元");
                        }
                    }else {
                        ToastUtils.toast(getActivity(),alltotalbean.getError_msg());
                    }
                }else {
                    Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void error(Exception e) {
                closeLoading();
                Toast.makeText(getActivity(),"网络错误，请重新请求",Toast.LENGTH_LONG).show();
            }
        });


        HashMap<String, String> map=new HashMap<>();
        map.put("page",page+"");
        map.put("s_date",s_date);
        map.put("e_date",e_date);
        OkHttpUtils.get(UrlUtils.MyOrder_Url,ShearPreferenceUtils.getToken(getActivity()),
                MyOrderBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj!=null){
                            MyOrderBean bean= (MyOrderBean) obj;
                            if(bean.isSuccess()){
                                order_list = bean.getOrder_list();
                                setData(order_list);
                            }else {
                                ToastUtils.toast(getActivity(),bean.getError_msg());
                            }
                        }else {
                            Toast.makeText(getActivity(),"",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(getActivity(),"网络错误，请重新请求",Toast.LENGTH_LONG).show();
                    }
                },map);
    }

    private void setData(List<MyOrderBean.OrderListEntity> data) {
        list.addAll(data);
        if(list.size()>0){
            rcv.setAdapter(new MyOrderAdapter(getActivity(),rcv,list,R.layout.item_my_order,1));
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        list.clear();
        page=1;
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if(order_list!=null){
            if(order_list.size()<20){
                ToastUtils.toast(getActivity(),"加载完毕!");
            }else {
                page++;
                getData();

            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
