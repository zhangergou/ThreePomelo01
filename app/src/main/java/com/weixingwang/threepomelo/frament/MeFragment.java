package com.weixingwang.threepomelo.frament;

import android.content.Intent;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.activity.AccountManagerActivity;
import com.weixingwang.threepomelo.activity.AllInActivity;
import com.weixingwang.threepomelo.activity.CofferManagerActivity;
import com.weixingwang.threepomelo.activity.CreateShopActivity;
import com.weixingwang.threepomelo.activity.LoginActivity;
import com.weixingwang.threepomelo.activity.MainActivity;
import com.weixingwang.threepomelo.activity.MySunFlwoerActivity;
import com.weixingwang.threepomelo.activity.MyTeamActivity;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class MeFragment extends BaseFragment {
    private View view;

    @Override
    protected int getLayoutId() {
        return R.layout.me_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;

        setTitle("个人中心");
    }

    @Override
    protected void initData() {

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_creat_shop:
                startActivity(new Intent(getActivity(),CreateShopActivity.class));
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
            case R.id.vip_lin_my_sunflwoer:
                startActivity(new Intent(getActivity(),MySunFlwoerActivity.class));
                break;
            case R.id.vip_lin_my_allin:
                startActivity(new Intent(getActivity(),AllInActivity.class));
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

    public void logout(View n){}
}
