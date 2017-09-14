package com.dmz.library.dmzapi.api.model;


import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.IBaseBean;
import com.dmz.library.dmzapi.api.OnMyErrorListener;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class BaseNetModel<T extends IBaseBean, D> implements IBaseModel<D>, OnMyOtherCodeListener<T>, OnMyErrorListener {

    private DmzBuilder dmzBuilder;

    public void excute(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        excute();
    }

    public DmzBuilder getDmzBuilder() {
        return dmzBuilder;
    }

    public BaseNetModel setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        return this;
    }

    private DmzApi dmzApi;

    @Override
    public void excute() {
        setListener(dmzBuilder);
        DmzApi.cancel(dmzApi);
        dmzApi = DmzApi._build();
        dmzApi.setDmzBuilder(dmzBuilder).excute();
    }

    public void setListener(DmzBuilder dmzBuilder) {
        dmzBuilder
                .setOnMyErrorListener(this)
                .setOnMyOtherCodeListener(this)
                .setOnMySuccessListener(this);

    }

    protected IBasePresenter iBasePresenter;

    public BaseNetModel(IBasePresenter iBasePresenter) {
        this.iBasePresenter = iBasePresenter;
    }


    @Override
    public void onError() {
        iBasePresenter.onError();
    }

    @Override
    public void onSuccess(D bean) {
        iBasePresenter.onSuccess(bean);
    }

    @Override
    public void onOther(T bean) {
        iBasePresenter.onOther(bean);
    }


}
