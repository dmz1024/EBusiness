package com.dmz.library.dmzapi.api;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public interface OnMyOtherCodeListener<D extends IBaseBean> {
    void onOther(D bean);
}
