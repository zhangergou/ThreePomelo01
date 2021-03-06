package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyTeamVIPBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class MyVIPFragmentRecyAdapter extends BaseRecyleAdapter {


    private List<?> reList;

    public MyVIPFragmentRecyAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        MyTeamVIPBean.MyTeamListEntity bean= (MyTeamVIPBean.MyTeamListEntity) reList.get(position);
       setData(holder,bean);
    }

    private void setData(MyHolder holder, MyTeamVIPBean.MyTeamListEntity bean) {
        if(!TextUtils.isEmpty(bean.getRel_name())){
            holder.tvName.setText(bean.getRel_name());
        }
        if(!TextUtils.isEmpty(bean.getMobile())){
            holder.tvPhone.setText(bean.getMobile());
        }
        if(!TextUtils.isEmpty(bean.getTeam_total())){
            double v = Double.parseDouble(bean.getTeam_total());
            holder.tvMoney.setText(v/100+"");
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName,tvPhone,tvMoney;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_my_vip_name);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_my_vip_phone);
            tvMoney = (TextView) itemView.findViewById(R.id.tv_my_vip_take_money);

        }
    }
}
