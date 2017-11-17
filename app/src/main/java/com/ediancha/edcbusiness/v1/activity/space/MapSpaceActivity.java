package com.ediancha.edcbusiness.v1.activity.space;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.RotateAnimation;
import com.amap.api.maps.model.animation.TranslateAnimation;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
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
    private Marker marker1;
    private Marker marker2;
    private boolean is1;
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
                    marker.setPositionByPixels(ScreenUtil.getScreenWidth() / 2, ((ScreenUtil.getScreenHeight() - (ScreenUtil.dp2px(50)) - bitmapWo.getHeight()) + (bitmapLan.getHeight() / 2) - 10) / 2);


                    marker1 = aMap.addMarker(new MarkerOptions().position(new LatLng(40.05941412643571, 116.41451507806778)));
                    marker2 = aMap.addMarker(new MarkerOptions().position(new LatLng(40.05797605314868, 116.41531839966775)));
                }

//                ivWo.setVisibility(View.VISIBLE);
                aMap.moveCamera(CameraUpdateFactory.zoomTo(16));
                MyToast.normal(location.getLatitude() + "--" + location.getLongitude());
            }
        });

        if (DateUtils.getHour() >= 18 || DateUtils.getHour() <= 7)
            aMap.setMapType(AMap.MAP_TYPE_NIGHT);//夜间模式


        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (!TextUtils.equals(MapSpaceActivity.this.marker.getId(), marker.getId())) {
                    routeSearch(marker);
                }

                return true;
            }
        });


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

                        Log.d("大小位置", position.latitude + "---" + position.longitude);
                        jumpPoint(marker);
                        //TODO 请求网络
                    }
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


    /**
     * marker点击时跳动一下
     */
    public void jumpPoint(final Marker marker) {
//        LatLng position = marker.getPosition();
//        Animation animation = new TranslateAnimation(new LatLng(position.latitude + 0.0002, position.longitude));
//        animation.setDuration(500L);
//        animation.setInterpolator(new LinearInterpolator());
//        marker.setAnimation(animation);
//        marker.startAnimation();

    }

    public void routeSearch(Marker marker) {
        RouteSearch routeSearch = new RouteSearch(this);

        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            @Override
            public void onBusRouteSearched(BusRouteResult result, int code) {

            }

            @Override
            public void onDriveRouteSearched(DriveRouteResult result, int code) {

            }

            @Override
            public void onWalkRouteSearched(WalkRouteResult result, int code) {

                if(code==1000){
                    WalkPath walkPath = result.getPaths().get(0);
//                aMap.clear();// 清理地图上的所有覆盖物
                    WalkRouteOverlay walkRouteOverlay = new WalkRouteOverlay(MapSpaceActivity.this,
                            aMap, walkPath, result.getStartPos(),
                            result.getTargetPos());
//                    walkRouteOverlay.removeFromMap();
                    walkRouteOverlay.addToMap();
//                walkRouteOverlay.zoomToSpan();

                }
            }

            @Override
            public void onRideRouteSearched(RideRouteResult result, int code) {

            }
        });


        LatLng marker1Position = marker.getPosition();


        RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(new LatLonPoint(aMap.getMyLocation().getLatitude(), aMap.getMyLocation().getLongitude()), new LatLonPoint(marker1Position.latitude, marker1Position.longitude));

        RouteSearch.WalkRouteQuery query = new RouteSearch.WalkRouteQuery(fromAndTo, RouteSearch.WALK_MULTI_PATH);//RouteSearch.WALK_DEFAULT
        routeSearch.calculateWalkRouteAsyn(query);//开始算路


    }
}
