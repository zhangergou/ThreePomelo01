package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.SellerMessageActivity;
import com.weixingwang.threepomelo.activity.ShopMessageActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class ShopFragmentRecyclAdapter extends BaseRecyleAdapter {
    private Context context;
    private final List<?> reList;

    public ShopFragmentRecyclAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyHolder holder= (MyHolder) mholder;
        holder.tvName.setText((String)reList.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,ShopMessageActivity.class));
            }
        });
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private  CardView cardView;
        private TextView tvName;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.shop_name_item);
            cardView = (CardView) itemView.findViewById(R.id.shop_recycle_item_card);

        }
    }
}
