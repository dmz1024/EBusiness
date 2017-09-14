package com.dmz.library.dmzapi.api;

/**
 * Created by dengmingzhi on 2017/6/20.
 */

public interface IBaseBean<D> {
    /**
     * 获取返回码
     *
     * @return
     */
    int getCode();

    /**
     * 获取提示信息
     *
     * @return
     */
    String getMsg();

    /**
     * 获取返回数据
     *
     * @return
     */
    D getData();

}
