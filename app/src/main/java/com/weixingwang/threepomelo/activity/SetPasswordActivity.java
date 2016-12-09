package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.ToastUtils;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class SetPasswordActivity extends BaseActivity{

    private EditText etOne;
    private EditText etTwo;

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
            return;
        }
        if(!TextUtils.equals(one,two)){
            ToastUtils.toast(this,"两次输入不一致,请重新输入");
            return;
        }
        ToastUtils.toast(this,"密码重置成功,请登录");
        startActivity(new Intent(SetPasswordActivity.this,LoginActivity.class));
        finish();
    }
}
