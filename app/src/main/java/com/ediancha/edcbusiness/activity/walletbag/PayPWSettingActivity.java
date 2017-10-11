package com.ediancha.edcbusiness.activity.walletbag;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.presenter.user.CodePresenter;
import com.ediancha.edcbusiness.presenter.user.UpdatePayPWPresenter;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/22.
 * 支付密码设置
 */
@Route(path = "/activity/walletbag/payPassWord")
public class PayPWSettingActivity extends NotNetBaseActivity implements CodePresenter.ICodeView, UpdatePayPWPresenter.IUpdatePayPWView, Validator.ValidationListener {


    @BindView(R.id.et_tel)
    EditText mEtTel;

    @BindView(R.id.et_code)
    @NotEmpty(sequence = 1, message = "不能为空!")
    EditText mEtCode;

    @BindView(R.id.tv_code)
    TextView mTvCode;

    @BindView(R.id.et_pass)
    @NotEmpty(sequence = 2, message = "不能为空!")
    @Password(min = 6, message = "密码为六位!")
    EditText mEtPass;

    @BindView(R.id.et_passyz)
    @ConfirmPassword(sequence = 3,message = "密码和验证密码不统一")
    EditText mEtPassyz;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;

    MyCountDownTimer mCountDownTimer;
    private CodePresenter mCodePresenter;
    private UpdatePayPWPresenter mPayPWPresenter;
    Validator validator;


    @Override
    protected void initView() {
        super.initView();
        mEtTel.setText(UserInfoUtil.getUserPhone());
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("修改密码");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_paypwsetting;
    }

    @Override
    protected void initData() {
        super.initData();
        mCountDownTimer = new MyCountDownTimer(60000, 1000);
        mCodePresenter = new CodePresenter(this);
        mPayPWPresenter = new UpdatePayPWPresenter(this);

    }

    @OnClick({R.id.tv_code, R.id.tv_submit})
    void click(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                mCountDownTimer.start();
                mCodePresenter.getCode(UserInfoUtil.getUserPhone(), 1);
                break;
            case R.id.tv_submit:
                validator.validate();
//                String passyz = mEtPassyz.getText().toString().trim();
                break;
        }
    }

    @Override
    public void codeSuccess() {

    }

    @Override
    public void successCode() {
        finish();
    }

    @Override
    public void onValidationSucceeded() {
        String code = mEtCode.getText().toString().trim();
        String pass = mEtPass.getText().toString().trim();
        mPayPWPresenter.UpdatePayPw(UserInfoUtil.getUserPhone(), code, pass);
    }

    @Override
    public void onValidationFailed(List<ValidationError> list) {
        for (ValidationError error : list) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
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
                mTvCode.setText("验证码");
                //设置可点击
                mTvCode.setClickable(true);
            }
        }
    }

}
