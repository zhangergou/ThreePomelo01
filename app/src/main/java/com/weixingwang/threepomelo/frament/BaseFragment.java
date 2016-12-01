package com.weixingwang.threepomelo.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private View view;

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

    public void isShowBack(boolean show){
        ImageView ivBack = (ImageView) view.findViewById(R.id.iv_title_back);
        if(show){
            ivBack.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onClick(View v) {


    }
}
