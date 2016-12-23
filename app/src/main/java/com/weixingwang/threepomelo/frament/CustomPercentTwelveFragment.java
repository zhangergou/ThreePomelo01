package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.CoustomPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.CustomPercentTwelveFragmentRecyAdapter;
import com.weixingwang.threepomelo.bean.SunFlowerCountPersonBean;
import com.weixingwang.threepomelo.bean.TotalSunBean;
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
public class CustomPercentTwelveFragment extends BaseFragment {
    private RecyclerView recycl;
    private int page = 1;
    private List<SunFlowerCountPersonBean.UserHeartListEntity> user_heart_list;
    private List<SunFlowerCountPersonBean.UserHeartListEntity> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.custom_pencent_twelve_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.custom_fragment_percent_twelve_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.custom_fragment_percent_twelve_recyle);
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
        map.put("tab_type", 2 + "");
        map.put("page", page + "");
        OkHttpUtils.get(UrlUtils.PERSON_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
                SunFlowerCountPersonBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            SunFlowerCountPersonBean bean = (SunFlowerCountPersonBean) obj;
                            if (bean.isSuccess()) {
                                user_heart_list = bean.getUser_heart_list();
                                setShiAdapter(user_heart_list);
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

    private void setShiAdapter(List<SunFlowerCountPersonBean.UserHeartListEntity> bean) {
        list.addAll(bean);
        if (list != null && list.size() > 0) {
            recycl.setAdapter(new CustomPercentTwelveFragmentRecyAdapter(getActivity(), recycl, list,
                    R.layout.fragment_costom_sunflower_percent_two_item, 1));
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

        if(user_heart_list.size()<20){
            ToastUtils.toast(getActivity(),"已加载完毕!");
        }else{
            page++;
            getData();
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
