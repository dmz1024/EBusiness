package com.dmz.library.dmzapi.api.list;

import com.dmz.library.dmzapi.api.BaseListBean;
import com.dmz.library.dmzapi.api.presenter.BasePresenter;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/5.
 */

public class MoreDataBasePresenter<D extends BaseListBean> extends BasePresenter<D, D> implements IMoreDataBasePresenter {
    private MoreDataBaseModel moreDataBaseModel;
    private IMoreDataView iMoreDataView;
    private MoreDataBuilder moreDataBuilder;


    public MoreDataBuilder getMoreDataBuilder() {
        return moreDataBuilder;
    }

    public MoreDataBasePresenter setMoreDataBuilder(MoreDataBuilder moreDataBuilder) {
        this.moreDataBuilder = moreDataBuilder;
        moreDataBuilder.setData(moreDataBaseModel.getDatas());
        return this;
    }

    public MoreDataBasePresenter(IMoreDataView iMoreDataView) {
        this.iMoreDataView = iMoreDataView;
        moreDataBaseModel = new MoreDataBaseModel<D>(this);

    }


    @Override
    public void notifyDataSetChanged() {
        iMoreDataView.notifyDataSetChanged();
    }

    @Override
    public void excute() {

        if (moreDataBaseModel.lastIsMore() && moreDataBuilder.getRequestEnum() == MoreDataBaseModel.RequestEnum.LOADMORE) {
            return;
        }

        moreDataBuilder.setRequesting(true);
        moreDataBaseModel.setRequestEnum(moreDataBuilder.getRequestEnum());
        switch (moreDataBuilder.getRequestEnum()) {
            case FIRST_REFRESH:
                moreDataBuilder.setPage(1);
                break;
            case REFRESH:
                moreDataBuilder.setPage(1);
                break;
            case CLEAR_REFRESH:
                moreDataBuilder.setPage(1);
                moreDataBaseModel.clear();
                break;
            case LOADMORE:
                moreDataBuilder.setPage(moreDataBuilder.getPage() + 1);
                moreDataBaseModel.addLoadMore();
                break;
        }
        moreDataBaseModel.excute(moreDataBuilder.getDmzBuilder().setAll(true).setParms("page", moreDataBuilder.getSPage(), "size", moreDataBuilder.getSSize()));
        notifyDataSetChanged();
    }


    @Override
    public void onError() {
        super.onError();
        if (moreDataBuilder.getOnMyErrorListener() != null) {
            moreDataBuilder.getOnMyErrorListener().onError();
        }

        if (moreDataBaseModel.size2()) {
            moreDataBaseModel.clear();
            moreDataBaseModel.addError();
        } else {
            switch (moreDataBaseModel.getRequestEnum()) {
                case LOADMORE:
                    moreDataBuilder.setPage(moreDataBuilder.getPage() - 1);
                    moreDataBaseModel.removeLast();
                    break;
                case CLEAR_REFRESH:
                case REFRESH:
                case FIRST_REFRESH:
                    moreDataBaseModel.remove0();
                    break;

            }
        }
        iMoreDataView.stopRefresh();
        notifyDataSetChanged();
    }

    @Override
    public void onOther(D bean) {
        super.onOther(bean);
        if (moreDataBuilder.getOnMyOtherCodeListener() != null) {
            moreDataBuilder.getOnMyOtherCodeListener().onOther(bean);
        }
        if (bean.getCode() == moreDataBuilder.getDmzBuilder().getLoginCode()) {
            moreDataBuilder.setPage(1);
            moreDataBaseModel.clear();
            moreDataBaseModel.addLogin();
        } else {
            if (moreDataBaseModel.size2()) {
                moreDataBaseModel.clear();
                moreDataBaseModel.addError();
            } else {
                switch (moreDataBaseModel.getRequestEnum()) {
                    case LOADMORE:
                        moreDataBuilder.setPage(moreDataBuilder.getPage() - 1);
                        moreDataBaseModel.removeLast();
                        break;
                    case CLEAR_REFRESH:
                    case REFRESH:
                    case FIRST_REFRESH:
                        moreDataBaseModel.remove0();
                        break;
                }
            }
        }

        if (moreDataBaseModel.sizeO()) {
            moreDataBaseModel.addEmpty();
        }
        iMoreDataView.stopRefresh();
        notifyDataSetChanged();
    }

    @Override
    public void onSuccess(D bean) {
        super.onSuccess(bean);

        if (moreDataBuilder.getOnMySuccessListener() != null) {
            moreDataBuilder.getOnMySuccessListener().onSuccess(bean);
        }

        ArrayList data = bean.getData();
        switch (moreDataBaseModel.getRequestEnum()) {
            case FIRST_REFRESH:
            case REFRESH:
            case CLEAR_REFRESH:
                moreDataBaseModel.clear();
                moreDataBaseModel.addData(data);
                break;
            case LOADMORE:
                moreDataBaseModel.removeLast();
                moreDataBaseModel.addData(data);
                break;
        }

        if (moreDataBaseModel.sizeO()) {
            moreDataBaseModel.addEmpty();
        } else if (!bean.haveNextPage() || !moreDataBuilder.isCanLoadMore()) {
            moreDataBaseModel.addNoMore();
        }
        iMoreDataView.stopRefresh();
        moreDataBuilder.setHaveMore(bean.haveNextPage());
        moreDataBuilder.setRequesting(false);
        notifyDataSetChanged();
    }
}
