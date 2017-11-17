package com.ediancha.edcbusiness.presenter.v1.activity;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.ediancha.edcbusiness.bean.ActivityMessageBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/11/8.
 */

public class InfoPresenter {

    IInfoView mIInfoView;

    public InfoPresenter(IInfoView mIInfoView) {
        this.mIInfoView = mIInfoView;
    }

    public void getInfoView() {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(ActivityMessageBean.class)
                .setUrl(ApiContant.ACTIIVTY_MESSAGE_URL)
                .setOnMySuccessListener(new OnMySuccessListener<ActivityMessageBean.Data>() {
                    @Override
                    public void onSuccess(ActivityMessageBean.Data bean) {
                        mIInfoView.success(bean);
                    }
                })
        )
                .excute();
    }


    public interface IInfoView extends IContextView {

        void success(ActivityMessageBean.Data homeBean);
    }
}
