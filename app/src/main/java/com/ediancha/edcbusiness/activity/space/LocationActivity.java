package com.ediancha.edcbusiness.activity.space;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.location.IMarkerListener;
import com.ediancha.edcbusiness.helper.location.LBSWay;
import com.ediancha.edcbusiness.helper.location.MapHelper;
import com.ediancha.edcbusiness.helper.location.POISearchData;
import com.ediancha.edcbusiness.helper.location.POISearchListener;
import com.ediancha.edcbusiness.helper.location.PointLocation;
import com.ediancha.edcbusiness.helper.location.PointUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Admin
 * @date 2017/10/19
 */
@Route(path = "/activity/space/location")
public class LocationActivity extends NotNetBaseActivity {


    @BindView(R.id.map)
    MapView mMap;

    @Autowired
    public String mLatitude;
    @Autowired
    public String mLongtude;


    @Override
    protected void initView() {
        super.initView();
        mMap.onCreate(savedInstanceState);
        final AMap map = mMap.getMap();

        map.moveCamera(CameraUpdateFactory.zoomTo(14));
        final PointUtils pointUtils = new PointUtils(this, mMap)
                .setMarkerListener(new IMarkerListener(){
                    @Override
                    public void onMarkerClick(Marker marker) {
                        MyToast.error(marker.getTitle());
                        new LBSWay(ctx)
                                .setLBSWay(mMap,new LatLng(Double.parseDouble(mLatitude),Double.parseDouble(mLongtude)),marker.getPosition());
                    }
                });
        pointUtils.setLocationPoint();
        new MapHelper(ctx).setLatLongtudeListener(new MapHelper.LatLongtudeListener() {

            @Override
            public void setLatitude(Double latitude) {

            }

            @Override
            public void setLongtude(Double longtude) {

            }

            @Override
            public void getLocaionInfo(AMapLocation amapLocation) {

                new POISearchData(ctx)
                        .setPOISearchListener(new POISearchListener() {
                            @Override
                            public void onPoiSearched(PoiResult poiResult) {
                                ArrayList<LatLng> mark = new ArrayList<>();
                                ArrayList<PoiItem> pois = poiResult.getPois();
                                for (int i = 0; i < pois.size(); i++) {
                                    LatLonPoint latLonPoint = pois.get(i).getLatLonPoint();
                                    mark.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                                }
                                pointUtils.setLocationMarker(mark);
                            }

                            @Override
                            public void onPoiItemSearched(PoiItem poiItem) {
                            }
                        }).poiSearchKey("会所", amapLocation.getCityCode());
            }
        }).getLocation();

    }

    @Override
    protected void initBarView() {
        super.initBarView();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_location;
    }

    @Override
    protected void initData() {
        super.initData();


    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMap.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMap.onSaveInstanceState(outState);
    }


}
