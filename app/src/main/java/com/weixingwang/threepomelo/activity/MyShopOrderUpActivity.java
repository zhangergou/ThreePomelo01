package com.weixingwang.threepomelo.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.adapter.MyShopOrderUpRecylAdapter;
import com.weixingwang.threepomelo.bean.MyShopOrderManagerBean;
import com.weixingwang.threepomelo.bean.MyShopOrderUpBean;
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
public class MyShopOrderUpActivity extends BaseActivity implements BaseRecyleAdapter.OnClickItemView {
    private RecyclerView re;
    private List<MyShopOrderUpBean.OrdersEntity> list = new ArrayList<>();
    private MyShopOrderUpRecylAdapter recylAdapter;
    private int page = 1;
    private String s_date = "";
    private String e_date = "";
    private String keywords = "";
    private List<MyShopOrderUpBean.OrdersEntity> orders;
    private Dialog dialog;
    private EditText tvSearchStartTime;
    private EditText tvSearchEndTime;
    private EditText tvSearchPerson;

    @Override
    protected int getLayoutId() {
        return R.layout.my_shop_order_up_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.pull_my_shop_order_up_mannger);
        re = (RecyclerView) findViewById(R.id.recyle_my_shop_order_up_mannger);
        setTitle("订单提交");
        isShowBack(true);
        refrush(pull);
    }

    @Override
    protected void initData() {
        getData();
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.iv_my_shop_order_up_mannger_search).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_my_shop_order_up_mannger_search:
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

    @Override
    public void onItem(int postion) {
        MyShopOrderUpBean.OrdersEntity ordersEntity = list.get(postion);
        String id = ordersEntity.getId();
        Intent intent = new Intent(MyShopOrderUpActivity.this, MyShopOrderDataUpActivity.class);
        intent.putExtra("order_id", id);
        startActivity(intent);
    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("keywords", keywords);
        map.put("s_date", s_date);
        map.put("e_date", e_date);
        OkHttpUtils.get(UrlUtils.MY_SHOP_ORDER_DATA_LIST_Url, ShearPreferenceUtils.getToken(MyShopOrderUpActivity.this),
                MyShopOrderUpBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            MyShopOrderUpBean bean = (MyShopOrderUpBean) obj;
                            if (bean.isSuccess()) {
                                orders = bean.getOrders();
                                setData(orders);
                            } else {
                                ToastUtils.toast(MyShopOrderUpActivity.this, bean.getError_msg());
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

    public void setData(List<MyShopOrderUpBean.OrdersEntity> data) {

        list.addAll(data);

            recylAdapter = new MyShopOrderUpRecylAdapter(MyShopOrderUpActivity.this, re,
                    list, R.layout.my_shop_order_up_re_item, 1);
            re.setAdapter(recylAdapter);
            recylAdapter.setOnClickItemView(this);
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
        if (orders != null) {
            if (orders.size() < 20) {
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
