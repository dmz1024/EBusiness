package com.dmz.library.dmzapi.api.presenter;


/**
 * Created by dengmingzhi on 2017/8/25.
 */

public class BasePresenter<T, D> implements IBasePresenter<T, D> {

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess(D bean) {

    }


    @Override
    public void onOther(T bean) {

    }
}
