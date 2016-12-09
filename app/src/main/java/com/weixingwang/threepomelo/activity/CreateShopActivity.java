package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.CreatShopRecyleAdapter;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;

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
    private List<String> listGroup = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private LinearLayout linType;
    private LinearLayout linSheng;
    private LinearLayout linCyte;
    private LinearLayout linQu;
    private LinearLayout linSellType;
    private ListView lvSheng;
    private PopupWindow popupWindow;
    private RecyclerView rvUpImage;
    private CreatShopRecyleAdapter recyleAdapter;
    private int image=0;
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

        rvUpImage = (RecyclerView) findViewById(R.id.rv_cread_shop_up_image);

        linType = (LinearLayout) findViewById(R.id.creat_lin_choese_type);
        linSheng = (LinearLayout) findViewById(R.id.creat_lin_choese_sheng);
        linCyte = (LinearLayout) findViewById(R.id.creat_lin_choese_cyte);
        linQu = (LinearLayout) findViewById(R.id.creat_lin_choese_qu);
        linSellType = (LinearLayout) findViewById(R.id.creat_lin_choese_sell_type);


//        exbv = (ExpandableListView) findViewById(R.id.cread_shop_expndble);
        setTitle("商家入驻");
        isShowBack(true);

    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            listGroup.add("数据" + i);
        }
        recyleAdapter = new CreatShopRecyleAdapter(this, rvUpImage, list,
                R.layout.create_shop_re_up_image_item, 1);
        rvUpImage.setAdapter(recyleAdapter);
        showCreateDialog();
    }

    private void showCreateDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);


        View viewPop = View.inflate(this, R.layout.pop_sheng_item, null);
        lvSheng = (ListView) viewPop.findViewById(R.id.regest_lv_sheng);
        popupWindow = DialogUtils.showPopupWindow(this, viewPop);
        lvSheng.setAdapter(new ArrayAdapter<String>(CreateShopActivity.this,
                android.R.layout.simple_list_item_1, listGroup));

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.creat_btn_up_log).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_licence).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_answer).setOnClickListener(this);
        findViewById(R.id.creat_btn_up_id).setOnClickListener(this);
        findViewById(R.id.lin_cread_shop_up_image).setOnClickListener(this);
        linType.setOnClickListener(this);
        linSheng.setOnClickListener(this);
        linCyte.setOnClickListener(this);
        linQu.setOnClickListener(this);
        linSellType.setOnClickListener(this);
        recyleAdapter.setOnClickItemView(new BaseRecyleAdapter.OnClickItemView() {
            @Override
            public void onItem(int postion) {
                list.remove(postion);
                recyleAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.creat_lin_choese_type:
                popupWindow.showAsDropDown(linType);
                break;
            case R.id.creat_lin_choese_sheng:
                popupWindow.showAsDropDown(linSheng);
                break;
            case R.id.creat_lin_choese_cyte:
                popupWindow.showAsDropDown(linCyte);
                break;
            case R.id.creat_lin_choese_qu:
                popupWindow.showAsDropDown(linQu);
                break;
            case R.id.creat_lin_choese_sell_type:
                popupWindow.showAsDropDown(linSellType);
                break;
            case R.id.creat_btn_up_log:
                imageView = ivLog;
                dialog.show();
                break;
            case R.id.creat_btn_up_licence:
                imageView = ivLicence;
                dialog.show();
                break;
            case R.id.creat_btn_up_answer:
                imageView = ivAnswer;
                dialog.show();
                break;
            case R.id.lin_cread_shop_up_image:
                image=1;
                dialog.show();
                break;
            case R.id.creat_btn_up_id:
                imageView = ivId;
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
        CreamerAndAlbumUtils.openCramererFile(this, 2);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if(image==1){

                String uri = CreamerAndAlbumUtils.getPhoto(this, requestCode, data, photoUri, 1);
                list.add(list.size(),uri);
                recyleAdapter.notifyDataSetChanged();
                image=0;
            }else{
                CreamerAndAlbumUtils.doPhoto(this, requestCode, data, imageView, photoUri, 1);
            }

        }
    }
}
