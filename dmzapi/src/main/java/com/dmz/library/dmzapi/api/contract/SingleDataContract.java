package com.dmz.library.dmzapi.api.contract;

import android.app.Activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.bean.IBaseBean;

import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.api.presenter.SinglePresenter;
import com.dmz.library.dmzapi.api.view.IMoreDataView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class SingleDataContract<T extends IBaseBean, D> extends IContract<SinglePresenter> implements IMoreDataView<T, D> {
    private SwipeRefreshLayout refreshLayout;
    private NestedScrollView scRoot;
    private SingleDataBuilder mBuilder;
    private LayoutInflater layoutInflater;

    public static <T extends IBaseBean, D> SingleDataContract _instance(NestedScrollView scRoot, SwipeRefreshLayout refreshLayout) {
        return new SingleDataContract<T, D>(scRoot, refreshLayout);
    }

    private SingleDataContract(NestedScrollView scRoot, SwipeRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        this.scRoot = scRoot;
        layoutInflater = ((Activity) refreshLayout.getContext()).getLayoutInflater();
    }


    private void initRefresh() {
        refreshLayout.setEnabled(mBuilder.isCanRefresh());
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                autoRefresh();
            }
        });
    }


    public void autoRefresh() {
        if (mBuilder.getDmzBuilder().getiLoadingView() != null) {
            refreshLayout.setRefreshing(false);
        } else {
            if (mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW) {
                refreshLayout.setEnabled(true);
            }
        }
        excute();
    }


    public SingleDataContract setDataBuilder(SingleDataBuilder mBuilder) {
        this.mBuilder = mBuilder;
        return this;
    }

    @Override
    public void excute() {
        super.excute();
        basePresenter.excute();
    }

    public SingleDataContract _init() {
        basePresenter = new SinglePresenter<T, D>(this).setMoreDataBuilder(mBuilder);

        if (mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW) {
            getSuccessView(mBuilder.getSuccessRid());
        }

        initRefresh();
        notifyDataSetChanged();
        if (mBuilder.isFirstRequest()) {
            refreshLayout.setEnabled(false);
            if (mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW) {
                refreshLayout.setEnabled(true);
                refreshLayout.setRefreshing(true);
            }
            excute();
        }
        return this;
    }


    @Override
    public void notifyDataSetChanged() {
        if (!mBuilder.isSuccessView()) {
            View view = null;
            if (mBuilder.getCurrentViewEnum() != null) {
                switch (mBuilder.getCurrentViewEnum()) {
                    case SUCCESSVIEW:
                        view = mBuilder.getSuccessView();
                        break;
                    case ERRORVIEW:
                        if (mBuilder.getErrorView() == null) {
                            getErrorView();
                        }
                        view = mBuilder.getErrorView();
                        break;
                    case OTHERVIEW:
                        if (mBuilder.getOtherView() == null) {
                            getOtherView();
                        }
                        view = mBuilder.getOtherView();
                        break;
                    case LOADINGVIEW:
                        if (mBuilder.getLoadingView() == null) {
                            getLoadingView();
                        }
                        view = mBuilder.getLoadingView();
                        break;
                    case LOGINVIEW:
                        if (mBuilder.getLoginView() == null) {
                            getLoginView();
                        }
                        view = mBuilder.getLoginView();
                        break;
                }

            }
            scRoot.removeAllViews();
            if (view != null) {
                scRoot.addView(view);
            }
        }
    }

    private void getLoginView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_login_view, null);
        mBuilder.setLoginView(view);
    }

    private Unbinder unbinder;

    public void getSuccessView(int rid) {
        if (mBuilder.getSuccessView() == null) {
            mBuilder.setSuccessView(layoutInflater.inflate(rid, null));

            unbinder = ButterKnife.bind(refreshLayout.getContext(), mBuilder.getSuccessView());
        }
    }

    private void getLoadingView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_loading_view, null);
        mBuilder.setLoadingView(view);
    }

    private void getOtherView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_other_view, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excute();
            }
        });
        mBuilder.setOtherView(view);
    }


    private void getErrorView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_error_view, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excute();
            }
        });
        mBuilder.setErrorView(view);
    }

    @Override
    public void stopRefresh() {
        if (mBuilder.getCurrentViewEnum() == SingleDataBuilder.ShowViewEnum.SUCCESSVIEW) {
            refreshLayout.setEnabled(mBuilder.isCanRefresh());
        } else {
            refreshLayout.setEnabled(false);
        }
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onOther(IBasePresenter presenter, T bean) {
        if (mBuilder.getOnMyOtherCodeListener() != null) {
            mBuilder.getOnMyOtherCodeListener().onOther(presenter, bean);
        }
    }

    @Override
    public void onError(IBasePresenter presenter) {
        if (mBuilder.getOnMyErrorListener() != null) {
            mBuilder.getOnMyErrorListener().onError(presenter);
        }
    }

    @Override
    public void onSuccess(IBasePresenter presenter, D d) {
        if (mBuilder.getOnMySuccessListener() != null) {
            getSuccessView(mBuilder.getSuccessRid());
            mBuilder.getOnMySuccessListener().onSuccess(presenter, d);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
