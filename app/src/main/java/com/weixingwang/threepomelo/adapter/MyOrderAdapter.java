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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder>  {
    private final Context context;
    private final List<String> list;
    private HashMap<Integer, Boolean> map;
    private  One o;
    private LayoutInflater inflater;

    public MyOrderAdapter(Context context, List<String> list, HashMap<Integer, Boolean> map) {

        this.context = context;
        this.list = list;
        this.map = map;
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
                o.setOne(position);
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

        public MyHolder(View itemView) {
            super(itemView);
            load_more = (LinearLayout) itemView.findViewById(R.id.load_more);
            lll = (LinearLayout) itemView.findViewById(R.id.lll);
             ll= (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }
    public void setClickListener(One one){
        this.o=one;
    }

    public interface  One{
        void setOne(int postion);
    }
}
