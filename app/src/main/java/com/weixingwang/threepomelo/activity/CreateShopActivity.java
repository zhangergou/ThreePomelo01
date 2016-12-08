package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseMyExpandableListAdapter;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.ExpanableChildUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6 0006.
 */
public class CreateShopActivity extends BaseActivity {

    private Dialog dialog;
    private Uri photoUri;
    private ImageView imageView;
    private ImageView ivLog;
    private ImageView ivLicence;
    private ImageView ivAnswer;
    private ImageView ivId;
    private ExpandableListView exbv;
    private List<List<String>> listChild=new ArrayList<>();
    private List<String> listGroup=new ArrayList<>();
    private BaseMyExpandableListAdapter adapterEx;

    @Override
    protected int getLayoutId() {
        return R.layout.create_shop_layout;
    }

    @Override
    protected void initView() {
        ivLog = (ImageView) findViewById(R.id.create_iv_log_icon);
        ivLicence = (ImageView) findViewById(R.id.create_iv_licence_icon);
        ivAnswer = (ImageView) findViewById(R.id.create_iv_answer_icon);
        ivId = (ImageView) findViewById(R.id.create_iv_id_icon);
        exbv = (ExpandableListView) findViewById(R.id.cread_shop_expndble);
        setTitle("商家入驻");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < ArrayUtils.createShop.length; i++) {
            listGroup.add( ArrayUtils.createShop[i]);
        }
        for (int i = 0; i < listGroup.size(); i++) {
            List<String> li=new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                li.add("数据"+j);
            }
            listChild.add(li);
        }
        showCreateDialog();
        adapterEx = new BaseMyExpandableListAdapter(CreateShopActivity.this, listGroup, listChild);
        exbv.setAdapter(adapterEx);

    }

    private void showCreateDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.creat_btn_up_log).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_licence).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_answer).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_id).setOnClickListener(this);
        exbv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ExpandableListAdapter adapter = parent.getExpandableListAdapter();
                String child = (String) adapter.getChild(groupPosition, childPosition);

                listGroup.remove(groupPosition);
                listGroup.add(groupPosition,child);
                if(parent.isGroupExpanded(groupPosition)){
                    parent.collapseGroup(groupPosition);
                }

                Toast.makeText(CreateShopActivity.this, "child="+child, Toast.LENGTH_SHORT).show();
                adapterEx.notifyDataSetChanged();
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.creat_btn_up_log:
                imageView=ivLog;
                dialog.show();
                break;
            case R.id.creat_btn_up_licence:
                imageView=ivLicence;
                dialog.show();
                break;
            case R.id.creat_btn_up_answer:
                imageView=ivAnswer;
                dialog.show();
                break;
            case R.id.creat_btn_up_id:
                imageView=ivId;
                dialog.show();
                break;
            case R.id.cread_log_icon_dia:
                //打开相机
                dialog.dismiss();
                openCramerer();
                break;
            case R.id.loca_icon_log_dia:
                //打开相册
                dialog.dismiss();
                openCramererFile();
                break;
            case R.id.dialog_cancle_log:
                dialog.dismiss();

                break;
            default:
                super.onClick(v);
                break;
        }

    }
    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this,2);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            CreamerAndAlbumUtils.doPhoto(this,requestCode,data,imageView,photoUri,1);
        }
    }
}
