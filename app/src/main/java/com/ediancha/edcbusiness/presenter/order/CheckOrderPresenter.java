package com.ediancha.edcbusiness.presenter.order;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.ediancha.edcbusiness.bean.CheckOrderBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class CheckOrderPresenter {

    public void check() {
        DmzApi._build()
                .setDmzBuilder(
                        DmzBuilder._builder()
                                .setUrl(ApiContant.HAND_ORDER)
                                .setaClass(CheckOrderBean.class)
                                .setParms(UserInfoUtil.getUserToken())
                                .setOnMySuccessListener(new OnMySuccessListener<CheckOrderBean.Data>() {
                                    @Override
                                    public void onSuccess(CheckOrderBean.Data bean) {
                                        switch (bean.orderStatus) {
                                            case 1:
                                            case 2:
                                                Go.goSpaceOrderInProgeressDesc(bean.getOrderId());
                                                break;

                                        }
                                    }
                                })
                )
                .excute();
    }

}
