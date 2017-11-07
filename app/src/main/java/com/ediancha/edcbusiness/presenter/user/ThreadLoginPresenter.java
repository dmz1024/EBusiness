package com.ediancha.edcbusiness.presenter.user;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.LoginBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.login.Login;
import com.ediancha.edcbusiness.router.Go;

/**
 * Created by Admin on 2017/10/18.
 */

public class ThreadLoginPresenter {

    private IThreadLoginView mIThreadLoginView;
    String key;

    public ThreadLoginPresenter(IThreadLoginView iThreadLoginView) {
        this.mIThreadLoginView = iThreadLoginView;
    }

    /**
     * type==1 QQ登陆 2：微信
     *
     * @param key
     * @param type
     */
    public void threadLogin(String key, final int type) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(LoginBean.class)
                .setUrl(type == 1 ? ApiContant.QQ_LOGIN_URL : ApiContant.WECHAT_LOGIN_URL)
                .setOnMySuccessListener(new OnMySuccessListener<LoginBean.Data>() {
                    @Override
                    public void onSuccess(LoginBean.Data bean) {
                        if (type == 1) {
                            UserInfoUtil.saveInfo(bean);
                            mIThreadLoginView.loginThreadSuccess();
                        } else {
                            UserInfoUtil.saveInfo(bean);
                            mIThreadLoginView.loginThreadSuccess();
                        }
                    }
                })
                .setOnMyOtherCodeListener(new OnMyOtherCodeListener<LoginBean>() {
                    @Override
                    public void onOther(LoginBean bean) {
                        switch (bean.getCode()) {
                            case 60058:
                                mIThreadLoginView.regBind();
                                break;
                            default:
                        }
                    }
                })
                .setParms(type == 1 ? "openid" : "code", key))
                .excute();
    }

    public void bindLogin(String type, String userPhone, String code, String access_token, String openid) {

        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(LoginBean.class)
                .setUrl(ApiContant.BIND_URL)
                .setOnMySuccessListener(new OnMySuccessListener<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean bean) {
                        mIThreadLoginView.successBind();
                    }
                })
                .setParms("type", type, "userPhone", userPhone, "code", code, "access_token", access_token, "openid", openid)
                .setiLoadingView(new MyProgress(mIThreadLoginView.getContext())))
                .excute();
    }

    public interface IThreadLoginView extends IContextView {

        void loginThreadSuccess();

        void regBind();


        void successBind();
    }
}
