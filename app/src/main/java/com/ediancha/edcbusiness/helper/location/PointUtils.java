package com.ediancha.edcbusiness.helper.location;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.dmz.library.dmzapi.utils.MyToast;
import com.ediancha.edcbusiness.R;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/10/19.
 */

public class PointUtils implements AMap.OnMarkerClickListener {

    private Context mContext;
    private AMap mAMap;

    private boolean isInfoWindow;
    /**
     * 定位标记点标记点样式
     */
    private PointLocation myLocationStyle;
    /**
     * 标记点
     */
    private MarkerOptions mMarkerOptions;

    private IMarkerListener mMarkerListener;

    public PointUtils(Context mContext, MapView mMap) {
        this.mContext = mContext;
        mAMap = mAMap != null ? mAMap : mMap.getMap();
    }

    /**
     * 设置定位点
     */
    public void setLocationPoint() {
        myLocationStyle = new PointLocation(mContext);//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);//只定位一次。
        mAMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        mAMap.setMyLocationEnabled(true);

    }


    public PointUtils setInfoWindow(boolean infoWindow) {
        isInfoWindow = infoWindow;
        return this;
    }

    /**
     * 拖拽监听
     */
    private AMap.OnMarkerDragListener mMarkerDragListener = new AMap.OnMarkerDragListener() {
        @Override
        public void onMarkerDragStart(Marker marker) {
            if (marker != null) {
                mMarkerListener.onMarkerDragStart(marker);
            }
        }

        @Override
        public void onMarkerDrag(Marker marker) {
            if (marker != null) {
                mMarkerListener.onMarkerDrag(marker);
            }
        }

        @Override
        public void onMarkerDragEnd(Marker marker) {
            if (marker != null) {
                mMarkerListener.onMarkerDragEnd(marker);
            }
        }
    };

    private AMap.OnInfoWindowClickListener mOnInfoWindowClickListener = new AMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            marker.setTitle("xxxxx");
        }
    };

    /**
     * 设置标记点以及监听
     *
     * @param markers
     */
    public PointUtils setLocationMarker(ArrayList<LatLng> markers) {
        for (int i = 0; i < markers.size(); i++) {
            mMarkerOptions = new MarkerOptions();
            LatLng latLng = markers.get(i);
            mMarkerOptions.position(latLng)
                    .title("第几个" + i)
                    .draggable(false)//表示可拖动
                    .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.icon_space)))
                    .setFlat(true);//设置marker平贴地图效果

            mAMap.addMarker(mMarkerOptions);
        }
        if (!isInfoWindow) {
            mAMap.setOnMarkerClickListener(this);
            mAMap.setOnMarkerDragListener(mMarkerDragListener);
        } else {
            mAMap.setInfoWindowAdapter(new IInfoWindow(mContext));
            mAMap.setOnInfoWindowClickListener(mOnInfoWindowClickListener);
        }
        return this;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // marker 对象被点击时回调的接口
        // 返回 true 则表示接口已响应事件，否则返回false
        if (mMarkerListener != null) {
            mMarkerListener.onMarkerClick(marker);
            return true;
        } else {
            return false;
        }
    }

    public PointUtils setMarkerListener(IMarkerListener markerListener) {
        mMarkerListener = markerListener;
        return this;
    }

//    public ArrayList<LatLng> getMarks() {
//        ArrayList<LatLng> marks = new ArrayList<>();
//        LatLng latLng1 = new LatLng(39.986901, 116.357972);
//        LatLng latLng2 = new LatLng(39.976901, 116.347972);
//        LatLng latLng3 = new LatLng(39.966801, 116.397972);
//        LatLng latLng4 = new LatLng(39.957901, 116.396972);
//        LatLng latLng5 = new LatLng(39.946801, 116.397772);
//        LatLng latLng6 = new LatLng(39.936501, 116.397772);
//        LatLng latLng7 = new LatLng(39.926301, 116.357972);
//        LatLng latLng8 = new LatLng(39.916901, 116.397972);
//        LatLng latLng9 = new LatLng(39.906501, 116.397972);
//        LatLng latLng10 = new LatLng(39.916911, 116.387962);
//        marks.add(latLng1);
//        marks.add(latLng2);
//        marks.add(latLng3);
//        marks.add(latLng4);
//        marks.add(latLng5);
//        marks.add(latLng6);
//        marks.add(latLng7);
//        marks.add(latLng8);
//        marks.add(latLng9);
//        marks.add(latLng10);
//        return marks;
//    }


}
