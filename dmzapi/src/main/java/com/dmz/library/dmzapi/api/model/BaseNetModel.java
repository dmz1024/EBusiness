package com.dmz.library.dmzapi.api.model;


import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.OnMyErrorListener;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.presenter.NetBasePresenter;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class BaseNetModel<T extends IBaseBean, D> implements IBaseModel, OnMySuccessListener<D>, OnMyOtherCodeListener<T>, OnMyErrorListener {

    private NetBasePresenter netBasePresenter;

    public BaseNetModel(NetBasePresenter netBasePresenter) {
        this.netBasePresenter = netBasePresenter;
    }


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

    @Override
    public void excute() {
        setListener(dmzBuilder);
        DmzApi.cancel(dmzBuilder.getSign());
        dmzBuilder.setSign(this);
        DmzApi dmzApi = DmzApi._build();
        dmzApi.setDmzBuilder(dmzBuilder).excute();
    }

    @Override
    public void cancel() {
        if (dmzBuilder != null) {
            DmzApi.cancel(dmzBuilder.getSign());
            dmzBuilder = null;
        }
    }

    public void setListener(DmzBuilder dmzBuilder) {
        dmzBuilder
                .setOnMyErrorListener(this)
                .setOnMyOtherCodeListener(this)
                .setOnMySuccessListener(this);

    }


    @Override
    public void onError() {
        netBasePresenter.onError();
    }

    @Override
    public void onSuccess(D bean) {
        netBasePresenter.onSuccess(bean);
    }

    @Override
    public void onOther(T bean) {
        netBasePresenter.onOther(bean);
    }

}
