package com.dmz.library.dmzapi.api.contract;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.bean.IBaseBean;

import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.api.presenter.SinglePresenter;
import com.dmz.library.dmzapi.api.view.IMoreDataView;

/**
 * Created by dengmingzhi on 2017/9/15.
 */

public class SingleDataContract<T extends IBaseBean, D> extends IContract<SinglePresenter> implements IMoreDataView<T, D> {
    private SwipeRefreshLayout refreshLayout;
    private NestedScrollView scRoot;
    private SingleDataBuilder mBuilder;
    private LayoutInflater layoutInflater;

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获得屏幕宽度
     *
     * @param context
     * @return
     */
    public int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    private int totalHeight = 0;

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
            refreshLayout.setEnabled(mBuilder.isCanRefresh());
            refreshLayout.setRefreshing(false);
            excute();
        } else {
            refreshLayout.setEnabled(true);
            refreshLayout.post(autoRefresh);
        }
    }

    public SingleDataContract setDataBuilder(SingleDataBuilder mBuilder) {
        this.mBuilder = mBuilder;
        return this;
    }


    private Runnable autoRefresh = new Runnable() {
        @Override
        public void run() {
            refreshLayout.setRefreshing(true);
            excute();
        }
    };

    @Override
    public void excute() {
        super.excute();
        basePresenter.excute();
    }

    public SingleDataContract _init() {
        basePresenter = new SinglePresenter<T, D>(this).setMoreDataBuilder(mBuilder);
        initRefresh();
        notifyDataSetChanged();
        if (mBuilder.isFirstRequest()) {
            autoRefresh();
        }
        return this;
    }

    @Override
    public void notifyDataSetChanged() {
        View view = null;
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
        scRoot.removeAllViews();
        scRoot.addView(view);

//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        if (totalHeight == 0) {
//            totalHeight = getScreenHeight(refreshLayout.getContext()) - getStatusHeight(refreshLayout.getContext()) - dip2px(refreshLayout.getContext(), mBuilder.getBarHeight());
//        }
//
//        layoutParams.height = totalHeight;
//        view.setLayoutParams(layoutParams);
    }

    private void getLoginView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_login_view, null);
        mBuilder.setLoginView(view);
    }


    public View getSuccessView(int rid) {
        if (mBuilder.getSuccessView() == null) {
            mBuilder.setSuccessView(layoutInflater.inflate(rid, null));
        }
        return mBuilder.getSuccessView();
    }

    private void getLoadingView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_loading_view, null);
        mBuilder.setLoadingView(view);
    }

    private void getOtherView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_other_view, null);
        mBuilder.setOtherView(view);
    }

    private void getErrorView() {
        View view = layoutInflater.inflate(R.layout.dmzshow_single_error_view, null);
        mBuilder.setErrorView(view);
    }

    @Override
    public void stopRefresh() {
        refreshLayout.setEnabled(mBuilder.isCanRefresh());
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
            mBuilder.getOnMySuccessListener().onSuccess(presenter, d);
        }
    }
}
