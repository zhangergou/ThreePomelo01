package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MoneyLogBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class MoneyLogFragmentRecyAdapter extends BaseRecyleAdapter{

    private List<?> reList;

    public MoneyLogFragmentRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        MoneyLogBean.MoneyLogListEntity bean= (MoneyLogBean.MoneyLogListEntity) reList.get(position);
        setData(holder,bean);


    }

    private void setData(MyHolder holder, MoneyLogBean.MoneyLogListEntity bean) {
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
        }
        if(!TextUtils.isEmpty(bean.getMoney())){
            double v = Double.parseDouble(bean.getMoney());
            holder.tvName.setText(v/100+"元");
        }
        if(!TextUtils.isEmpty(bean.getRemark())){

        }

    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName,tvTime;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.item_tv_money_log_num);
            tvTime = (TextView) itemView.findViewById(R.id.item_tv_money_log_time);

        }
    }
}
