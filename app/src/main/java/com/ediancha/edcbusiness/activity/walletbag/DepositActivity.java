package com.ediancha.edcbusiness.activity.walletbag;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.dialog.DepositDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/21.
 * 押金
 */

@Route(path = "/activity/walletbag/deposit")
public class DepositActivity extends ToobarBaseActivity {

    DepositDialog mDepositDialog;
    @BindView(R.id.dmzBar)
    DmzBar mDmzBar;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("押金");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_deposit;
    }


    public void setDialog() {
        mDepositDialog = new DepositDialog();
        mDepositDialog.show(getSupportFragmentManager(),"1");



    }


    @OnClick(R.id.tv_submit)
    void click(View view){
        switch (view.getId()){
            case R.id.tv_submit:
                setDialog();
                break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
