package com.dmz.library.dmzapi.api.contract;

import com.dmz.library.dmzapi.api.presenter.IDestroyBasePresenter;
import com.dmz.library.dmzapi.api.view.IMoreDataView;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class IContract<P extends IDestroyBasePresenter> {
    public P basePresenter;

    public void destroy() {
        basePresenter.destroy();
    }

    public void excute() {

    }


}
