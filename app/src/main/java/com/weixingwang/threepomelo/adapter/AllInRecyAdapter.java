package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyAllInBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class AllInRecyAdapter extends BaseRecyleAdapter {

    private List<?> reList;

    public AllInRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        MyAllInBean.MyIncomeListEntity bean= (MyAllInBean.MyIncomeListEntity) reList.get(position);
        setData(holder,bean);

    }

    private void setData(MyHolder holder, MyAllInBean.MyIncomeListEntity bean) {
        if(!TextUtils.isEmpty(bean.getMoney())){
            double v = Double.parseDouble(bean.getMoney());
            holder.tvName.setText(v/100+"元");
        }
        if(!TextUtils.isEmpty(bean.getRemark())){
            holder.tvFrom.setText(bean.getRemark());
        }
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName,tvFrom,tvTime;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_all_in_num);
            tvFrom = (TextView) itemView.findViewById(R.id.tv_all_in_from);
            tvTime = (TextView) itemView.findViewById(R.id.tv_all_in_time);

        }
    }
}
