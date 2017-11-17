package com.ediancha.edcbusiness.v1.fragment;


import android.widget.ImageView;


import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.bean.ShopOrderDataBean;

import com.ediancha.edcbusiness.view.BaseFragment;

import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by Admin on 2017/11/13.
 */

public class ShopOrderSendFragment extends BaseFragment<ShopOrderDataBean.Data,ShopOrderDataBean> {

    public static ShopOrderSendFragment newInstance(){
        return new ShopOrderSendFragment();
    }
    @Override
    protected void initMoreBuilder() {
        mBuilder.setCanRefresh(true)
                .addView(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_shop_order)
                        .setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(ShopOrderDataBean.class)
                .setUrl(ApiContant.SHOP_ORDER_ITEM_URL)
                .setParms("token","NDgxNjA5N1==");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, ShopOrderDataBean.Data shopOrderDataBean, int position) {
        holder.setText(R.id.tv_location, shopOrderDataBean.getSpace())
                .setText(R.id.tv_name, shopOrderDataBean.getGoodsName())
                .setText(R.id.tv_price, "￥" + shopOrderDataBean.getOriginalPrice())
                .setText(R.id.tv_quality, shopOrderDataBean.getSpec() + shopOrderDataBean.getUnits());
        ImageLoader.loadCircu(getContext(), shopOrderDataBean.getGoodsImage(), holder.<ImageView>getView(R.id.img_show));

        switch (shopOrderDataBean.getStatus()) {
            case 1:
                holder.setText(R.id.tv_status, "生成订单");
                break;
            case 2:
                holder.setText(R.id.tv_status, "支付成功");
                break;
            case 3:
                holder.setText(R.id.tv_status, "出货失败");
                break;
            case 4:
                holder.setText(R.id.tv_status, "已取消");
                break;
            case 5:
                holder.setText(R.id.tv_status, "已完成");
                break;
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        Go.goShopOrderActivity();
    }
}
