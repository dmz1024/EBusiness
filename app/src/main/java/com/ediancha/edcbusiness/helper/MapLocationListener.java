package com.ediancha.edcbusiness.helper;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.dmz.library.dmzapi.api.LogUtil;

/**
 *
 * @author Admin
 * @date 2017/10/17
 */

public class MapLocationListener implements AMapLocationListener {

    private LatLongtudeListener mLatLongtudeListener;

    public MapLocationListener setLatLongtudeListener(LatLongtudeListener latLongtudeListener) {
        mLatLongtudeListener = latLongtudeListener;
        return this;
    }
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //解析定位结果
                mLatLongtudeListener.setLatitude(amapLocation.getLatitude());
                mLatLongtudeListener.setLongtude(amapLocation.getLongitude());
            }else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                LogUtil.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    public interface LatLongtudeListener{
        void setLatitude(Double latitude);
        void setLongtude(Double longtude);
    }
}
