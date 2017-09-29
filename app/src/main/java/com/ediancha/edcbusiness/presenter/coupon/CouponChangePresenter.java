package com.ediancha.edcbusiness.presenter.coupon;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/9/29.
 */

public class CouponChangePresenter {

    ICouponChangeView mICouponChangeView;
    public CouponChangePresenter(ICouponChangeView mICouponChangeView){
        this.mICouponChangeView=mICouponChangeView;
    }

    public void exchangeCoupon(String userId,String code){
        DmzApi._build()
                .setDmzBuilder(DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.COUPON_CHANGE)
                        .setAll(true)
                        .setOnMySuccessListener(new OnMySuccessListener<BaseBean>() {
                            @Override
                            public void onSuccess(BaseBean bean) {
                                mICouponChangeView.successCode(bean);
                            }
                        })
                .setParms("userId",userId,"couponcode",code)
                .setiLoadingView(new MyProgress(mICouponChangeView.getContext())))
                .excute();
    }

    public interface ICouponChangeView extends IContextView{

        void successCode(BaseBean baseBean);
    }
}
