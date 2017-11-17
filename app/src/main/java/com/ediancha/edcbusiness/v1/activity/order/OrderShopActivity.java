package com.ediancha.edcbusiness.v1.activity.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.v1.bean.OrderShopBean;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/11/13.
 */
@Route(path = "/v1/activity/order/ordershop")
public class OrderShopActivity extends SingleDataBaseActivity<OrderShopBean, OrderShopBean.Data> implements AdapterHelper.OnConvertInterface {


    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_num)
    TextView mTvNum;
    @BindView(R.id.recy_item)
    RecyclerView mRecyItem;

    @Override
    public void onSuccess(IBasePresenter presenter, OrderShopBean.Data bean) {
        mTvName.setText(bean.getGoodsName());
        mTvPrice.setText("价格：" + bean.getOriginalPrice() + "元");
        mTvNum.setText("重量：" + bean.getUnits());
        ImageLoader.loadCircu(ctx, bean.getGoodsImage(), mImgShow);
        AdapterHelper._instance(ctx, mRecyItem)
                ._initData(bean.getOrderDetails())
                .setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1)
                        .setRid(R.layout.item_text_match)
                        .setConvertInterface(this));

    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.activity_ordershop);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(OrderShopBean.class)
                .setParms("orderNo", "12312312321")
                .setUrl(ApiContant.SHOP_ORDER_URL);

    }


    @Override
    protected void initBarView() {
        super.initBarView();

        dmzBar.setText("订单详情");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        OrderShopBean.OrderDetailsBean orderDetailsBean = (OrderShopBean.OrderDetailsBean) iType;
        holder
                .setText(R.id.tv_key, orderDetailsBean.getName())
                .setText(R.id.tv_value, orderDetailsBean.getValue());
    }
}
