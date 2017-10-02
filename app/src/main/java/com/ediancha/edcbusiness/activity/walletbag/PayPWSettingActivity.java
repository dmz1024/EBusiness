package com.ediancha.edcbusiness.activity.walletbag;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/22.
 * 支付密码设置
 */

public class PayPWSettingActivity extends NotNetBaseActivity {

    MyCountDownTimer mCountDownTimer;
    @BindView(R.id.et_tel)
    EditText mEtTel;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.tv_code)
    TextView mTvCode;
    @BindView(R.id.et_pass)
    EditText mEtPass;
    @BindView(R.id.et_passyz)
    EditText mEtPassyz;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;


    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_paypwsetting;
    }

    @Override
    protected void initData() {
        super.initData();
        mCountDownTimer=new MyCountDownTimer(60000, 1000);
    }

    @OnClick()
    void click(View view){
        switch (view.getId()){
            case R.id.tv_code:
                mCountDownTimer.start();
                break;
        }
    }


    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            if (mTvCode != null) {
                mTvCode.setClickable(false);
                mTvCode.setText(l / 1000 + "s");
            }

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            if (mTvCode != null) {
                //重新给Button设置文字
                mTvCode.setText("重新获取验证码");
                //设置可点击
                mTvCode.setClickable(true);
            }
        }
    }

}
