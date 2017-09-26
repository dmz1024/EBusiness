package com.ediancha.edcbusiness.activity.my;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.bean.MyInfoBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/26.
 */
@Route(path = "/activity/my/myInfo")
public class MyInfoActivity extends SingleDataBaseActivity<MyInfoBean, MyInfoBean.Data> {

    @Override
    public void onSuccess(IBasePresenter presenter, MyInfoBean.Data bean) {

    }

    @Override
    protected void initContract() {
        super.initContract();

    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(com.dmz.library.dmzapi.R.layout.success_recyle_view);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(MyInfoBean.class).setUrl(ApiContant.MY_INFO).setParms("type", "12");
    }
}
