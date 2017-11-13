package com.ediancha.edcbusiness.v1.presenter;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.HomeBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/9.
 */

public class HomePresenter {

    IHomeView mIHomeView;

    public HomePresenter(IHomeView iHomeView) {
        this.mIHomeView = iHomeView;
    }

    public void getHomeView() {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(HomeBean.class)
                .setUrl(ApiContant.HOME_URL)
                .setOnMySuccessListener(new OnMySuccessListener<HomeBean.Data>() {
                    @Override
                    public void onSuccess(HomeBean.Data bean) {
                        mIHomeView.successHome(bean);
                    }
                })
                )
                .excute();
    }

    public interface IHomeView extends IContextView {

        void successHome(HomeBean.Data homeBean);
    }
}
