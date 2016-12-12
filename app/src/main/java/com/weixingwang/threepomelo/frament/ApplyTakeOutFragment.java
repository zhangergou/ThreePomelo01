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
public class ApplyTakeOutFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_apply_take_out_layout;
    }

    @Override
    protected void initView(View v) {
        vp = (ViewPager) v.findViewById(R.id.apply_take_out_vp);
        tab = (TabLayout) v.findViewById(R.id.apply_take_out_tab);
    }

    @Override
    protected void initData() {
        list.add(new AliPayTakeFragment());
        list.add(new BankCardTakeFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),vp,tab,
                list, ArrayUtils.takeMoneyType));
    }

    @Override
    protected void initLisener() {

    }
}
