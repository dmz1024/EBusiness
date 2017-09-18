package com.dmz.library.dmzapi.api.contract;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class BaseDataBuilder {
    private DmzBuilder dmzBuilder;//网络请求配置项
    private boolean isFirstRequest = true;


    private BaseDataBuilder.OnMyErrorListener onMyErrorListener;//请求错误时的回调，比如连接超时等
    private BaseDataBuilder.OnMyOtherCodeListener onMyOtherCodeListener;//请求code码不是默认的code时，比如返回的是10001，但是我们约定的是10000
    private BaseDataBuilder.OnMySuccessListener onMySuccessListener;//请求成功时的回调


    public boolean isFirstRequest() {
        return isFirstRequest;
    }

    public BaseDataBuilder setFirstRequest(boolean firstRequest) {
        isFirstRequest = firstRequest;
        return this;
    }

    public BaseDataBuilder.OnMySuccessListener getOnMySuccessListener() {
        return onMySuccessListener;
    }

    public BaseDataBuilder.OnMyOtherCodeListener getOnMyOtherCodeListener() {
        return onMyOtherCodeListener;
    }

    public BaseDataBuilder.OnMyErrorListener getOnMyErrorListener() {
        return onMyErrorListener;
    }


    public interface OnMyErrorListener {
        void onError(IBasePresenter presenter);
    }

    public interface OnMyOtherCodeListener<D extends IBaseBean> {
        void onOther(IBasePresenter presenter, D bean);
    }

    public interface OnMySuccessListener<D> {
        void onSuccess(IBasePresenter presenter, D bean);
    }


    public BaseDataBuilder setOnMyErrorListener(BaseDataBuilder.OnMyErrorListener onMyErrorListener) {
        this.onMyErrorListener = onMyErrorListener;
        return this;
    }

    public BaseDataBuilder setOnMyOtherCodeListener(BaseDataBuilder.OnMyOtherCodeListener onMyOtherCodeListener) {
        this.onMyOtherCodeListener = onMyOtherCodeListener;
        return this;
    }


    public BaseDataBuilder setOnMySuccessListener(BaseDataBuilder.OnMySuccessListener onMySuccessListener) {
        this.onMySuccessListener = onMySuccessListener;
        return this;
    }

    private boolean isCanRefresh = true;//是否可以刷新


    public boolean isCanRefresh() {
        return isCanRefresh;
    }

    public BaseDataBuilder setCanRefresh(boolean canRefresh) {
        isCanRefresh = canRefresh;
        return this;
    }


    public DmzBuilder getDmzBuilder() {
        return dmzBuilder;
    }

    public BaseDataBuilder setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        return this;
    }


}
