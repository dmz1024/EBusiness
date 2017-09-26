package com.ediancha.edcbusiness.activity.walletbag;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.MyPackageBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/21.
 * 我的钱包
 */
@Route(path = "/activity/walletbag/mypackage")
public class MyPackageActivity extends SingleDataBaseActivity<MyPackageBean, MyPackageBean.Data> {


    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.ln_money)
    LinearLayout mLnMoney;
    @BindView(R.id.tv_coupon)
    TextView mTvCoupon;
    @BindView(R.id.ln_coupon)
    LinearLayout mLnCoupon;
    @BindView(R.id.tv_deposit)
    TextView mTvDeposit;
    @BindView(R.id.ln_deposit)
    LinearLayout mLnDeposit;
    @BindView(R.id.tv_pass)
    TextView mTvPass;
    @BindView(R.id.ln_pass)
    LinearLayout mLnPass;

    @Override
    protected void initDataBuilder() {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
    }

    @Override
    protected void initContract() {
        super.initContract();
        mContract.getSuccessView(R.layout.activity_mypackage);
    }

    @Override
    protected void initDmzBuilder() {

        dBuilder.setaClass(MyPackageBean.class)
                .setUrl(ApiContant.MYPACKAGE).setParms("type", "9");
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("我的钱包");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, MyPackageBean.Data bean) {
        View successView = mContract.getSuccessView(R.layout.activity_mypackage);
        ButterKnife.bind(this,successView);
        mTvMoney.setText(bean.getyMoney());
        mTvCoupon.setText(bean.getCount());
        mTvDeposit.setText(bean.getYjMoney());

        mTvPass.setText((bean.getPayPassWord() != 0) ? "已设置" : "未设置");
    }

    @OnClick({R.id.ln_money, R.id.ln_coupon, R.id.ln_deposit})
    void click(View view) {
        switch (view.getId()) {
            case R.id.ln_money: //余额
                Go.goMoney();
                break;
            case R.id.ln_coupon://优惠券
                Go.goCoupon();
                break;
            case R.id.ln_deposit://押金
                Go.goDeposit();
                break;
        }
    }

}
