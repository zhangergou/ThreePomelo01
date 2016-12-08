package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.SellerMessageActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class HomeFragmentRecyleAdapter extends BaseRecyleAdapter {


    private Context context;
    private List<?> reList;

    public HomeFragmentRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,SellerMessageActivity.class));
            }
        });
    }



     class MyHolder extends RecyclerView.ViewHolder{

         private  CardView cardView;
         private  TextView tvName;

         public MyHolder(View itemView) {
            super(itemView);
             tvName = (TextView) itemView.findViewById(R.id.home_shop_name);
             cardView = (CardView) itemView.findViewById(R.id.home_recycle_item_card);

        }
    }
}
