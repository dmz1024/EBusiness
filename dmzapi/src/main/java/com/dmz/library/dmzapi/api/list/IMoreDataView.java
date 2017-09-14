package com.dmz.library.dmzapi.api.list;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public interface IMoreDataView {
    void notifyDataSetChanged();

    void excute();

    void stopRefresh();
}
