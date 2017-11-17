package com.ediancha.edcbusiness.v1.presenter;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.v1.bean.ShopOrderItemBean;
import com.ediancha.edcbusiness.v1.bean.SpaceOrderItemBean;

/**
 * Created by Admin on 2017/11/14.
 */

public class SpaceOrderPresenter {

    ISpaceOrderView mOrderView;

    public SpaceOrderPresenter(ISpaceOrderView iSpaceOrderView) {
        mOrderView=iSpaceOrderView;
    }

    public void getOrderItem(String token) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(SpaceOrderItemBean.class)
                .setUrl(ApiContant.SHOP_ORDER_ITEM_URL)
                .setParms("token",token)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<SpaceOrderItemBean>() {
                    @Override
                    public void onSuccess(SpaceOrderItemBean bean) {
                        mOrderView.successData(bean);
                    }
                })
        )
                .excute();
    }

    public interface ISpaceOrderView extends IContextView {
        void successData(SpaceOrderItemBean data);
    }
}
