package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.BitmapUtils;
import com.weixingwang.threepomelo.utils.BytesToFileUtils;
import com.weixingwang.threepomelo.utils.DataCleanManager;
import com.weixingwang.threepomelo.utils.ToastUtils;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class CreatShopRecyleAdapter extends BaseRecyleAdapter {
    private Context context;
    private List<?> reList;
    private static Handler handler=new Handler(Looper.getMainLooper());
    public CreatShopRecyleAdapter(Context context, RecyclerView recl, List<?> reList, int layoutId, int clum) {
        super(context, recl, reList, layoutId, clum);
        this.context = context;
        this.reList = reList;
    }

    @Override
    protected RecyclerView.ViewHolder getHolder(View inflate) {
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    protected void initData(RecyclerView.ViewHolder mholder, final int position) {
        final MyHolder holder = (MyHolder) mholder;
        if(reList.size()>0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap getimage = BitmapUtils.getimage(reList.get(position).toString());
//                    Bitmap bitmap = BitmapUtils.getBitmapForPath(reList.get(position).toString());
                    Bitmap comp = BitmapUtils.comp(getimage);
                    final Bitmap image = BitmapUtils.compressImage(comp);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {


                            File file = BytesToFileUtils.getFile(BitmapUtils.getBitmapbyte(image), context.getFilesDir().getAbsolutePath(), "/1.png");
                            try {

                                String orFilesSize = DataCleanManager.getAutoFileOrFilesSize(file.getAbsolutePath());
                                ToastUtils.toast(context,"orFilesSize="+orFilesSize);
                                holder.ivName.setImageBitmap(image);
                                ToastUtils.toast(context, "以选中");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }).start();
//            Glide.with(context).load(reList.get(position).toString()).into(holder.ivName);
            holder.tvName.setText(DataCleanManager.getFileName(reList.get(position).toString()));
            holder.tvSize.setText(DataCleanManager.getAutoFileOrFilesSize(reList.get(position).toString()));
        }

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemView.onItem(position);
            }
        });
    }

    class MyHolder extends RecyclerView.ViewHolder{


        private ImageView ivName;
        private  ImageView ivDelete;
        private  TextView tvName;
        private  TextView tvSize;

        public MyHolder(View itemView) {
            super(itemView);
            ivName = (ImageView) itemView.findViewById(R.id.creat_shop_item_up_iv);
            ivDelete = (ImageView) itemView.findViewById(R.id.creat_shop_item_delete_iv);
            tvName = (TextView) itemView.findViewById(R.id.creat_shop_item_up_iv_name);
            tvSize = (TextView) itemView.findViewById(R.id.creat_shop_item_up_iv_size);
        }
    }
}
