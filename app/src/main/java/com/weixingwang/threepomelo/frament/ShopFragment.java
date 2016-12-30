package com.weixingwang.threepomelo.frament;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.ShoppingBusActivity;
import com.weixingwang.threepomelo.adapter.ShopFragmentRecyclAdapter;
import com.weixingwang.threepomelo.bean.PersonCenterBean;
import com.weixingwang.threepomelo.bean.ShopFragmentBean;
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
 * Created by Administrator on 2016/11/29 0029.
 */
public class ShopFragment extends BaseFragment {


    private RecyclerView recl;
    private ArrayList<ShopFragmentBean.GoodsListEntity> list=new ArrayList<>();
    private View view;
    private int page=1;
    private List<ShopFragmentBean.GoodsListEntity> goods_list;

    @Override
    protected int getLayoutId() {
        return R.layout.shop_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        PullToRefreshLayout swrf= (PullToRefreshLayout) view.findViewById(R.id.shop_fragment_swf);
        recl = (RecyclerView) view.findViewById(R.id.shop_fragment_recl);
        setTitle("在线商城");
        refrush(swrf);
    }

    @Override
    protected void initData() {

        getData();

    }

    @Override
    protected void initLisener() {
        view.findViewById(R.id.rla_come_in_shopping_bus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rla_come_in_shopping_bus:
                startActivity(new Intent(getActivity(), ShoppingBusActivity.class));
            break;
        }
    }

    private void getData() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("page",page+"");
        OkHttpUtils.get(UrlUtils.SHOP_GOODS_Url, ShearPreferenceUtils.getToken(getActivity()),
                ShopFragmentBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if(obj!=null){
                            ShopFragmentBean bean = (ShopFragmentBean) obj;
                            if (bean.isSuccess()) {
                                goods_list = bean.getGoods_list();
                                setData(goods_list);
                            } else {
                                ToastUtils.toast(getActivity(), bean.getError_msg());
                            }
                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        netError();
                    }
                },map);
    }

    public void setData(List<ShopFragmentBean.GoodsListEntity> data) {
        list.addAll(data);
        if(list.size()>0){
            recl.setAdapter(new ShopFragmentRecyclAdapter(getActivity(),recl,list,
                    R.layout.shop_frament_recyle_item,1));
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        page=1;
        list.clear();
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if(goods_list!=null){
            if(goods_list.size()<20){
                ToastUtils.toast(getActivity(),"加载完毕!");
            }else {
                page++;
                getData();
            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
