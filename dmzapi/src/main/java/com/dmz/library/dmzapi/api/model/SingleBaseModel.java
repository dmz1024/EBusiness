package com.dmz.library.dmzapi.api.model;

import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.NetBasePresenter;

/**
 * Created by dengmingzhi on 2017/9/5.
 */

public class SingleBaseModel<T extends IBaseBean, D> extends BaseNetModel<T, D> {
    private T t;
    private D d;

    public D getD() {
        return d;
    }

    public T getT() {
        return t;
    }

    public SingleBaseModel(NetBasePresenter netBasePresenter) {
        super(netBasePresenter);
    }

    @Override
    public void onSuccess(D bean) {
        d = bean;
        super.onSuccess(bean);
    }

    @Override
    public void onOther(T bean) {
        t = bean;
        super.onOther(bean);
    }
}
