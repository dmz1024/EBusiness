package com.ediancha.edcbusiness.activity.walletbag;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.NormalContant;
import com.ediancha.edcbusiness.dialog.DepositDialog;
import com.ediancha.edcbusiness.presenter.deposit.DepositPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/21.
 * 押金
 */

@Route(path = "/activity/walletbag/deposit")
public class DepositActivity extends NotNetBaseActivity implements DepositPresenter.IDepositView {

    DepositDialog mDepositDialog;
    @BindView(R.id.dmzBar)
    DmzBar mDmzBar;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    @BindView(R.id.tv_show)
    TextView mTvShow;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;

    @Autowired
    public String money;
    @Autowired
    public int status;

    private DepositPresenter mDepositPresenter;

    @Override
    protected void initView() {
        super.initView();

        mTvTotal.setText(money);

        if (status == 1) {
            mTvShow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("押金");
    }

    @Override
    protected void initData() {
        super.initData();
        mDepositPresenter=new DepositPresenter(this);
    }

    @Override
    protected int getRid() {
        return R.layout.activity_deposit;
    }



    @OnClick(R.id.tv_submit)
    void click(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                if (!("0".equals(money)) && !(status==1)){
                    mDepositDialog = new DepositDialog();
                    mDepositDialog.show(getSupportFragmentManager(), "1");
                    mDepositDialog.setOkClickListner(new DepositDialog.okClickListner() {
                        @Override
                        public void setOnOkListener() {
                            mDepositPresenter.returnDeposit(UserInfoUtil.getToken(),UserInfoUtil.getUserId());
                            mDepositDialog.dismiss();
                        }
                    });
                }
                break;
            case R.id.tv_xieyi:
                break;
        }
    }

    @Override
    public void successCode(BaseBean bean) {
        if (bean.getCode()== NormalContant.SUCCESS_CODE){
            MyToast.normal(getResources().getString(R.string.string_deposit_text));
        }else {
            MyToast.error(bean.msg);
        }
    }
}
