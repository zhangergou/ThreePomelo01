package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MoneyLogFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.TakeOutMoneyRecyAdapter;
import com.weixingwang.threepomelo.bean.MoneyLogBean;
import com.weixingwang.threepomelo.bean.TakeMoneyLogBean;
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
 * Created by Administrator on 2016/12/12 0012.
 */
public class TakeOutMoneyLogFragment extends BaseFragment {

    private RecyclerView recycl;
    private int page=1;
    private List<TakeMoneyLogBean.WithdrawListEntity> withdraw_list;
    private List<TakeMoneyLogBean.WithdrawListEntity> list=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_take_out_money_layout;
    }

    @Override
    protected void initView(View v) {
        PullToRefreshLayout swrf = (PullToRefreshLayout) v.findViewById(R.id.fragment_take_out_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_take_out_recyle);
        refrush(swrf);
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
        map.put("page", page+"");
        OkHttpUtils.get(UrlUtils.TAKE_MONEY_LOG_Url, ShearPreferenceUtils.getToken(getActivity()),
                TakeMoneyLogBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            TakeMoneyLogBean bean = (TakeMoneyLogBean) obj;
                            if (bean.isSuccess()) {
                                withdraw_list = bean.getWithdraw_list();
                                setShiAdapter(withdraw_list);
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
                }, map);
    }

    public void setShiAdapter(List<TakeMoneyLogBean.WithdrawListEntity> bean) {
        list.addAll(bean);
        if(list!=null&&list.size()>0){
            recycl.setAdapter(new TakeOutMoneyRecyAdapter(getActivity(),recycl,list,
                    R.layout.take_out_recyle_item,1));
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
       if(withdraw_list!=null){
           if(withdraw_list.size()<20){
               ToastUtils.toast(getActivity(),"加载完毕");
           }else {
               page++;
               getData();
           }
       }
        super.onLoadMore(pullToRefreshLayout);
    }
}
