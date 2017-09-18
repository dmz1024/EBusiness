package com.dmz.library.dmzapi.api.view;

import com.dmz.library.dmzapi.api.bean.IBaseBean;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public interface IMoreDataView<T extends IBaseBean, D> extends IBaseView<T, D> {
    void notifyDataSetChanged();

    void stopRefresh();
}
