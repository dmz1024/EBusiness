package com.dmz.library.dmzapi.api.presenter;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.view.IMoreDataView;
import com.dmz.library.dmzapi.api.model.MoreDataBaseModel;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/5.
 */

public class MoreDataBasePresenter<D extends BaseListBean> extends NetBasePresenter<D, D, MoreDataBaseModel<D>, IMoreDataView<D, D>> {

    private MoreDataBuilder moreDataBuilder;

    public MoreDataBasePresenter setMoreDataBuilder(MoreDataBuilder moreDataBuilder) {
        this.moreDataBuilder = moreDataBuilder;
        moreDataBuilder.setData(getM().getDatas());
        return this;
    }

    public MoreDataBasePresenter(IMoreDataView iMoreDataView) {
        createPresenter(new MoreDataBaseModel<D>(this), iMoreDataView);
    }


    @Override
    public void excute() {
        if (getM().lastIsMore() && moreDataBuilder.getRequestEnum() == MoreDataBuilder.RequestEnum.LOADMORE) {
            return;
        }


//        getM().setRequestEnum(moreDataBuilder.getRequestEnum());
        switch (moreDataBuilder.getRequestEnum()) {
            case FIRST_REFRESH:
                moreDataBuilder.setPage(1);
                break;
            case REFRESH:
                moreDataBuilder.setPage(1);
                break;
            case CLEAR_REFRESH:
                moreDataBuilder.setPage(1);
                getM().clear();
                break;
            case LOADMORE:
                moreDataBuilder.setPage(moreDataBuilder.getPage() + 1);
                getM().addLoadMore();
                break;
        }

        setDmzBuilder(moreDataBuilder.getDmzBuilder().setAll(true).setParms("page", moreDataBuilder.getSPage(), "size", moreDataBuilder.getSSize()));
        super.excute();
        getV().notifyDataSetChanged();
    }


    @Override
    public void onError() {
        super.onError();

        if (getM().size2()) {
            getM().clear();
            getM().addError();
        } else {
            switch (moreDataBuilder.getRequestEnum()) {
                case LOADMORE:
                    moreDataBuilder.setPage(moreDataBuilder.getPage() - 1);
                    getM().removeLast();
                    break;
                case CLEAR_REFRESH:
                case REFRESH:
                case FIRST_REFRESH:
                    getM().remove0();
                    break;

            }
        }
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onOther(D bean) {
        super.onOther(bean);
        if (bean.getCode() == dmzBuilder.getLoginCode()) {
            moreDataBuilder.setPage(1);
            getM().clear();
            getM().addLogin();
        } else {
            if (getM().size2()) {
                getM().clear();
                getM().addError();
            } else {
                switch (moreDataBuilder.getRequestEnum()) {
                    case LOADMORE:
                        moreDataBuilder.setPage(moreDataBuilder.getPage() - 1);
                        getM().removeLast();
                        break;
                    case CLEAR_REFRESH:
                    case REFRESH:
                    case FIRST_REFRESH:
                        getM().remove0();
                        break;
                }
            }
        }

        if (getM().sizeO()) {
            getM().addEmpty();
        }
        getV().stopRefresh();
        getV().notifyDataSetChanged();
    }

    @Override
    public void onSuccess(D bean) {
        super.onSuccess(bean);
        ArrayList data = bean.getData();
        switch (moreDataBuilder.getRequestEnum()) {
            case FIRST_REFRESH:
            case REFRESH:
            case CLEAR_REFRESH:
                getM().clear();
                getM().addData(data);
                break;
            case LOADMORE:
                getM().removeLast();
                getM().addData(data);
                break;
        }

        if (getM().sizeO()) {
            getM().addEmpty();
        } else if (!bean.haveNextPage() || !moreDataBuilder.isCanLoadMore()) {
            getM().addNoMore();
        }
        getV().stopRefresh();
        moreDataBuilder.setHaveMore(bean.haveNextPage());
        moreDataBuilder.setRequesting(false);
        getV().notifyDataSetChanged();
    }
}
