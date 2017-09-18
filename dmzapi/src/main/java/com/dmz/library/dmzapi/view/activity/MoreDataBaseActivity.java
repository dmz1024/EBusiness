package com.dmz.library.dmzapi.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public class MoreDataBaseActivity<D extends IType, T extends BaseListBean> extends ToobarBaseActivity implements AdapterHelper.OnConvertInterface<D> {
    protected SwipeRefreshLayout swRoot;
    protected RecyclerView rvRoot;

    @Override
    protected void init() {
        initView();
        initData();
    }

    protected MoreDataContract mContract;

    private void initData() {
        initDmzBuilder();
        initMoreBuilder();
        mContract = MoreDataContract.<T>_instance(this, rvRoot, swRoot).setMoreDataBuilder(mBuilder)._init();
    }

    protected MoreDataBuilder mBuilder;

    protected void initMoreBuilder() {
        mBuilder = MoreDataBuilder._build().setDmzBuilder(dBuilder);
    }

    protected DmzBuilder dBuilder;

    protected void initDmzBuilder() {
        dBuilder = DmzBuilder._builder();
    }

    protected void initView() {
        swRoot = findViewById(R.id.swRoot);
        rvRoot = findViewById(R.id.rvRoot);
    }

    protected int getRid() {
        return R.layout.view_base_more_data;
    }

    @Override
    public void convert(int viewType, ViewHolder holder, D d, int position) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContract.destroy();
        mContract = null;
    }
}
