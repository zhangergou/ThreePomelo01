package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShoppingBusRecylAdapter extends BaseRecyleAdapter {
    private List<?> reList;

    public ShoppingBusRecylAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyViewHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) mholder;
        myViewHolder.tvHomeGoodsName.setText(reList.get(position).toString());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHomeGoodsName,tvFillPrice,tvLosePrice,tvKm;
        private ImageView ivHomeGoodsImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHomeGoodsName = (TextView) itemView.findViewById(R.id.shop_bus_recycle_item_name);
        }
    }
}
