package com.dmz.library.dmzapi.view.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataContract;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.contract.SingleDataContract;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public class SingleDataBaseActivity<T extends IBaseBean, D> extends ToobarBaseActivity {
    protected SwipeRefreshLayout swRoot;
    protected NestedScrollView scRoot;

    @Override
    protected void init() {
        initView();
        initData();
    }

    protected SingleDataContract mContract;

    private void initData() {
        mContract = SingleDataContract.<T, D>_instance(scRoot, swRoot);
        initDmzBuilder();
        initMoreBuilder();
        mContract._init();
    }

    protected SingleDataBuilder mBuilder;

    protected void initMoreBuilder() {
        mBuilder = SingleDataBuilder._build().setDmzBuilder(dBuilder);
        mContract.setDataBuilder(mBuilder);
    }

    protected DmzBuilder dBuilder;

    protected void initDmzBuilder() {
        dBuilder = DmzBuilder._builder();
    }

    protected void initView() {
        swRoot = findViewById(R.id.swRoot);
        scRoot = findViewById(R.id.scRoot);
    }

    protected int getRid() {
        return R.layout.view_base_single_data;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContract.destroy();
        mContract = null;
    }
}
