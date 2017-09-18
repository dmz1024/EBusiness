package com.dmz.library.dmzapi.api.contract;

import android.view.View;

import com.dmz.library.dmzapi.api.DmzBuilder;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class SingleDataBuilder extends BaseDataBuilder {
    private boolean alwaysErr = true;//如果请求发生错误，是否总是显示错误页面

    private View loadingView;
    private View errorView;
    private View successView;
    private View otherView;
    private View loginView;


    public View getLoadingView() {
        return loadingView;
    }

    public View getErrorView() {
        return errorView;
    }

    public View getLoginView() {
        return loginView;
    }

    public View getOtherView() {
        return otherView;
    }

    public View getSuccessView() {
        return successView;
    }

    public SingleDataBuilder setErrorView(View errorView) {
        this.errorView = errorView;
        return this;
    }

    public SingleDataBuilder setLoadingView(View loadingView) {
        this.loadingView = loadingView;
        return this;
    }


    public SingleDataBuilder setLoginView(View loginView) {
        this.loginView = loginView;
        return this;
    }

    public SingleDataBuilder setOtherView(View otherView) {
        this.otherView = otherView;
        return this;
    }


    public SingleDataBuilder setSuccessView(View successView) {
        this.successView = successView;
        return this;
    }

    public SingleDataBuilder setAlwaysErr(boolean alwaysErr) {
        this.alwaysErr = alwaysErr;
        return this;
    }


    public View getView() {
        View view = null;
        switch (currentViewEnum) {
            case SUCCESSVIEW:
                view = successView;
                break;
            case ERRORVIEW:
                view = errorView;
                break;
            case OTHERVIEW:
                view = otherView;
                break;
            case LOADINGVIEW:
                view = loadingView;
                break;
            case LOGINVIEW:
                view = loginView;
                break;
        }
        return view;
    }

    public boolean isAlwaysErr() {
        return alwaysErr;
    }


    public enum ShowViewEnum {
        LOADINGVIEW, ERRORVIEW, SUCCESSVIEW, OTHERVIEW, LOGINVIEW
    }

    /**
     * 当前显示的页面枚举
     */
    private ShowViewEnum currentViewEnum = ShowViewEnum.LOADINGVIEW;
    private boolean isSuccessView;

    public boolean isSuccessView() {
        return isSuccessView;
    }

    public SingleDataBuilder setSuccessView(boolean successView) {
        isSuccessView = successView;
        return this;
    }

    public SingleDataBuilder setCurrentViewEnum(ShowViewEnum currentViewEnum) {
        this.currentViewEnum = currentViewEnum;
        return this;
    }

    public ShowViewEnum getCurrentViewEnum() {
        return currentViewEnum;
    }



    public static SingleDataBuilder _build() {
        return new SingleDataBuilder().setCanRefresh(false);
    }

    @Override
    public SingleDataBuilder setFirstRequest(boolean firstRequest) {
        super.setFirstRequest(firstRequest);
        return this;
    }

    @Override
    public SingleDataBuilder setOnMyErrorListener(OnMyErrorListener onMyErrorListener) {
        super.setOnMyErrorListener(onMyErrorListener);
        return this;
    }

    @Override
    public SingleDataBuilder setOnMyOtherCodeListener(OnMyOtherCodeListener onMyOtherCodeListener) {
        super.setOnMyOtherCodeListener(onMyOtherCodeListener);
        return this;
    }

    @Override
    public SingleDataBuilder setOnMySuccessListener(OnMySuccessListener onMySuccessListener) {
        super.setOnMySuccessListener(onMySuccessListener);
        return this;
    }

    @Override
    public SingleDataBuilder setCanRefresh(boolean canRefresh) {
        super.setCanRefresh(canRefresh);
        return this;
    }


    @Override
    public SingleDataBuilder setDmzBuilder(DmzBuilder dmzBuilder) {
        super.setDmzBuilder(dmzBuilder);
        return this;
    }
}
