package com.dmz.library.dmzapi.api.bean;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/6/20.
 */

public interface IBaseListBean<D extends ViewBaseType> extends IBaseBean<ArrayList<D>> {
    /**
     * 是否还有下一页
     *
     * @return
     */
    boolean haveNextPage();


}
