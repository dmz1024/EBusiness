package com.ediancha.edcbusiness.v1.activity.space;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.dmz.library.dmzapi.utils.DateUtils;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.dmz.library.dmzapi.view.activity.BaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/11/15.
 */
@Route(path = "/v1/activity/space/mapSpace")
public class MapSpaceActivity extends BaseActivity {

    @BindView(R.id.rlTop)
    RelativeLayout rlTop;
    @BindView(R.id.map)
    MapView map;
    @BindView(R.id.ivSpace)
    ImageView ivSpace;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.ivLoad)
    ImageView ivLoad;
    @BindView(R.id.ivWo)
    ImageView ivWo;


    private AMap aMap;

    @Override
    protected int getRid() {
        return R.layout.activity_map_space;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        super.initView();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map.onCreate(savedInstanceState);
        aMap = map.getMap();
        initMap();
        ImageLoader.loadCircu(this, ApiContant.IMAGE, ivSpace);
    }

    private Marker marker;

    private void initMap() {
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);//定位一次，且将视角移动到地图中心点
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.lan_icon)));
        myLocationStyle.strokeWidth(1);//设置定位蓝点精度圈的边框宽度的方法。
        myLocationStyle.strokeColor(Color.parseColor("#00000000"));
        myLocationStyle.radiusFillColor(Color.parseColor("#00000000"));


        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

                if (marker == null) {
                    lastChangeTime = System.currentTimeMillis();
                    marker = aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.wo_icon))));
                    Bitmap bitmapWo = BitmapFactory.decodeResource(getResources(), R.mipmap.wo_icon);
                    Bitmap bitmapLan = BitmapFactory.decodeResource(getResources(), R.mipmap.lan_icon);
                    marker.setPositionByPixels(ScreenUtil.getScreenWidth() / 2, ((ScreenUtil.getScreenHeight() - (ScreenUtil.dp2px(50)) - bitmapWo.getHeight()) + (bitmapLan.getHeight() / 2) - 5) / 2);
                }

//                ivWo.setVisibility(View.VISIBLE);
                aMap.moveCamera(CameraUpdateFactory.zoomTo(16));
                MyToast.normal(location.getLatitude() + "--" + location.getLongitude());
            }
        });

        if (DateUtils.getHour() >= 18 || DateUtils.getHour() <= 7)
            aMap.setMapType(AMap.MAP_TYPE_NIGHT);//夜间模式


        aMap.showIndoorMap(true);//显示室内地图
        aMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        UiSettings uiSettings = aMap.getUiSettings();

        uiSettings.setMyLocationButtonEnabled(true);

        uiSettings.setZoomControlsEnabled(false);//缩放按钮

        aMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {
                if (lastChangeTime != 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - lastChangeTime > 1000) {
                        lastChangeTime = currentTimeMillis;
                        LatLng position = marker.getPosition();
                        MyToast.error(position.latitude + "---" + position.longitude);
                        //TODO 请求网络
                    }
                } else {
                    //TODO 请求网络
                }
            }
        });

    }

    private long lastChangeTime;

    @OnClick(R.id.ivHome)
    void goHome() {
        finish();
    }

    @OnClick(R.id.ivLoad)
    void load() {
        aMap.reloadMap();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }
}
