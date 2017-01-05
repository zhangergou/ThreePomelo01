package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.MyShopOrderUpActivity;
import com.weixingwang.threepomelo.bean.MyShopOrderUpBean;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderUpRecylAdapter extends BaseRecyleAdapter {


    private Context context;
    private List<?> reList;

    public MyShopOrderUpRecylAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        MyShopOrderUpBean.OrdersEntity bean= (MyShopOrderUpBean.OrdersEntity) reList.get(position);
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemView.onItem(position);
            }
        });
        setData(holder,bean);
    }

    private void setData(MyHolder holder, MyShopOrderUpBean.OrdersEntity bean) {
        if(!TextUtils.isEmpty(bean.getNum())){
            holder.tvName.setText(bean.getNum());
        }
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
            holder.tvTimeT.setText(bean.getCdate());
        }
        if(!TextUtils.isEmpty(bean.getTotal())){
            double v = Double.parseDouble(bean.getTotal());
            holder.tvMoney.setText(v/100+"");

        }
//        if(!TextUtils.isEmpty(bean.getPic())){
//            holder.linShow.setVisibility(View.VISIBLE);
//            Glide.with(context).load(UrlUtils.MAIN_Url+"/upload/order_pic/"+bean.getPic())
//                    .into(holder.ivZheng);
//        }
        String status = bean.getStatus();
        if(!TextUtils.isEmpty(status)){
            if(TextUtils.equals(status,"1")){
                holder.tvStus.setText("未提交");
            }
            if(TextUtils.equals(status,"2")){
                holder.tvStus.setText("审核中");
            }
            if(TextUtils.equals(status,"3")){
                holder.tvStus.setText("已完成");
            }
            if(TextUtils.equals(status,"-1")){
                holder.tvStus.setText("审核拒绝");
            }
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{


        private TextView tvName,tvDelete,tvTime,tvStus,tvMoney,tvTimeT;
        private final LinearLayout linShow;
        private final ImageView ivZheng;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_count);
            tvDelete = (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_delete);
            tvStus= (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_status);
            tvTime= (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_time);
            tvMoney= (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_money);
            tvTimeT= (TextView) itemView.findViewById(R.id.tv_my_shop_order_up_re_item_time_t);
            linShow = (LinearLayout) itemView.findViewById(R.id.lin_my_shop_order_up_recl_item_zheng_show);
            ivZheng = (ImageView) itemView.findViewById(R.id.iv_my_shop_order_up_recl_item_zheng);
        }
    }
}
