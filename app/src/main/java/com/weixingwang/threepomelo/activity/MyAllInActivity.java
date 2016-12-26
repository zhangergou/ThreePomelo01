package com.weixingwang.threepomelo.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.AllInRecyAdapter;
import com.weixingwang.threepomelo.bean.GetCodeBean;
import com.weixingwang.threepomelo.bean.MyAllInBean;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9 0009.
 */
public class MyAllInActivity extends BaseActivity{

    private RecyclerView recycl;
    private int page=1;
    private List<MyAllInBean.MyIncomeListEntity> my_income_list;
    private List<MyAllInBean.MyIncomeListEntity> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_earnings;
    }

    @Override
    protected void initView() {
        PullToRefreshLayout swrf = (PullToRefreshLayout) findViewById(R.id.my_all_in_swrf);
        recycl = (RecyclerView) findViewById(R.id.my_all_in_recyle);
        refrush(swrf);
        setTitle("我的收益");
        isShowBack(true);
    }

    @Override
    protected void initData() {
        getData();

    }

    @Override
    protected void initLisener() {

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("page",page+"");
        OkHttpUtils.get(UrlUtils.ALL_IN_Url, ShearPreferenceUtils.getToken(MyAllInActivity.this),
                MyAllInBean.class, new OkHttpUtils.CallBackUtils() {

                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            MyAllInBean bean = (MyAllInBean) obj;
                            if (bean.isSuccess()) {
                                setData(bean);
                            } else {
                                ToastUtils.toast(MyAllInActivity.this, bean.getError_msg());
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

    private void setData(MyAllInBean bean) {
        my_income_list = bean.getMy_income_list();
        list.addAll(my_income_list);
        if(list !=null&& list.size()>0){
            recycl.setAdapter(new AllInRecyAdapter(MyAllInActivity.this,recycl, list,
                    R.layout.all_in_recycle_item,1));
        }
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        list.clear();
        page=1;
        getData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

       if(my_income_list!=null){
           if(my_income_list.size()<20){
               ToastUtils.toast(MyAllInActivity.this,"已加载完毕!");
           }else{
               page++;
               getData();
           }
       }
        super.onLoadMore(pullToRefreshLayout);
    }
}
