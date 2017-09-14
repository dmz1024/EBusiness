package com.dmz.library.dmzapi.api.list;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.api.BaseListBean;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/6.
 */

public class MoreDataContract<T extends BaseListBean> implements IMoreDataView, AdapterHelper.OnLoadMoreInterface {
    private Context ctx;
    private RecyclerView rvContent;
    private SwipeRefreshLayout refreshLayout;
    private MoreDataBuilder moreDataBuilder;
    private AdapterHelper adapterHelper;

    private MoreDataBasePresenter basePresenter;


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


    public MoreDataContract _init(boolean isRequest) {
        basePresenter = new MoreDataBasePresenter<T>(this).setMoreDataBuilder(moreDataBuilder);
        adapterHelper = AdapterHelper._instance(ctx, rvContent).
                _initData(moreDataBuilder.getData())
                .setLayoutManager(manager).setType(moreDataBuilder.getDefaultView()).setType(moreDataBuilder.getAllView()).setOnLoadMoreInterface(moreDataBuilder.isCanLoadMore() ? this : null);

        if (isRequest) {
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
        basePresenter.excute();
    }


    @Override
    public void stopRefresh() {
        refreshLayout.setEnabled(moreDataBuilder.isCanRefresh());
        moreDataBuilder.setRequestEnum(MoreDataBaseModel.RequestEnum.FIRST_REFRESH);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMore() {
        if (moreDataBuilder.isHaveMore() && moreDataBuilder.isCanLoadMore() && !moreDataBuilder.isRequesting()) {
            refreshLayout.setEnabled(false);
            moreDataBuilder.setRequestEnum(MoreDataBaseModel.RequestEnum.LOADMORE);
            excute();
        }
    }
}
