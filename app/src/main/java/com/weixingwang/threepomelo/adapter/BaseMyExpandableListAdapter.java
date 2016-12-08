package com.weixingwang.threepomelo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.CreateShopActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class BaseMyExpandableListAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final List<String> listGroup;
    private final List<List<String>> listChild;

    public BaseMyExpandableListAdapter(Context context, List<String> listGroup, List<List<String>> listChild) {

        this.context = context;
        this.listGroup = listGroup;
        this.listChild = listChild;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChild.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.create_shop_exb_group_item,null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_create_shop_exb_group_item);
        tvName.setText(listGroup.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.create_shop_exb_child_item,null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_create_shop_exb_child_item);
        tvName.setText(listChild.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
