package com.weixingwang.threepomelo.frament;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener,
        ViewPager.OnPageChangeListener, PullToRefreshLayout.OnRefreshListener {

    private View view;
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), null);
            initView(view);
            initData();
            initLisener();
        }
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View v);

    protected abstract void initData();

    protected abstract void initLisener();

    public void setTitle(String title) {
        TextView titleName = (TextView) view.findViewById(R.id.tv_title_name);
        titleName.setText(title);
    }
    public void setTitle(String title,int colorId,int bagroundId) {
        RelativeLayout ra = (RelativeLayout) view.findViewById(R.id.title_rla);
        TextView titleName = (TextView) view.findViewById(R.id.tv_title_name);
        titleName.setText(title);
        titleName.setTextColor(getResources().getColor(colorId));
        ra.setBackgroundColor(getResources().getColor(bagroundId));
    }
    ////显示返回
//    public void isShowBack(boolean show){
//        ImageView ivBack = (ImageView) view.findViewById(R.id.iv_title_back);
//        if(show){
//            ivBack.setVisibility(View.VISIBLE);
//
//        }
//    }
//显示区域
    public LinearLayout isShowArea(boolean show) {
        LinearLayout linArea = (LinearLayout) view.findViewById(R.id.lin_home_area);
        if (show) {
            linArea.setVisibility(View.VISIBLE);
        }
        return linArea;
    }

    //显示搜索
    public void isShowSearch(boolean show) {
        LinearLayout linSearch = (LinearLayout) view.findViewById(R.id.lin_home_search);
        if (show) {
            linSearch.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {


    }

    public void noData() {
        ToastUtils.toast(getActivity(), "暂无数据");
    }

    public void netError() {
        ToastUtils.toast(getActivity(), "网络错误");
    }

    public void showLoading() {
        dialog = DialogUtils.showLoading(getActivity(), "加载中...");
        dialog.show();
    }

    public void closeLoading() {
        dialog.dismiss();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void refrush(PullToRefreshLayout ref) {
        ref.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
    }


    public void closeRefresh(boolean show) {
        if (show) {
            RelativeLayout re = (RelativeLayout) view.findViewById(R.id.head_view);
            re.setVisibility(View.GONE);
        }
    }

    public void closeLoadMore(boolean show) {
        if (show) {
            RelativeLayout load = (RelativeLayout) view.findViewById(R.id.loadmore_view);
            load.setVisibility(View.GONE);
        }
    }


}
