package com.weixingwang.threepomelo.frament;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MyFragmentPagerAdapter;
import com.weixingwang.threepomelo.bean.TotalSunBean;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class ShopSunFlwoerFragment extends BaseFragment{
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list=new ArrayList<>();
    private TextView tvXi;
    private TextView tvCount;

    @Override
    protected int getLayoutId() {
        return R.layout.shop_sun_flwoer_fragment_layout;
    }

    @Override
    protected void initView(View v) {
        vp = (ViewPager) v.findViewById(R.id.shop_sunflwoer_vp);
        tab = (TabLayout) v.findViewById(R.id.shop_sunflwoer_tab);
        tvXi = (TextView) v.findViewById(R.id.tv_shop_xi);
        tvCount = (TextView) v.findViewById(R.id.tv_shop_sun_count);
    }

    @Override
    protected void initData() {
        list.add(new PercentSixFragment());
        list.add(new PercentTwelveFragment());
        list.add(new PercentTwentyFourFragment());
        vp.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),vp,tab,
                list, ArrayUtils.prence));
        getTopData();
    }

    @Override
    protected void initLisener() {

    }

    private void getTopData() {
        OkHttpUtils.get(UrlUtils.TOTAL_SUN_Url, ShearPreferenceUtils.getToken(getActivity()),
                TotalSunBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            TotalSunBean bean = (TotalSunBean) obj;
                            if (bean.isSuccess()) {
                                putData(bean);
                                setData("6 系列",bean.getShop_count6());
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

    private void putData(final TotalSunBean bean) {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0){
                    setData("6 系列",bean.getShop_count6());
                }
                if(position==1){
                    setData("12系列",bean.getShop_count12());
                }
                if(position==2){
                    setData("24系列",bean.getShop_count24());
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void setData(String xi,String total){
        tvXi.setText(xi);
        tvCount.setText(total);
    }
}
