package com.ediancha.edcbusiness.helper.location;

import android.content.Context;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.dmz.library.dmzapi.api.LogUtil;

/**
 * POI检索数据
 *
 * @author Admin
 * @date 2017/10/20
 */

public class POISearchData implements PoiSearch.OnPoiSearchListener {

    private PoiSearch.Query mQuery;
    private PoiSearch mPoiSearch;
    private Context mContext;

    private POISearchListener mPOISearchListener;

    public POISearchData(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * @param keyWord  搜索字符串
     * @param cityCode 表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
     */
    public void poiSearchKey(String keyWord, String cityCode) {
        mQuery = new PoiSearch.Query(keyWord, "", cityCode);
        //设置每一页返回来的条数
//        mQuery.setPageNum(200);
//        LogUtil.e("执行到这"+cityCode+"地址"+keyWord);
        mPoiSearch = new PoiSearch(mContext, mQuery);
        mPoiSearch.setOnPoiSearchListener(this);
        mPoiSearch.searchPOIAsyn();
    }


    public POISearchData setPOISearchListener(POISearchListener POISearchListener) {
        mPOISearchListener = POISearchListener;
        return this;
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        LogUtil.e("执行到这" + poiResult.toString());
        if (mPOISearchListener != null) {
            mPOISearchListener.onPoiSearched(poiResult);
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {
        if (mPOISearchListener != null) {
            mPOISearchListener.onPoiItemSearched(poiItem);
        }
    }
}
