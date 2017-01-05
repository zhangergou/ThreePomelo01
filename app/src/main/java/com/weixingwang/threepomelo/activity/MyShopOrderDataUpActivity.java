package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.MyShopOrderDataUpDiaRecyAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.MyShopOrderBean;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;
import com.weixingwang.threepomelo.utils.CreamerAndAlbumUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderDataUpActivity extends BaseActivity {

    private String order_id;
    private TextView tvTotalMoney;
    private TextView tvPayMoney;
    private TextView tvOrderCount;
    private TextView tvBankName;
    private TextView tvBankCardName;
    private TextView tvOrderStus;
    private TextView tvOrderTime;
    private TextView tvOrderRmark;
    private Button btnOk;
    private Button btnNo;
    private RecyclerView reDia;
    private Dialog dialog;
    private ImageView ivPic;
    private List<MyShopOrderBean.OrderListEntity> order_list;
    private List<MyShopOrderBean.OrderListEntity> list=new ArrayList<>();
    private MyShopOrderDataUpDiaRecyAdapter diaRecyAdapter;
    private Dialog dialogBtom;
    private Uri photoUri;
    private HashMap<Integer, String> putString = new HashMap<>();
    private HashMap<String, File> putFile = new HashMap<>();
    private int pos=-1;
    private String orderId;
    private ImageView ivUpButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detailss;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.my_shop_order_infor_pull);
        refrush(pull);
        tvTotalMoney = (TextView) findViewById(R.id.tv_my_shop_order_infor_total_money);
        tvPayMoney = (TextView) findViewById(R.id.tv_my_shop_order_infor_pay_money);
        tvOrderCount = (TextView) findViewById(R.id.tv_my_shop_order_infor_order_count);
        tvBankName = (TextView) findViewById(R.id.tv_my_shop_order_infor_bank_name);
        tvBankCardName = (TextView) findViewById(R.id.tv_my_shop_order_infor_person_name);
        tvOrderStus = (TextView) findViewById(R.id.tv_my_shop_order_infor_order_stutas);
        tvOrderTime = (TextView) findViewById(R.id.tv_my_shop_order_infor_person_time);
        tvOrderRmark = (TextView) findViewById(R.id.tv_my_shop_order_infor_person_remark);
        btnOk = (Button) findViewById(R.id.tv_my_shop_order_infor_ok);
        btnNo = (Button) findViewById(R.id.tv_my_shop_order_infor_no);
        ivPic = (ImageView) findViewById(R.id.iv_my_shop_order_infor_person_pic);
        ivUpButton = (ImageView) findViewById(R.id.iv_my_shop_order_infor_up_pic);
        setTitle("订单详情");
        isShowBack(true);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        initDia();
        getData();
    }

    private void initDia() {
        View inflate = View.inflate(this, R.layout.order_data_up_dia_item, null);
        reDia = (RecyclerView) inflate.findViewById(R.id.tv_my_shop_order_infor_dia_recy);
        inflate.findViewById(R.id.tv_my_shop_order_infor_dia_iv).setOnClickListener(this);
        dialog = DialogUtils.showCenter(this, inflate, false);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.tv_my_shop_order_infor_order_infor).setOnClickListener(this);
        ivUpButton.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

    private void getData() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", order_id);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_DATA_Url, ShearPreferenceUtils.getToken(MyShopOrderDataUpActivity.this),
                MyShopOrderBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            MyShopOrderBean bean = (MyShopOrderBean) obj;
                            if (bean.isSuccess()) {

                                setData(bean);
                            } else {
                                ToastUtils.toast(MyShopOrderDataUpActivity.this, bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        netError();
                    }
                }, map);
    }

    private void setData(MyShopOrderBean data) {
        MyShopOrderBean.OrderEntity order = data.getOrder();
        orderId = order.getId();
        order_list = data.getOrder_list();
        if (order != null) {
            if (!TextUtils.isEmpty(order.getTotal())) {
                double v = Double.parseDouble(order.getTotal());
                tvTotalMoney.setText(v / 100 + "");


                tvPayMoney.setText(v / 10000 + "");
            }
            if (!TextUtils.isEmpty(order.getNum())) {
                tvOrderCount.setText(order.getNum());
            }
            String status = order.getStatus();
            if (!TextUtils.isEmpty(order.getStatus())) {
                if (TextUtils.equals(status, "1")) {
                    tvOrderStus.setText("未提交");

                    btnOk.setVisibility(View.VISIBLE);
                    btnNo.setVisibility(View.VISIBLE);

                }
                if (TextUtils.equals(status, "2")) {
                    tvOrderStus.setText("审核中");
                    tvOrderRmark.setEnabled(false);
                    tvOrderRmark.setFocusable(false);
                    ivUpButton.setEnabled(false);
                    ivUpButton.setFocusable(false);
                }
                if (TextUtils.equals(status, "3")) {
                    tvOrderStus.setText("已完成");
                    tvOrderRmark.setEnabled(false);
                    tvOrderRmark.setFocusable(false);
                    ivUpButton.setEnabled(false);
                    ivUpButton.setFocusable(false);
                }
                if (TextUtils.equals(status, "-1")) {
                    tvOrderStus.setText("审核拒绝");
                }
            }
            if (!TextUtils.isEmpty(order.getSdate())) {
                tvOrderTime.setText(order.getSdate());
            }
            if (!TextUtils.isEmpty(order.getRemark())) {
                tvOrderRmark.setText(order.getRemark());
            }
            if (!TextUtils.isEmpty(order.getPic())) {
                Glide.with(this).load(UrlUtils.MAIN_Url + "/upload/order_pic/" + order.getPic())
                        .into(ivPic);
            }

        }
        list.clear();
        if (order_list != null && order_list.size() > 0) {
            list.addAll(order_list);
        }
        diaRecyAdapter = new MyShopOrderDataUpDiaRecyAdapter(MyShopOrderDataUpActivity.this,
                reDia, list, R.layout.my_shop_order_re_item, 1);
        reDia.setAdapter(diaRecyAdapter);
        diaRecyAdapter.setOnClickDeleteView(new BaseRecyleAdapter.OnClickDeleteView() {
            @Override
            public void onDelete(int postion) {
                deleteData(postion);
            }
        });

    }

    private void deleteData(int postion) {
        MyShopOrderBean.OrderListEntity orderListEntity = order_list.get(postion);
        String oid = orderListEntity.getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", oid);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_DELETE_Url, ShearPreferenceUtils.getToken(MyShopOrderDataUpActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(MyShopOrderDataUpActivity.this, "删除成功");
                                getData();
                            } else {
                                ToastUtils.toast(MyShopOrderDataUpActivity.this, bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                }, map);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_my_shop_order_infor_order_infor:
                dialog.show();
                break;
            case R.id.tv_my_shop_order_infor_ok:
                    upData();
                break;
            case R.id.tv_my_shop_order_infor_no:
                finish();
                break;
            case R.id.iv_my_shop_order_infor_up_pic:
                pos=0;
                putString.put(0,"pic");
                showDia();
                break;
            case R.id.tv_my_shop_order_infor_dia_iv:
                dialog.dismiss();
                break;
            case R.id.cread_log_icon_dia:
                //打开相机
                dialogBtom.dismiss();
                openCramerer();
                break;
            case R.id.loca_icon_log_dia:
                //打开相册
                dialogBtom.dismiss();
                openCramererFile();
                break;
            case R.id.dialog_cancle_log:
                dialogBtom.dismiss();

                break;
            default:
                super.onClick(v);
                break;
        }
    }



    private void showDia() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialogBtom = DialogUtils.diaBottm(this, inflate, true);
        dialogBtom.show();
    }

    private void openCramererFile() {
        CreamerAndAlbumUtils.openCramererFile(this, 5);
    }

    private void openCramerer() {
        photoUri = CreamerAndAlbumUtils.openCramerer(this, 5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            for (int i = 0; i < putString.size(); i++) {
                Set<Map.Entry<Integer, String>> entries = putString.entrySet();
                Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, String> next = iterator.next();
                    Integer key = next.getKey();
                    if (pos == key) {
                        HashMap<String, File> hashMap = CreamerAndAlbumUtils.putMap(this, requestCode, data, putString.get(key), ivPic, photoUri, 1);
                        putFile.putAll(hashMap);
                    }

                }
            }

        }
    }

    private void upData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", orderId);
        OkHttpUtils.putImages(UrlUtils.TI_JIAO_ORDER_Url, ShearPreferenceUtils.getToken(MyShopOrderDataUpActivity.this),
                LoginBean.class,putFile, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(MyShopOrderDataUpActivity.this, "提交成功");
                                getData();
                            } else {
                                ToastUtils.toast(MyShopOrderDataUpActivity.this, bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                }, map);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getData();
        super.onRefresh(pullToRefreshLayout);
    }
}
