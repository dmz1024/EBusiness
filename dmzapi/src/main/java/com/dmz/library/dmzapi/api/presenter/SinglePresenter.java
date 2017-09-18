package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.model.SingleBaseModel;
import com.dmz.library.dmzapi.api.view.IBaseView;
import com.dmz.library.dmzapi.api.view.IMoreDataView;
import com.dmz.library.dmzapi.api.view.ISingleBaseView;
import com.dmz.library.dmzapi.api.view.SingleBaseViewImpl;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class SinglePresenter<T extends IBaseBean, D> extends NetBasePresenter<T, D, SingleBaseModel<T, D>, IMoreDataView<T, D>> {
    private SingleDataBuilder mBuilder;

    public SinglePresenter setMoreDataBuilder(SingleDataBuilder mBuilder) {
        this.mBuilder = mBuilder;
        return this;
    }

    public SinglePresenter(IMoreDataView iBaseView) {
        createPresenter(new SingleBaseModel<T, D>(this), iBaseView);
    }


    @Override
    public void excute() {
        switch (mBuilder.getCurrentViewEnum()) {
            case LOGINVIEW:
            case OTHERVIEW:
            case ERRORVIEW:
                mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.LOGINVIEW);
                break;

        }
        setDmzBuilder(mBuilder.getDmzBuilder());
        getV().notifyDataSetChanged();
        super.excute();
    }

    @Override
    public void onError() {
        super.onError();
        switch (mBuilder.getCurrentViewEnum()) {
            case LOADINGVIEW:
            case LOGINVIEW:
            case OTHERVIEW:
                mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.ERRORVIEW);
                break;
            case SUCCESSVIEW:
                mBuilder.setCurrentViewEnum(mBuilder.isAlwaysErr() ? SingleDataBuilder.ShowViewEnum.ERRORVIEW : SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
                break;

        }
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onOther(T bean) {
        super.onOther(bean);
        if (bean.getCode() == dmzBuilder.getLoginCode()) {
            mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.LOGINVIEW);
        } else {
            if (mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW) {
                mBuilder.setCurrentViewEnum(mBuilder.isAlwaysErr() ? SingleDataBuilder.ShowViewEnum.ERRORVIEW : SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
            } else {
                mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.ERRORVIEW);
            }

        }
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onSuccess(D bean) {
        super.onSuccess(bean);
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }
}
