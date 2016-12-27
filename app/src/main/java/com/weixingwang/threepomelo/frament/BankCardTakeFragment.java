package com.weixingwang.threepomelo.frament;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.GetCodeBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.bean.TakeMoneyGetBean;
import com.weixingwang.threepomelo.bean.TakeMoneyLogBean;
import com.weixingwang.threepomelo.utils.ArrayUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ThreeAreaUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
public class BankCardTakeFragment extends BaseFragment {
    private View v;
    private EditText etMoneyNum,etCardNum,etBankName,etName,etYZMCode;
    private TextView tvBankHome,tvPhone,tvMyName,tvMyMoney;
    private Button btnOk,btnTime;
    private ListView lvBank;
    private PopupWindow popupWindowBank;
    private LinearLayout linBanks;
    private int conut=60;
    private String yzm;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(conut==0){
                conut=60;
                btnTime.setVisibility(View.GONE);
                handler.removeCallbacksAndMessages(null);
            }else{
                conut--;
                btnTime.setText(conut+"s");
                handler.sendEmptyMessageDelayed(0,1000);
            }

        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bank_apply_log;
    }

    @Override
    protected void initView(View v) {
        this.v = v;
        linBanks = (LinearLayout) v.findViewById(R.id.lin_bank_take_money);
        etMoneyNum = (EditText) v.findViewById(R.id.et_bank_take_money_num);
        etCardNum = (EditText) v.findViewById(R.id.et_bank_take_money_card_num);
         etBankName = (EditText) v.findViewById(R.id.et_bank_take_money_bank_address);
         etName = (EditText) v.findViewById(R.id.et_bank_take_money_card_name);
         etYZMCode = (EditText) v.findViewById(R.id.et_bank_take_money_yzm_code);
        tvBankHome = (TextView) v.findViewById(R.id.tv_bank_take_money_bank_home);
         tvPhone = (TextView) v.findViewById(R.id.tv_bank_take_money_phone);
         tvMyName = (TextView) v.findViewById(R.id.tv_bank_take_money_my_name);
         tvMyMoney = (TextView) v.findViewById(R.id.tv_bank_take_money_my_money);
         btnOk = (Button) v.findViewById(R.id.btn_bank_take_money_ok);
         btnTime = (Button) v.findViewById(R.id.btn_bank_take_money_time);


    }

    @Override
    protected void initData() {
        initPopwinow();
        getData();
    }

    private void initPopwinow() {
        View viewPopType = View.inflate(getActivity(), R.layout.pop_banks_item, null);
        lvBank = (ListView) viewPopType.findViewById(R.id.creat_lv_bank);
        popupWindowBank = DialogUtils.showPopupWindow(getActivity(), viewPopType);
        ThreeAreaUtils.setStringArrayArea(getActivity(),lvBank, ArrayUtils.bnaks);

    }

    @Override
    protected void initLisener() {
        linBanks.setOnClickListener(this);
        v.findViewById(R.id.btn_bank_take_money_get_code).setOnClickListener(this);
        btnOk.setOnClickListener(this);
        lvBank.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindowBank.dismiss();
                tvBankHome.setText(ArrayUtils.bnaks[position]);
                etCardNum.setText("");
                etBankName.setText("");
                etName.setText("");
            }
        });
    }

    private void getData() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.GET_TAKE_MONEY_INFOR_Url, ShearPreferenceUtils.getToken(getActivity()),
                TakeMoneyGetBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            TakeMoneyGetBean bean = (TakeMoneyGetBean) obj;
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
                        netError();
                    }
                });
    }

    private void setData(TakeMoneyGetBean data) {
        TakeMoneyGetBean.WithdrawInfoEntity withdraw_info = data.getWithdraw_info();
        if(withdraw_info!=null){
            if(!TextUtils.isEmpty(withdraw_info.getBank())){
                tvBankHome.setText(withdraw_info.getBank());
            }
            if(!TextUtils.isEmpty(withdraw_info.getBank_no())){
                etCardNum.setText(withdraw_info.getBank_no());
            }
            if(!TextUtils.isEmpty(withdraw_info.getBank_branch())){
                etBankName.setText(withdraw_info.getBank_branch());
            }
            if(!TextUtils.isEmpty(withdraw_info.getRel_name())){
                etName.setText(withdraw_info.getRel_name());
            }
        }
        TakeMoneyGetBean.UserInfoEntity user_info = data.getUser_info();
        if(user_info!=null){
            if(!TextUtils.isEmpty(user_info.getMobile())){
                tvPhone.setText(user_info.getMobile());
            }
            if(!TextUtils.isEmpty(user_info.getRel_name())){
                tvMyName.setText(user_info.getRel_name());
            }
            if(!TextUtils.isEmpty(user_info.getIntegral())){
                double v = Double.parseDouble(user_info.getIntegral());
                double v1 = v / 100;
                if(v1<100){
                    btnOk.setVisibility(View.GONE);
                }else {
                    btnOk.setVisibility(View.VISIBLE);
                }
                tvMyMoney.setText(v1+"");
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_bank_take_money:
                //show
                popupWindowBank.showAsDropDown(linBanks);
                break;
            case R.id.btn_bank_take_money_get_code:
                handler.sendEmptyMessageDelayed(0,1000);
                btnTime.setVisibility(View.VISIBLE);
                    getCode();
                break;
            case R.id.btn_bank_take_money_ok:
                putInfor();
                break;
        }
    }
    private void getCode() {
        String ph = tvPhone.getText().toString().trim();
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",ph);
        OkHttpUtils.get(UrlUtils.TAKE_MONEY_CODE_Url, ShearPreferenceUtils.getToken(getActivity()),
                GetCodeBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            GetCodeBean bean = (GetCodeBean) obj;
                            if (bean.isSuccess()) {
                                yzm = bean.getYzm()+"";
                                ToastUtils.toast(getActivity(),yzm);
                            } else {
                                ToastUtils.toast(getActivity(), bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                },map);
    }
    private void putInfor() {
        String money = etMoneyNum.getText().toString().trim();
        if(TextUtils.isEmpty(money)){
            ToastUtils.toast(getActivity(),"提现金额不能为空!");
            return;
        }
        double v = Double.parseDouble(money);
        if(v<100){
            ToastUtils.toast(getActivity(),"提现金额不能少于100!");
            return;
        }
        String yinHangName = tvBankHome.getText().toString().trim();
        if(TextUtils.isEmpty(yinHangName)){
            ToastUtils.toast(getActivity(),"请选择开户银行!");
            return;
        }
        String cardNum = etCardNum.getText().toString().trim();
        if(TextUtils.isEmpty(cardNum)){
            ToastUtils.toast(getActivity(),"银行卡号不能为空!");
            return;
        }
        String zhiHNmae = etBankName.getText().toString().trim();
        if(TextUtils.isEmpty(zhiHNmae)){
            ToastUtils.toast(getActivity(),"支行名称不能为空!");
            return;
        }
        String kaiName = etName.getText().toString().trim();
        if(TextUtils.isEmpty(kaiName)){
            ToastUtils.toast(getActivity(),"开户名不能为空!");
            return;
        }
        String yzCode = etYZMCode.getText().toString().trim();
        if(!TextUtils.equals(yzCode,yzm)){
            ToastUtils.toast(getActivity(),"验证码输入不正确,请重新获取!");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("money",money);
        map.put("bank",yinHangName);
        map.put("bank_no",cardNum);
        map.put("bank_branch",zhiHNmae);
        map.put("rel_name",kaiName);
        OkHttpUtils.get(UrlUtils.TAKE_MONEY_Url, ShearPreferenceUtils.getToken(getActivity()),
                LoginBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            LoginBean bean = (LoginBean) obj;
                            if (bean.isSuccess()) {
                                ToastUtils.toast(getActivity(),"提交成功!");
                            } else {
                                ToastUtils.toast(getActivity(), bean.getError_msg());
                            }

                        } else {
                            noData();
                        }

                    }

                    @Override
                    public void error(Exception e) {
                        netError();
                    }
                },map);

    }
}
