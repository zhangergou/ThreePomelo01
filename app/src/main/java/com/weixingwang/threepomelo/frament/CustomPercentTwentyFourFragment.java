package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.CoustomPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.CustomPercentTwelveFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.CustomPercentTwentyFourFragmentRecyAdapter;
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
public class CustomPercentTwentyFourFragment extends BaseFragment {
    private RecyclerView recycl;
    private int page=1;
    @Override
    protected int getLayoutId() {
        return R.layout.custom_percent_twenty_four_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.custom_fragment_percent_twenty_four_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.custom_fragment_percent_twenty_four_recyle);
       refrush(swrf);
    }

    @Override
    protected void initData() {
        getData();
        getTopData();
    }

    @Override
    protected void initLisener() {

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("tab_type", 3+"");
        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.PERSON_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
                SunFlowerCountPersonBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            SunFlowerCountPersonBean bean = (SunFlowerCountPersonBean) obj;
                            if (bean.isSuccess()) {
                                setShiAdapter(bean.getUser_heart_list());
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

        if(bean!=null&&bean.size()>0){
            recycl.setAdapter(new CustomPercentTwentyFourFragmentRecyAdapter(getActivity(),recycl,bean,
                    R.layout.fragment_costom_sunflower_percent_three_item,1));
        }
    }

    private void getTopData() {
        OkHttpUtils.get(UrlUtils.TOTAL_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
                TotalSunBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            TotalSunBean bean = (TotalSunBean) obj;
                            if (bean.isSuccess()) {
                                CustomSunFlwoerFragment.csf.setData("24系列",bean.getUser_count24()+"");
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
                });
    }


    @Override
    public void onResume() {
        super.onResume();
        getTopData();
    }
}
