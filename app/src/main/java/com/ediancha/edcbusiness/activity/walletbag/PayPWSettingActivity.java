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
import com.ediancha.edcbusiness.MyApp;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.dialog.AutherDialog;
import com.ediancha.edcbusiness.dialog.IndetifyCodeDialog;
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

//    @BindView(R.id.et_code)
//    @NotEmpty(sequence = 1, message = "不能为空!")
//    EditText mEtCode;

//    @BindView(R.id.tv_code)
//    TextView mTvCode;

    @BindView(R.id.et_pass)
    @NotEmpty(sequence = 2, message = "不能为空!")
    @Password(min = 6, message = "密码为六位!")
    @Length(min = 6, max = 6)
    EditText mEtPass;

    @BindView(R.id.et_passyz)
    @ConfirmPassword(sequence = 3, message = "密码和验证密码不统一")
    EditText mEtPassyz;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;


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

        mCodePresenter = new CodePresenter(this);
        mPayPWPresenter = new UpdatePayPWPresenter(this);

    }

    @OnClick({R.id.tv_submit})
    void click(View view) {
        switch (view.getId()) {
//            case R.id.tv_code:
//                mCountDownTimer.start();
////                mCodePresenter.getCode(UserInfoUtil.getUserPhone(), 1);
//                IndetifyCodeDialog indetifyCodeDialog = new IndetifyCodeDialog();
//                indetifyCodeDialog.show(this);
//                break;
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
        MyToast.normal("设置支付密码成功!");
        finish();
    }

    @Override
    public void onValidationSucceeded() {

        final String payPass = mEtPass.getText().toString().trim();
//
        final IndetifyCodeDialog indetifyCodeDialog = new IndetifyCodeDialog();
        indetifyCodeDialog.show(this);
        indetifyCodeDialog.setPasswordListener(new IndetifyCodeDialog.UpDatePasswordListener() {
            @Override
            public void updatePassword(String pass) {
                indetifyCodeDialog.dismiss();
                mPayPWPresenter.UpdatePayPw(UserInfoUtil.getUserPhone(), pass, payPass);
            }
        });
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


}
