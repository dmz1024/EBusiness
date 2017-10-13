package com.ediancha.edcbusiness.activity.orderdetail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/10/13.
 */

@Route(path = "/activity/orderdetail/consumeDetail")
public class ConsumeDetailActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface {


    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.recy)
    RecyclerView mRecy;

    AdapterHelper mAdapterHelper;

    @Override
    protected void initView() {
        super.initView();

        mAdapterHelper = AdapterHelper._instance(this, mRecy)._initData(null).setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_consumedetail).setConvertInterface(this));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("消费详情");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_consumedetail;
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        holder.setText(R.id.tv_key, "")
                .setText(R.id.tv_value, "");
    }
}
