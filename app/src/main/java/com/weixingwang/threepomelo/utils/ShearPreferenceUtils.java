package com.weixingwang.threepomelo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/10/22 0022.
 */
public class ShearPreferenceUtils {

    private static SharedPreferences sp;

    public static void putInt(Context context, int pos){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sp.edit().putInt("count",pos).commit();
    }
    public static int getInt(Context context){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        int count = sp.getInt("count", 0);
        return count;
    }
    public static void putToken(Context context, String token){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sp.edit().putString("token",token).commit();
    }
    public static String getToken(Context context){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        String token = sp.getString("token", null);
        return token;
    }
    public static void putName(Context context, String name){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sp.edit().putString("name",name).commit();
    }
    public static String getName(Context context){
        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
        String token = sp.getString("name", null);
        return token;
    }
}
