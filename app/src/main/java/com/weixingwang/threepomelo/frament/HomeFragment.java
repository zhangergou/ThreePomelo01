package com.weixingwang.threepomelo.frament;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.adapter.HomeFragmentPagerAdapter;
import com.weixingwang.threepomelo.adapter.HomeFragmentRecyleAdapter;
import com.weixingwang.threepomelo.bean.HomeShopListBean;
import com.weixingwang.threepomelo.bean.HomeShopTypeBean;
import com.weixingwang.threepomelo.bean.RegestGetQuBean;
import com.weixingwang.threepomelo.bean.RegestGetShengBean;
import com.weixingwang.threepomelo.bean.RegestGetShiBean;
import com.weixingwang.threepomelo.utils.AddressUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.OkHttpUtils;
import com.weixingwang.threepomelo.utils.ShearPreferenceUtils;
import com.weixingwang.threepomelo.utils.ThreeAreaUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.utils.UrlUtils;
import com.weixingwang.threepomelo.view.MyListView;
import com.weixingwang.threepomelo.view.MyScrollView;
import com.weixingwang.threepomelo.view.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class HomeFragment extends BaseFragment {

    private ViewPager vp;
    private RecyclerView recl;
    private ArrayList<ImageView> imageList = new ArrayList<>();
    private int[] color = {Color.BLUE, Color.BLACK, Color.RED, Color.WHITE, Color.YELLOW};
    private LinearLayout linIndc;
    private int pos;
    private List<String> listsh = new ArrayList<>();
    private List<String> listsi = new ArrayList<>();
    private List<String> listq = new ArrayList<>();
    private List<RegestGetShengBean.ProvinceListEntity> listSheng = new ArrayList<>();
    private List<RegestGetShiBean.CityListEntity> listShi = new ArrayList<>();
    private List<RegestGetQuBean.AreaListEntity> listQu = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = vp.getCurrentItem();
            if (currentItem == imageList.size() - 1) {
                vp.setCurrentItem(0, false);
            } else {
                vp.setCurrentItem(currentItem + 1);
            }
            handler.sendEmptyMessageDelayed(1, 2000);
        }
    };
    private View view;
    private LinearLayout linArea;
    private MyListView lvProvice;
    private MyListView lvCity;
    private MyListView lvArea;
    private PopupWindow popupWindow;
    private String area_code;
    private TextView tvArea;
    private MyScrollView swCity;
    private MyScrollView swArea;
    private List<HomeShopListBean.ShopListEntity> shopList=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.home_frament_layout;
    }

    @Override
    protected void initView(View view) {
        this.view = view;
        PullToRefreshLayout swrf = (PullToRefreshLayout) view.findViewById(R.id.home_fragment_swf);
        vp = (ViewPager) view.findViewById(R.id.home_frament_vp);
        recl = (RecyclerView) view.findViewById(R.id.home_fragment_recl);
        linIndc = (LinearLayout) view.findViewById(R.id.lin_home_fragment_indector);
        tvArea = (TextView) view.findViewById(R.id.tv_home_fragment_area);
        refrush(swrf);
        linArea = isShowArea(true);
        isShowSearch(true);
        initPopuw();
    }

    private void initPopuw() {
        View inflate = View.inflate(getActivity(), R.layout.home_fragment_pop_item, null);
        lvProvice = (MyListView) inflate.findViewById(R.id.home_fragment_lv_provice);
        lvCity = (MyListView) inflate.findViewById(R.id.home_fragment_lv_city);
        lvArea = (MyListView) inflate.findViewById(R.id.home_fragment_lv_area);
        swCity = (MyScrollView) inflate.findViewById(R.id.home_fragment_scro_city);
        swArea = (MyScrollView) inflate.findViewById(R.id.home_fragment_scro_area);
        popupWindow = DialogUtils.showPopupWindow(getActivity(), inflate);
    }

    @Override
    protected void initData() {
        getShopData();
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundColor(color[i]);
            imageList.add(imageView);
        }
        vp.setAdapter(new HomeFragmentPagerAdapter(imageList));
        for (int i = 0; i < imageList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.indector_selector);
            LinearLayout.LayoutParams prams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            prams.leftMargin = 10;
            imageView.setLayoutParams(prams);
            linIndc.addView(imageView);
        }
        linIndc.getChildAt(0).setSelected(true);

        handler.sendEmptyMessageDelayed(1, 2000);
        initLisViewData();

    }

    @Override
    protected void initLisener() {
        vp.addOnPageChangeListener(this);
        view.findViewById(R.id.lin_home_area).setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onPageSelected(int position) {
        linIndc.getChildAt(pos).setSelected(false);
        linIndc.getChildAt(position).setSelected(true);
        pos = position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_home_area:
                popupWindow.showAsDropDown(linArea);
                break;
        }
    }
    //省
    private void initLisViewData() {
        OkHttpUtils.get(UrlUtils.SHENG_Url, null, RegestGetShengBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShengBean bean = (RegestGetShengBean) obj;
                    if (bean.isSuccess()) {
                        listSheng.clear();
                        listSheng.addAll(bean.getProvince_list());
                        setShengAdapter();
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

    private void setShengAdapter() {
        listsh.clear();
        for (int i = 0; i < listSheng.size(); i++) {
            listsh.add(listSheng.get(i).getName());
        }
        ThreeAreaUtils.getArea(getActivity(),lvProvice,listsh);
        lvProvice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                swCity.setVisibility(View.INVISIBLE);
                swArea.setVisibility(View.INVISIBLE);
                getShiList(listSheng.get(position).getCode());


            }
        });
    }
