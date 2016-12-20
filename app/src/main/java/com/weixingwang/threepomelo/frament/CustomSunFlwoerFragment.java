package com.weixingwang.threepomelo.frament;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class CustomSunFlwoerFragment extends BaseFragment{
    public static CustomSunFlwoerFragment csf;
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    private TextView tvXi;
    private TextView tvTotal;

    @Override
    protected int getLayoutId() {
        return R.layout.custom_sun_flwoer_fragment_layout;
    }

    @Override
    protected void initView(View v) {
        csf=this;
        vp = (ViewPager) v.findViewById(R.id.custom_sunflwoer_vp);
        tab = (TabLayout) v.findViewById(R.id.custom_sunflwoer_tab);
        tvXi = (TextView) v.findViewById(R.id.tv_coust_xishu);
        tvTotal = (TextView) v.findViewById(R.id.tv_custom_total);
    }

    @Override
    protected void initData() {
        list.add(new CustomPercentSixFragment());
        list.add(new CustomPercentTwelveFragment());
        list.add(new CustomPercentTwentyFourFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),vp,tab,
                list, ArrayUtils.prence));
    }

    @Override
    protected void initLisener() {

    }

    public void setData(String xi,String total){
        tvXi.setText(xi);
        tvTotal.setText(total);
    }
}
