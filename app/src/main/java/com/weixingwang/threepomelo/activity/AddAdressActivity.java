package com.weixingwang.threepomelo.activity;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.AddAdressReclAdapter;
import com.weixingwang.threepomelo.adapter.BaseRecyleAdapter;
import com.weixingwang.threepomelo.bean.AddAddressBean;
import com.weixingwang.threepomelo.bean.AddressListBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class AddAdressActivity extends BaseActivity{

    private RecyclerView recly;
    private ArrayList<AddressListBean.ListAddressEntity> list=new ArrayList();
    private AddAdressReclAdapter reclAdapter;
    private Dialog dialog;
    private int page=1;
    private List<AddressListBean.ListAddressEntity> list_address;
    private EditText etPerson;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etYb;
    private CheckBox cbDef;
    private int def=-1;
    private String address_id;
    private int newAdd=1;//新建为1,编辑为2
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
        getData();
        initMyDialog();
    }

    private void initMyDialog() {
        View inflate = View.inflate(this, R.layout.add_adress_dia_item, null);
        inflate.findViewById(R.id.iv_close_add_adress_dialog).setOnClickListener(this);
        inflate.findViewById(R.id.iv_seave_address).setOnClickListener(this);
        inflate.findViewById(R.id.lin_add_adress_def_dia).setOnClickListener(this);
        etPerson = (EditText)inflate. findViewById(R.id.et_add_adress_person_dia);
        etPhone = (EditText)inflate. findViewById(R.id.et_add_adress_phone_dia);
        etAddress = (EditText) inflate.findViewById(R.id.et_add_adress_address_dia);
        etYb = (EditText) inflate.findViewById(R.id.et_add_adress_yb_dia);
        cbDef = (CheckBox) inflate.findViewById(R.id.cb_add_adress_def_dia);
        dialog = DialogUtils.showCenter(this, inflate, true);
    }

    @Override
    protected void initLisener() {
         findViewById(R.id.add_adress_iv_new_adress).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_adress_iv_new_adress:
                dialog.show();
                etAddress.setText("");
                etPhone.setText("");
                etPerson.setText("");
                cbDef.setChecked(false);
                newAdd=1;
            break;
            case R.id.iv_close_add_adress_dialog:
                dialog.dismiss();
            break;
            case R.id.lin_add_adress_def_dia:
                if(cbDef.isChecked()){
                    cbDef.setChecked(false);
                }else {
                    cbDef.setChecked(true);
                }
            break;
            case R.id.iv_seave_address:
                newAdd=2;
                seaveAddress();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void getData() {
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.SHOP_ADDRESS_LIST_Url, ShearPreferenceUtils.getToken(AddAdressActivity.this),
                AddressListBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            AddressListBean bean = (AddressListBean) obj;
                            if (bean.isSuccess()) {
//                                ToastUtils.toast(AddAdressActivity.this, "操作成功!");
                                list_address = bean.getList_address();
                                setData(list_address);
                            } else {
                                ToastUtils.toast(AddAdressActivity.this, bean.getError_msg());
                            }
                        } else {
                            Toast.makeText(AddAdressActivity.this, "", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(AddAdressActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    private void setData(List<AddressListBean.ListAddressEntity> list_address) {
        list.addAll(list_address);
        if(list.size()>0){
            reclAdapter = new AddAdressReclAdapter(this, recly, list, R.layout.add_adress_recyl_item, 1);
            recly.setAdapter(reclAdapter);
            reclAdapter.setOnClickChoeseView(new BaseRecyleAdapter.OnClickChoeseView() {
                @Override
                public void onChoese(int postion) {
                    if(!TextUtils.isEmpty(list.get(postion).getId())){
                        setChoese(list.get(postion).getId(),UrlUtils.SHOP_SET_DEF_ADDRESS_Url,1);
                    }

                }
            });
            reclAdapter.setOnClickDeleteView(new BaseRecyleAdapter.OnClickDeleteView() {
                @Override
                public void onDelete(int postion) {
                    if(!TextUtils.isEmpty(list.get(postion).getId())){
                        setChoese(list.get(postion).getId(),UrlUtils.SHOP_DELE_ADDRESS_Url,0);
                    }

                }
            });

            reclAdapter.setOnClickEditView(new BaseRecyleAdapter.OnClickEditView() {
                @Override
                public void onEdit(int postion) {
                    if(!TextUtils.isEmpty(list.get(postion).getId())){
                        address_id = list.get(postion).getId();
                        if(!TextUtils.isEmpty(list.get(postion).getPerson())){
                            etPerson.setText(list.get(postion).getPerson());
                        }
                        if(!TextUtils.isEmpty(list.get(postion).getAddress())){
                            etAddress.setText(list.get(postion).getAddress());
                        }
                        if(!TextUtils.isEmpty(list.get(postion).getPhone())){
                            etPhone.setText(list.get(postion).getPhone());
                        }

                        if(!TextUtils.isEmpty(list.get(postion).getDefaultX())){
                            if(TextUtils.equals(list.get(postion).getDefaultX(),"1")){
                                cbDef.setChecked(true);
                            }
                            if(TextUtils.equals(list.get(postion).getDefaultX(),"-1")){
                                cbDef.setChecked(false);
                            }
                        }
                        dialog.show();
                    }

                }
            });
        }
    }



    private void setChoese(String choese,String url,int cho) {

        showLoading();
        HashMap<String, String> map = new HashMap<>();
        if(cho==1){
            map.put("default", 1+"");
        }
        map.put("address_id", choese);

        OkHttpUtils.get(url, ShearPreferenceUtils.getToken(AddAdressActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(AddAdressActivity.this, "操作成功!");
                                page=1;
                                list.clear();
                                getData();
                            } else {
                                ToastUtils.toast(AddAdressActivity.this, bean.getError_msg());
                            }
                        } else {
                           noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(AddAdressActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }


    private void seaveAddress() {
        String url=UrlUtils.SHOP_EDIT_ADDRESS_Url;
        String person = etPerson.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String addre = etAddress.getText().toString().trim();
        String yb = etYb.getText().toString().trim();
        if(cbDef.isChecked()){
            def=1;
        }else {
            def=-1;
        }
    if(TextUtils.isEmpty(person)){
        ToastUtils.toast(this,"收件人不能为空");
        return;
    }
    if(TextUtils.isEmpty(phone)){
        ToastUtils.toast(this,"电话不能为空!");
        return;
    }
    if(TextUtils.isEmpty(addre)){
        ToastUtils.toast(this,"详细地址不能为空!");
        return;
    }
    if(TextUtils.isEmpty(yb)){
        yb="";
    }
        dialog.dismiss();
        showLoading();
        HashMap<String, String> map = new HashMap<>();
        if(newAdd==2){
            newAdd=1;
            url=UrlUtils.SHOP_ADD_ADDRESS_Url;
        }else {
            map.put("address_id", address_id);
        }

        map.put("address", addre);
        map.put("person", person);
        map.put("phone", phone);
        map.put("zip", yb);
        map.put("default", def+"");
        OkHttpUtils.get(url, ShearPreferenceUtils.getToken(AddAdressActivity.this),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        closeLoading();
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(AddAdressActivity.this, "操作成功!");
                                page=1;
                                list.clear();
                                getData();
                            } else {
                                ToastUtils.toast(AddAdressActivity.this, bean.getError_msg());
                            }
                        } else {
                            noData();
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        closeLoading();
                        Toast.makeText(AddAdressActivity.this, "网络错误，请重新请求", Toast.LENGTH_LONG).show();
                    }
                }, map);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        page=1;
        list.clear();
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if(list_address!=null){
            if(list_address.size()<20){
                ToastUtils.toast(this,"加载完毕!");
            }else {
                page++;
                getData();
            }
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
