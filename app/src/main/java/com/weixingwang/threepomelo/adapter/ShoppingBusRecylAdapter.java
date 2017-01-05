package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.ShopBusBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShoppingBusRecylAdapter extends BaseRecyleAdapter {
    private Context context;
    private List<?> reList;

    public ShoppingBusRecylAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyViewHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) mholder;
        ShopBusBean.ListCartEntity bean = (ShopBusBean.ListCartEntity) reList.get(position);
        setData(myViewHolder,bean,position);
    }

    private void setData(final MyViewHolder myViewHolder, ShopBusBean.ListCartEntity bean, final int position) {
        double oneD =0;
        double num=0;
       if(!TextUtils.isEmpty(bean.getGood_name())){
           myViewHolder.tvHomeGoodsName.setText(bean.getGood_name());
       }
       if(!TextUtils.isEmpty(bean.getNum())){
            num = Double.parseDouble(bean.getNum());
           myViewHolder.tvNum.setText(bean.getNum());
       }
       if(!TextUtils.isEmpty(bean.getGg_price())){
            oneD =  Double.parseDouble(bean.getGg_price());
           myViewHolder.tvOnePrice.setText(oneD/100+"");
       }
        myViewHolder.tvTotalPrice.setText(oneD*num/100+"");

        if(!TextUtils.isEmpty(bean.getLogo())){
            Glide.with(context).load(UrlUtils.MAIN_Url+"/upload/goods_logo/"+bean.getLogo())
                    .into(myViewHolder.ivIcon);
        }

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickChoeseView.onChoese(position);
            }
        });




        myViewHolder.ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMusView.onMus(position);

            }
        });
        myViewHolder.ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPlusView.onPlus(position);
            }
        });
        myViewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onClickDeleteView.onDelete(position);
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private  CardView cardView;
        private TextView tvHomeGoodsName,tvTotalPrice,tvOnePrice,tvNum;
        private ImageView ivMinus,ivPlus,ivDelete,ivIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHomeGoodsName = (TextView) itemView.findViewById(R.id.shop_bus_recycle_item_name);
            tvTotalPrice= (TextView) itemView.findViewById(R.id.bus_tv_total_price);
            tvOnePrice= (TextView) itemView.findViewById(R.id.bus_tv_one_price);
            tvNum= (TextView) itemView.findViewById(R.id.bus_tv_num);
            ivMinus=(ImageView) itemView.findViewById(R.id.bus_iv_minus);
            ivPlus=(ImageView) itemView.findViewById(R.id.bus_iv_plus);
            ivDelete=(ImageView) itemView.findViewById(R.id.bus_iv_delete);
            ivIcon=(ImageView) itemView.findViewById(R.id.bus_iv_icon);
            cardView =(CardView) itemView.findViewById(R.id.shop_bus_cardview);
        }
    }

}
