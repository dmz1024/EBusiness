package com.dmz.library.dmzapi.view.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.contract.BaseDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataContract;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.contract.SingleDataContract;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public abstract class SingleDataBaseActivity<T extends IBaseBean, D> extends ToobarBaseActivity implements BaseDataBuilder.OnMySuccessListener<D> {
    protected SwipeRefreshLayout swRoot;
    protected ViewGroup scRoot;


    protected SingleDataContract mContract;
    protected DmzBuilder dBuilder;

    protected SingleDataBuilder mBuilder;

    @Override
    protected void initView() {
        super.initView();
        swRoot = findViewById(R.id.swRoot);
        scRoot = findViewById(R.id.scRoot);
    }

    @Override
    protected void initData() {
        super.initData();
        dBuilder = DmzBuilder._builder();
        initDmzBuilder();
        mBuilder = SingleDataBuilder._build().setDmzBuilder(dBuilder).setOnMySuccessListener(this);
        initDataBuilder();
        mContract = SingleDataContract.<T, D>_instance(scRoot, swRoot);
        mContract.setDataBuilder(mBuilder);
        initContract();
        mContract._init();
    }

    protected void initContract() {

    }


    protected abstract void initDataBuilder();

    protected abstract void initDmzBuilder();

    @Override
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