//市
    private void getShiList(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("province_code", code);
        OkHttpUtils.get(UrlUtils.SHI_Url, null, RegestGetShiBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetShiBean bean = (RegestGetShiBean) obj;
                    if (bean.isSuccess()) {
                        listShi.clear();
                        listShi.addAll(bean.getCity_list());
                        setShiAdapter();
                    } else {
                        ToastUtils.toast(getActivity(), bean.getError_msg());
                        popupWindow.dismiss();
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

    private void setShiAdapter() {
            swCity.setVisibility(View.VISIBLE);
            listsi.clear();
            for (int i = 0; i < listShi.size(); i++) {
                listsi.add(listShi.get(i).getName());
            }

            lvCity.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listsi));
            lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    getQuList(listShi.get(position).getCode());

                }
            });
    }
//区
    private void getQuList(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("city_code", code);
        OkHttpUtils.get(UrlUtils.QU_Url, null, RegestGetQuBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    RegestGetQuBean bean = (RegestGetQuBean) obj;
                    if (bean.isSuccess()) {
                        listQu.clear();
                        listQu.addAll(bean.getArea_list());
                        setQuAdapter();
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

    private void setQuAdapter() {
        swArea.setVisibility(View.VISIBLE);
        listq.clear();
        for (int i = 0; i < listQu.size(); i++) {
            listq.add(listQu.get(i).getName());
        }
        lvArea.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listq));
        lvArea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
                String s = listq.get(position);
                if(s.length()>3){
                    s=s.substring(0,2)+"..";
                }
                tvArea.setText(s);
                area_code = listQu.get(position).getCode();
                initRecleData(area_code);
            }
        });
    }

    private void getShopData() {
        String latitude = AddressUtils.getLatitude(getActivity());
        String lontitude = AddressUtils.getLontitude(getActivity());
        if(TextUtils.isEmpty(latitude)){
            latitude=121.487160+"";
        }
        if(TextUtils.isEmpty(lontitude)){
            lontitude=31.226601+"";
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("lat", latitude);
        map.put("lng", lontitude);
        OkHttpUtils.get(UrlUtils.HOME_AREA_CODE_Url, ShearPreferenceUtils.getToken(getActivity()),
                HomeShopTypeBean.class, new OkHttpUtils.CallBackUtils() {
            @Override
            public void sucess(Object obj) {
                if (obj != null) {
                    HomeShopTypeBean bean = (HomeShopTypeBean) obj;
                    if (bean.isSuccess()) {
                       setViewPagerData(bean);
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

    private void setViewPagerData(HomeShopTypeBean bean) {
        tvArea.setText(bean.getArea_name());
        List<HomeShopTypeBean.ShopTypeListEntity> shop_type_list = bean.getShop_type_list();
        initRecleData(bean.getArea_code());
    }
    private String codeT;
    private int page=1;
    private void initRecleData(String code) {
        codeT=code;
        String latitude = AddressUtils.getLatitude(getActivity());
        String lontitude = AddressUtils.getLontitude(getActivity());
        if(TextUtils.isEmpty(latitude)){
            latitude=121.487160+"";
        }
        if(TextUtils.isEmpty(lontitude)){
            lontitude=31.226601+"";
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("lat", latitude);
        map.put("lng", lontitude);
        map.put("area_code", code);
        map.put("page", page+"");

        OkHttpUtils.get(UrlUtils.HOME_SHOP_LIST_Url, ShearPreferenceUtils.getToken(getActivity()),
                HomeShopListBean.class, new OkHttpUtils.CallBackUtils() {
                    @Override
                    public void sucess(Object obj) {
                        if (obj != null) {
                            HomeShopListBean bean = (HomeShopListBean) obj;
                            if (bean.isSuccess()) {
                               setRecylAdapter(bean.getShop_list());
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
    private boolean isR=false;
    private void setRecylAdapter(List<HomeShopListBean.ShopListEntity> shop_list) {

        if(shop_list.size()<20){
            isR=true;
        }else {
            isR=false;
        }
        shopList.addAll(shop_list);
        recl.setAdapter(new HomeFragmentRecyleAdapter(getActivity(), recl,
                shopList, R.layout.home_frament_recle_item, 1));
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        page=1;
        shopList.clear();
        getShopData();
        super.onRefresh(pullToRefreshLayout);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        if(!isR){
            page++;
            initRecleData(codeT);
            super.onLoadMore(pullToRefreshLayout);
            return;
        }

        pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
        ToastUtils.toast(getActivity(),"店铺已加载完.");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        AddressUtils.remo();
    }
}
