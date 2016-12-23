package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.CoustomPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.MyVIPFragmentRecyAdapter;
import com.weixingwang.threepomelo.bean.MyTeamVIPBean;
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
public class MyVIPFragment extends BaseFragment {
    private RecyclerView recycl;
    private int page=1;
    private List<MyTeamVIPBean.MyTeamListEntity> my_team_list;
    private List<MyTeamVIPBean.MyTeamListEntity> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.my_vip_fragment;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.my_vip_fragment_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.my_vip_fragment_recyle);
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
        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.TEAM_VIP_Url, ShearPreferenceUtils.getToken(getActivity()),
                MyTeamVIPBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            MyTeamVIPBean bean = (MyTeamVIPBean) obj;
                            if (bean.isSuccess()) {
                                my_team_list = bean.getMy_team_list();
                                setShiAdapter(my_team_list);
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

    private void setShiAdapter(List<MyTeamVIPBean.MyTeamListEntity> bean) {
        list.addAll(bean);
        if(list!=null&&list.size()>0){
            recycl.setAdapter(new MyVIPFragmentRecyAdapter(getActivity(),recycl,list,
                    R.layout.fragment_my_vip_item,1));
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

        if(my_team_list.size()<20){
            ToastUtils.toast(getActivity(),"已加载完毕!");
        }else{
            page++;
            getData();
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
