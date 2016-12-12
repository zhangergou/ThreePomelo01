package com.weixingwang.threepomelo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.frament.CustomSunFlwoerFragment;
import com.weixingwang.threepomelo.frament.ShopSunFlwoerFragment;
import com.weixingwang.threepomelo.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class MySunFlwoerActivity extends BaseActivity{
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.my_sunflwoer_layout;
    }

    @Override
    protected void initView() {
        vp = (ViewPager) findViewById(R.id.my_sunflwoer_vp);
        tab = (TabLayout) findViewById(R.id.my_sunflwoer_tab);
        setTitle("我的向日葵");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        list.add(new ShopSunFlwoerFragment());
        list.add(new CustomSunFlwoerFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),vp,tab,
                list, ArrayUtils.sunFlowers));
    }

    @Override
    protected void initLisener() {

    }
}
