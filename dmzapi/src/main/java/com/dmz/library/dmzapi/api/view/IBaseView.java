package com.dmz.library.dmzapi.api.view;

import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public interface IBaseView<T extends IBaseBean, D> {
    void onOther(IBasePresenter presenter, T bean);

    void onError(IBasePresenter presenter);

    void onSuccess(IBasePresenter tag, D d);
}
