package com.ediancha.edcbusiness.helper.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.ediancha.edcbusiness.R;

/**
 * Created by Admin on 2017/10/19.
 */

public class IInfoWindow implements AMap.InfoWindowAdapter {

    private Context mContext;

    public IInfoWindow(Context mContext){
        this.mContext=mContext;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.window_map, null);
        return inflate;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }



}
