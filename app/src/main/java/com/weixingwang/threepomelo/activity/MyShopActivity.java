package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.HomeShopTypeBean;
import com.weixingwang.threepomelo.bean.MyAllInBean;
import com.weixingwang.threepomelo.bean.MyShopBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.CircleImageView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class MyShopActivity extends BaseActivity {

    private CircleImageView ivLog;
    private TextView tvShopName,tvShopId,tvShopType,tvMoney,tvSunCount;
    private double dou;

    @Override
    protected int getLayoutId() {
        return R.layout.my_shop_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.my_shop_pull);
        refrush(pull);
        ivLog = (CircleImageView) findViewById(R.id.my_shop_icon);
        tvShopName = (TextView) findViewById(R.id.my_shop_tv_name);
        tvShopId = (TextView) findViewById(R.id.my_shop_tv_id);
         tvShopType = (TextView) findViewById(R.id.my_shop_tv_putong);
         tvMoney = (TextView) findViewById(R.id.my_shop_tv_get_money);
         tvSunCount = (TextView) findViewById(R.id.my_shop_tv_sun_count);
        setTitle("我的店铺");
        isShowBack(true);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        getData();
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.rla_my_shop_order_mannger).setOnClickListener(this);
        findViewById(R.id.vip_lin_my_shop_order_up).setOnClickListener(this);
        findViewById(R.id.vip_lin_my_shop_infor).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rla_my_shop_order_mannger:
                Intent intent = new Intent(MyShopActivity.this, MyShopOrderManagerActivity.class);
                intent.putExtra("total",dou/100+"");
                startActivity(intent);
                break;
            case R.id.vip_lin_my_shop_order_up:
                startActivity(new Intent(MyShopActivity.this,MyShopOrderUpActivity.class));
                break;
            case R.id.vip_lin_my_shop_infor:
                startActivity(new Intent(MyShopActivity.this,MyShopDataActivity.class));
                break;
            default:
                Intent inten = new Intent(MyShopActivity.this, MainActivity.class);
                inten.putExtra("frag",5);
                startActivity(inten);
                finish();
//                super.onClick(v);
                break;
        }
    }

    private void getData() {
        showLoading();
//        HashMap<String, String> map = new HashMap<>();
//        map.put("page",page+"");
        OkHttpUtils.get(UrlUtils.MY_SHOP_Url, ShearPreferenceUtils.getToken(MyShopActivity.this),
                MyShopBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            MyShopBean bean = (MyShopBean) obj;
                            if (bean.isSuccess()) {
                                setData(bean);
                            } else {
                                ToastUtils.toast(MyShopActivity.this, bean.getError_msg());
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
                });

    }

    private void setData(MyShopBean data) {
        MyShopBean.ShopInfoEntity shop_info = data.getShop_info();
        if(shop_info!=null){
            if(!TextUtils.isEmpty(shop_info.getShop_name())){
                tvShopName.setText(shop_info.getShop_name());
            }
            if(!TextUtils.isEmpty(shop_info.getLogo())){
                Glide.with(this).load(UrlUtils.MAIN_Url+"/upload/logo/"+shop_info.getLogo())
                        .into(ivLog);
            }
            if(!TextUtils.isEmpty(shop_info.getId())){
                tvShopId.setText("(ID:"+shop_info.getId()+")");
            }
            if(!TextUtils.isEmpty(data.getSum_count_shop())){
                tvSunCount.setText(data.getSum_count_shop());
            }
            if(!TextUtils.isEmpty(shop_info.getTotal())){
                dou = Double.parseDouble(shop_info.getTotal());
                tvMoney.setText(dou /100+"");
            }
            if(!TextUtils.isEmpty(shop_info.getType())){
                getType(shop_info.getType());
            }
        }

    }

    private void getType(final String type) {
        OkHttpUtils.get(UrlUtils.SHOP_TYPE_Url, null,
                HomeShopTypeBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            HomeShopTypeBean bean = (HomeShopTypeBean) obj;
                            if (bean.isSuccess()) {
                                setType(bean,type);
                            } else {
                                ToastUtils.toast(MyShopActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                });
    }

    public void setType(HomeShopTypeBean type, String s) {
        List<HomeShopTypeBean.ShopTypeListEntity> shop_type_list = type.getShop_type_list();
        if(shop_type_list!=null&&shop_type_list.size()>0){
            for (int i = 0; i < shop_type_list.size(); i++) {
                HomeShopTypeBean.ShopTypeListEntity shopTypeListEntity = shop_type_list.get(i);
                if(!TextUtils.isEmpty(shopTypeListEntity.getId())&&
                        TextUtils.equals(shopTypeListEntity.getId(),s)&&!TextUtils.isEmpty(shopTypeListEntity.getName())){
                    tvShopType.setText(shopTypeListEntity.getName());
                }
            }
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onBackPressed() {
        Intent inten = new Intent(MyShopActivity.this, MainActivity.class);
        inten.putExtra("frag",5);
        startActivity(inten);
        finish();
    }
}
