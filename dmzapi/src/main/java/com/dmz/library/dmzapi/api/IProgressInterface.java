package com.dmz.library.dmzapi.api;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public interface IProgressInterface {
    void loading(String loading, OnProgressCancelListener listener);

    void error(String error);

    void waring(String waring);

    void dismiss();

    void success(String success);

    interface OnProgressCancelListener {
        void cancel();
    }
}
