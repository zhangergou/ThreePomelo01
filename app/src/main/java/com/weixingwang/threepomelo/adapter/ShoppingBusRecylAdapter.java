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

    private int pos=1;
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
       setData(myViewHolder,position);
    }

    private void setData(final MyViewHolder myViewHolder, final int position) {
        myViewHolder.tvHomeGoodsName.setText(reList.get(position).toString());
        final int num = Integer.parseInt(myViewHolder.tvNum.getText().toString().trim());
        final int onePrice = Integer.parseInt(myViewHolder.tvOnePrice.getText().toString().trim());
        myViewHolder.tvTotalPrice.setText(num*onePrice+"");
        myViewHolder.ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos>1){
                    pos--;
                    myViewHolder.tvTotalPrice.setText(pos*onePrice+"");
                }
                onClickItemView.onItem(position);
               // lisntene.onDeleAndAdd(position);
            }
        });
        myViewHolder.ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos++;
                myViewHolder.tvTotalPrice.setText(pos*onePrice+"");
               // lisntene.onDeleAndAdd(position);
            }
        });
        myViewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lisntene.onDeleAndAdd(position);
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHomeGoodsName,tvTotalPrice,tvOnePrice,tvNum;
        private ImageView ivMinus,ivPlus,ivDelete;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHomeGoodsName = (TextView) itemView.findViewById(R.id.shop_bus_recycle_item_name);
            tvTotalPrice= (TextView) itemView.findViewById(R.id.bus_tv_total_price);
            tvOnePrice= (TextView) itemView.findViewById(R.id.bus_tv_one_price);
            tvNum= (TextView) itemView.findViewById(R.id.bus_tv_num);
            ivMinus=(ImageView) itemView.findViewById(R.id.bus_iv_minus);
            ivPlus=(ImageView) itemView.findViewById(R.id.bus_iv_plus);
            ivDelete=(ImageView) itemView.findViewById(R.id.bus_iv_delete);
        }
    }

}
