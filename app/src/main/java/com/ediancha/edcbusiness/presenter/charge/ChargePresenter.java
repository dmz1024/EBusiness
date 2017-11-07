package com.ediancha.edcbusiness.presenter.charge;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.pay.PayInfoBean;
import com.ediancha.edcbusiness.bean.pay.WeChatBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.pay.WeChatPayUtil;

/**
 * Created by Admin on 2017/10/13.
 */

public class ChargePresenter {

    private IChargeView mIChargeView;

    public ChargePresenter(IChargeView iChargeView) {
        this.mIChargeView = iChargeView;
    }

    public void Pay(String id, int payType, String money, String isGive) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(payType==1?PayInfoBean.AliPayInfoBean.class: PayInfoBean.WeChatPayInfoBean.class)
                .setUrl(ApiContant.CHAREGE_MONEY_URL)
                .setAll(true)
                .setOnMySuccessListener(payType==1?new OnMySuccessListener<PayInfoBean.AliPayInfoBean>() {
                    @Override
                    public void onSuccess(PayInfoBean.AliPayInfoBean bean) {
                        mIChargeView.successCode(bean);
                    }
                }:new OnMySuccessListener<PayInfoBean.WeChatPayInfoBean>() {
                    @Override
                    public void onSuccess(PayInfoBean.WeChatPayInfoBean bean) {
                        mIChargeView.successCode(bean);
                    }
                })
                .setParms(UserInfoUtil.getUserToken())
                .setParms("id",id, "payType", payType+"", "money",money, "isGive", isGive)
                .setiLoadingView(new MyProgress(mIChargeView.getContext())))
                .excute();
    }

    public interface IChargeView extends IContextView {
        void successCode(PayInfoBean bean);
    }
}
