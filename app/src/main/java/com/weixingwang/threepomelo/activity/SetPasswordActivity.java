package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.GetCodeBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class SetPasswordActivity extends BaseActivity{

    private EditText etOne;
    private EditText etTwo;
    private String mobile;

    @Override
    protected int getLayoutId() {
        return R.layout.set_password_layout;
    }

    @Override
    protected void initView() {
        etOne = (EditText) findViewById(R.id.tv_new_password_one);
        etTwo = (EditText) findViewById(R.id.tv_new_password_two);
        setTitle("设置新密码");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
    }

    @Override
    protected void initLisener() {

    }

    public void commit(View v){
        String one = etOne.getText().toString().trim();
        String two = etTwo.getText().toString().trim();
        if(TextUtils.isEmpty(one)){
            ToastUtils.toast(this,"密码不能为空");
            return;
        }
        if(one.length()<6){
            ToastUtils.toast(this,"密码不能少于6位");
            etOne.setText("");
            etTwo.setText("");
            return;
        }
        if(!TextUtils.equals(one,two)){
            ToastUtils.toast(this,"两次输入不一致,请重新输入");
            etTwo.setText("");
            return;
        }
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("mobile",mobile);
        hashMap.put("password",one);
        OkHttpUtils.get(UrlUtils.XIU_GAI_PASSWORD_Url, null, LoginBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if(obj!=null){
                    LoginBean bean= (LoginBean) obj;
                    if(bean.isSuccess()){
                        ToastUtils.toast(SetPasswordActivity.this,"密码重置成功,请登录");
                        startActivity(new Intent(SetPasswordActivity.this,LoginActivity.class));
                        finish();
                    }else {
                        ToastUtils.toast(SetPasswordActivity.this,bean.getError_msg());
                    }
                }else {
                   noData();
                }
            }

            @Override
            public void error(Exception e) {
                netError();
            }
        },hashMap);

    }
}
