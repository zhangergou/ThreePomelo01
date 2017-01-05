package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.AddAddressBean;
import com.weixingwang.threepomelo.bean.AddressListBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class AddAdressReclAdapter extends BaseRecyleAdapter{
    private final Context context;
    private List<?> reList;

    public AddAdressReclAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        return new MyViewHolder(inflate);
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) mholder;
        AddressListBean.ListAddressEntity bean= (AddressListBean.ListAddressEntity) reList.get(position);
       setData(myViewHolder,bean);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickChoeseView.onChoese(position);
            }
        });
        myViewHolder.linEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEditView.onEdit(position);
            }
        });
        myViewHolder.linDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDeleteView.onDelete(position);
            }
        });

    }

    private void setData(MyViewHolder myViewHolder, AddressListBean.ListAddressEntity bean) {
        if(!TextUtils.isEmpty(bean.getPerson())){
            myViewHolder.tvHomeGoodsName.setText(bean.getPerson());
        }
        if(!TextUtils.isEmpty(bean.getPhone())){
            myViewHolder.tvPhone.setText(bean.getPhone());
        }
        if(!TextUtils.isEmpty(bean.getAddress())){
            myViewHolder.tvAddress.setText(bean.getAddress());
        }
        if(!TextUtils.isEmpty(bean.getDefaultX())){
            if(TextUtils.equals(bean.getDefaultX(),"1")){
                myViewHolder.ivChoese.setSelected(true);
                myViewHolder.tvChoese.setTextColor(context.getResources().getColor(R.color.blueTabText));
            }
            if(TextUtils.equals(bean.getDefaultX(),"-1")){
                myViewHolder.ivChoese.setSelected(false);
                myViewHolder.tvChoese.setTextColor(context.getResources().getColor(R.color.grayThree));
            }
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHomeGoodsName,tvPhone,tvAddress,tvChoese;
        private ImageView ivChoese;
        private  LinearLayout linEdit,linDelete;
        private  CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHomeGoodsName = (TextView) itemView.findViewById(R.id.tv_add_address_name_item);
            linEdit = (LinearLayout) itemView.findViewById(R.id.lin_add_adress_edit_item);
            linDelete = (LinearLayout) itemView.findViewById(R.id.lin_add_adress_delete_item);
            cardView = (CardView) itemView.findViewById(R.id.cardview_add_address_choese_item);
            tvPhone= (TextView) itemView.findViewById(R.id.tv_add_address_phone_item);
            tvAddress= (TextView) itemView.findViewById(R.id.tv_add_address_address_item);
            tvChoese= (TextView) itemView.findViewById(R.id.tv_add_adress_choese_item);
            ivChoese=(ImageView) itemView.findViewById(R.id.iv_add_adress_choese_item);
//            ivPlus=(ImageView) itemView.findViewById(R.id.bus_iv_plus);
//            ivDelete=(ImageView) itemView.findViewById(R.id.bus_iv_delete);
        }
    }
}
