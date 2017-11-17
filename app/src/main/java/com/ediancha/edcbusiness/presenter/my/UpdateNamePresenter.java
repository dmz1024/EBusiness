package com.ediancha.edcbusiness.presenter.my;

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

/**
 * Created by Admin on 2017/10/10.
 */

public class UpdateNamePresenter {

    private IUpDateNameView mIUpDateNameView;

    public UpdateNamePresenter(IUpDateNameView iUpDateNameView) {
        this.mIUpDateNameView = iUpDateNameView;
    }

    public void UpdateName(String name, String userPhoto) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(BaseBean.class)
                .setUrl(ApiContant.UPDATAEINFO)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        mIUpDateNameView.responseCode(bean);
                    }
                })
                .setOnMyOtherCodeListener(new OnMyOtherCodeListener<BaseBean>() {
                    @Override
                    public void onOther(BaseBean bean) {
                        mIUpDateNameView.responseCode(bean);
                    }
                })
                .setParms(UserInfoUtil.getUserToken())
                .setParms("userName", name, "userPhoto", userPhoto)
                .setiLoadingView(new MyProgress(mIUpDateNameView.getContext())))
                .excute();
    }


    public interface IUpDateNameView extends IContextView {
        void responseCode(BaseBean bean);
    }
}
