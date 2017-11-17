package com.ediancha.edcbusiness.helper.location;

import com.amap.api.maps.model.Marker;

/**
 * 标记点监听
 *
 * @author Admin
 * @date 2017/10/19
 */

public interface MarkerListener {


    void onMarkerClick(Marker marker);


    void onMarkerDragStart(Marker marker);

    void onMarkerDragEnd(Marker marker);

    void onMarkerDrag(Marker marker);
}
