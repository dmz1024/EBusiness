package com.dmz.library.dmzapi.api.list;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public interface IMoreDataResultView<D> extends IMoreDataView {
    void onError();

    void onSuccess(D d);

    void onOther(D d);

}
