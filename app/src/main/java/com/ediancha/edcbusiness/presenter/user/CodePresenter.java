package com.ediancha.edcbusiness.presenter.user;


import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;

import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.LoginBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/28.
 */

public class CodePresenter {
    private ICodeView iLoginView;

    public CodePresenter(ICodeView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void getCode(String userPhone, int type) {
        DmzApi._build()
                .setDmzBuilder(
                        DmzBuilder._builder()
                                .setaClass(BaseBean.class)
                                .setUrl(ApiContant.GET_CODE)
                                .setShowSuccess(true)
                                .setSuccessMsg("验证码发送成功，请注意查收")
                                .setOnMySuccessListener(new OnMySuccessListener<Object>() {
                                    @Override
                                    public void onSuccess(Object bean) {
                                        iLoginView.codeSuccess();
                                    }
                                })
                                .setParms("userPhone", userPhone, "type", type + "")
                                .setiLoadingView(new MyProgress(iLoginView.getContext())))
                .excute();
    }

    public interface ICodeView extends IContextView {
        void codeSuccess();
    }

}
