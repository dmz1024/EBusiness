package com.ediancha.edcbusiness.activity.walletbag;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.MoneyBean;
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
public class MoneyActivity extends SingleDataBaseActivity<MoneyBean, MoneyBean.Data> {

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
    public void onSuccess(IBasePresenter presenter, MoneyBean.Data bean) {
        mTvTotal.setText(bean.getTotalMoney());
        mTvCharge.setText(bean.getcMoney());
        mTvGive.setText(bean.getzMoney());

    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW).setSuccessRid(R.layout.activity_money);
    }


    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(MoneyBean.class)
                .setUrl(ApiContant.MONEY)
                .setParms("type", "11");
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
