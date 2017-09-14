package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.IBaseBean;
import com.dmz.library.dmzapi.api.model.BaseNetModel;
import com.dmz.library.dmzapi.api.model.IBaseView;

/**
 * Created by dengmingzhi on 2017/9/4.
 */

public class ComPresenter<T extends IBaseBean, D> extends BasePresenter<T, D> {
    private BaseNetModel iBaseModel;
    private IBaseView iBaseView;
    private Class c;

    public ComPresenter(final Class c, IBaseView iBaseView) {
        this(iBaseView);
        this.c = c;
    }

    public ComPresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
        iBaseModel = new BaseNetModel<T, D>(this);
    }

    public void excute(DmzBuilder dmzBuilder) {
        dmzBuilder.setaClass(getaClass());
        iBaseModel.excute(dmzBuilder);
    }

    @Override
    public void onSuccess(D bean) {
        super.onSuccess(bean);
        iBaseView.onSuccess(this, bean);
    }

    public Class getaClass() {
        return c;
    }
}
