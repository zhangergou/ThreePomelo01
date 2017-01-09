package com.weixingwang.threepomelo.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.MyShopOrderManagerRecylAdapter;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.MyShopBean;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.TimeUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopOrderManagerActivity extends BaseActivity {

    private RecyclerView re;
    private MyShopOrderManagerRecylAdapter recylAdapter;
    private int page = 1;
    private String s_date = "";
    private String e_date = "";
    private String keywords = "";
    private List<MyShopOrderManagerBean.ListOrdersEntity> list_orders;
    private List<MyShopOrderManagerBean.ListOrdersEntity> list = new ArrayList<>();
    private TextView tvTotal;
    private Dialog dialog;
    private EditText tvSearchStartTime;
    private EditText tvSearchEndTime;
    private EditText tvSearchPerson;

    @Override
    protected int getLayoutId() {
        return R.layout.my_shop_order_manager_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.pull_my_shop_order_mannger);
        re = (RecyclerView) findViewById(R.id.recyle_my_shop_order_mannger);
        tvTotal = (TextView) findViewById(R.id.tv_my_shop_order_manager_total);
        setTitle("订单管理");
        isShowBack(true);
        refrush(pull);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String total = intent.getStringExtra("total");
        if (!TextUtils.isEmpty(total)) {
            tvTotal.setText(total);
        }

        getData();

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.iv_my_shop_order_add_order).setOnClickListener(this);
        findViewById(R.id.iv_my_shop_order_search_order).setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_my_shop_order_add_order:
                startActivity(new Intent(MyShopOrderManagerActivity.this, MyShopOrderManagerAddActivity.class));
                break;
            case R.id.iv_my_shop_order_search_order:
                search();
                break;
            case R.id.btn_search:
                searchData();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;

            default:
                super.onClick(v);
                break;
        }
    }


    private void search() {
        View inflate = View.inflate(this, R.layout.shop_search_dialog_layout, null);
        inflate.findViewById(R.id.btn_search).setOnClickListener(this);
        inflate.findViewById(R.id.btn_cancel).setOnClickListener(this);
        tvSearchStartTime = (EditText) inflate.findViewById(R.id.et_search_start_time);
        tvSearchEndTime = (EditText) inflate.findViewById(R.id.et_search_end_time);
        tvSearchPerson = (EditText) inflate.findViewById(R.id.et_search_person_name);
        dialog = DialogUtils.diaBottm(this, inflate, true);
        dialog.show();
    }

    private void getData() {

        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("keywords", keywords);
        map.put("s_date", s_date);
        map.put("e_date", e_date);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_Url, ShearPreferenceUtils.getToken(MyShopOrderManagerActivity.this),
                MyShopOrderManagerBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            MyShopOrderManagerBean bean = (MyShopOrderManagerBean) obj;
                            if (bean.isSuccess()) {
                                list_orders = bean.getList_orders();
                                setData(list_orders);
                            } else {
                                ToastUtils.toast(MyShopOrderManagerActivity.this, bean.getError_msg());
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

    private void setData(List<MyShopOrderManagerBean.ListOrdersEntity> data) {

        list.addAll(data);
        recylAdapter = new MyShopOrderManagerRecylAdapter(MyShopOrderManagerActivity.this, re,
                list, R.layout.my_shop_order_re_item, 1);
        re.setAdapter(recylAdapter);
        recylAdapter.setOnClickDeleteView(new BaseRecyleAdapter.OnClickDeleteView() {
            @Override
            public void onDelete(int postion) {
                deleteData(postion);
            }
        });
    }

    private void deleteData(int postion) {
        MyShopOrderManagerBean.ListOrdersEntity listOrdersEntity = list_orders.get(postion);
        String oid = listOrdersEntity.getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("order_id", oid);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_DELETE_Url, ShearPreferenceUtils.getToken(MyShopOrderManagerActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(MyShopOrderManagerActivity.this, "删除成功");
                                list.clear();
                                page = 1;
                                getData();
                            } else {
                                ToastUtils.toast(MyShopOrderManagerActivity.this, bean.getError_msg());
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
    protected void onRestart() {
        super.onRestart();
        list.clear();
        page = 1;
        getData();
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        list.clear();
        page = 1;
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if (list_orders != null) {
            if (list_orders.size() < 20) {
                ToastUtils.toast(this, "已加载完毕");
            } else {
                page++;
                getData();
            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }

    private void searchData() {
        String startTime = tvSearchStartTime.getText().toString().trim();
        String endTime = tvSearchEndTime.getText().toString().trim();
        String personN = tvSearchPerson.getText().toString().trim();
        if (!TextUtils.isEmpty(personN) || !TextUtils.isEmpty(startTime) || !TextUtils.isEmpty(endTime)) {
            if (!TextUtils.isEmpty(startTime)) {
                if (!TimeUtils.valiDateTimeWithLongFormat(startTime)) {
                    ToastUtils.toast(this, "时间格式不正确,请重新输入!");
                    tvSearchStartTime.setText("");
                    return;
                } else {
                    s_date = startTime;
                }
            }
            if (!TextUtils.isEmpty(personN)) {
                keywords = personN;
            }
            if (!TextUtils.isEmpty(endTime)) {
                if (!TimeUtils.valiDateTimeWithLongFormat(endTime)) {
                    ToastUtils.toast(this, "时间格式不正确,请重新输入!");
                    tvSearchStartTime.setText("");
                    return;
                } else {
                    s_date = endTime;
                }
            }
            getData();
            dialog.dismiss();
        } else {
            ToastUtils.toast(this, "搜索条件不能为空");
            return;
        }
    }
}
