package com.ediancha.edcbusiness.v1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.v1.bean.ShopOrderDataBean;
import com.ediancha.edcbusiness.v1.bean.SpaceOrderDataBean;
import com.ediancha.edcbusiness.v1.bean.SpaceOrderItemBean;
import com.ediancha.edcbusiness.v1.presenter.SpaceOrderPresenter;
import com.ediancha.edcbusiness.view.BaseFragment;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Admin on 2017/11/13.
 */

public class SpaceOrderSubFragment extends BaseFragment<SpaceOrderDataBean.Data, SpaceOrderDataBean> {

    public static SpaceOrderSubFragment newInstance() {
        return new SpaceOrderSubFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.e("SpaceOrderSubFragment +  onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.e("SpaceOrderSubFragment +  onStart");
    }

    @Override
    protected void initMoreBuilder() {
        mBuilder.setCanRefresh(true)
                .addView(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_space_order)
                        .setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceOrderDataBean.class)
                .setUrl(ApiContant.SHOP_ORDER_ITEM_URL)
                .setParms("token", "NDgxNjA5N1==");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, SpaceOrderDataBean.Data data, int position) {
        holder.setText(R.id.tv_name, "望京店")
                .setText(R.id.tv_status, "待使用")
                .setText(R.id.tv_time, "使用时段： 2017-05-07")
                .setText(R.id.tv_money, "支付金额： 100元");
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        super.onItemClick(viewType, adapterHelper, position);
    }
}
