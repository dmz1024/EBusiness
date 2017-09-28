package com.ediancha.edcbusiness.activity.order;

import android.graphics.Color;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ExpenseTipsBean;
import com.ediancha.edcbusiness.bean.SpaceOrderBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/22.
 */


@Route(path = "/activity/order/spaceOrder")
public class SpaceOrderActivity extends MoreDataBaseActivity<SpaceOrderBean.Data, SpaceOrderBean> {

    @Override
    protected void initView() {
        super.initView();
        rvRoot.setBackgroundColor(Color.parseColor("#f6f6f6"));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("空间订单");
    }

    @Override
    protected void initMoreBuilder() {
        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_activity_order_space).setConvertInterface(this).setOnClickListener(this));

    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceOrderBean.class)
                .setUrl(ApiContant.SPACE_ORDER).setParms("type", "5");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, SpaceOrderBean.Data data, int position) {
        holder
                .setText(R.id.tvInfo, data.getInfo())
                .setText(R.id.tvStatus, data.getStatus())
                .setText(R.id.tvStatusInfo, data.getStatusInfo())
                .setText(R.id.tvTitle, data.getTitle());
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        super.onItemClick(viewType, adapterHelper, position);
        Go.goSpaceOrderInProgeressDesc(adapterHelper.<SpaceOrderBean.Data>getT(position).getOrderId());
    }
}
