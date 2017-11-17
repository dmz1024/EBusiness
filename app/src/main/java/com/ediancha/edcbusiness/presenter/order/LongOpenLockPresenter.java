package com.ediancha.edcbusiness.presenter.order;

import android.support.v7.app.AlertDialog;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMyOtherCodeListener;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.OpenLockBean;
import com.ediancha.edcbusiness.bean.SpaceOrderBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;

/**
 * Created by dengmingzhi on 2017/10/10.
 */

public class LongOpenLockPresenter {
    private IOpenLockView iContextView;

    public LongOpenLockPresenter(IOpenLockView iContextView) {
        this.iContextView = iContextView;
    }

    public void openLock(String spaceId) {
        DmzApi._build()
                .setDmzBuilder(DmzBuilder._builder()
                        .setUrl(ApiContant.OPEN_LOCK)
                        .setaClass(OpenLockBean.class)
                        .setParms(UserInfoUtil.getUserToken())
                        .setParms("id", spaceId, "orderSrc", "2")
                        .setiLoadingView(new MyProgress(iContextView.getContext()))
                        .setOnMySuccessListener(new OnMySuccessListener<OpenLockBean.Data>() {
                            @Override
                            public void onSuccess(OpenLockBean.Data data) {
                                iContextView.openSuccess(data);
                            }
                        })
                        .setOnMyOtherCodeListener(new OnMyOtherCodeListener<OpenLockBean>() {
                            @Override
                            public void onOther(OpenLockBean bean) {
                                iContextView.onOtherCode(bean);
                            }
                        })
                )
                .excute();
    }

    public interface IOpenLockView extends IContextView {
        void openSuccess(OpenLockBean.Data data);

        void onOtherCode(OpenLockBean data);
    }
}
