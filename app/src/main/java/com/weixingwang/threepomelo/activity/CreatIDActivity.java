package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.GetCodeBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class CreatIDActivity extends BaseActivity {

    private EditText etName;
    private EditText etCode;
    private ImageView ivGreen;
    private  String telRegex = "[1][3587]\\d{9}";
    private String testCode=null;
    private Button time;
    private int timeConut=0;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(timeConut==60){
                time.setVisibility(View.GONE);
                timeConut=0;
            }else{
                time.setText(""+timeConut++);
                handler.sendEmptyMessageDelayed(1,1000);
            }

        }
    };
    private LinearLayout linAgreement;
    private Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.creat_id_activity;
    }

    @Override
    protected void initView() {
        etName = (EditText) findViewById(R.id.tv_login__code_name);
        etCode = (EditText) findViewById(R.id.tv_login__code);
        linAgreement = (LinearLayout) findViewById(R.id.lin_xie_yi);
        ivGreen = (ImageView) findViewById(R.id.iv_regest_green);
        time = (Button) findViewById(R.id.btn_time);
        btnLogin = (Button) findViewById(R.id.btn_codeLogin);

        isShowBack(true);
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 1);
        if(type==1){
            setTitle("会员注册");
            btnLogin.setVisibility(View.GONE);
        }else{
            setTitle("重置密码");
            linAgreement.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initLisener() {
        ivGreen.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        findViewById(R.id.tv_login).setOnClickListener(this);
    }

    public void next(View v){
        String name = etName.getText().toString().trim();
        String code = etCode.getText().toString().trim();

        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(code)){
            ToastUtils.toast(this,"手机号码或验证码不能为空");
            return;
        }
        if(!name.matches(telRegex)){
            ToastUtils.toast(this, "输入正确的手机号");
            return;
        }
        if(type==1){
            ToastUtils.toast(this, "未选择同意用户协议");
            return;
        }

        if(!TextUtils.equals(testCode,code)){
            ToastUtils.toast(this,"验证码输入不正确");
            return;
        }
        startActivity(new Intent(CreatIDActivity.this,RegestActivity.class));
    }
    public void getCode(View v){
        String name = etName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            ToastUtils.toast(this,"手机号码不能为空");
            return;
        }

        if(!name.matches(telRegex)){
            ToastUtils.toast(this, "输入正确的手机号");
            return;
        }

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("mobile",name);
        OkHttpUtils.get(UrlUtils.getCodeUrl, null, GetCodeBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if(obj!=null){
                            GetCodeBean bean= (GetCodeBean) obj;
                            if(bean.isSuccess()){
                                time.setVisibility(View.VISIBLE);
                                handler.sendEmptyMessageDelayed(1,1000);
                                ToastUtils.toast(CreatIDActivity.this,"获取成功");
                                ToastUtils.toast(CreatIDActivity.this,bean.getYzm()+"");
                                testCode=bean.getYzm()+"";
                            }else {
                                ToastUtils.toast(CreatIDActivity.this,bean.getError_msg());
                            }
                        }else {
                            ToastUtils.toast(CreatIDActivity.this,"请重新获取");
                        }
                    }

                    @Override
                    public void error(Exception e) {
                        ToastUtils.toast(CreatIDActivity.this,"网络错误,请重新获取");
                    }
                },hashMap
        );
    }
    private int type=1;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_regest_green:
                if(type==1){
                    ivGreen.setSelected(true);
                    type=2;
                }else{
                    ivGreen.setSelected(false);
                    type=1;
                }
            break;
            case R.id.tv_login:
                finish();
                break;
            case R.id.btn_codeLogin:
                codeLogin();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
    //验证码登录
    public void codeLogin(){
        String name = etName.getText().toString().trim();
        String code = etCode.getText().toString().trim();

        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(code)){
            ToastUtils.toast(this,"手机号码或验证码不能为空");
            return;
        }
        if(!name.matches(telRegex)){
            ToastUtils.toast(this, "输入正确的手机号");
            return;
        }

//        if(!TextUtils.equals(testCode,code)){
//            ToastUtils.toast(this,"验证码输入不正确");
//            return;
//        }
        startActivity(new Intent(CreatIDActivity.this,SetPasswordActivity.class));
        finish();
        LoginActivity.login.finish();

    }
}
