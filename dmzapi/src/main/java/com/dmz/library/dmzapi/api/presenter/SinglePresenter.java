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
        setDmzBuilder(this.mBuilder.getDmzBuilder());
        return this;
    }

    public SinglePresenter(IMoreDataView iBaseView) {
        createPresenter(new SingleBaseModel<T, D>(this), iBaseView);

    }


    @Override
    public void excute() {
        mBuilder.setSuccessView(mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
        if (mBuilder.getCurrentViewEnum() != null) {
            switch (mBuilder.getCurrentViewEnum()) {
                case OTHERVIEW:
                case ERRORVIEW:
                case LOGINVIEW:
                case LOADINGVIEW:
                    mBuilder.setCurrentViewEnum(mBuilder.getDmzBuilder().getiLoadingView() != null ? null : SingleDataBuilder.ShowViewEnum.LOADINGVIEW);
                    break;
            }
        }
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
        mBuilder.setSuccessView(mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onOther(T bean) {
        super.onOther(bean);
        if (bean.getCode() == dmzBuilder.getLoginCode()) {
            mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.LOGINVIEW);
        } else {
            if (mBuilder.isSuccessView()) {
                mBuilder.setCurrentViewEnum(mBuilder.isAlwaysErr() ? SingleDataBuilder.ShowViewEnum.OTHERVIEW : SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
            } else {
                mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.OTHERVIEW);
            }

        }
        mBuilder.setSuccessView(mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onSuccess(D bean) {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
        super.onSuccess(bean);
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }
}
