package com.ediancha.edcbusiness.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.contract.MoreDataBuilder;
import com.dmz.library.dmzapi.api.contract.MoreDataContract;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/11/14.
 */

public abstract class BaseFragment<D extends IType, T extends BaseListBean> extends LazyLoadFragment implements AdapterHelper.OnConvertInterface<D>, AdapterHelper.OnClickListener {

    protected SwipeRefreshLayout swRoot;
    protected RecyclerView rvRoot;
    protected MoreDataBuilder mBuilder;
    protected MoreDataContract mContract;
    protected DmzBuilder dBuilder;

    @Override
    public void initBaseView() {
        swRoot = findViewById(com.dmz.library.dmzapi.R.id.swRoot);
        rvRoot = findViewById(com.dmz.library.dmzapi.R.id.rvRoot);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_base_view;
    }

    @Override
    protected void lazyLoad() {
        if (mBuilder == null) {
            dBuilder = DmzBuilder._builder();
            initDmzBuilder();
            mBuilder = MoreDataBuilder._build().setDmzBuilder(dBuilder);
            initMoreBuilder();
            mContract = MoreDataContract.<T>_instance(getContext(), rvRoot, swRoot);
            initContract();
            mContract.setMoreDataBuilder(mBuilder)._init();
        }
    }

    protected void initContract() {
    }

    protected abstract void initMoreBuilder();

    protected abstract void initDmzBuilder();

    protected int getRid() {
        return com.dmz.library.dmzapi.R.layout.view_base_more_data;
    }

    @Override
    public abstract void convert(int viewType, ViewHolder holder, D d, int position);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContract!=null){
            mContract.destroy();
            mContract = null;
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

    }
}
