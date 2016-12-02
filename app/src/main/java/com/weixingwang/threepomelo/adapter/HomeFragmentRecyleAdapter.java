package com.weixingwang.threepomelo.adapter;

import android.content.Context;
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
public class HomeFragmentRecyleAdapter extends BaseRecyleAdapter {


    private List<?> reList;

    public HomeFragmentRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyHolder holder = (MyHolder) mholder;
        holder.tvName.setText((String) reList.get(position));
    }



     class MyHolder extends RecyclerView.ViewHolder{

         private  TextView tvName;

         public MyHolder(View itemView) {
            super(itemView);
             tvName = (TextView) itemView.findViewById(R.id.home_shop_name);

        }
    }
}
