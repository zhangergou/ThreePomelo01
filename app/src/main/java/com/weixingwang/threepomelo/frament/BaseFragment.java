package com.weixingwang.threepomelo.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener , SwipeRefreshLayout.OnRefreshListener{

    private View view;
    private SwipeRefreshLayout sw;

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
}
