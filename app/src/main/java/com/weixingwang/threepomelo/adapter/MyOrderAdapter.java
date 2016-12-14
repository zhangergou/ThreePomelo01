package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder>  {
    private final Context context;
    private ArrayList<MyOrderBean.OrderListBean> list;
    private HashMap<Integer, Boolean> map;
    private  One one;
    private LayoutInflater inflater;
    private MyOrderAdapter adapter;
    public MyOrderAdapter(Context context, ArrayList<MyOrderBean.OrderListBean> list, HashMap<Integer, Boolean> map) {
        this.context = context;
        this.list = list;
        this.map = map;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_my_order, null);
        parent.addView(inflate);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        final MyHolder myHolder= (MyHolder) holder;
        holder.price_one.setText(list.get(position).getPrice());
        holder.price_two.setText(list.get(position).getPrice());
        holder.adress.setText(list.get(position).getAddress());
        holder.shop_name.setText(list.get(position).getShop_name());
        holder.cdate_one.setText(list.get(position).getCdate());
        holder.cdate_two.setText(list.get(position).getCdate());
        // holder.status.setText(list.get(position).getStatus());
        int status=Integer.valueOf(list.get(position).getStatus());

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

        if(map.get(position)){
            myHolder.load_more.setVisibility(View.VISIBLE);
        }else{

            myHolder.load_more.setVisibility(View.GONE);
        }
        myHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MyOrderEvaluateActivity.class);
               context.startActivity(intent);
            }
        });
        myHolder.lll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setOne(position);
            }
        });
    }
    @Override
    public int getItemCount() {

        return list.size();
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
    public void setClickListener(One one){
        this.one=one;
    }
    public interface  One{
        void setOne(int postion);
    }
}
