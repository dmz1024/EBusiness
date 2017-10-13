package com.ediancha.edcbusiness.activity.orderdetail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/10/13.
 */
@Route(path = "/activity/orderdetail/orderItem")
public class OrderItemActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener {


    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.recy)
    RecyclerView mRecy;

    AdapterHelper mAdapterHelper;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("余额明细");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_orderitem;
    }

    @Override
    protected void initData() {
        super.initData();
        mAdapterHelper = AdapterHelper._instance(this, mRecy)._initData(null).setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_order_item).setConvertInterface(this).setOnClickListener(this));

    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        holder.setText(R.id.tv_name, "")
                .setText(R.id.tv_date, "")
                .setText(R.id.tv_money, "");
        Glide.with(this).load("")
                .into(holder.<ImageView>getView(R.id.img_head));
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

    }
}
