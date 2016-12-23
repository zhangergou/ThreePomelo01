package com.weixingwang.threepomelo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.frament.ApplyTakeOutFragment;
import com.weixingwang.threepomelo.frament.MoneyLogFragment;
import com.weixingwang.threepomelo.frament.MyShopFragment;
import com.weixingwang.threepomelo.frament.MyVIPFragment;
import com.weixingwang.threepomelo.frament.SecondShopFragment;
import com.weixingwang.threepomelo.frament.TakeOutMoneyLogFragment;
import com.weixingwang.threepomelo.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class MyTeamActivity extends BaseActivity{
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.my_team_layout;
    }

    @Override
    protected void initView() {
        vp = (ViewPager) findViewById(R.id.my_team_vp);
        tab = (TabLayout) findViewById(R.id.my_team_tab);
        setTitle("我的团队");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        list.add(new MyVIPFragment());
        list.add(new MyShopFragment());
        list.add(new SecondShopFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),vp,tab,
                list, ArrayUtils.teams));
    }

    @Override
    protected void initLisener() {

    }
}
