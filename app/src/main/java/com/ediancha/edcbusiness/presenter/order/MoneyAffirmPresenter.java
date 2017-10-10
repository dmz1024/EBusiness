package com.ediancha.edcbusiness.presenter.order;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.MoneyAffirmBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;

/**
 * Created by dengmingzhi on 2017/10/9.
 */

public class MoneyAffirmPresenter {
    private IContextView iMoneyAffirmView;

    public MoneyAffirmPresenter(IContextView iMoneyAffirmView) {
        this.iMoneyAffirmView = iMoneyAffirmView;
    }

    public void goMoneyAffir(String id) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setUrl(ApiContant.SCANCODE)
                .setParms(UserInfoUtil.getUserToken())
                .setParms("id", id)
                .setiLoadingView(new MyProgress(iMoneyAffirmView.getContext()))
                .setaClass(MoneyAffirmBean.class)
                .setOnMySuccessListener(new OnMySuccessListener<MoneyAffirmBean.Data>() {
                    @Override
                    public void onSuccess(MoneyAffirmBean.Data data) {
                        Go.goMoneyAffirmActivity(data);
                    }
                })
        )
                .excute();
    }
}
