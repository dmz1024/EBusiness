package com.ediancha.edcbusiness.presenter.deposit;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/9/30.
 */

public class DepositPresenter  {

    private IDepositView mDepositView;

    public DepositPresenter(IDepositView iDepositView){
        this.mDepositView=iDepositView;
    }

    public void returnDeposit(String token,String userId){
        DmzApi._build().setDmzBuilder(
                DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.EXITDEPOSIT_URL)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        mDepositView.successCode(bean);
                    }
                })
                .setParms("token",token,"userId",userId)
                .setiLoadingView(new MyProgress(mDepositView.getContext()))
        ).excute();

    }

    public interface IDepositView extends IContextView{

        void successCode(BaseBean bean);
    }
}
