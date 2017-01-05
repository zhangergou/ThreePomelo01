package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.AddressListBean;
import com.weixingwang.threepomelo.bean.SureOrderBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4 0004.
 */
public class SureMyOrderRecyleAdapter extends BaseRecyleAdapter {
    private final Context context;
    private final List<?> reList;

    //SureOrderBean.GoodsListEntity
    public SureMyOrderRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        SureOrderBean.GoodsListEntity bean= (SureOrderBean.GoodsListEntity) reList.get(position);
        setData(myViewHolder,bean);
    }

    private void setData(MyViewHolder myViewHolder, SureOrderBean.GoodsListEntity bean) {
        if(!TextUtils.isEmpty(bean.getGood_name())){
            myViewHolder.tvGoodsName.setText(bean.getGood_name());
        }
        if(!TextUtils.isEmpty(bean.getGg_name())){
            myViewHolder.tvType.setText(bean.getGg_name());
        }
        if(!TextUtils.isEmpty(bean.getGood_logo())){
            Glide.with(context).load(UrlUtils.MAIN_Url)
                    .into(myViewHolder.ivIcon);
        }
        if(!TextUtils.isEmpty(bean.getGood_num())){
            myViewHolder.tvCount.setText(bean.getGood_num());
        }
        if(!TextUtils.isEmpty(bean.getGood_price())){
            double v = Double.parseDouble(bean.getGood_price());
            myViewHolder.tvPrice.setText(v/100+"");
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvGoodsName,tvCount,tvType,tvPrice;
        private ImageView ivIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvGoodsName = (TextView) itemView.findViewById(R.id.tv_sure_order_re_item_name);
            tvType= (TextView) itemView.findViewById(R.id.tv_sure_order_re_item_type);
            tvPrice= (TextView) itemView.findViewById(R.id.tv_sure_order_re_item_price);
            tvCount= (TextView) itemView.findViewById(R.id.tv_sure_order_re_item_count);
            ivIcon=(ImageView) itemView.findViewById(R.id.iv_sure_order_re_item_icon);
        }
    }
}
