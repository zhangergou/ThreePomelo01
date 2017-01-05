package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.MyOrderEvaluateActivity;
import com.weixingwang.threepomelo.bean.MyOrderBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderAdapter extends BaseRecyleAdapter {
    private HashMap<Integer, Boolean> map;
    private Context context;
    private List<?> reList;

    public MyOrderAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
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
        MyOrderBean.OrderListEntity bean = (MyOrderBean.OrderListEntity) reList.get(position);
        setData(holder,bean);
    }

    private void setData(MyHolder holder, MyOrderBean.OrderListEntity bean) {
       if(!TextUtils.isEmpty(bean.getPrice())){
           double v = Double.parseDouble(bean.getPrice());
           holder.price_one.setText(v/100+"");
           holder.price_two.setText(v/100+"");
       }
       if(!TextUtils.isEmpty(bean.getAddress())){
           holder.adress.setText(bean.getAddress());
       }
       if(!TextUtils.isEmpty(bean.getShop_name())){
           holder.shop_name.setText(bean.getShop_name());
       }
       if(!TextUtils.isEmpty(bean.getCdate())){
           holder.cdate_one.setText(bean.getCdate());
           holder.cdate_two.setText(bean.getCdate());
       }

       if(!TextUtils.isEmpty(bean.getStatus())){
           // holder.status.setText(list.get(position).getStatus());
           int status=Integer.valueOf(bean.getStatus());

           if(status==1) {
               holder.status.setText("待提交");
           }
           else if(status==2){
               holder.status.setText("待审核");
           }
           else if(status==3){
               holder.status.setText("已完成");
           }
           else if(status==-1){
               holder.status.setText("已拒绝");
           }
       }




    }

    class MyHolder extends RecyclerView.ViewHolder {
        public LinearLayout load_more;
        public LinearLayout lll;
        public LinearLayout ll;
        public TextView price_one;
        public TextView price_two;
        public TextView status;
        public TextView adress;
        public TextView shop_name;
        public TextView cdate_one;
        public TextView cdate_two;
        public MyHolder(View itemView) {
            super(itemView);
            load_more = (LinearLayout) itemView.findViewById(R.id.load_more);
            lll = (LinearLayout) itemView.findViewById(R.id.lll);
             ll= (LinearLayout) itemView.findViewById(R.id.ll);
            price_one= (TextView) itemView.findViewById(R.id.price_one);
            price_two= (TextView) itemView.findViewById(R.id.price_two);
            status = (TextView) itemView.findViewById(R.id.status);
            adress = (TextView) itemView.findViewById(R.id.address);
            shop_name= (TextView) itemView.findViewById(R.id.shop_name);
            cdate_one= (TextView) itemView.findViewById(R.id.cdate_one);
            cdate_two= (TextView) itemView.findViewById(R.id.cdate_two);
        }
    }

}
