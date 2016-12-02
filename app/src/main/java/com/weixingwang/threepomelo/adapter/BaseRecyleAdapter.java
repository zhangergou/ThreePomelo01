package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public abstract class BaseRecyleAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<?> reList;
    private int layoutId;


    public BaseRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        this.context = context;
        this.reList = reList;
        this.layoutId = layoutId;
        if(clum<1){
            clum=1;
        }
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(clum,
                StaggeredGridLayoutManager.VERTICAL);
        recl.setLayoutManager(gridLayoutManager);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(layoutId, null);
        parent.addView(inflate);
        return getHolder(inflate);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        initData(holder,position);
    }

    @Override
    public int getItemCount() {
        return reList.size();
    }
    protected abstract RecyclerView.ViewHolder getHolder(View inflate);
    protected abstract void initData(RecyclerView.ViewHolder mholder, int position);
}
