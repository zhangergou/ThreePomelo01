package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.ShopOrderActivityAdapter;
import com.weixingwang.threepomelo.bean.MyAllInBean;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import com.weixingwang.threepomelo.bean.ShopOrderBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class ShopOrderActivity extends BaseActivity implements  BaseRecyleAdapter.OnClickItemView {
    private RecyclerView recyclerview;
    private List<ShopOrderBean.OrderListEntity> list = new ArrayList<>();
    private int page = 1;
    private List<ShopOrderBean.OrderListEntity> order_list;

    @Override
    protected int getLayoutId() {
        return R.layout.shop_order_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.shop_order_swf);
        recyclerview = (RecyclerView) findViewById(R.id.rcv);
        setTitle("商城订单");//
        refrush(pull);
        isShowBack(true);


    }

    @Override
    protected void initData() {
        getData();

    }

    @Override
    protected void initLisener() {

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        OkHttpUtils.get(UrlUtils.SHOP_ORDERS_Url, ShearPreferenceUtils.getToken(ShopOrderActivity.this),
                ShopOrderBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            ShopOrderBean bean = (ShopOrderBean) obj;
                            if (bean.isSuccess()) {
                                order_list = bean.getOrder_list();
                                setData(order_list);
                            } else {
                                ToastUtils.toast(ShopOrderActivity.this, bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                }, map);

    }

    private void setData(List<ShopOrderBean.OrderListEntity> data) {
        list.addAll(data);
        ShopOrderActivityAdapter shopOrderActivityAdapter = new ShopOrderActivityAdapter(ShopOrderActivity.this, recyclerview,
                list, R.layout.item_shop_order_layout, 1);
        recyclerview.setAdapter(shopOrderActivityAdapter);
//        shopOrderActivityAdapter.setOnClickChoeseView(this);
        shopOrderActivityAdapter.setOnClickItemView(this);
    }

//    @Override
//    public void onChoese(int postion) {
//        String id = list.get(postion).getId();
//        Intent intent = new Intent(ShopOrderActivity.this, PayActivity.class);
//        intent.putExtra("order_id", id);
//        startActivity(intent);
//    }

    @Override
    public void onItem(int postion) {
        Intent intent = null;
        String id = list.get(postion).getId();
        String status = list.get(postion).getStatus();
        intent = new Intent(ShopOrderActivity.this, PublicOrderInforActivity.class);
        intent.putExtra("order_id", id);
        intent.putExtra("state", status);
        intent.putExtra("corde", id);
        startActivity(intent);


    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        list.clear();
        page = 1;
        getData();
        super.onRefresh(pullToRefreshLayout);
    }


    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if (order_list != null) {
            if (order_list.size() < 20) {
                ToastUtils.toast(this, "加载完毕!");
            } else {
                page++;
                getData();
            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }


}
