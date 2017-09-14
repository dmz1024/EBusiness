package com.dmz.library.dmzapi.api;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class BaseListBean<D extends ViewBaseType> implements IBaseListBean<D> {
    public int code;

    public String msg;

    public ArrayList<D> data;

    public Pager pager;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public ArrayList<D> getData() {
        return data;
    }

    @Override
    public boolean haveNextPage() {
        if (pager == null) {
            return false;
        }
        return pager.getCurrentPage() < pager.getTotalPage();
    }

    public static class Pager {
        public int curpage;
        public int pagecount;

        public int getCurrentPage() {
            return curpage;
        }

        public int getTotalPage() {
            return pagecount;
        }
    }
}
