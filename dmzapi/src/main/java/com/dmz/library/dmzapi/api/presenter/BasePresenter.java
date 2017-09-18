package com.dmz.library.dmzapi.api.presenter;


import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.model.IBaseModel;
import com.dmz.library.dmzapi.api.view.IBaseView;

/**
 * Created by dengmingzhi on 2017/8/25.
 */

public class BasePresenter<M extends IBaseModel, V extends IBaseView> implements IBasePresenter<M, V> {
    private M m;
    private V v;

    @Override
    public void createPresenter(M m, V v) {
        this.m = m;
        this.v = v;
    }

    public void excute() {

    }

    @Override
    public void destroy() {
        if (v != null) {
            v = null;
        }
        if (m != null) {
            m.cancel();
            m = null;
        }
    }

    public M getM() {
        return m;
    }

    public V getV() {
        return v;
    }


}
