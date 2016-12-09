package com.weixingwang.threepomelo.frament;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class BaseFragment extends Fragment implements View.OnClickListener , SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener {

    private View view;
    private SwipeRefreshLayout sw;
    private MyScrollView scrollView;
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(getLayoutId(), null);
            initView(view);
            initData();
            initLisener();
        }
        return view;
    }
    protected abstract int getLayoutId() ;
    protected abstract void initView(View v);
    protected abstract void initData();
    protected abstract void initLisener();

    public void setTitle(String title){
        TextView titleName = (TextView) view.findViewById(R.id.tv_title_name);
        titleName.setText(title);
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
    public void isShowArea(boolean show){
        LinearLayout linArea = (LinearLayout) view.findViewById(R.id.lin_home_area);
        if(show){
            linArea.setVisibility(View.VISIBLE);
        }
    }
    //显示搜索
    public void isShowSearch(boolean show){
        LinearLayout linSearch = (LinearLayout) view.findViewById(R.id.lin_home_search);
        if(show){
            linSearch.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onClick(View v) {


    }

    @Override
    public void onRefresh() {
        sw.setRefreshing(false);
        Toast.makeText(getActivity(), "刷新完成", Toast.LENGTH_SHORT).show();
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
        ToastUtils.toast(getActivity(), "暂无数据");
    }

    public void netError() {
        ToastUtils.toast(getActivity(), "网络错误");
    }

    public void showLoading() {
        dialog.show();
    }

    public void initDialog(){
        dialog = DialogUtils.showLoading(getActivity(), "加载中...");
    }

    public void closeLoading() {
        dialog.dismiss();
    }
}
