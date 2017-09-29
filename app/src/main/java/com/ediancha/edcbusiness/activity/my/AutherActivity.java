package com.ediancha.edcbusiness.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.dialog.AutherDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/28.
 * <p>
 * 认证界面
 */
@Route(path = "/activity/my/auther")
public class AutherActivity extends SingleDataBaseActivity<BaseBean, Object> {


    @BindView(R.id.tv_info)
    TextView mTvInfo;
    @BindView(R.id.tv_name)
    EditText mTvName;
    @BindView(R.id.tv_card)
    EditText mTvCard;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;

    private AutherDialog mAutherDialog;

    @Override
    protected void initDataBuilder() {
        mBuilder.setFirstRequest(false)
                .setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW)
                .setSuccessRid(R.layout.activity_auther);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(BaseBean.class)
                .setUrl(ApiContant.AUTHER_URL)
                .setParms();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("实名认证");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, Object bean) {

    }

    @OnClick({R.id.tv_submit})
    void click() {
        mAutherDialog = new AutherDialog();
        mAutherDialog.show(getSupportFragmentManager(),"2");
        String name = mTvName.getText().toString().trim();
        String card = mTvCard.getText().toString().trim();
        mAutherDialog.setName(name)
                .setCard(card)
                .setOkClickListner(new AutherDialog.okClickListner() {
                    @Override
                    public void setOnOkListener() {
                    }
                });
    }
}
