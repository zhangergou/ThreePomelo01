package com.weixingwang.threepomelo.activity;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.AddAdressReclAdapter;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.bean.AddAddressBean;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class AddAdressActivity extends BaseActivity{

    private RecyclerView recly;
    private ArrayList<AddAddressBean> list=new ArrayList();
    private AddAdressReclAdapter reclAdapter;
    private Dialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.add_adress_layout;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout pull = (PullToRefreshLayout) findViewById(R.id.add_adress_pull);
        recly = (RecyclerView) findViewById(R.id.add_adress_recl);
        setTitle("收货地址管理");
        isShowBack(true);
        refrush(pull);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            AddAddressBean bean=new AddAddressBean();
            bean.setSelect(false);
            bean.setAddress("111111111111111"+i);
            bean.setName("jjajaj");
            bean.setPhone("123456");
            list.add(bean);
        }
        reclAdapter = new AddAdressReclAdapter(this, recly, list, R.layout.add_adress_recyl_item, 1);
        recly.setAdapter(reclAdapter);
        initMyDialog();
    }

    private void initMyDialog() {
        View inflate = View.inflate(this, R.layout.add_adress_dia_item, null);
        inflate.findViewById(R.id.iv_close_add_adress_dialog).setOnClickListener(this);
        inflate.findViewById(R.id.iv_seave_address).setOnClickListener(this);
        dialog = DialogUtils.showCenter(this, inflate, true);
    }

    @Override
    protected void initLisener() {
         findViewById(R.id.add_adress_iv_new_adress).setOnClickListener(this);
        reclAdapter.setOnClickChoeseView(new BaseRecyleAdapter.OnClickChoeseView() {
            @Override
            public void onChoese(int postion) {
                for (int i = 0; i < list.size(); i++) {
                    if(i==postion){
                        list.get(postion).setSelect(!list.get(postion).isSelect());
                    }else {
                        list.get(i).setSelect(false);
                    }

                }

                reclAdapter.notifyDataSetChanged();
            }
        });
        reclAdapter.setOnClickDeleteView(new BaseRecyleAdapter.OnClickDeleteView() {
            @Override
            public void onDelete(int postion) {
                list.remove(postion);
                reclAdapter.notifyDataSetChanged();
            }
        });

        reclAdapter.setOnClickEditView(new BaseRecyleAdapter.OnClickEditView() {
            @Override
            public void onEdit(int postion) {
                dialog.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_adress_iv_new_adress:
                dialog.show();
            break;
            case R.id.iv_close_add_adress_dialog:
                dialog.dismiss();
            break;
            case R.id.iv_seave_address:
                dialog.dismiss();
                break;
            default:
                super.onClick(v);
                break;
        }
    }
}
