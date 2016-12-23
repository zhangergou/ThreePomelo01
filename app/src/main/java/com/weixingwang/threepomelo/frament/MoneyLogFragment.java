package com.weixingwang.threepomelo.frament;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.MoneyLogFragmentRecyAdapter;
import com.weixingwang.threepomelo.adapter.TakeOutMoneyRecyAdapter;
import com.weixingwang.threepomelo.bean.MoneyLogBean;
import com.weixingwang.threepomelo.bean.MyTeamVIPBean;
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
public class MoneyLogFragment extends BaseFragment {

    private RecyclerView recycl;
    private int page=1;
    private PullToRefreshLayout swrf;
    private List<MoneyLogBean.MoneyLogListEntity> money_log_list;
    private List<MoneyLogBean.MoneyLogListEntity> list=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_money_log;
    }

    @Override
    protected void initView(View v) {
        swrf = (PullToRefreshLayout) v.findViewById(R.id.fragment_money_swrf);
        recycl = (RecyclerView) v.findViewById(R.id.fragment_money_recyle);
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
        OkHttpUtils.get(UrlUtils.MONEY_LOG_Url, ShearPreferenceUtils.getToken(getActivity()),
                MoneyLogBean.class, new OkHttpUtils.CallBackUtils() {


                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            MoneyLogBean bean = (MoneyLogBean) obj;
                            if (bean.isSuccess()) {
                               money_log_list =  bean.getMoney_log_list();
                                setShiAdapter(money_log_list);
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

    public void setShiAdapter(List<MoneyLogBean.MoneyLogListEntity> bean) {
        list.addAll(bean);
        if(list!=null&&list.size()>0){
            recycl.setAdapter(new MoneyLogFragmentRecyAdapter(getActivity(),recycl,list,
                    R.layout.fragment_money_recyle_item,1));
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
        if(money_log_list.size()<20){
            ToastUtils.toast(getActivity(),"加载完毕");
        }else {
            page++;
            getData();
        }
        super.onLoadMore(pullToRefreshLayout);
    }
}
