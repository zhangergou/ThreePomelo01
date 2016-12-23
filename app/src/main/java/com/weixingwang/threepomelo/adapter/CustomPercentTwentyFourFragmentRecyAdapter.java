package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.SunFlowerCountPersonBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class CustomPercentTwentyFourFragmentRecyAdapter extends BaseRecyleAdapter {

    private List<?> reList;

    public CustomPercentTwentyFourFragmentRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        SunFlowerCountPersonBean.UserHeartListEntity bean= (SunFlowerCountPersonBean.UserHeartListEntity) reList.get(position);
        setData(holder,bean);
    }
    private void setData(MyHolder holder, SunFlowerCountPersonBean.UserHeartListEntity bean) {
        String status = bean.getStatus();
        if(!TextUtils.isEmpty(status)){
            if(TextUtils.equals(status,"1")){
                holder.tvName.setText("激励中");
            }else {
                holder.tvName.setText("已完成");
            }
        }
        if(!TextUtils.isEmpty(bean.getReturn_integral())){
            double v = Double.parseDouble(bean.getReturn_integral());
            holder.tvCount.setText(v/100+"");
        }
        if(!TextUtils.isEmpty(bean.getCdate())){
            holder.tvTime.setText(bean.getCdate());
        }

    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName,tvCount,tvTime;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_percent_twenty_four_custom);
            tvCount = (TextView) itemView.findViewById(R.id.tv_percent_twenty_four_custom_jili);
            tvTime = (TextView) itemView.findViewById(R.id.tv_percent_twenty_four_custom_time);

        }
    }
}
