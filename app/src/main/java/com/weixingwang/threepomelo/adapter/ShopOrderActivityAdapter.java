package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyOrderBean;
import java.util.ArrayList;
/**
 * Created by Administrator on 2016/12/15.
 */
public class ShopOrderActivityAdapter extends RecyclerView.Adapter<ShopOrderActivityAdapter.MyHolder>  {
    private final Context context;
    private ArrayList<MyOrderBean.OrderListBean> list;
    private LayoutInflater inflater;
    private ShopOrderActivityAdapter adapter;
    public ShopOrderActivityAdapter(Context context, ArrayList<MyOrderBean.OrderListBean> list) {
        this.context = context;
        this.list = list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context,R.layout.item_shop_order_layout, null);
        parent.addView(inflate);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        final MyHolder myHolder= (MyHolder) holder;
        holder.price_one.setText(list.get(position).getPrice());
        holder.price_two.setText(list.get(position).getPrice());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        public TextView price_one;
        public TextView price_two;
        public MyHolder(View itemView) {
            super(itemView);
            price_one= (TextView) itemView.findViewById(R.id.price_one);
            price_two= (TextView) itemView.findViewById(R.id.price_two);
        }
    }
}
