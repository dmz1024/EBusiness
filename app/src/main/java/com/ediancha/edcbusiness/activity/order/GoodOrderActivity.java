package com.ediancha.edcbusiness.activity.order;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.GoodsOrderBean;
import com.ediancha.edcbusiness.bean.SpaceOrderBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/22.
 */


@Route(path = "/activity/order/goodOrder")
public class GoodOrderActivity extends MoreDataBaseActivity<GoodsOrderBean.Data, GoodsOrderBean> {

    @Override
    protected void initView() {
        super.initView();
        rvRoot.setBackgroundColor(Color.parseColor("#f6f6f6"));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("商品订单");
    }

    @Override
    protected void initMoreBuilder() {
        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_good_order).setConvertInterface(this).setOnClickListener(this));

    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(GoodsOrderBean.class)
                .setUrl(ApiContant.GOOD_ORDER).setParms(UserInfoUtil.getUserToken());
    }

    @Override
    public void convert(int viewType, ViewHolder holder, GoodsOrderBean.Data data, int position) {
        holder.setText(R.id.tvStatus, data.getStatus())
                .setText(R.id.tvStatusInfo, data.getStatusInfo())
                .setText(R.id.tvTitle, data.getTitle())
                .setText(R.id.tvGoodName, data.getGoodName())
                .setText(R.id.tvInfo, data.getGoodInfo())
                .setText(R.id.tvCount, data.getGoodNum())
                .setText(R.id.tvPrice, data.getGoodPrice());
        Glide.with(this).load(data.getGoodImg()).into(holder.<ImageView>getView(R.id.ivGoodImg));
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        super.onItemClick(viewType, adapterHelper, position);
        Go.goGoodOrderDesc(adapterHelper.<GoodsOrderBean.Data>getT(position).getOrderId());
    }
}
