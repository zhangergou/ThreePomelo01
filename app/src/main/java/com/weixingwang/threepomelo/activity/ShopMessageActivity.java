package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.bean.ShopBusBean;
import com.weixingwang.threepomelo.bean.ShopFragmentBean;
import com.weixingwang.threepomelo.bean.ShopMessageBean;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class ShopMessageActivity extends BaseActivity  {

    private ViewPager viewPager;
    private LinearLayout linIndictor;
    private List<ImageView> list=new ArrayList<>();
    private int pos=0                  ;
    private String id;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvZheKou;
    private TextView tvOldPrice;
    private TextView tvSellCount;
    private TextView tvHaveCount;
    private TextView tvMustKnow;
    private RatingBar starts;
    private TextView tvTypeOne;
    private TextView tvTypeTwo;
    private TextView tvTypeThree;
    private TextView tvTypeFour;
    private TextView tvTypeFive;
    private TextView tvTypeSix;
    private LinearLayout linGoodType;
    private ArrayList<TextView> listTV=new ArrayList<>();
    private List<ShopMessageBean.GgListEntity> gg_list;
    private int types=0;
    private String ggId;

    @Override
    protected int getLayoutId() {
        return R.layout.shop_message_layout;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.shop_message_vp);
        linIndictor = (LinearLayout) findViewById(R.id.shop_message_indcitor_lin);
        linGoodType = (LinearLayout) findViewById(R.id.shop_goods_type_lin);
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.shop_message_pull);

        tvName = (TextView) findViewById(R.id.shop_infor_tv_name);
        tvPrice = (TextView) findViewById(R.id.shop_infor_tv_goods_price);
        tvZheKou = (TextView) findViewById(R.id.shop_infor_tv_goods_zhekou);
        tvOldPrice = (TextView) findViewById(R.id.shop_infor_tv_goods_old_price);
        tvSellCount = (TextView) findViewById(R.id.shop_infor_tv_goods_sells);
        tvHaveCount = (TextView) findViewById(R.id.shop_infor_tv_goods_have);
        tvMustKnow = (TextView) findViewById(R.id.shop_goods_infor_tv_must_know);
        tvTypeOne = (TextView) findViewById(R.id.shop_goods_type_one);
        tvTypeTwo = (TextView) findViewById(R.id.shop_goods_type_two);
        tvTypeThree = (TextView) findViewById(R.id.shop_goods_type_three);
        tvTypeFour = (TextView) findViewById(R.id.shop_goods_type_four);
        tvTypeFive = (TextView) findViewById(R.id.shop_goods_type_five);
        tvTypeSix = (TextView) findViewById(R.id.shop_goods_type_six);
        starts = (RatingBar) findViewById(R.id.shop_infor_starts);
        refrush(pull);
        setTitle("商品详情");
        isShowBack(true);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        listTV.add(tvTypeOne);
        listTV.add(tvTypeTwo);
        listTV.add(tvTypeThree);
        listTV.add(tvTypeFour);
        listTV.add(tvTypeFive);
        listTV.add(tvTypeSix);

        getData();
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.lin_shop_details_have_shopping).setOnClickListener(this);
        findViewById(R.id.lin_shop_details_dianpu).setOnClickListener(this);
        findViewById(R.id.btn_plus_shopbus).setOnClickListener(this);
        findViewById(R.id.shop_message_now_shopping).setOnClickListener(this);
        tvTypeOne.setOnClickListener(this);
        tvTypeTwo.setOnClickListener(this);
        tvTypeThree.setOnClickListener(this);
        tvTypeFour.setOnClickListener(this);
        tvTypeFive.setOnClickListener(this);
        tvTypeSix.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_shop_details_have_shopping :
                startActivity(new Intent(ShopMessageActivity.this,ShoppingBusActivity.class));
            break;
            case R.id.lin_shop_details_dianpu :
