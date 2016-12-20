package com.weixingwang.threepomelo.frament;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.ShopPercentSixFragmentRecyAdapter;
import com.weixingwang.threepomelo.bean.SunFlowerCountPersonBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class PercentSixFragment extends BaseFragment {
    private RecyclerView recycl;
    private ArrayList<String> list=new ArrayList<>();
    private int page=1;
    @Override
    protected int getLayoutId() {
        return R.layout.percent_six_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.fragment_percent_six_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_percent_six_recyle);
        refrush(swrf);
    }

    @Override
    protected void initData() {
        getData();


        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recycl.setAdapter(new ShopPercentSixFragmentRecyAdapter(getActivity(),recycl,list,
                R.layout.fragment_shop_sunflower_percent_one_item,1));
    }

    @Override
    protected void initLisener() {

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("tab_type", 1+"");
        map.put("page", page+"");
//        OkHttpUtils.get(UrlUtils.SHOP_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
//                SunFlowerCountPersonBean.class, new OkHttpUtils.CallBackUtils() {
//            @Override
//            public void sucess(Object obj) {
//                if (obj != null) {
//                    SunFlowerCountPersonBean bean = (SunFlowerCountPersonBean) obj;
//                    if (bean.isSuccess()) {
//
//                        setShiAdapter(bean.getUser_heart_list());
//                    } else {
//                        ToastUtils.toast(getActivity(), bean.getError_msg());
//
//                    }
//
//                } else {
//                    noData();
//                }
//
//            }
//
//            @Override
//            public void error(Exception e) {
//                netError();
//            }
//        }, map);

    }
}
