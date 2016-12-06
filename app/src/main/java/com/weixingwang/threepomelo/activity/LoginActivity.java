package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.GetCodeBean;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class LoginActivity extends BaseActivity {

    private TextView tvNmae;
    private TextView tvPassword;
    public static LoginActivity login;
    @Override
    protected int getLayoutId() {
        return R.layout.login_activity_layout;
    }

    @Override
    protected void initView() {
        login=this;
        tvNmae = (TextView) findViewById(R.id.tv_login_name);
        tvPassword = (TextView) findViewById(R.id.tv_login_password);
        setTitle("登录");

    }

    @Override
    protected void initData() {
        String sName = ShearPreferenceUtils.getName(this);
        if(!TextUtils.isEmpty(sName)){
            tvNmae.setText(sName);
        }
    }
    //密码登录
    public void login(View view){
        String name = tvNmae.getText().toString().trim();

            String password = tvPassword.getText().toString().trim();
            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){
                ToastUtils.toast(this,"账号或密码不能为空!");
                return;
            }
            ShearPreferenceUtils.putName(this,name);
            comeIn(name,password);
//            String code = tvCode.getText().toString().trim();
//            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(code)){
//                ToastUtils.toast(this,"账号或验证码不能为空!");
//                return;
//            }
//            ShearPreferenceUtils.putName(this,name);
//            comeIn(name,code);

    }

    private void comeIn(String name, String password) {
        HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("mobile",name);
            hashMap.put("password",password);
        OkHttpUtils.get(UrlUtils.PASWORD_LOGIN_Url, null, LoginBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if(obj!=null){
                    LoginBean bean= (LoginBean) obj;
                    if(bean.isSuccess()){
                        ToastUtils.toast(LoginActivity.this,"登录成功");
                        ToastUtils.toast(LoginActivity.this,bean.getToken());
                        ShearPreferenceUtils.putToken(LoginActivity.this,bean.getToken());
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }else {
                        ToastUtils.toast(LoginActivity.this,bean.getError_msg());
                    }
                }else {
                    ToastUtils.toast(LoginActivity.this,"没有数据");
                }
            }

            @Override
            public void error(Exception e) {
                ToastUtils.toast(LoginActivity.this,"网络错误,请重新请求...");
            }
        },hashMap);
    }

    @Override
    protected void initLisener() {
        findViewById(R.id.go_regest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreatIDActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);

            }
        });

        findViewById(R.id.tv_forget_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreatIDActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);

            }
        });

    }
//    //手机验证码登录
//    public void codeLogin(View view){
//        tvPassword.setVisibility(View.GONE);
//        linCode.setVisibility(View.VISIBLE);
//        pos=2;
//
//    }
//    //密码登录
//    public void passwordLogin(View view){
//        linCode.setVisibility(View.GONE);
//        tvPassword.setVisibility(View.VISIBLE);
//        pos=1;
//    }
    //获取验证码
    public void getCode(View view){
        String name = tvNmae.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            ToastUtils.toast(this,"账号不能为空!");
            return;
        }

    }
}
