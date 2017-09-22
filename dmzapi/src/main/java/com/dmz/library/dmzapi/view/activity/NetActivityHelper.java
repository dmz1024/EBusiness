package com.dmz.library.dmzapi.view.activity;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataContract;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.contract.SingleDataContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/21.
 */

public class NetActivityHelper {


//    protected SwipeRefreshLayout swRoot;
//    protected NestedScrollView scRoot;
//    protected SingleDataContract mContract;
//    @Override
//    protected void initView() {
//        super.initView();
//        swRoot = findViewById(R.id.swRoot);
//        scRoot = findViewById(R.id.scRoot);
//    }
//
//    @Override
//    protected void initData() {
//        super.initData();
//        mContract = SingleDataContract.<T, D>_instance(scRoot, swRoot);
//        initDmzBuilder();
//        initMoreBuilder();
//        mContract._init();
//    }
//
//
//    protected SingleDataBuilder mBuilder;
//
//    protected void initMoreBuilder() {
//        mBuilder = SingleDataBuilder._build().setDmzBuilder(dBuilder);
//        mContract.setDataBuilder(mBuilder);
//    }
//
//    protected DmzBuilder dBuilder;
//
//    protected void initDmzBuilder() {
//        dBuilder = DmzBuilder._builder();
//    }
//
//    protected int getRid() {
//        return R.layout.view_base_single_data;
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mContract.destroy();
//        mContract = null;
//    }


//    protected SwipeRefreshLayout swRoot;
//    protected RecyclerView rvRoot;
//    protected MoreDataBuilder mBuilder;
//    protected MoreDataContract mContract;
//    protected DmzBuilder dBuilder;

//    @Override
//    protected void initView() {
//        super.initView();
//        swRoot = findViewById(R.id.swRoot);
//        rvRoot = findViewById(R.id.rvRoot);
//    }
//
//    @Override
//    protected void initData() {
//        super.initData();
//        initDmzBuilder();
//        initMoreBuilder();
//        mContract = MoreDataContract.<T>_instance(this, rvRoot, swRoot).setMoreDataBuilder(mBuilder)._init();
//    }
//
//    protected void initMoreBuilder() {
//        mBuilder = MoreDataBuilder._build().setDmzBuilder(dBuilder);
//    }
//
//
//
//    protected void initDmzBuilder() {
//        dBuilder = DmzBuilder._builder();
//    }
//
//
//
//    protected int getRid() {
//        return R.layout.view_base_more_data;
//    }
//
//    @Override
//    public abstract void convert(int viewType, ViewHolder holder, D d, int position);
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mContract.destroy();
//        mContract = null;
//    }
//}
}
