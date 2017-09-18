package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.view.IBaseView;
import com.dmz.library.dmzapi.api.model.ComBaseModel;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class BaseBeanPresenter extends NetBasePresenter<BaseBean, Object, ComBaseModel, IBaseView<BaseBean, Object>> {
    public BaseBeanPresenter(IBaseView iBaseView) {
        createPresenter(new ComBaseModel(this), iBaseView);
    }

    @Override
    public void onSuccess(Object bean) {
        super.onSuccess(bean);
    }

    @Override
    public void excute() {
        super.excute();
        getM().excute();

    }


    public void setDmzBuilder(DmzBuilder dmzBuilder) {
        getM().setDmzBuilder(dmzBuilder);
        excute();
    }
}
