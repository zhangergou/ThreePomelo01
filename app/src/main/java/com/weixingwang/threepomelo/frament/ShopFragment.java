package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.ShopFragmentRecyclAdapter;
import com.weixingwang.threepomelo.view.MyScrollView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class ShopFragment extends BaseFragment {


    private MyScrollView sw;
    private RecyclerView recl;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.shop_frament_layout;
    }

    @Override
    protected void initView(View view) {
        SwipeRefreshLayout swrf= (SwipeRefreshLayout) view.findViewById(R.id.shop_fragment_swf);
        sw = (MyScrollView) view.findViewById(R.id.shop_fragment_msw);
        recl = (RecyclerView) view.findViewById(R.id.shop_fragment_recl);
        setTitle("在线商城");
        setSwColor(swrf);
        isReflash(sw);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }
        recl.setAdapter(new ShopFragmentRecyclAdapter(getActivity(),recl,list,
                R.layout.shop_frament_recyle_item,1));
    }

    @Override
    protected void initLisener() {

    }
}
