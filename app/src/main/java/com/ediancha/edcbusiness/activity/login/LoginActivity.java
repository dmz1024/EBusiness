package com.ediancha.edcbusiness.activity.login;

import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.CodeHelper;
import com.ediancha.edcbusiness.presenter.user.CodePresenter;
import com.ediancha.edcbusiness.presenter.user.LoginPresenter;
import com.ediancha.edcbusiness.router.Go;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/activity/start/start")
public class LoginActivity extends NotNetBaseActivity implements LoginPresenter.ILoginView, CodePresenter.ICodeView, Validator.ValidationListener {

    @BindView(R.id.ivCha)
    ImageView ivCha;
    @Length(message = "手机号长度为11位", max = 11, min = 11)
    @Order(1)
    @BindView(R.id.etName)
    AutoCompleteTextView etName;
    @Length(message = "验证码为6位", max = 6, min = 6)
    @Order(2)
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.tvCode)
    TextView tvCode;
    @BindView(R.id.tvCodeTime)
    TextView tvCodeTime;
    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.tvNoLogin)
    TextView tvNoLogin;

    @Override
    protected int getRid() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        AnimationUtil.chaAnimatio(findViewById(R.id.ivCha));
    }

    private LoginPresenter loginPresenter;
    private CodePresenter codePresenter;
    private Validator mValidator;

    @Override
    protected void initData() {
        super.initData();
        loginPresenter = new LoginPresenter(this);
        codePresenter = new CodePresenter(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mValidator.setValidationMode(Validator.Mode.IMMEDIATE);
        codeHelper = new CodeHelper(this, tvCode, tvCodeTime);
    }

    private CodeHelper codeHelper;

    @OnClick({R.id.tvNoLogin, R.id.btLogin, R.id.ivCha, R.id.tvCode,R.id.tvXieyi})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCha:
            case R.id.tvNoLogin:
                finish();
                break;
            case R.id.btLogin:
                login();
                break;
            case R.id.tvCode:
                code();
                break;
            case R.id.tvXieyi:
                Go.goWebView("https://www.baidu.com");
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        codeHelper.close();
    }

    private void code() {
        String name = etName.getText().toString();
        if (name.length() != 11) {
            MyToast.warn("手机号长度为11位");
            return;
        }
        codePresenter.getCode(name, 1);
    }

    private void login() {
        mValidator.validate();
    }

    @Override
    public void loginSuccess() {
        finish();
    }

    @Override
    public void codeSuccess() {
        codeHelper.codeSuccess();
    }

    @Override
    public void onValidationSucceeded() {
        loginPresenter.login(etName.getText().toString(), etCode.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> list) {
        for (ValidationError error : list) {
            MyToast.warn(error.getCollatedErrorMessage(this));
        }
    }
}
