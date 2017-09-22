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

public abstract class MoreDataBaseActivity<D extends IType, T extends BaseListBean> extends ToobarBaseActivity implements AdapterHelper.OnConvertInterface<D> {
    protected SwipeRefreshLayout swRoot;
    protected RecyclerView rvRoot;
    protected MoreDataBuilder mBuilder;
    protected MoreDataContract mContract;
    protected DmzBuilder dBuilder;

    @Override
    protected void initView() {
        super.initView();
        swRoot = findViewById(R.id.swRoot);
        rvRoot = findViewById(R.id.rvRoot);
    }

    @Override
    protected void initData() {
        super.initData();
        dBuilder = DmzBuilder._builder();
        initDmzBuilder();
        mBuilder = MoreDataBuilder._build().setDmzBuilder(dBuilder);
        initMoreBuilder();
        mContract = MoreDataContract.<T>_instance(this, rvRoot, swRoot);
        initContract();
        mContract.setMoreDataBuilder(mBuilder)._init();
    }

    protected void initContract() {
    }

    protected abstract void initMoreBuilder();

    protected abstract void initDmzBuilder();

    protected int getRid() {
        return R.layout.view_base_more_data;
    }

    @Override
    public abstract void convert(int viewType, ViewHolder holder, D d, int position);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContract.destroy();
        mContract = null;
    }
}
