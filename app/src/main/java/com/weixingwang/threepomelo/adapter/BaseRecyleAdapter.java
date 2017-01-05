package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public abstract class BaseRecyleAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<?> reList;
    private int layoutId;
    public OnClickItemView onClickItemView;
    public OnClickChoeseView onClickChoeseView;
    public OnClickEditView onClickEditView;
    public OnClickDeleteView onClickDeleteView;
    public OnClickPlusView onClickPlusView;
    public OnClickMusView onClickMusView;


    public BaseRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        this.context = context;
        this.reList = reList;
        this.layoutId = layoutId;
        if(clum<1){
            clum=1;
        }
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(clum,
                StaggeredGridLayoutManager.VERTICAL);
        recl.setLayoutManager(gridLayoutManager);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(layoutId, null);
        parent.addView(inflate);
        return getHolder(inflate);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        initData(holder,position);
    }

    @Override
    public int getItemCount() {
        return reList.size();
    }
    protected abstract RecyclerView.ViewHolder getHolder(View inflate);
    protected abstract void initData(RecyclerView.ViewHolder mholder, int position);
    public void setOnClickItemView(OnClickItemView onClickItemView){
        this.onClickItemView = onClickItemView;
    }
    public interface OnClickItemView{
        void onItem(int postion);
    }

    public void setOnClickChoeseView(OnClickChoeseView onClickChoeseView){

        this.onClickChoeseView = onClickChoeseView;
    }
    public interface OnClickChoeseView{
        void onChoese(int postion);
    }

    public void setOnClickEditView(OnClickEditView onClickEditView){
        this.onClickEditView = onClickEditView;
    }
    public interface OnClickEditView{
            void onEdit(int postion);
    }

    public void setOnClickDeleteView(OnClickDeleteView onClickDeleteView){

        this.onClickDeleteView = onClickDeleteView;
    }
    public interface OnClickDeleteView{
        void onDelete(int postion);
    }

    public void setOnClickPlusView(OnClickPlusView onClickPlusView){

        this.onClickPlusView = onClickPlusView;
    }
    public interface OnClickPlusView{
        void onPlus(int postion);
    }

    public void setOnClickMusView(OnClickMusView onClickMusView){


        this.onClickMusView = onClickMusView;
    }
    public interface OnClickMusView{
        void onMus(int postion);
    }
}
