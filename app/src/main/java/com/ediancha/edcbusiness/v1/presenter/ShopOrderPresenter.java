package com.ediancha.edcbusiness.v1.presenter;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.v1.bean.ShopOrderItemBean;

/**
 * Created by Admin on 2017/11/14.
 */

public class ShopOrderPresenter{

    IShopOrderView mOrderView;

    public ShopOrderPresenter(IShopOrderView iShopOrderView) {
        mOrderView=iShopOrderView;
    }

    public void getOrderItem(String token) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(ShopOrderItemBean.class)
                .setUrl(ApiContant.SHOP_ORDER_ITEM_URL)
                .setParms("token",token)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<ShopOrderItemBean>() {
                    @Override
                    public void onSuccess(ShopOrderItemBean bean) {
                        mOrderView.successData(bean);
                    }
                })
        )
                .excute();
    }

    public interface IShopOrderView extends IContextView {
        void successData(ShopOrderItemBean data);
    }
}
