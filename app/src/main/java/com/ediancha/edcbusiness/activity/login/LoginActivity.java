package com.ediancha.edcbusiness.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.CodeHelper;
import com.ediancha.edcbusiness.helper.login.ILoginResultInterface;
import com.ediancha.edcbusiness.helper.login.Login;
import com.ediancha.edcbusiness.helper.login.QQLogin;
import com.ediancha.edcbusiness.presenter.user.CodePresenter;
import com.ediancha.edcbusiness.presenter.user.LoginPresenter;
import com.ediancha.edcbusiness.presenter.user.ThreadLoginPresenter;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.dialog.DealDialog;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/activity/login/login")
public class LoginActivity extends NotNetBaseActivity implements LoginPresenter.ILoginView, CodePresenter.ICodeView, Validator.ValidationListener, ThreadLoginPresenter.IThreadLoginView {

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
    @BindView(R.id.tvXieyi)
    TextView mTvXieyi;
    @BindView(R.id.img_wechat)
    ImageView mImgWechat;
    @BindView(R.id.img_qq)
    ImageView mTvQq;

    int type;
    String access_token, openid;
    @BindView(R.id.thread)
    LinearLayout mThread;
    private ThreadLoginPresenter mThreadLoginPresenter;

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
        mThreadLoginPresenter = new ThreadLoginPresenter(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mValidator.setValidationMode(Validator.Mode.IMMEDIATE);
        codeHelper = new CodeHelper(this, tvCode, tvCodeTime);
    }

    private CodeHelper codeHelper;

    @OnClick({ R.id.btLogin, R.id.ivCha, R.id.tvCode, R.id.tvXieyi, R.id.img_qq, R.id.img_wechat})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCha:
                break;
            case R.id.btLogin:
                login();
                break;
            case R.id.tvCode:
                code();
                break;
            case R.id.tvXieyi:
                DealDialog.getInstance().setTitle("用户注册协议").setUrl("https://www.baidu.com").show(this);
                break;
            case R.id.img_wechat:
                type = 1;
                Login.getLogin(0)
                        .setListener(new ILoginResultInterface() {
                            @Override
                            public void onSuccess(String info) {
                                mThreadLoginPresenter.threadLogin(info, 2);
                            }

                            @Override
                            public void onCancel() {

                            }

                            @Override
                            public void onFaile() {
                                MyToast.normal("微信授权登陆失败!");
                            }
                        })
                        .start(this);
                break;
            case R.id.img_qq:
                type = 2;
                login = (QQLogin) Login.getLogin(1).setListener(new ILoginResultInterface() {
                    @Override
                    public void onSuccess(String info) {
                        access_token = info.split(",")[1];
                        openid = info.split(",")[0];
                        mThreadLoginPresenter.threadLogin(openid, 1);
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onFaile() {
                        MyToast.normal("QQ授权登陆失败!");
                    }
                });
                login.start(this);
                break;
            default:

        }
    }

    QQLogin login;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (login != null) {
            login.onActivity(requestCode, resultCode, data);
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
        if (type == 0) {
            loginPresenter.login(etName.getText().toString(), etCode.getText().toString());
        } else {
            mThreadLoginPresenter.bindLogin(type + "", etName.getText().toString(),
                    etCode.getText().toString(), access_token, openid);
        }
    }

    @Override
    public void onValidationFailed(List<ValidationError> list) {
        for (ValidationError error : list) {
            MyToast.warn(error.getCollatedErrorMessage(this));
        }
    }

    @Override
    public void loginThreadSuccess() {
        finish();
    }

    @Override
    public void regBind() {
        mThread.setVisibility(View.GONE);
        btLogin.setText("绑定并登录");
        type = 1;
    }

    @Override
    public void successBind() {
        finish();
    }
}
