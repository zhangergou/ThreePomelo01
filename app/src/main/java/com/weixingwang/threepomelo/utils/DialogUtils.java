package com.weixingwang.threepomelo.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.weixingwang.threepomelo.R;


/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class DialogUtils {

    public static Dialog showCenter(Context context, View view, boolean touch) {
        Dialog dialog = new Dialog(context, R.style.dialog_style_one);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        attributes.width = (int) (metrics.widthPixels * 0.8);
        attributes.height = (int) (metrics.heightPixels * 0.4);
        attributes.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        attributes.dimAmount = 0.5f;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.gravity = Gravity.CENTER;
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(touch);
        return dialog;
    }

    public static Dialog showBottm(Context context, View view, boolean touch) {
        Dialog dialog = new Dialog(context, R.style.dialog_style);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
//        attributes.width = (int) (metrics.widthPixels * 1);
//        attributes.height = (int) (metrics.heightPixels * 0.8);
        attributes.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        attributes.dimAmount = 0.5f;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.gravity = Gravity.BOTTOM;
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(touch);
        dialog.show();
        return dialog;
    }

    public static Dialog diaBottm(Context context, View view, boolean touch) {

        Dialog dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
//        attributes.width = (int) (metrics.widthPixels * 1);
//        attributes.height = (int) (metrics.heightPixels * 0.8);
        attributes.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        attributes.dimAmount = 0.5f;
//        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM;
        attributes.y=20;
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(touch);
        return dialog;

    }

    public static void showAlertDia(final Context context) {
        new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("亲,要退出吗?")
                .setPositiveButton("狠心退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        System.exit(0);
                    }
                })
                .setNegativeButton("在玩一会", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
    public static ProgressDialog showLoading(Context context,String masg) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage(masg);
        pd.show();
        return pd;
    }
    //自定义位置
//    public static Dialog autoDialog(Context context,View view){
//        Dialog dialog = new Dialog(context, R.style.two);
//        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
//        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
//        attributes.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//        attributes.dimAmount = 0.5f;
//        attributes.y=-800;
//        attributes.x=100;
//
//        dialog.setContentView(view);
//        dialog.setCanceledOnTouchOutside(true);
//        return dialog;
//    }
    public static PopupWindow showPopupWindow(Context context,View view){
        PopupWindow pw=new PopupWindow(context);
        ColorDrawable dw = new ColorDrawable(0xfcfcfc);
        pw.setBackgroundDrawable(dw);
        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setHeight(LayoutParams.FILL_PARENT);
        pw.setWidth(LayoutParams.WRAP_CONTENT);
        pw.setTouchable(true);
        pw.setOutsideTouchable(true);
        return pw;
    }

}
