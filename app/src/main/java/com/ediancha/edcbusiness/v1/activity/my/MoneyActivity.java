package com.ediancha.edcbusiness.v1.activity.my;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.bean.walletbean.MyPackageBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/21.
 * 余额
 */

@Route(path = "/v1/activity/my/money")
public class MoneyActivity extends SingleDataBaseActivity<MyPackageBean, MyPackageBean.Data> {


    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.tvCmoney)
    TextView tvCmoney;
    @BindView(R.id.tvSmoney)
    TextView tvSmoney;
    @BindView(R.id.tvXieyi)
    TextView tvXieyi;

    @Override
    public void onSuccess(IBasePresenter presenter, MyPackageBean.Data bean) {
        MyPackageBean.MoneyBean money = bean.getMoney();
        tvMoney.setText("￥"+money.getGiftAmount());
        tvCmoney.setText(money.getUserMoney());
        tvSmoney.setText(money.getMoney());
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW).setAlwaysErr(false).setSuccessRid(R.layout.activity_money);
    }


    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(MyPackageBean.class)
                .setUrl(ApiContant.MYPACKAGE)
                .setParms(UserInfoUtil.getUserToken());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("余额")
                .addItemView(new DmzBar.DmzBarItemInfo().setTitle("明细"));
    }

    @OnClick(R.id.btSubmit)
    void onClick() {
        Go.goCharge();
    }

}
