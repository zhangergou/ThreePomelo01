package com.weixingwang.threepomelo.frament;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BasePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class HomeFragment extends BaseFragment {

    private ViewPager vp;
    private RecyclerView recl;
    private ArrayList<ImageView> imageList= new ArrayList<>();
    private int[] color={Color.BLUE,Color.BLACK,Color.RED,Color.WHITE,Color.YELLOW};
    private LinearLayout linIndc;
    private int pos;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = vp.getCurrentItem();
            if(currentItem==imageList.size()-1){
                vp.setCurrentItem(0,false);
            }else{
                vp.setCurrentItem(currentItem+1);
            }
            handler.sendEmptyMessageDelayed(1,2000);
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.home_frament_layout;
    }

    @Override
    protected void initView(View view) {
        vp = (ViewPager) view.findViewById(R.id.home_frament_vp);
        recl = (RecyclerView) view.findViewById(R.id.home_fragment_recl);
        linIndc = (LinearLayout) view.findViewById(R.id.lin_home_fragment_indector);
        isShowArea(true);
        isShowSearch(true);
    }

    @Override
    protected void initData() {

        for (int i = 0; i <5 ; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundColor(color[i]);
//            RelativeLayout.LayoutParams pm = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                    RelativeLayout.LayoutParams.MATCH_PARENT);
//            imageView.setLayoutParams(pm);
            imageList.add(imageView);
        }
        vp.setAdapter(new BasePagerAdapter(imageList));
        for (int i = 0; i < imageList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.indector_selector);
            LinearLayout.LayoutParams prams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            prams.leftMargin=10;
            imageView.setLayoutParams(prams);
            linIndc.addView(imageView);
        }
        linIndc.getChildAt(0).setSelected(true);
        handler.sendEmptyMessageDelayed(1,2000);
    }

    @Override
    protected void initLisener() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                linIndc.getChildAt(pos).setSelected(false);
                linIndc.getChildAt(position).setSelected(true);
                pos=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