//                ToastUtils.toast(this,"待做...........");
//                Intent intent = new Intent(ShopMessageActivity.this, SellerMessageActivity.class);
//                intent.putExtra("shop_id",)
//                startActivity(intent);

                break;
            case R.id.btn_plus_shopbus :
                addBus(0);
                break;
            case R.id.shop_message_now_shopping :
                addBus(1);//立即购买
                break;
            case R.id.shop_goods_type_one :
                types=1;
                selectorTV(0);
                break;
            case R.id.shop_goods_type_two :
                types=1;
                selectorTV(1);
                break;
            case R.id.shop_goods_type_three :
                types=1;
                selectorTV(2);
                break;
            case R.id.shop_goods_type_four :
                types=1;
                selectorTV(3);
                break;
            case R.id.shop_goods_type_five :
                types=1;
                selectorTV(4);
                break;
            case R.id.shop_goods_type_six :
                types=1;
                selectorTV(5);
                break;
            default:
                super.onClick(v);
                break;
        }
    }



    private void selectorTV(int i) {
        double v01 =0;
        double v02 =0;
        if(!TextUtils.isEmpty(gg_list.get(i).getGg_price())){
             v01 = Double.parseDouble(gg_list.get(i).getGg_price());
            tvPrice.setText(v01/100+"");
        }
        if(!TextUtils.isEmpty(gg_list.get(i).getId())){
            ggId = gg_list.get(i).getId();
        }
        if(!TextUtils.isEmpty(gg_list.get(i).getGg_old_price())){
             v02 = Double.parseDouble(gg_list.get(i).getGg_old_price());
            tvOldPrice.setText(v02/100+"");
        }
        if(!TextUtils.isEmpty(gg_list.get(i).getGg_kc())){
            tvHaveCount.setText(gg_list.get(i).getGg_kc());
        }
        if(v02!=0){
            String s = (v01 / v02) * 10 + "";
            if(s.length()>3){
                s=s.substring(0,3) ;
            }
            tvZheKou.setText(s+"折");
        }else {
            tvZheKou.setText("10折");
        }
        for (int j = 0; j < gg_list.size(); j++) {
            if(i==j){
                listTV.get(j).setSelected(true);
            }else {
                listTV.get(j).setSelected(false);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        linIndictor.getChildAt(pos).setSelected(false);
        linIndictor.getChildAt(position).setSelected(true);
        pos=position;
    }

    private void getData() {
        if(id==null){
            id="";
        }
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("good_id",id);
        OkHttpUtils.get(UrlUtils.SHOP_GOODS_INFOR_Url, null,
                ShopMessageBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if(obj!=null){
                            ShopMessageBean bean = (ShopMessageBean) obj;
                            if (bean.isSuccess()) {

                                setData(bean);
                            } else {
                                ToastUtils.toast(ShopMessageActivity.this, bean.getError_msg());
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
                },map);
    }

    private void setData(ShopMessageBean data) {
        ShopMessageBean.GoodDetailEntity good_detail = data.getGood_detail();
        gg_list = data.getGg_list();
        List<ShopMessageBean.PicListEntity> pic_list = data.getPic_list();
        getLunIv(pic_list);
        if(good_detail!=null){
            if(!TextUtils.isEmpty(good_detail.getGood_name())){
                tvName.setText(good_detail.getGood_name());
            }
            if(!TextUtils.isEmpty(good_detail.getScroe())){
                int i = Integer.parseInt(good_detail.getScroe());
                starts.setProgress(i);
            }
            if(!TextUtils.isEmpty(good_detail.getBuy_num())){
                tvSellCount.setText(good_detail.getBuy_num());
            }
            if(!TextUtils.isEmpty(good_detail.getGmxz())){
                tvMustKnow.setText(good_detail.getGmxz());
            }
        }
        if(gg_list !=null&& gg_list.size()>0){
            for (int i = 0; i < gg_list.size(); i++) {
                listTV.get(i).setVisibility(View.VISIBLE);
                if(!TextUtils.isEmpty(gg_list.get(i).getGg_name())){
                    listTV.get(i).setText(gg_list.get(i).getGg_name());
                }
            }

            if(!TextUtils.isEmpty(gg_list.get(0).getGg_price())){
                tvPrice.setText(gg_list.get(0).getGg_price());
            }
            if(!TextUtils.isEmpty(gg_list.get(0).getGg_old_price())){
                tvOldPrice.setText(gg_list.get(0).getGg_old_price());
            }

            double v01 =0;
            double v02 =0;
            if(!TextUtils.isEmpty(gg_list.get(0).getGg_price())){
                v01 = Double.parseDouble(gg_list.get(0).getGg_price());
                tvPrice.setText(v01/100+"");
            }
            if(!TextUtils.isEmpty(gg_list.get(0).getGg_old_price())){
                v02 = Double.parseDouble(gg_list.get(0).getGg_old_price());
                tvOldPrice.setText(v02/100+"");
            }

            if(!TextUtils.isEmpty(gg_list.get(0).getGg_kc())){
                tvHaveCount.setText(gg_list.get(0).getGg_kc());
            }
            if(v02!=0){
                String s = (v01 / v02) * 10 + "";
                if(s.length()>3){
                    s=s.substring(0,3) ;
                }
                tvZheKou.setText(s+"折");
            }else {
                tvZheKou.setText("10折");
            }

        }else {
            linGoodType.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    private void getLunIv(List<ShopMessageBean.PicListEntity> pic_list) {
        if(pic_list!=null&&pic_list.size()>0){
            list.clear();
            for (int i = 0; i < pic_list.size(); i++) {
                if(!TextUtils.isEmpty(pic_list.get(i).getPic())&&!TextUtils.isEmpty(pic_list.get(i).getFolder())){
                    ImageView imageView = new ImageView(this);
                    Glide.with(this).load(UrlUtils.MAIN_Url+"/upload/goods_pic/"+pic_list.get(i).getFolder()+
                            "/"+pic_list.get(i).getPic())
                            .into(imageView);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    list.add(imageView);
                }

            }
            viewPager.setAdapter(new HomeFragmentPagerAdapter(list));
            linIndictor.removeAllViews();
            for (int i = 0; i < pic_list.size(); i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.indector_selector);
                LinearLayout.LayoutParams prams=new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                prams.leftMargin=10;
                imageView.setLayoutParams(prams);
                linIndictor.addView(imageView);
            }
            pos=0;
            linIndictor.getChildAt(0).setSelected(true);
        }
    }

    private void addBus(final int sho) {
        if(types==0){
            ToastUtils.toast(ShopMessageActivity.this,"请选择商品类型!");
            return;
        }
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("good_id",id);
        map.put("gg_id", ggId);
        OkHttpUtils.get(UrlUtils.SHOP_ADD_BUS_Url, ShearPreferenceUtils.getToken(ShopMessageActivity.this),
                ShopBusBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            ShopBusBean bean = (ShopBusBean) obj;
                            if (bean.isSuccess()) {
                                if(sho==1){
                                    startActivity(new Intent(ShopMessageActivity.this,ShoppingBusActivity.class));
                                }else
                                ToastUtils.toast(ShopMessageActivity.this, "添加成功!");
                            } else {
                                ToastUtils.toast(ShopMessageActivity.this, bean.getError_msg());
                            }
                        } else {
                            Toast.makeText(ShopMessageActivity.this, "", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(ShopMessageActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);

    }
}
