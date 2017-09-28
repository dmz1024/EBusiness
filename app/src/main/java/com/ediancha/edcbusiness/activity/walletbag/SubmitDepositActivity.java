package com.ediancha.edcbusiness.activity.walletbag;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/9/28.
 * 提交押金
 */
@Route(path = "/activity/walletbag/submitdeposit")
public class SubmitDepositActivity extends NotNetBaseActivity {


    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.rb_wechat)
    RadioButton mRbWechat;
    @BindView(R.id.rb_pay)
    RadioButton mRbPay;
    @BindView(R.id.rg_pay)
    RadioGroup mRgPay;
    @BindView(R.id.tv_bmony)
    TextView mTvBmony;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    @BindView(R.id.tv_xysubmit)
    TextView mTvXysubmit;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("缴纳押金")
                .addItemView(new DmzBar.DmzBarItemInfo().setIid(R.mipmap.icon_my_close));
    }

    @Override
    protected int getRid() {
        return R.layout.activity_submitdeposit;
    }

}
