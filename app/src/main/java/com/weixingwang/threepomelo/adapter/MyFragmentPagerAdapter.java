package com.weixingwang.threepomelo.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private String[] tabName;


    public MyFragmentPagerAdapter(FragmentManager fm, ViewPager vpHome, TabLayout tabHome, ArrayList<Fragment> list, String[] tabName) {
        super(fm);
        this.list = list;
        this.tabName = tabName;
        vpHome.setAdapter(this);
        tabHome.setupWithViewPager(vpHome);

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (tabName != null && tabName.length > 0) {
            return tabName[position];
        } else {
            return "";
        }
    }
}
