package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class CoustomPercentSixFragmentRecyAdapter extends BaseRecyleAdapter {

    private List<?> reList;

    public CoustomPercentSixFragmentRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyHolder holder= (MyHolder) mholder;
        holder.tvName.setText(reList.get(position).toString());
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_percent_six_custom);

        }
    }
}