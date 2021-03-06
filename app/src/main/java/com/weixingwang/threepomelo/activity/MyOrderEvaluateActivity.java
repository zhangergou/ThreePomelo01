package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.bean.LoginBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/6.
 */
public class MyOrderEvaluateActivity extends BaseActivity {

   private TextView tv_finish;
    private EditText edittext;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order_evaluate;
    }


    @Override
    protected void initView() {

        tv_finish= (TextView) findViewById(R.id.tv_finish);
        edittext= (EditText) findViewById(R.id.edittext);
        setTitle("商品点评");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {
        tv_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String text=edittext.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("text",text);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}
