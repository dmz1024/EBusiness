package com.ediancha.edcbusiness.presenter.my;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/18.
 */

public class BindThreadPresenter {

    private IBindThreadView mIBindThreadView;

    public BindThreadPresenter(IBindThreadView iBindThreadView) {
        this.mIBindThreadView = iBindThreadView;
    }

    /**
     * 绑定
     * @param type
     * @param access_token
     */
    public void bindThread(int type, String access_token, String key) {

        DmzApi._build().setDmzBuilder(
                DmzBuilder._builder().setaClass(BaseBean.class)
                        .setUrl(type == 1 ? ApiContant.THREAD_BINDWECHAT_URL : ApiContant.THREAD_BINDQQ_URL)
                        .setAll(true)
                        .setOnMySuccessListener(new OnMySuccessListener<BaseBean>() {
                            @Override
                            public void onSuccess(BaseBean bean) {
                                mIBindThreadView.successCode();
                            }
                        })
                        .setParms(UserInfoUtil.getUserToken())
                        .setParms("type",type+"","access_token",access_token,type==2?"openid":"code",key)
                        .setiLoadingView(new MyProgress(mIBindThreadView.getContext())))
                .excute();
    }

    /**
     * 解除绑定
     * @param type
     */
    public void unBindThread(int type){
        DmzApi._build().setDmzBuilder(
                DmzBuilder._builder().setaClass(BaseBean.class)
                        .setUrl(ApiContant.THREAD_UNBIND_URL)
                        .setAll(true)
                        .setOnMySuccessListener(new OnMySuccessListener<BaseBean>() {
                            @Override
                            public void onSuccess(BaseBean bean) {
                                mIBindThreadView.unBindSuccess();
                            }
                        })
                        .setParms(UserInfoUtil.getUserToken())
                        .setParms("type",type+"")
                        .setiLoadingView(new MyProgress(mIBindThreadView.getContext())))
                .excute();
    }


    public interface IBindThreadView extends IContextView {

        void successCode();

        void unBindSuccess();
    }

}
