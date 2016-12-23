package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.TakeMoneyLogBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class TakeOutMoneyRecyAdapter extends BaseRecyleAdapter {
    private List<?> reList;

    public TakeOutMoneyRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, int position) {
        MyHolder holder= (MyHolder) mholder;
        TakeMoneyLogBean.WithdrawListEntity bean= (TakeMoneyLogBean.WithdrawListEntity) reList.get(position);
        setData(holder,bean);

    }

    private void setData(MyHolder holder, TakeMoneyLogBean.WithdrawListEntity bean) {
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
        }
        if(!TextUtils.isEmpty(bean.getMoney())){
            double v = Double.parseDouble(bean.getMoney());
            holder.tvName.setText(v/100+"元");
        }
        if(!TextUtils.isEmpty(bean.getStatus())){
            if(TextUtils.equals(bean.getStatus(),"1")){
                holder.tvStus.setText("待审核");
            }
            if(TextUtils.equals(bean.getStatus(),"2")){
                holder.tvStus.setText("申请通过");
            }
            if(TextUtils.equals(bean.getStatus(),"-1")){
                holder.tvStus.setText("拒绝");
            }
        }


    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName,tvTime,tvStus;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_take_out_money_num);
            tvTime = (TextView) itemView.findViewById(R.id.tv_take_out_money_time);
            tvStus = (TextView) itemView.findViewById(R.id.tv_take_out_money_status);

        }
    }
}
