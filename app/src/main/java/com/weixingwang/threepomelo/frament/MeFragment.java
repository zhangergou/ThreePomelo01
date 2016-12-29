package com.weixingwang.threepomelo.frament;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.AccountManagerActivity;
import com.weixingwang.threepomelo.activity.MyAllInActivity;
import com.weixingwang.threepomelo.activity.CofferManagerActivity;
import com.weixingwang.threepomelo.activity.CreateShopActivity;
import com.weixingwang.threepomelo.activity.LoginActivity;
import com.weixingwang.threepomelo.activity.MainActivity;
import com.weixingwang.threepomelo.activity.MyShopActivity;
import com.weixingwang.threepomelo.activity.MySunFlwoerActivity;
import com.weixingwang.threepomelo.activity.MyTeamActivity;
import com.weixingwang.threepomelo.activity.ShopOrderActivity;
import com.weixingwang.threepomelo.bean.CreatShopInBean;
import com.weixingwang.threepomelo.bean.PersonCenterBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.CircleImageView;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MeFragment extends BaseFragment {
    private View view;
    private CircleImageView ivIcon;
    private TextView tvName;
    private TextView tvId;
    private TextView tvSunChildCount;
    private TextView tvSunCount;
    private TextView tvPu;
    private ImageView ivIn;
    private String status;


    @Override
    protected int getLayoutId() {
        return R.layout.me_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        PullToRefreshLayout pull = (PullToRefreshLayout) view.findViewById(R.id.me_fragment_pull);
        ivIcon = (CircleImageView) view.findViewById(R.id.me_fragment_icon);
        tvName = (TextView) view.findViewById(R.id.me_frament_tv_name);
        tvId = (TextView) view.findViewById(R.id.me_frament_tv_id);
        tvSunChildCount = (TextView) view.findViewById(R.id.me_frament_tv_sun_child_count);
        tvSunCount = (TextView) view.findViewById(R.id.me_frament_tv_sun_count);
        tvPu = (TextView) view.findViewById(R.id.me_frament_tv_putong);
        ivIn = (ImageView) view.findViewById(R.id.iv_in_my_shop);
        setTitle("个人中心");
        refrush(pull);
        closeLoadMore(true);
    }

    @Override
    protected void initData() {
        showLoading();
        OkHttpUtils.get(UrlUtils.PERSEN_CENTER_Url, ShearPreferenceUtils.getToken(getActivity()),
                PersonCenterBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if(obj!=null){
                        PersonCenterBean bean = (PersonCenterBean) obj;
                        if (bean.isSuccess()) {

                            setData(bean);
                        } else {
                            ToastUtils.toast(getActivity(), bean.getError_msg());
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

    @Override
    protected void initLisener() {
        view.findViewById(R.id.lin_creat_shop).setOnClickListener(this);
        view.findViewById(R.id.logout).setOnClickListener(this);

        view.findViewById(R.id.rla_my_account_mannger).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_my_coffer_mannger).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_my_order_mannger).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_my_sunflwoer).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_my_allin).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_my_team).setOnClickListener(this);
        view.findViewById(R.id.vip_lin_shop_order_mannger).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_creat_shop:
                if(TextUtils.equals(status,"0")){
                    startActivity(new Intent(getActivity(),CreateShopActivity.class));
                }else{
                    startActivity(new Intent(getActivity(),MyShopActivity.class));
                }
                MainActivity.main.finish();
//                startActivity(new Intent(getActivity(),MyShopActivity.class));

            break;
            case R.id.rla_my_account_mannger:
                startActivity(new Intent(getActivity(), AccountManagerActivity.class));
                break;
            case R.id.vip_lin_my_coffer_mannger:
                startActivity(new Intent(getActivity(),CofferManagerActivity.class));
                break;
            case R.id.vip_lin_my_order_mannger:
                MainActivity.main.setSelectCount(1);
                break;
            case R.id.vip_lin_shop_order_mannger:
                startActivity(new Intent(getActivity(),ShopOrderActivity.class));
                break;
            case R.id.vip_lin_my_sunflwoer:
                startActivity(new Intent(getActivity(),MySunFlwoerActivity.class));
                break;
            case R.id.vip_lin_my_allin:
                startActivity(new Intent(getActivity(),MyAllInActivity.class));
                break;
            case R.id.vip_lin_my_team:
                startActivity(new Intent(getActivity(),MyTeamActivity.class));
                break;
            case R.id.logout:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                MainActivity.main.finish();
                break;
        }
    }

    public void setData(PersonCenterBean data) {
        PersonCenterBean.UserInfoEntity user_info = data.getUser_info();
        if (!TextUtils.isEmpty(data.getSum_count() + "")) {
            tvSunCount.setText(data.getSum_count() + "");
        }
        if (!TextUtils.isEmpty(user_info.getRel_name())) {
            tvName.setText(user_info.getRel_name());
        }
        if (!TextUtils.isEmpty(user_info.getId())) {
            tvId.setText("(ID:" + user_info.getId() + ")");
        }
        if (!TextUtils.isEmpty(user_info.getIs_dl())) {
            if (TextUtils.equals(user_info.getIs_dl(), "1")) {
                tvPu.setText("普通用户");
            }
            if (TextUtils.equals(user_info.getIs_dl(), "2")) {
                tvPu.setText("服务商");
            }
            if (TextUtils.equals(user_info.getIs_dl(), "3")) {
                tvPu.setText("联合服务商");
            }
            if (TextUtils.equals(user_info.getIs_dl(), "4")) {
                tvPu.setText("市级代理");
            }
            if (TextUtils.equals(user_info.getIs_dl(), "5")) {
                tvPu.setText("省级代理");
            }
        }
        if (!TextUtils.isEmpty(user_info.getIntegral())) {
            tvSunChildCount.setText(user_info.getIntegral());
        }
        if (!TextUtils.isEmpty(user_info.getShop_id())) {
            status = user_info.getShop_id();
            if (TextUtils.equals(status, "0")) {
                ivIn.setImageResource(R.drawable.personalcenter_icons_merchant);

            } else {
                ivIn.setImageResource(R.drawable.personalcenter_icons_myshop);
            }
            if (!TextUtils.isEmpty(user_info.getFace())) {
                Glide.with(getActivity()).load(UrlUtils.MAIN_Url + "/upload/face/" + user_info.getFace())
                        .into(ivIcon);
            }
        }


    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        initData();
        super.onRefresh(pullToRefreshLayout);
    }

}
