package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.ShoppingBusRecylAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import com.weixingwang.threepomelo.bean.ShopBusBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShoppingBusActivity extends BaseActivity implements BaseRecyleAdapter.OnClickChoeseView, BaseRecyleAdapter.OnClickMusView, BaseRecyleAdapter.OnClickPlusView, BaseRecyleAdapter.OnClickDeleteView {

    private PullToRefreshLayout swrf;
    private RecyclerView recycV;
    private int page = 1;
    private ArrayList<ShopBusBean.ListCartEntity> list = new ArrayList<>();
    private List<ShopBusBean.ListCartEntity> list_cart;
    private ShoppingBusRecylAdapter busRecylAdapter;
    private int can=0;
    @Override
    protected int getLayoutId() {
        return R.layout.shopping_bus_activity_layout;
    }

    @Override
    protected void initView() {
        swrf = (PullToRefreshLayout) findViewById(R.id.shop_bus_swrf);
        recycV = (RecyclerView) findViewById(R.id.shop_bus_recycle);
        setTitle("购物车");
        isShowBack(true);
        refrush(swrf);

    }

    @Override
    protected void initData() {
        getData();
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.shop_bus_btn_statements).setOnClickListener(this);
    }

    private void getData() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        OkHttpUtils.get(UrlUtils.SHOP_BUS_Url, ShearPreferenceUtils.getToken(ShoppingBusActivity.this),
                ShopBusBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            ShopBusBean bean = (ShopBusBean) obj;
                            if (bean.isSuccess()) {
                                list_cart = bean.getList_cart();
                                setData(list_cart);
                            } else {
                                ToastUtils.toast(ShoppingBusActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }


                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(ShoppingBusActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);

    }

    private void setData(List<ShopBusBean.ListCartEntity> data) {
        list.addAll(data);

            int item = R.layout.shopping_bus_recyle_item;
            busRecylAdapter = new ShoppingBusRecylAdapter(ShoppingBusActivity.this, recycV, list, item, 1);
            recycV.setAdapter(busRecylAdapter);
            busRecylAdapter.setOnClickChoeseView(this);
            busRecylAdapter.setOnClickMusView(this);
            busRecylAdapter.setOnClickPlusView(this);
            busRecylAdapter.setOnClickDeleteView(this);
        can=0;
    }

    @Override
    public void onChoese(int postion) {
        String id = list.get(postion).getId();
        if (!TextUtils.isEmpty(id)) {
            Intent intent = new Intent(ShoppingBusActivity.this, ShopMessageActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }

    @Override
    public void onMus(int postion) {
        if(can==0){
            can=1;
            if (!TextUtils.isEmpty(list.get(postion).getNum()) && !TextUtils.isEmpty(list.get(postion).getCart_id())) {
                int i = Integer.parseInt(list.get(postion).getNum());
                if (i > 0) {
                    i--;
                    keepCount(i, list.get(postion).getCart_id());
                }
            }
        }


    }

    @Override
    public void onPlus(int postion) {
        if(can==0){
            can=1;
            if (!TextUtils.isEmpty(list.get(postion).getNum()) && !TextUtils.isEmpty(list.get(postion).getCart_id())) {
                int i = Integer.parseInt(list.get(postion).getNum());
                i++;
                keepCount(i, list.get(postion).getCart_id());
            }
        }

    }

    @Override
    public void onDelete(int postion) {
        if (!TextUtils.isEmpty(list.get(postion).getCart_id())) {
            deleteCount(list.get(postion).getCart_id());
        }

    }

    private void keepCount(int postion, String cart_id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("cart_id", cart_id);
        map.put("num", postion + "");
        OkHttpUtils.get(UrlUtils.SHOP_BUS_CONUT_Url, ShearPreferenceUtils.getToken(ShoppingBusActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(ShoppingBusActivity.this, "操作成功!");
                                list.clear();
                                page = 1;
                                getData();
                            } else {
                                ToastUtils.toast(ShoppingBusActivity.this, bean.getError_msg());
                            }
                        } else {
                            Toast.makeText(ShoppingBusActivity.this, "", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(ShoppingBusActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    private void deleteCount(String cart_id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("cart_id", cart_id);
        OkHttpUtils.get(UrlUtils.SHOP_BUS_DELETE_GOODS_Url, ShearPreferenceUtils.getToken(ShoppingBusActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(ShoppingBusActivity.this, "操作成功!");
                                list.clear();
                                page = 1;
                                getData();
                            } else {
                                ToastUtils.toast(ShoppingBusActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(ShoppingBusActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shop_bus_btn_statements:

            putData();

            break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void putData() {
        StringBuffer sb=new StringBuffer();
//        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
           if(i!=list.size()-1){
               sb.append(list.get(i).getCart_id()+",");
           }else
               sb.append(list.get(i).getCart_id());
        }
//        sb.append("]");
        HashMap<String, String> map = new HashMap<>();
        map.put("address_id", 22+"");
        map.put("cart_ids", sb.toString());

        OkHttpUtils.get(UrlUtils.SHOP_SAVE_ORDER_Url, ShearPreferenceUtils.getToken(ShoppingBusActivity.this),
                LoginBean.class,new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                //ToastUtils.toast(ShoppingBusActivity.this, "操作成功!");
                               if(!TextUtils.isEmpty(bean.getUser_order_id()+"")){
                                   Intent intent = new Intent(ShoppingBusActivity.this, SureMyOrderActivity.class);
                                   intent.putExtra("order_id",bean.getUser_order_id()+"");
                                   startActivity(intent);
                               }
                            } else {
                                ToastUtils.toast(ShoppingBusActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(ShoppingBusActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        list.clear();
        page = 1;
        getData();
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
        if(list_cart!=null){
            if(list_cart.size()<20){
                ToastUtils.toast(ShoppingBusActivity.this,"加载完毕!");
            }else {
                page ++;
                getData();
            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }


}
