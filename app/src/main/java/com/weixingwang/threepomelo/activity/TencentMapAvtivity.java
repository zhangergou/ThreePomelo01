package com.weixingwang.threepomelo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.OverlayItem;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.BitmapUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;

import java.io.File;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
public class TencentMapAvtivity extends MapActivity implements View.OnClickListener {

    private MapView mapView;
    private TencentMap tencentMap;
    private Marker marker;
    private String lat;
    private String lng;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.map_layout);
        initView();
        initData();
        initLisener();
    }
    protected void initView() {
        mapView = (MapView) findViewById(R.id.creat_mapview);
        TextView titleName = (TextView) findViewById(R.id.tv_title_name);
        titleName.setText("地图");
        ivBack = (ImageView) findViewById(R.id.iv_title_back);
        ivBack.setVisibility(View.VISIBLE);
    }

    protected void initData() {
        Intent intent = getIntent();
        lat = intent.getStringExtra("lat");
        lng = intent.getStringExtra("lng");
        if(TextUtils.isEmpty(lat)){
            lat = 116.395340+"";
        }
        if(TextUtils.isEmpty(lng)){
            lng = 39.919611+"";
        }
        //获取TencentMap实例
        tencentMap = mapView.getMap();
        //设置卫星底图
        tencentMap.setSatelliteEnabled(false);
        //设置实时路况开启
        tencentMap.setTrafficEnabled(true);
        //设置地图中心点
        tencentMap.setCenter(new LatLng(Double.parseDouble(lng.trim()),
                Double.parseDouble(lat.trim())));
        //设置缩放级别
        tencentMap.setZoom(16);


        LatLng latLng = new LatLng(39.984059,116.307771);
        Circle circle = tencentMap.addCircle(new CircleOptions().
                center(latLng).
                radius(1000d).
                fillColor(0x990000ff).
                strokeColor(0xff33ee00).
                strokeWidth(5));
//        tencentMap.addCircle(new CircleOptions().
//                center(new LatLng(Double.parseDouble(lng.trim()), Double.parseDouble(lat.trim()))).
//                radius(50d).
//                fillColor(0x990000ff).
//                strokeColor(0x990000ff).
//                strokeWidth(5));
        //获取UiSettings实例
        UiSettings uiSettings = mapView.getUiSettings();
        //设置logo到屏幕底部中心
        uiSettings.setLogoPosition(UiSettings.LOGO_POSITION_CENTER_BOTTOM);
        //设置比例尺到屏幕右下角
        uiSettings.setScaleViewPosition(UiSettings.SCALEVIEW_POSITION_RIGHT_BOTTOM);
        //启用缩放手势(更多的手势控制请参考开发手册)
        uiSettings.setZoomGesturesEnabled(true);



        marker = tencentMap.addMarker(new MarkerOptions()
                .position(new LatLng(39, 116))
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory
                        .defaultMarker())
                .draggable(true));
        marker.setIcon(new BitmapDescriptor(BitmapUtils.getBitmapFromResources(TencentMapAvtivity.this,
                R.drawable.map_icon_target)));


        mapView.addMarker(new MarkerOptions()
                .position(new LatLng(39, 116))
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory
                        .defaultMarker())
                .draggable(false))
                .setIcon(new BitmapDescriptor(BitmapUtils.getBitmapFromResources(TencentMapAvtivity.this,
                R.drawable.ic_launcher)));





    }


    protected void initLisener() {
        ivBack.setOnClickListener(this);
        findViewById(R.id.map_ok).setOnClickListener(this);
        tencentMap.setOnMapCameraChangeListener(new TencentMap.OnMapCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                LatLng target = cameraPosition.getTarget();
                marker.setPosition(new LatLng(target.getLatitude(), target.getLongitude()));

            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {
                Log.e("1", "pos="+tencentMap.getZoomLevel());
                LatLng target = cameraPosition.getTarget();
                marker.setPosition(new LatLng(target.getLatitude(), target.getLongitude()));
                lat=target.getLongitude()+"";
                lng=target.getLatitude()+"";
                ToastUtils.toast(TencentMapAvtivity.this, "latitude=" + target.getLatitude() +
                        "longitude=" + target.getLongitude());

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_ok:
                Intent intent = new Intent();
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                setResult(5,intent);
                finish();
                break;
            case R.id.iv_title_back:

                finish();
                break;

        }
    }

}
