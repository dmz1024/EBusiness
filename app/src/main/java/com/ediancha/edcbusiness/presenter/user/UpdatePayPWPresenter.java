package com.ediancha.edcbusiness.presenter.user;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

import java.lang.ref.SoftReference;

/**
 * Created by Admin on 2017/10/10.
 */

public class UpdatePayPWPresenter {

    private IUpdatePayPWView mIUpdatePayPWView;

    public UpdatePayPWPresenter(IUpdatePayPWView iUpdatePayPWView) {
        this.mIUpdatePayPWView = iUpdatePayPWView;
    }

    public void UpdatePayPw(String userPhone, String code, String payPwd) {

        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.UPDATE_PAY_URL)
                .setParms(UserInfoUtil.getUserToken())
                .setParms("userPhone", userPhone, "code", code, "payPwd", payPwd)
                .setSuccessMsg("修改成功!")
                .setiLoadingView(new MyProgress(mIUpdatePayPWView.getContext()))
                .setOnMySuccessListener(new OnMySuccessListener() {
                    @Override
                    public void onSuccess(Object bean) {
                        mIUpdatePayPWView.successCode();
                    }
                })
                .setOnMyOtherCodeListener(new OnMyOtherCodeListener() {
                    @Override
                    public void onOther(IBaseBean bean) {

                    }
                })).excute();
    }

    public interface IUpdatePayPWView extends IContextView {

        void successCode();
    }
}
