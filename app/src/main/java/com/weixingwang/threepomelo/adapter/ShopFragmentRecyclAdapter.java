package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.SellerMessageActivity;
import com.weixingwang.threepomelo.activity.ShopMessageActivity;
import com.weixingwang.threepomelo.bean.ShopFragmentBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

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
        final ShopFragmentBean.GoodsListEntity bean = (ShopFragmentBean.GoodsListEntity) reList.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShopMessageActivity.class);
                intent.putExtra("id",bean.getId());
                context.startActivity(intent);
            }
        });
        setData(holder,bean);

    }

    private void setData(MyHolder holder, ShopFragmentBean.GoodsListEntity bean) {
        if(!TextUtils.isEmpty(bean.getGood_name())){
            holder.tvName.setText(bean.getGood_name());
        }
        if(!TextUtils.isEmpty(bean.getDemo())){
            holder.tvSay.setText(bean.getDemo());
        }
        if(!TextUtils.isEmpty(bean.getGg_price())){
            double v = Double.parseDouble(bean.getGg_price());
            holder.tvNowMoney.setText(v/100+"");
        }
        if(!TextUtils.isEmpty(bean.getGg_old_price())){
            double v = Double.parseDouble(bean.getGg_old_price());
            holder.tvOldMoney.setText(v/100+"");
        }

        if(!TextUtils.isEmpty(bean.getLogo())){
            Glide.with(context).load(UrlUtils.MAIN_Url+"/upload/goods_logo/"+bean.getLogo())
                    .placeholder(R.drawable.orders_icon_loadpicture)
                    .into(holder.ivLog);
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private  CardView cardView;
        private TextView tvName,tvSay,tvNowMoney,tvOldMoney;
        private  ImageView ivLog;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.shop_name_item);
            tvSay = (TextView) itemView.findViewById(R.id.shop_say_item);
            tvNowMoney = (TextView) itemView.findViewById(R.id.shop_goods_now_money_item);
            tvOldMoney = (TextView) itemView.findViewById(R.id.shop_goods_old_money_item);
            cardView = (CardView) itemView.findViewById(R.id.shop_recycle_item_card);
            ivLog = (ImageView) itemView.findViewById(R.id.shop_iv_item);
        }
    }
}
