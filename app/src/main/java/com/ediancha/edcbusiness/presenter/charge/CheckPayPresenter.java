package com.ediancha.edcbusiness.presenter.charge;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/13.
 */

public class CheckPayPresenter {

    private ICheckPayView mICheckPayView;

    public CheckPayPresenter(ICheckPayView iCheckPayView) {
        this.mICheckPayView = iCheckPayView;
    }

    public void checkPay(String id, String payType) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.CHECK_PAY_URL)
                .setOnMySuccessListener(new OnMySuccessListener() {
                    @Override
                    public void onSuccess(Object bean) {
                        mICheckPayView.successCode();
                    }
                }).setParms(UserInfoUtil.getUserToken())
                .setParms("id", id, "payType", payType)
                .setiLoadingView(new MyProgress(mICheckPayView.getContext())))
                .excute();
    }

    public interface ICheckPayView extends IContextView {
        void successCode();

        void failCode();
    }
}
