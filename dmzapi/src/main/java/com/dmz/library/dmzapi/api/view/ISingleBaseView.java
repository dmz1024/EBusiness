package com.dmz.library.dmzapi.api.view;

import com.dmz.library.dmzapi.api.bean.IBaseBean;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public interface ISingleBaseView<T extends IBaseBean, D> extends IBaseView<T, D> {
    void notifyDataSetChanged();
}
