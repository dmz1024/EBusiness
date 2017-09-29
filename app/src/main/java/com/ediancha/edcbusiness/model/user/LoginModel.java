package com.ediancha.edcbusiness.model.user;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.model.BaseNetModel;
import com.dmz.library.dmzapi.api.model.SingleBaseModel;
import com.dmz.library.dmzapi.api.presenter.NetBasePresenter;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.user.LoginBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/28.
 */

public class LoginModel extends SingleBaseModel<LoginBean, LoginBean> {

    public LoginModel(NetBasePresenter netBasePresenter) {
        super(netBasePresenter);
    }


}
