package com.dmz.library.dmzapi.api.model;


import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;

/**
 * Created by dengmingzhi on 2017/8/22.
 */

public interface IBaseModel<D> extends OnMySuccessListener<D> {
    void excute();
}
