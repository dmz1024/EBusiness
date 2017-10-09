package com.ediancha.edcbusiness.presenter.user;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/9/30.
 */

public class AuthorPresnter {

    private IAuthorView mIAuthorView;

    public AuthorPresnter(IAuthorView mIAuthorView) {
        this.mIAuthorView = mIAuthorView;
    }

    public void authentication(String trueName, String cerNo, String userId, String token) {

        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.AUTHER_URL)
                .setAll(true)
                .setOnMyOtherCodeListener(new OnMyOtherCodeListener<BaseBean>() {
                    @Override
                    public void onOther(BaseBean bean) {
                        mIAuthorView.successCode(bean);
                    }
                })
                .setParms("trueName", trueName, "cerNo", cerNo, "userId", userId, "token", token)
                .setiLoadingView(new MyProgress(mIAuthorView.getContext())))
                .excute();
    }


    public interface IAuthorView extends IContextView {

        void successCode(BaseBean bean);
    }

}
