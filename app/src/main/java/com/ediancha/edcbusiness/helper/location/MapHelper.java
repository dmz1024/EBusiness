package com.ediancha.edcbusiness.helper.location;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.dmz.library.dmzapi.utils.PermissionUtil;
import com.ediancha.edcbusiness.helper.MapLocationListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * 获取地理位置(不需要显示地图)
 *
 * @author Admin
 * @date 2017/10/17
 */

public class MapHelper {

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient;
    public AMapLocationClientOption mLocationOption;
    private LatLongtudeListener mLatLongtudeListener;
    private Context mContext;

    private MapLocationListener mMapLocationListener;

    public MapHelper setLatLongtudeListener(LatLongtudeListener latLongtudeListener) {
        mLatLongtudeListener = latLongtudeListener;
        return this;
    }

    public MapHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void getLocation() {

        PermissionUtil.getInstance()
                .setOnSuccessPermission(new PermissionUtil.OnCheckSuccessPermission() {
                    @Override
                    public void onSuccess(int result) {
                        mMapLocationListener = mMapLocationListener != null ? mMapLocationListener : new MapLocationListener();
                        //初始化定位
                        mLocationClient = new AMapLocationClient(mContext);
                        mLocationOption = new AMapLocationClientOption();
                        //每分钟定位一次
                        mLocationOption.setInterval(60 * 1000);
                        //设置定位回调监听
                        mLocationClient.setLocationOption(mLocationOption);
                        mLocationClient.setLocationListener(mMapLocationListener
                                .setLatLongtudeListener(new MapLocationListener.LatLongtudeListener() {
                                    @Override
                                    public void setLatitude(Double latitude) {
                                        mLatLongtudeListener.setLatitude(latitude);
                                    }

                                    @Override
                                    public void setLongtude(Double longtude) {
                                        mLatLongtudeListener.setLongtude(longtude);
                                    }

                                    @Override
                                    public void loactionInfo(AMapLocation amapLocation) {
                                        mLatLongtudeListener.getLocaionInfo(amapLocation);
                                    }
                                }));
                        //启动定位
                        mLocationClient.startLocation();
                        //异步获取定位结果
                    }
                })
                .checkLoction(mContext);
    }


    public AMapLocationClient getLocationClient() {
        return mLocationClient;
    }

    public interface LatLongtudeListener {

        public void setLatitude(Double latitude) ;

        public void setLongtude(Double longtude);

        public void getLocaionInfo(AMapLocation amapLocation);
    }


    public static String sHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
