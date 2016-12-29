package com.weixingwang.threepomelo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.frament.ShopFragment;
import com.weixingwang.threepomelo.frament.HomeFragment;
import com.weixingwang.threepomelo.frament.MeFragment;
import com.weixingwang.threepomelo.frament.MyOrderFragment;
import com.weixingwang.threepomelo.frament.EveryDayDataFragment;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.view.MyViewPager;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

    public static MainActivity main;
    private MyViewPager mainViewPager;
    private TabLayout mainTab;
    private ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        mainViewPager = (MyViewPager) findViewById(R.id.main_vp);
        mainTab = (TabLayout) findViewById(R.id.main_tab);
        main=this;
        mainViewPager.setNoScroll(true);
    }

    @Override
    protected void initData() {
        list.add(new HomeFragment());
        list.add(new MyOrderFragment());
        list.add(new ShopFragment());
        list.add(new EveryDayDataFragment());
        list.add(new MeFragment());
        mainViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),mainViewPager,
                mainTab,list, ArrayUtils.mainTab));
        for (int i = 0; i <list.size() ; i++) {
            View view = View.inflate(this, R.layout.main_tab_item, null);
            ImageView tabIv = (ImageView) view.findViewById(R.id.main_tab_item_icon);
            TextView tabTv = (TextView) view.findViewById(R.id.main_tab_item_tv);
            tabTv.setText(ArrayUtils.mainTab[i]);
            tabIv.setImageResource(ArrayUtils.mainCion[i]);
            mainTab.getTabAt(i).setCustomView(view);
        }
        mainTab.getTabAt(0).getCustomView().setSelected(true);
        int frag = getIntent().getIntExtra("frag", 0);
        if(frag==5){
            setSelectCount(4);
        }
    }

    @Override
    protected void initLisener() {

    }
    public void setSelectCount(int count){
        mainViewPager.setCurrentItem(count,false);
        mainTab.getTabAt(count).getCustomView().setSelected(true);
    }
}
