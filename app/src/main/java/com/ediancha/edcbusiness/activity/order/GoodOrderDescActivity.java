package com.ediancha.edcbusiness.activity.order;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.Copy;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.GoodsOrderDescBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/9/22.
 */


@Route(path = "/activity/order/goodOrderDesc")
public class GoodOrderDescActivity extends SingleDataBaseActivity<GoodsOrderDescBean, GoodsOrderDescBean.Data> implements AdapterHelper.OnConvertInterface<IType> {
    @Autowired
    public String orderId;
    @BindView(R.id.tvStatusInfo)
    TextView tvStatusInfo;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.ivGoodImg)
    ImageView ivGoodImg;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.tvGoodName)
    TextView tvGoodName;
    @BindView(R.id.tvInfo)
    TextView tvInfo;
    @BindView(R.id.tvCount)
    TextView tvCount;
    @BindView(R.id.rvPayInfo)
    RecyclerView rvPayInfo;
    @BindView(R.id.rvOrderInfo)
    RecyclerView rvOrderInfo;


    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("商品订单详情");
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.success_good_order_desc);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(GoodsOrderDescBean.class)
                .setUrl(ApiContant.GOOD_ORDER_DESC).setParms("type", "10").setParms("orderId", orderId);
    }

    @Override
    public void onSuccess(IBasePresenter presenter, GoodsOrderDescBean.Data bean) {

        GoodsOrderDescBean.Goods goods = bean.getGoods();
        ArrayList<GoodsOrderDescBean.OrderInfo> orderInfos = bean.getOrderInfos();
        ArrayList<GoodsOrderDescBean.PayInfo> payInfo = bean.getPayInfo();

        tvStatusInfo.setText(bean.getStatus());
        tvTitle.setText(bean.getTitle());
        tvPrice.setText(goods.getGoodPrice());
        tvGoodName.setText(goods.getGoodPrice());
        tvInfo.setText(goods.getGoodInfo());
        tvCount.setText(goods.getGoodNum());
        Glide.with(this).load(goods.getGoodImg()).into(ivGoodImg);


        AdapterHelper._instance(this, rvPayInfo)._initData(payInfo).setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        }).setType(new AdapterHelper.ViewTypeInfo().setType(1).setConvertInterface(this).setRid(R.layout.item_good_order_desc_payinfo));


        AdapterHelper._instance(this, rvOrderInfo)._initData(orderInfos).setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        }).setType(new AdapterHelper.ViewTypeInfo().setType(2).setConvertInterface(this).setRid(R.layout.item_good_order_desc_orderinfo));

    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        switch (viewType) {
            case 1:
                GoodsOrderDescBean.PayInfo payInfo = (GoodsOrderDescBean.PayInfo) iType;
                holder.setText(R.id.tvTitle, payInfo.getTitle()).setText(R.id.tvContent, payInfo.getContent()).setTextColor(R.id.tvContent, Color.parseColor(payInfo.getColor()));
                break;
            case 2:
                final GoodsOrderDescBean.OrderInfo orderInfo = (GoodsOrderDescBean.OrderInfo) iType;
                holder.setText(R.id.tvTitle, orderInfo.getContent()).setVisible(R.id.tvContent, orderInfo.isCopy);
                holder.setOnClickListener(R.id.tvContent, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Copy.toCopy(orderInfo.getContent(), getContext());
                    }
                });
                break;
        }
    }

}
