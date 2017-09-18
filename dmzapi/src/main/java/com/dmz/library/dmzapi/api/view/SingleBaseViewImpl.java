package com.dmz.library.dmzapi.api.view;

import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class SingleBaseViewImpl<T extends IBaseBean, D> extends BaseViewImpl<T, D> implements ISingleBaseView<T, D> {
    @Override
    public void notifyDataSetChanged() {

    }
}
