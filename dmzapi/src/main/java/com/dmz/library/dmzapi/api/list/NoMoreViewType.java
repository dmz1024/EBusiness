package com.dmz.library.dmzapi.api.list;

import com.dmz.library.dmzapi.R;

/**
 * Created by dengmingzhi on 2017/9/5.
 * 空界面
 */

public class NoMoreViewType extends AdapterHelper.ViewTypeInfo {

    @Override
    public int getType() {
        return 100005;
    }


    @Override
    public int getRid() {
        return R.layout.dmzshow_item_no_more_view;
    }

}
