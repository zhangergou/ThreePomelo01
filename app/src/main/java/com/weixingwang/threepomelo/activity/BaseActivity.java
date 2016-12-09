package com.weixingwang.threepomelo.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.view.MyScrollView;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
 public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener {
    private SwipeRefreshLayout sw;
    private MyScrollView scrollView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

    @Override
    public void onRefresh() {
        sw.setRefreshing(false);
        Toast.makeText(this, "刷新完成", Toast.LENGTH_SHORT).show();
    }

    public void setSwColor(SwipeRefreshLayout sw) {
        this.sw = sw;
        sw.setOnRefreshListener(this);
        sw.setColorSchemeColors(getResources().getColor(R.color.blue),
                getResources().getColor(R.color.blueTab),
                getResources().getColor(R.color.red),
                getResources().getColor(R.color.black));
    }

    public void isReflash(MyScrollView scrollView){
        this.scrollView = scrollView;
        scrollView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isEnlable();
                break;
            case MotionEvent.ACTION_MOVE:
                isEnlable();
                break;
        }
        return false;
    }

    private void isEnlable() {
        int scrollY = scrollView.getScrollY();
        if(scrollY>0){
            sw.setEnabled(false);
        }else {
            sw.setEnabled(true);
        }
    }

    public void noData() {
        ToastUtils.toast(this, "暂无数据");
    }

    public void netError() {
        ToastUtils.toast(this, "网络错误");
    }

    public void showLoading() {
        dialog.show();
    }

    public void initDialog(){
        dialog = DialogUtils.showLoading(this, "加载中...");
    }

    public void closeLoading() {
        dialog.dismiss();
    }
}
