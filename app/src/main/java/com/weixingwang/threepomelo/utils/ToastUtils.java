package com.weixingwang.threepomelo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class ToastUtils {
    private static Toast toast;

    public static void toast(Context applicationContext, String s) {
        if(toast==null){
            toast = Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT);
        }
        toast.setText(s);
        toast.show();
    }
}
