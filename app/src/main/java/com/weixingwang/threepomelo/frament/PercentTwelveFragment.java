package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.ShopPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.ShopPercentTwelveFragmentRecyAdapter;
import com.weixingwang.threepomelo.bean.ShopSunFlowerBean;
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
 * Created by Administrator on 2016/12/12 0012.
 */
public class PercentTwelveFragment extends BaseFragment {
    private RecyclerView recycl;
    private int page=1;
    private List<ShopSunFlowerBean.ShopHeartListEntity> shop_heart_list;
    private List<ShopSunFlowerBean.ShopHeartListEntity> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.percent_twelve_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.fragment_percent_twelve_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_percent_twelve_recyle);
        refrush(swrf);
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
        map.put("tab_type", 2+"");
        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.SHOP_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
                ShopSunFlowerBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            ShopSunFlowerBean bean = (ShopSunFlowerBean) obj;
                            if (bean.isSuccess()) {
                                shop_heart_list = bean.getShop_heart_list();
                                setShiAdapter(shop_heart_list);
                            } else {
                                ToastUtils.toast(getActivity(), bean.getError_msg());

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

    public void setShiAdapter(List<ShopSunFlowerBean.ShopHeartListEntity> bean) {
        list.addAll(bean);
        if(list!=null&&list.size()>0){
            recycl.setAdapter(new ShopPercentTwelveFragmentRecyAdapter(getActivity(), recycl, list,
                    R.layout.fragment_shop_sunflower_percent_two_item, 1));
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

        if(shop_heart_list.size()<20){
            ToastUtils.toast(getActivity(),"已加载完毕!");
        }else{
            page++;
            getData();
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
