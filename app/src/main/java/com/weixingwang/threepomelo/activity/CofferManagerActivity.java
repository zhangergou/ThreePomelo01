package com.weixingwang.threepomelo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BasePagerAdapter;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.frament.ApplyTakeOutFragment;
import com.weixingwang.threepomelo.frament.BankCardTakeFragment;
import com.weixingwang.threepomelo.frament.MoneyLogFragment;
import com.weixingwang.threepomelo.frament.TakeOutMoneyLogFragment;
import com.weixingwang.threepomelo.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class CofferManagerActivity extends BaseActivity{

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.coffer_manager_layout;
    }

    @Override
    protected void initView() {
        vp = (ViewPager) findViewById(R.id.coffer_manager_vp);
        tab = (TabLayout) findViewById(R.id.coffer_manager_tab);
        setTitle("资金日志");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        list.add(new MoneyLogFragment());
        list.add(new TakeOutMoneyLogFragment());
        list.add(new BankCardTakeFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),vp,tab,
                list, ArrayUtils.cofferManager));
    }

    @Override
    protected void initLisener() {

    }
}
