package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyShopOrderBean;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
public class MyShopOrderDataUpDiaRecyAdapter extends BaseRecyleAdapter{
    private List<?> reList;

    public MyShopOrderDataUpDiaRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, final int position) {
        MyHolder holder= (MyHolder) mholder;
        MyShopOrderBean.OrderListEntity bean= (MyShopOrderBean.OrderListEntity) reList.get(position);
        setData(holder,bean);

        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDeleteView.onDelete(position);
            }
        });
    }
    private void setData(MyHolder holder, MyShopOrderBean.OrderListEntity bean) {
        if(!TextUtils.isEmpty(bean.getId())){
            holder.tvId.setText(bean.getId());
        }
        if(!TextUtils.isEmpty(bean.getPrice())){
            double v = Double.parseDouble(bean.getPrice());
            holder.tvMoney.setText(v/100+"");
        }
        if(!TextUtils.isEmpty(bean.getRel_name())){
            holder.tvName.setText(bean.getRel_name());
        }
        if(!TextUtils.isEmpty(bean.getMobile())){
            holder.tvPhone.setText(bean.getMobile());
        }
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
        }
        String status = bean.getStatus();
        if(!TextUtils.isEmpty(status)){
            if(TextUtils.equals(status,"1")){
                holder.tvStus.setText("未提交");
                holder.tvDelete.setVisibility(View.VISIBLE);
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

        private TextView tvName,tvDelete,tvId,tvMoney,tvPhone,tvTime,tvStus;

        public MyHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_id);
            tvMoney = (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_money);
            tvName = (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_name);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_phone);
            tvTime= (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_time);
            tvStus= (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_stus);
            tvDelete = (TextView) itemView.findViewById(R.id.tv_my_shop_order_recl_item_delete);

        }
    }
}
