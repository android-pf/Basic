package com.futurenavi.libbasic.utils;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.utils.LocationUtils;

import java.util.Date;

/**
 * Created by pf on 17/3/21.
 * 经纬度获取小工具
 */

public class LocationTool {
    private Activity mAct;
    private static LocationTool instance;
    private LocationManager gpsManager;  //gps
    private Location location;
    public static LocationTool getInstance() {
        //第一次判断是否为空
        if (instance == null) {
            synchronized (LocationTool.class) {//锁
                //第二次判断是否为空 多线程同时走到这里的时候，需要这样优化处理
                if (instance == null) {
                    instance = new LocationTool();
                }
            }
        }
        return instance;
    }


    public LocationTool init(Activity mAct) {
        this.mAct = mAct;

        openGPSSettings();
        getLocation();
        return this;
    }

    public void stopGps() {
        if (gpsManager != null) {
            gpsManager.removeUpdates(gpsListener);
            gpsManager=null;
        }
    }


    private void openGPSSettings() {
        gpsManager = (LocationManager) mAct.getSystemService(Context.LOCATION_SERVICE);
//        if (gpsManager.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
//        } else {
//            Log.e("WZK", "openGPSSettings 进入else");
////            Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
////            mAct.startActivityForResult(intent, 0); //此为设置完成后返回到获取界面
//        }
    }


    private void getLocation() {
        // 获取位置管理服务
        LocationManager locationManager;
        String serviceName = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) mAct.getSystemService(serviceName);
        // 查找到服务信息
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // 高精度
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW); // 低功耗
        String provider = locationManager.getBestProvider(criteria, true); // 获取GPS信息
        Location location = locationManager.getLastKnownLocation(provider); // 通过GPS获取位置
        this.location = location;
//        updateToNewLocation(location);
        // 设置监听*器，自动更新的最小时间为间隔N秒(1秒为1*1000，这样写主要为了方便)或最小位移变化超过N米
        locationManager.requestLocationUpdates(provider, 100 * 1000, 500,
                gpsListener);

    }



    public double[] getChinaLocation() {
//        location
        double[] haha = new double[2];
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
//            mL.i("维度：" + latitude + "经度 " + longitude);
            haha = Locations.standardToChina(mAct, latitude, longitude);
//            mL.i("处理过的经纬度长度" + haha[0]);
//            mL.i("处理过的经纬度长度" + haha[1]);
//            String address2 = LocationUtils.getStreet(haha[0], haha[1]);
        }
        return haha;
    }


    // 创建位置监听器
    private LocationListener gpsListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            Log.e("Locatisson", "onLocationChanged");
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            float speed = location.getSpeed();
            long time = location.getTime();
            String s = "latitude--->" + latitude
                    + "  longitude--->" + longitude
                    + "  speed--->" + speed
                    + "  time--->" + new Date(time).toString();
            Log.e("WZK", s);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
}
