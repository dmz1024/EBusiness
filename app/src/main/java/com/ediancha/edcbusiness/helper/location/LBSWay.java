package com.ediancha.edcbusiness.helper.location;

import android.content.Context;
import android.graphics.Color;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceOverlay;
import com.amap.api.trace.TraceStatusListener;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/10/19.
 */

public class LBSWay implements RouteSearch.OnRouteSearchListener {

    private Context mContext;
    private LBSTraceClient mLBSTraceClient;
    RouteSearch mRouteSearch;

    AMap mMap;
    PolylineOptions polylineOptions;
    private LatLng mLatLngEnd;

    public LBSWay(Context mContext) {
        this.mContext = mContext;

    }


    public void setLBSWay(MapView mMap, LatLng latLon, LatLng latLnEnd) {
        this.mMap = mMap.getMap();
        this.mLatLngEnd = latLnEnd;
        mRouteSearch = new RouteSearch(mContext);
        LatLonPoint latLonPoint = new LatLonPoint(latLon.latitude, latLon.longitude);
        LatLonPoint latLonEnd = new LatLonPoint(latLnEnd.latitude, latLnEnd.longitude);
        mRouteSearch.setRouteSearchListener(this);
        RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(latLonPoint, latLonEnd);
        RouteSearch.WalkRouteQuery query = new RouteSearch.WalkRouteQuery(fromAndTo, RouteSearch.WALK_DEFAULT);
        mRouteSearch.calculateWalkRouteAsyn(query);//开始算路
    }


    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

        List<WalkPath> paths = walkRouteResult.getPaths();
        List<LatLng> latLngs = new ArrayList<LatLng>();
        for (int j = 0; j < paths.size(); j++) {
            WalkPath walkPath = paths.get(j);
            for (int k = 0; k < walkPath.getSteps().size(); k++) {
                List<LatLonPoint> polyline1 = walkPath.getSteps().get(k).getPolyline();
                for (int l = 0; l < polyline1.size(); l++) {
                    LatLonPoint latLonPoint = polyline1.get(j);
                    LatLng latLng = new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
                    latLngs.add(latLng);
                }
            }
        }
        latLngs.add(mLatLngEnd);
        polylineOptions = polylineOptions != null ? polylineOptions : new PolylineOptions();
        mMap.addPolyline(polylineOptions
                .addAll(latLngs).width(10).color(Color.argb(255, 1, 1, 1)));
    }


    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

        List<RidePath> paths = rideRouteResult.getPaths();
        LogUtil.e("计算结果" + paths.size());
        List<LatLng> latLngs = new ArrayList<LatLng>();
        latLngs.add(new LatLng(39.999391, 116.135972));
        latLngs.add(new LatLng(39.898323, 116.057694));
        latLngs.add(new LatLng(39.900430, 116.265061));
        latLngs.add(new LatLng(39.955192, 116.140092));
        mMap.addPolyline(new PolylineOptions().
                addAll(latLngs).width(10).color(Color.argb(255, 1, 1, 1)));
    }
}
