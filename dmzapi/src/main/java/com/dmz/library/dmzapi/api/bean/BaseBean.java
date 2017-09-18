package com.dmz.library.dmzapi.api.bean;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public class BaseBean<D> implements IBaseBean<D> {
    public int code;

    public String msg;

    public D data;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public D getData() {
        return data;
    }
}
