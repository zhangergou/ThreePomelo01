package com.weixingwang.threepomelo.frament;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class CustomSunFlwoerFragment extends BaseFragment{
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.custom_sun_flwoer_fragment_layout;
    }

    @Override
    protected void initView(View v) {
        vp = (ViewPager) v.findViewById(R.id.custom_sunflwoer_vp);
        tab = (TabLayout) v.findViewById(R.id.custom_sunflwoer_tab);
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
}
