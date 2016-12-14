package com.weixingwang.threepomelo.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public class ThreeAreaUtils {
    public static void getArea(Context context, ListView lv, List<String> list){
        lv.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,list));
    }
}
