package com.dmz.library.dmzapi.api.contract;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.api.presenter.MoreDataBasePresenter;
import com.dmz.library.dmzapi.api.view.IMoreDataView;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public class MoreDataContract<T extends BaseListBean> extends IContract<MoreDataBasePresenter> implements IMoreDataView<T, T>, AdapterHelper.OnLoadMoreInterface {
    private Context ctx;
    private RecyclerView rvContent;
    private SwipeRefreshLayout refreshLayout;
    private MoreDataBuilder moreDataBuilder;
    private AdapterHelper adapterHelper;


    public static <T extends BaseListBean> MoreDataContract _instance(Context ctx, RecyclerView rvContent, SwipeRefreshLayout refreshLayout) {
        return new MoreDataContract<T>(ctx, rvContent, refreshLayout);
    }


    private MoreDataContract(Context ctx, RecyclerView rvContent, SwipeRefreshLayout refreshLayout) {
        this.ctx = ctx;
        this.rvContent = rvContent;
        this.refreshLayout = refreshLayout;
    }

    private void initRefresh() {
        refreshLayout.setEnabled(moreDataBuilder.isCanRefresh());
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                autoRefresh();
            }
        });
    }


    public MoreDataContract _init() {
        basePresenter = new MoreDataBasePresenter<T>(this).setMoreDataBuilder(moreDataBuilder);
        adapterHelper = AdapterHelper._instance(ctx, rvContent).
                _initData(moreDataBuilder.getData())
                .setLayoutManager(manager).setType(moreDataBuilder.getDefaultView()).setType(moreDataBuilder.getAllView()).setOnLoadMoreInterface(moreDataBuilder.isCanLoadMore() ? this : null);

        if (moreDataBuilder.isFirstRequest()) {
            autoRefresh();
        }
        return this;
    }


    public MultiItemTypeAdapter getAdapter() {
        return adapterHelper.getAdapter();
    }

    public void notifyItemChanged(int position) {
        getAdapter().notifyItemChanged(position);
    }

    public void autoRefresh() {
        if (moreDataBuilder.getDmzBuilder().getiLoadingView() != null) {
            refreshLayout.setEnabled(moreDataBuilder.isCanRefresh());
            refreshLayout.setRefreshing(false);
            excute();
        } else {
            refreshLayout.setEnabled(true);
            refreshLayout.post(autoRefresh);
        }
    }

    private Runnable autoRefresh = new Runnable() {
        @Override
        public void run() {
            refreshLayout.setRefreshing(true);
            excute();
        }
    };

    private RecyclerView.LayoutManager manager = new LinearLayoutManager(ctx);

    public MoreDataContract setManager(RecyclerView.LayoutManager manager) {
        this.manager = manager;
        return this;
    }

    public MoreDataContract setMoreDataBuilder(MoreDataBuilder moreDataBuilder) {
        this.moreDataBuilder = moreDataBuilder;
        initRefresh();
        return this;
    }

    @Override
    public void notifyDataSetChanged() {
        adapterHelper.notifyDataSetChanged();
    }

    @Override
    public void excute() {
        super.excute();
        moreDataBuilder.setRequesting(true);
        basePresenter.excute();
    }

    @Override
    public void stopRefresh() {
        refreshLayout.setEnabled(moreDataBuilder.isCanRefresh());
        moreDataBuilder.setRequestEnum(MoreDataBuilder.RequestEnum.FIRST_REFRESH);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMore() {
        if (moreDataBuilder.isHaveMore() && moreDataBuilder.isCanLoadMore() && !moreDataBuilder.isRequesting()) {
            refreshLayout.setEnabled(false);
            moreDataBuilder.setRequestEnum(MoreDataBuilder.RequestEnum.LOADMORE);
            excute();
        }
    }


    @Override
    public void onOther(IBasePresenter presenter, T bean) {
        if (moreDataBuilder.getOnMyOtherCodeListener() != null) {
            moreDataBuilder.getOnMyOtherCodeListener().onOther(presenter, bean);
        }
    }

    @Override
    public void onError(IBasePresenter presenter) {
        if (moreDataBuilder.getOnMyErrorListener() != null) {
            moreDataBuilder.getOnMyErrorListener().onError(presenter);
        }
    }


    @Override
    public void onSuccess(IBasePresenter presenter, T bean) {
        if (moreDataBuilder.getOnMySuccessListener() != null) {
            moreDataBuilder.getOnMySuccessListener().onSuccess(presenter, bean);
        }
    }
}
