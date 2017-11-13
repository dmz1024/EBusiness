package com.ediancha.edcbusiness.v1.activity.my;

import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.v1.bean.SetBean;

/**
 * Created by dengmingzhi on 2017/11/13.
 */

public class SetActivity extends SingleDataBaseActivity<SetBean, SetBean.Data> {
    @Override
    public void onSuccess(IBasePresenter presenter, SetBean.Data bean) {

    }

    @Override
    protected void initDataBuilder() {

    }

    @Override
    protected void initDmzBuilder() {

    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("设置");
    }
}
