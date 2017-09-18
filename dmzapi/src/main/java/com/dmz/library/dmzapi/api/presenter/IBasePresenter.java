package com.dmz.library.dmzapi.api.presenter;


import com.dmz.library.dmzapi.api.model.IBaseModel;
import com.dmz.library.dmzapi.api.view.IBaseView;

/**
 * Created by dengmingzhi on 2017/8/25.
 */

public interface IBasePresenter<M extends IBaseModel, V extends IBaseView> extends IDestroyBasePresenter {
    void createPresenter(M m, V v);


}
