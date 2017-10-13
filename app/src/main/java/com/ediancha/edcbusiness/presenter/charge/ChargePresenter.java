package com.ediancha.edcbusiness.presenter.charge;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.pay.AliPayBean;
import com.ediancha.edcbusiness.bean.pay.WeChatBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/13.
 */

public class ChargePresenter {

    private IChargeView mIChargeView;

    public ChargePresenter(IChargeView iChargeView) {
        this.mIChargeView = iChargeView;
    }

    public void weChatPay(String id, String payType, String money, String isGive) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(WeChatBean.class)
                .setUrl(ApiContant.CHAREGE_MONEY_URL)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<WeChatBean>() {
                    @Override
                    public void onSuccess(WeChatBean bean) {
                        mIChargeView.successWeChatCode(bean);
                    }
                })
                .setParms(UserInfoUtil.getUserToken())
                .setParms("id",id, "payType", payType, "money",money, "isGive", isGive)
                .setiLoadingView(new MyProgress(mIChargeView.getContext())))
                .excute();
    }

    public void aliPay(String id, String payType, String money, String isGive) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(AliPayBean.class)
                .setUrl(ApiContant.CHAREGE_MONEY_URL)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<AliPayBean>() {
                    @Override
                    public void onSuccess(AliPayBean bean) {
                        mIChargeView.successAliPayCode(bean);
                    }
                })
                .setParms(UserInfoUtil.getUserToken())
                .setParms("id",id, "payType", payType, "money",money, "isGive", isGive)
                .setiLoadingView(new MyProgress(mIChargeView.getContext())))
                .excute();
    }

    public interface IChargeView extends IContextView {

        void successWeChatCode(WeChatBean bean);
        void successAliPayCode(AliPayBean bean);

        void failCode();
    }
}
