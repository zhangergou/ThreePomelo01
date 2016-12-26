package com.weixingwang.threepomelo.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
 public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener,PullToRefreshLayout.OnRefreshListener{
    private ProgressDialog dialog;
    @Nullable
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initLisener();
    }
    protected abstract  int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initLisener();
    public Bundle getB(){
        return savedInstanceState;
    }
    public void setTitle(String title){
        TextView titleName = (TextView) findViewById(R.id.tv_title_name);
        titleName.setText(title);
    }

    public void isShowBack(boolean show){
        ImageView ivBack = (ImageView) findViewById(R.id.iv_title_back);
        if(show){
            ivBack.setVisibility(View.VISIBLE);
            ivBack.setOnClickListener(this);
        }
    }
    //显示区域
    public void isShowArea(boolean show){
        LinearLayout linArea = (LinearLayout) findViewById(R.id.lin_home_area);
        if(show){
            linArea.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_title_back:
                finish();
                break;
        }
    }

    public void noData() {
        ToastUtils.toast(this, "暂无数据");
    }

    public void netError() {
        ToastUtils.toast(this, "网络错误");
    }

    public void showLoading() {
        dialog = DialogUtils.showLoading(this, "加载中...");
        dialog.show();
    }

    public void closeLoading() {
        dialog.dismiss();
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

    public void refrush(PullToRefreshLayout ref){
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

    public void closeRefresh(boolean show){
        if(show){
            RelativeLayout re = (RelativeLayout) findViewById(R.id.head_view);
            re.setVisibility(View.GONE);
        }
    }
    public void closeLoadMore(boolean show){
        if(show){
            RelativeLayout load = (RelativeLayout) findViewById(R.id.loadmore_view);
            load.setVisibility(View.GONE);
        }
    }
}
