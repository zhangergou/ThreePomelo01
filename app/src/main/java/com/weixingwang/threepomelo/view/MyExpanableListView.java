package com.weixingwang.threepomelo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

import com.weixingwang.threepomelo.utils.ExpanableChildUtils;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class MyExpanableListView extends ExpandableListView {
    public MyExpanableListView(Context context) {
        super(context);
    }

    public MyExpanableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyExpanableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyExpanableListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

//    @Override
//    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
//        ExpanableChildUtils.setListViewHeightBasedOnChildren(this);
//        super.setOnGroupClickListener(onGroupClickListener);
//    }
//
//    @Override
//    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
//        ExpanableChildUtils.setListViewHeightBasedOnChildren(this);
//        super.setOnGroupCollapseListener(onGroupCollapseListener);
//    }
}
