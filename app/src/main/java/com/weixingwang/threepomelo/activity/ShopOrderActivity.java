package com.weixingwang.threepomelo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.ShopOrderActivityAdapter;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import java.util.ArrayList;


/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class ShopOrderActivity extends BaseActivity{
    private RecyclerView rcv;
    private ArrayList<MyOrderBean.OrderListBean> list = new ArrayList<>();
    private ShopOrderActivityAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.shop_order_layout;
    }

    @Override
    protected void initView() {
        rcv = (RecyclerView)findViewById(R.id.re);
        OkHttpUtils.get(UrlUtils.MyOrder_Url,"uIyBe4mjcWmzhY/MsLaHmoSKvd2wp56YhZdwog==", MyOrderBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj!=null){
                    MyOrderBean bean= (MyOrderBean) obj;
                    if(bean.isSuccess()){
                        list.addAll(bean.getOrder_list());
                        System.out.println(list.size() + "---------------------------");
                        adapter.notifyDataSetChanged();
                    }
                }else {
                    Toast.makeText(ShopOrderActivity.this,"",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void error(Exception e) {
                Toast.makeText(ShopOrderActivity.this,"网络错误，请重新请求",Toast.LENGTH_LONG).show();
            }
        });
        //Recyclerview线性排列,从零开始往下
        rcv.setLayoutManager(new LinearLayoutManager(ShopOrderActivity.this, LinearLayoutManager.VERTICAL, false));
        rcv.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {

    }
}
