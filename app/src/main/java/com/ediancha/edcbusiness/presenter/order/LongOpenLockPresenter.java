package com.ediancha.edcbusiness.presenter.order;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.OpenLockBean;
import com.ediancha.edcbusiness.bean.SpaceOrderBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

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
                )
                .excute();
    }

    public interface IOpenLockView extends IContextView {
        void openSuccess(OpenLockBean.Data data);
    }
}
