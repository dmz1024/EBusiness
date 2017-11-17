package com.ediancha.edcbusiness.helper.location;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;

/**
 *
 * POI检索监听
 * @author Admin
 * @date 2017/10/20
 */

public interface POISearchListener {

    void onPoiSearched(PoiResult poiResult);

    void onPoiItemSearched(PoiItem poiItem);
}
