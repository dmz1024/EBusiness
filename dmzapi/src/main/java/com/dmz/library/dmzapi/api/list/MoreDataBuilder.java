package com.dmz.library.dmzapi.api.list;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMyErrorListener;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public class MoreDataBuilder {
    private DmzBuilder dmzBuilder;//网络请求配置项
    private int page = 1;
    private int size = 15;
    private AdapterHelper.ViewTypeInfo emptyView = new EmptyViewType();
    private AdapterHelper.ViewTypeInfo errorView = new ErrorViewType();
    private AdapterHelper.ViewTypeInfo loadingMoreView = new LoadingMoreViewType();
    private AdapterHelper.ViewTypeInfo loginView = new LoginViewType();
    private AdapterHelper.ViewTypeInfo noMoreView = new NoMoreViewType();
    private MoreDataBaseModel.RequestEnum requestEnum = MoreDataBaseModel.RequestEnum.FIRST_REFRESH;


    private OnMyErrorListener onMyErrorListener;//请求错误时的回调，比如连接超时等
    private OnMyOtherCodeListener onMyOtherCodeListener;//请求code码不是默认的code时，比如返回的是10001，但是我们约定的是10000
    private OnMySuccessListener onMySuccessListener;//请求成功时的回调


    public OnMySuccessListener getOnMySuccessListener() {
        return onMySuccessListener;
    }

    public OnMyOtherCodeListener getOnMyOtherCodeListener() {
        return onMyOtherCodeListener;
    }

    public OnMyErrorListener getOnMyErrorListener() {
        return onMyErrorListener;
    }

    public MoreDataBuilder setOnMyErrorListener(OnMyErrorListener onMyErrorListener) {
        this.onMyErrorListener = onMyErrorListener;
        return this;
    }

    public MoreDataBuilder setOnMyOtherCodeListener(OnMyOtherCodeListener onMyOtherCodeListener) {
        this.onMyOtherCodeListener = onMyOtherCodeListener;
        return this;
    }


    public MoreDataBuilder setOnMySuccessListener(OnMySuccessListener onMySuccessListener) {
        this.onMySuccessListener = onMySuccessListener;
        return this;
    }

    public MoreDataBuilder setRequestEnum(MoreDataBaseModel.RequestEnum requestEnum) {
        this.requestEnum = requestEnum;
        return this;
    }

    public MoreDataBaseModel.RequestEnum getRequestEnum() {
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

    private boolean isCanRefresh = true;//是否可以刷新
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

    public boolean isCanRefresh() {
        return isCanRefresh;
    }

    public MoreDataBuilder setCanLoadMore(boolean canLoadMore) {
        isCanLoadMore = canLoadMore;
        return this;
    }

    public MoreDataBuilder setCanRefresh(boolean canRefresh) {
        isCanRefresh = canRefresh;
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

    public DmzBuilder getDmzBuilder() {
        return dmzBuilder;
    }

    public MoreDataBuilder setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        return this;
    }

}
