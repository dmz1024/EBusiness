package com.dmz.library.dmzapi.api.model;

import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/8/25.
 */

public interface IBaseView<D> {
    void onSuccess(IBasePresenter tag, D d);
}
