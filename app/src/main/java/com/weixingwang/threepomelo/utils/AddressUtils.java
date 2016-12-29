package com.weixingwang.threepomelo.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.List;


/**
 * Created by Administrator on 2016/11/4 0004.
 */
public class AddressUtils {
    private static String locationProvider;
    private static String lat = null;
    private static String lon = null;
    private static LocationManager locationManager;
    private static LocationListener locationListener;

    //经度
    public static String getLontitude(Context context) {

        return getLat(1, context);
    }

    //纬度
    public static String getLatitude(Context context) {
        return getLat(2, context);
    }

    private static String getLat(final int i, Context context) {

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        }
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.GPS_PROVIDER;
        }
        if (providers.contains(LocationManager.PASSIVE_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.PASSIVE_PROVIDER;
        }
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if (location != null) {
            lon = location.getLongitude() + "";
            lat = location.getLatitude() + "";
        }
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                if (location != null) {
                    lon = location.getLongitude() + "";
                    lat = location.getLatitude() + "";
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, locationListener);
       if(i==1){
         return lon;
       }else {
           return lat;
       }
    }

    public static void remo(){
        if(locationManager!=null){
            locationManager.removeUpdates(locationListener);
        }

    }

}
