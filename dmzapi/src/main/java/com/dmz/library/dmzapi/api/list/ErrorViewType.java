package com.dmz.library.dmzapi.api.list;

import com.dmz.library.dmzapi.R;

/**
 * Created by dengmingzhi on 2017/9/5.
 * 空界面
 */

public class ErrorViewType extends AdapterHelper.ViewTypeInfo {
    @Override
    public AdapterHelper.OnConvertInterface getConvertInterface() {
        return null;
    }

    @Override
    public int getType() {
        return 100002;
    }


    @Override
    public int getRid() {
        return R.layout.dmzshow_item_error_view;
    }
}
