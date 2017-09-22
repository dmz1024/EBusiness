package com.dmz.library.dmzapi.api.bean;

/**
 * Created by dengmingzhi on 2017/6/22.
 */

public class ViewBaseType implements IType {


    public int iViewType;

    @Override
    public int getViewType() {
        return iViewType;
    }

    @Override
    public ViewBaseType setViewType(int type) {
        this.iViewType = type;
        return this;
    }


}
