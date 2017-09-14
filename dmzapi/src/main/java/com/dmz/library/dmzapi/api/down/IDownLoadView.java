package com.dmz.library.dmzapi.api.down;

/**
 * Created by dengmingzhi on 2017/9/8.
 */

public interface IDownLoadView {
    void onError(Object tag);

    void onProress(Object tag, float progress);

    void onSuccess(Object tag);

    void finish();

    void start(Object tag);
}
