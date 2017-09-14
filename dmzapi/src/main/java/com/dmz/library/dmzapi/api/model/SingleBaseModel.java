package com.dmz.library.dmzapi.api.model;

import com.dmz.library.dmzapi.api.BaseBean;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class SingleBaseModel extends BaseNetModel<BaseBean, Object> {

    public SingleBaseModel(IBasePresenter iBasePresenter) {
        super(iBasePresenter);
    }

    @Override
    public void excute() {
        getDmzBuilder().setaClass(BaseBean.class);
        super.excute();
    }
}
