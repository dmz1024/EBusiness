package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.model.BaseNetModel;
import com.dmz.library.dmzapi.api.view.IBaseView;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class NetBasePresenter<T extends IBaseBean, D, M extends BaseNetModel<T, D>, V extends IBaseView<T, D>> extends BasePresenter<M, V> {

    public void onSuccess(D bean) {
        getV().onSuccess(this, bean);
    }

    public void onOther(T bean) {
        getV().onOther(this, bean);
    }

    public void onError() {
        getV().onError(this);
    }

    public NetBasePresenter() {

    }

    @Override
    public void excute() {
        super.excute();
        getM().excute(dmzBuilder);
    }

    protected DmzBuilder dmzBuilder;

    public void setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
    }


}
