package com.dmz.library.dmzapi.api.presenter;


import com.dmz.library.dmzapi.api.IBaseBean;

/**
 * Created by dengmingzhi on 2017/8/25.
 */

public interface IBasePresenter<T, D> {
    void onError();

    void onSuccess(D bean);

    void onOther(T bean);
}
