package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.model.ComBaseModel;
import com.dmz.library.dmzapi.api.view.IBaseView;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class ComPresenter extends NetBasePresenter<BaseBean, Object, ComBaseModel, IBaseView<BaseBean, Object>> {

    public ComPresenter(IBaseView baseView) {
        createPresenter(new ComBaseModel(this), baseView);
    }

}
