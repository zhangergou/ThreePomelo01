package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import com.weixingwang.threepomelo.bean.ShopOrderBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public class ShopOrderActivityAdapter extends BaseRecyleAdapter {


    private Context context;
    private List<?> reList;

    public ShopOrderActivityAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, final int position) {
        MyHolder holder= (MyHolder) mholder;
        ShopOrderBean.OrderListEntity bean= (ShopOrderBean.OrderListEntity) reList.get(position);
//        holder.ivPay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onClickChoeseView.onChoese(position);
//            }
//        });
        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemView.onItem(position);
            }
        });
        setData(holder,bean);
    }

    private void setData(MyHolder holder, ShopOrderBean.OrderListEntity bean) {
        if(!TextUtils.isEmpty(bean.getStatus())){
            if(TextUtils.equals(bean.getStatus(),"1")){
                holder.tvState.setText("等待付款");
                holder.ivPay.setVisibility(View.VISIBLE);
            }
            if(TextUtils.equals(bean.getStatus(),"-1")){
                holder.tvState.setText("订单异常");
                holder.ivPay.setVisibility(View.GONE);
            }
            if(TextUtils.equals(bean.getStatus(),"2")){
                holder.tvState.setText("等待付款");
                holder.ivPay.setVisibility(View.VISIBLE);
            }
            if(TextUtils.equals(bean.getStatus(),"3")){
                holder.tvState.setText("发货中");
                holder.ivPay.setVisibility(View.GONE);
            }
        }
        if(!TextUtils.isEmpty(bean.getGood_name())){
            holder.tvName.setText(bean.getGood_name());
        }
        if(!TextUtils.isEmpty(bean.getId())){
            holder.tvId.setText(bean.getId());
        }
        if(!TextUtils.isEmpty(bean.getNeed_pay())){
            double v = Double.parseDouble(bean.getNeed_pay());
            holder.tvPrivce.setText(v/100+"");
        }
        if(!TextUtils.isEmpty(bean.getGoods_pty())){
            holder.tvCount.setText(bean.getGoods_pty());
        }
        if(!TextUtils.isEmpty(bean.getGood_logo())){
            Glide.with(context).load(UrlUtils.MAIN_Url+"/upload/goods_logo/"+bean.getGood_logo())
                    .into(holder.ivIcon);
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public TextView tvState,tvName,tvType,tvCount,tvPrivce,tvId;
        private  ImageView ivPay,ivIcon;
        private final LinearLayout lin;

        public MyHolder(View itemView) {
            super(itemView);
            tvState= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_state);
            tvName= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_name);
            tvId= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_id);
//            tvType= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_type);
            tvCount= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_count);
            tvPrivce= (TextView) itemView.findViewById(R.id.tv_shop_order_rel_item_price);
            ivPay = (ImageView) itemView.findViewById(R.id.iv_shop_order_rel_item_pay);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_shop_order_rel_item_icon);
            lin = (LinearLayout) itemView.findViewById(R.id.lin_shop_order_rel_item);
        }
    }
}
