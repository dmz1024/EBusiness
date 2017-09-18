package com.dmz.library.dmzapi.api.model;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.presenter.NetBasePresenter;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class ComBaseModel extends BaseNetModel<BaseBean, Object> {

    public ComBaseModel(NetBasePresenter netBasePresenter) {
        super(netBasePresenter);
    }

    @Override
    public void excute() {
        getDmzBuilder().setaClass(BaseBean.class);
        super.excute();
    }
}
