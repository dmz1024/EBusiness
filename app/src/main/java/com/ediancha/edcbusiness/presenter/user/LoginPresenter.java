package com.ediancha.edcbusiness.presenter.user;


import android.content.Context;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.LoginBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/28.
 */

public class LoginPresenter {
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void login(String userPhone, String code) {
        DmzApi._build()
                .setDmzBuilder(
                        DmzBuilder._builder()
                                .setaClass(LoginBean.class)
                                .setUrl(ApiContant.LOGIN)
                                .setOnMySuccessListener(new OnMySuccessListener<LoginBean.Data>() {
                                    @Override
                                    public void onSuccess(LoginBean.Data bean) {
                                        iLoginView.loginSuccess();
                                    }
                                })
                                .setParms("userPhone", userPhone, "code", code)
                                .setiLoadingView(new MyProgress(iLoginView.getContext())))
                .excute();
    }

    public interface ILoginView extends IContextView {
        void loginSuccess();
    }

}
