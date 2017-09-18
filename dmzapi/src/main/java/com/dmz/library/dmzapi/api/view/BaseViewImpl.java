package com.dmz.library.dmzapi.api.view;

import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class BaseViewImpl<T extends IBaseBean, D> implements IBaseView<T, D> {
    @Override
    public void onOther(IBasePresenter presenter, T bean) {

    }

    @Override
    public void onError(IBasePresenter presenter) {

    }

    @Override
    public void onSuccess(IBasePresenter tag, D d) {

    }
}
