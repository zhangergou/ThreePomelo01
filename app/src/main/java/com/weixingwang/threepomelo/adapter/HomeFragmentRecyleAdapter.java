package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.SellerMessageActivity;
import com.weixingwang.threepomelo.bean.HomeShopListBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

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
        final HomeShopListBean.ShopListEntity shop = (HomeShopListBean.ShopListEntity) reList.get(position);
        if(!TextUtils.isEmpty(shop.getShop_name())){
            holder.tvName.setText(shop.getShop_name());
        }
        if(!TextUtils.isEmpty(shop.getJuli())){

            holder.tvKm.setText(shop.getJuli()+"km");
        }
        if(!TextUtils.isEmpty(shop.getDesc())){
            holder.tvSay.setText(shop.getDesc().trim());
        }
        if(!TextUtils.isEmpty(shop.getAddress())){
            holder.tvAddress.setText(shop.getAddress());
        }
        String percent = shop.getPercent().toString().trim();
        if(TextUtils.equals(percent,"6")){
            holder.ivPercent.setImageResource(R.drawable.home_icon_6series);
        }
        if(TextUtils.equals(percent,"12")){
            holder.ivPercent.setImageResource(R.drawable.home_icon_12series);
        }
        if(TextUtils.equals(percent,"24")){
            holder.ivPercent.setImageResource(R.drawable.home_icon_24series);
        }
        if(!TextUtils.isEmpty(shop.getLogo())){
            Glide.with(context).load(UrlUtils.getImgUrl+shop.getLogo())
                    .placeholder(R.drawable.orders_icon_loadpicture)
                    .centerCrop()
                    .into(holder.ivShopIcon);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SellerMessageActivity.class);
                intent.putExtra("shop_id",shop.getId());
                context.startActivity(intent);
            }
        });
    }



     class MyHolder extends RecyclerView.ViewHolder{

         private  ImageView ivPercent,ivShopIcon;
         private  CardView cardView;
         private  TextView tvName,tvKm,tvSay,tvAddress;

         public MyHolder(View itemView) {
            super(itemView);
             tvName = (TextView) itemView.findViewById(R.id.home_shop_name);
             tvKm = (TextView) itemView.findViewById(R.id.home_shop_tv_km);
             tvSay = (TextView) itemView.findViewById(R.id.home_shop_tv_say);
             tvAddress = (TextView) itemView.findViewById(R.id.home_shop_tv_address);
             ivPercent = (ImageView) itemView.findViewById(R.id.home_percent_iv);
             ivShopIcon = (ImageView) itemView.findViewById(R.id.home_shop_iv);

             cardView = (CardView) itemView.findViewById(R.id.home_recycle_item_card);

        }
    }
}
