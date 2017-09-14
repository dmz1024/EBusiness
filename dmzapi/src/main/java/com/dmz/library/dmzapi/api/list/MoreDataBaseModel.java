package com.dmz.library.dmzapi.api.list;

import com.dmz.library.dmzapi.api.BaseListBean;
import com.dmz.library.dmzapi.api.IType;
import com.dmz.library.dmzapi.api.ViewBaseType;
import com.dmz.library.dmzapi.api.model.BaseNetModel;


import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/5.
 */

public class MoreDataBaseModel<D extends BaseListBean> extends BaseNetModel<D, D> {
    private ArrayList<IType> datas = new ArrayList<>();

    public MoreDataBaseModel(MoreDataBasePresenter iBasePresenter) {
        super(iBasePresenter);
    }

    public ArrayList<IType> getDatas() {
        return datas;
    }

    public void clear() {
        datas.clear();
    }

    public void removeLast() {
        datas.remove(datas.size() - 1);
    }

    public int size() {
        return datas.size();
    }

    public boolean sizeO() {
        return datas.size() == 0;
    }

    public void addEmpty() {
        datas.add(new ViewBaseType().setViewType(100001));
    }

    public void addError() {
        datas.add(new ViewBaseType().setViewType(100002));
    }

    public void addLogin() {
        datas.add(new ViewBaseType().setViewType(100004));
    }

    public void addLoadMore() {
        datas.add(new ViewBaseType().setViewType(100003));
    }

    public void addNoMore() {
        datas.add(new ViewBaseType().setViewType(100005));
    }


    public boolean size2() {
        return datas.size() <= 1;
    }

    public void remove0() {
        if (datas.size() == 1) {
            datas.remove(0);
        }
    }


    public void addData(IType d) {
        datas.add(d);
    }

    public void addData(ArrayList<IType> ds) {
        datas.addAll(ds);
    }

    public boolean lastIsMore() {
        if (datas.size() > 0) {
            return datas.get(datas.size() - 1).getViewType() == 100003;
        }
        return false;
    }

    public enum RequestEnum {
        REFRESH, CLEAR_REFRESH, LOADMORE, FIRST_REFRESH
    }

    private RequestEnum requestEnum = RequestEnum.FIRST_REFRESH;

    public MoreDataBaseModel setRequestEnum(RequestEnum requestEnum) {
        this.requestEnum = requestEnum;
        return this;
    }

    public RequestEnum getRequestEnum() {
        return requestEnum;
    }
}
