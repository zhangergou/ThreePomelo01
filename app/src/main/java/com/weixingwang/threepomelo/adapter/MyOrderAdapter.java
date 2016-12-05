package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.MyOrderBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/2.
 */
public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder>  {
   private Context mcontent;
    private ArrayList<String> list;
    private LayoutInflater inflater;
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate=inflater.inflate(R.layout.item_my_order,null);
        parent.addView(inflate);
        return new MyHolder(inflate);
    }
  public MyOrderAdapter(Context context,ArrayList<String> list){
      this.mcontent=context;
      this.list=list;
      this.inflater=LayoutInflater.from(context);
  }
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
      holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

       private TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
