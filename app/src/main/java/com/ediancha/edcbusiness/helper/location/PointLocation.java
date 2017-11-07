package com.ediancha.edcbusiness.helper.location;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.ediancha.edcbusiness.R;

/**
 * Created by Admin on 2017/10/19.
 */

public class PointLocation extends MyLocationStyle {


    MyLocationStyle mMyLocationStyle;

    Context mContext;

    public PointLocation(Context mContext) {
        this.mContext=mContext;
    }

    public void getMyLocationstyle() {

    }


    public void pointLocationStyle() {

    }

    @Override
    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.icon_me);
        bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
        return super.myLocationIcon(bitmapDescriptor);
    }
}
