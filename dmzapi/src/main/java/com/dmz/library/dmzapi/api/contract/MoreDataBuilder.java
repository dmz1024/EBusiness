package com.dmz.library.dmzapi.api.contract;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.EmptyViewType;
import com.dmz.library.dmzapi.api.list.ErrorViewType;
import com.dmz.library.dmzapi.api.list.LoadingMoreViewType;
import com.dmz.library.dmzapi.api.list.LoginViewType;
import com.dmz.library.dmzapi.api.list.NoMoreViewType;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public class MoreDataBuilder extends BaseDataBuilder {
    private int page = 1;
    private int size = 15;
    private AdapterHelper.ViewTypeInfo emptyView = new EmptyViewType();
    private AdapterHelper.ViewTypeInfo errorView = new ErrorViewType();
    private AdapterHelper.ViewTypeInfo loadingMoreView = new LoadingMoreViewType();
    private AdapterHelper.ViewTypeInfo loginView = new LoginViewType();
    private AdapterHelper.ViewTypeInfo noMoreView = new NoMoreViewType();


    public enum RequestEnum {
        REFRESH, CLEAR_REFRESH, LOADMORE, FIRST_REFRESH
    }

    private RequestEnum requestEnum = RequestEnum.FIRST_REFRESH;

    public MoreDataBuilder setRequestEnum(RequestEnum requestEnum) {
        this.requestEnum = requestEnum;
        return this;
    }

    public RequestEnum getRequestEnum() {
        return requestEnum;
    }


    public AdapterHelper.ViewTypeInfo getEmptyView() {
        return emptyView;
    }

    public AdapterHelper.ViewTypeInfo getErrorView() {
        return errorView;
    }

    public AdapterHelper.ViewTypeInfo getLoadingMoreView() {
        return loadingMoreView;
    }

    public AdapterHelper.ViewTypeInfo getLoginView() {
        return loginView;
    }

    public AdapterHelper.ViewTypeInfo getNoMoreView() {
        return noMoreView;
    }


    public MoreDataBuilder setEmptyView(AdapterHelper.ViewTypeInfo emptyView) {
        this.emptyView = emptyView;
        return this;
    }

    public MoreDataBuilder setErrorView(AdapterHelper.ViewTypeInfo errorView) {
        this.errorView = errorView;
        return this;
    }

    public MoreDataBuilder setLoadingMoreView(AdapterHelper.ViewTypeInfo loadingMoreView) {
        this.loadingMoreView = loadingMoreView;
        return this;
    }

    public MoreDataBuilder setLoginView(AdapterHelper.ViewTypeInfo loginView) {
        this.loginView = loginView;
        return this;
    }

    public MoreDataBuilder setNoMoreView(AdapterHelper.ViewTypeInfo noMoreView) {
        this.noMoreView = noMoreView;
        return this;
    }

    private ArrayList<AdapterHelper.ViewTypeInfo> allView;

    public MoreDataBuilder addView(ArrayList<AdapterHelper.ViewTypeInfo> allView) {
        this.allView = allView;
        return this;
    }

    public MoreDataBuilder addView(AdapterHelper.ViewTypeInfo view) {
        if (this.allView == null) {
            allView = new ArrayList<>();
        }
        allView.add(view);
        return this;
    }

    public ArrayList<AdapterHelper.ViewTypeInfo> getAllView() {
        return allView;
    }

    public ArrayList getDefaultView() {
        ArrayList<AdapterHelper.ViewTypeInfo> arrayList = new ArrayList<>();
        arrayList.add(getEmptyView());
        arrayList.add(getErrorView());
        arrayList.add(getLoadingMoreView());
        arrayList.add(getLoginView());
        arrayList.add(getNoMoreView());
        return arrayList;
    }

    private ArrayList data;

    public MoreDataBuilder setData(ArrayList data) {
        this.data = data;
        return this;
    }

    public ArrayList getData() {
        return data;
    }

    private boolean isCanLoadMore = true;//是否可以加载更多

    private boolean isRequesting;

    private boolean isHaveMore;

    public MoreDataBuilder setHaveMore(boolean haveMore) {
        isHaveMore = haveMore;
        return this;
    }

    public boolean isHaveMore() {
        return isHaveMore;
    }

    public boolean isRequesting() {
        return isRequesting;
    }

    public MoreDataBuilder setRequesting(boolean requesting) {
        isRequesting = requesting;
        return this;
    }

    public boolean isCanLoadMore() {
        return isCanLoadMore;
    }


    public MoreDataBuilder setCanLoadMore(boolean canLoadMore) {
        isCanLoadMore = canLoadMore;
        return this;
    }


    public static MoreDataBuilder _build() {
        return new MoreDataBuilder();
    }

    public MoreDataBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public MoreDataBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }

    public String getSSize() {
        return String.valueOf(size);
    }

    public String getSPage() {
        return String.valueOf(page);
    }


    @Override
    public MoreDataBuilder setFirstRequest(boolean firstRequest) {
        super.setFirstRequest(firstRequest);
        return this;
    }


    @Override
    public MoreDataBuilder setOnMyErrorListener(OnMyErrorListener onMyErrorListener) {
        super.setOnMyErrorListener(onMyErrorListener);
        return this;
    }

    @Override
    public MoreDataBuilder setOnMyOtherCodeListener(OnMyOtherCodeListener onMyOtherCodeListener) {
        super.setOnMyOtherCodeListener(onMyOtherCodeListener);
        return this;
    }

    @Override
    public MoreDataBuilder setOnMySuccessListener(OnMySuccessListener onMySuccessListener) {
        super.setOnMySuccessListener(onMySuccessListener);
        return this;
    }

    @Override
    public MoreDataBuilder setCanRefresh(boolean canRefresh) {
        super.setCanRefresh(canRefresh);
        return this;
    }


    @Override
    public MoreDataBuilder setDmzBuilder(DmzBuilder dmzBuilder) {
        super.setDmzBuilder(dmzBuilder);
        return this;
    }
}
