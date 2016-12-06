package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import java.util.ArrayList;
public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyHolder>  {
   private Context mcontent;
    private ArrayList<String> list;
    private LayoutInflater inflater;
    private LinearLayout linearLayout;
   private boolean visibility_Flag=false;
    private LinearLayout load_more;
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
    public void onBindViewHolder(MyHolder holder, final int position) {
      holder.tv.setText(list.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visibility_Flag){
                    load_more.setVisibility(View.INVISIBLE);
                    visibility_Flag = false;
                } else {
                    load_more.setVisibility(View.VISIBLE);
                    visibility_Flag =true;
                }
                Toast.makeText(mcontent, position+"position=", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
       private TextView tv;
        private LinearLayout linearLayout;
        public MyHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.linearLayout);
            load_more= (LinearLayout) itemView.findViewById(R.id.load_more);

        }
    }
}
