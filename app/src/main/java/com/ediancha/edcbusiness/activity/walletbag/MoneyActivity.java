package com.ediancha.edcbusiness.activity.walletbag;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.AnyPref;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.bean.walletbean.MoneyBean;
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

@Route(path = "/activity/walletbag/money")
public class MoneyActivity extends SingleDataBaseActivity<MyPackageBean, MyPackageBean.Data> {

    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.tv_charge)
    TextView mTvCharge;
    @BindView(R.id.tv_give)
    TextView mTvGive;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;


    @Override
    public void onSuccess(IBasePresenter presenter, MyPackageBean.Data bean) {
        MyPackageBean.MoneyBean money = bean.getMoney();
        mTvTotal.setText(money.getMoney()+"");
        mTvCharge.setText(money.getUserMoney()+"");
        mTvGive.setText(money.getGiftAmount()+"");
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW).setSuccessRid(R.layout.activity_money);
    }


    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(MyPackageBean.class)
                .setUrl(ApiContant.MONEY)
                .setParms("token",UserInfoUtil.getToken() ,"userId", UserInfoUtil.getUserId());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("余额")
                .addItemView(new DmzBar.DmzBarItemInfo().setTitle("余额明细"));
    }

    @OnClick(R.id.tv_submit)
    void onClick(){

        Go.goCharge();

    }

}
