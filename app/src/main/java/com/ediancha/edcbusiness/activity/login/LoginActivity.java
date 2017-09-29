package com.ediancha.edcbusiness.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.presenter.ComPresenter;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.api.view.IBaseView;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.presenter.user.CodePresenter;
import com.ediancha.edcbusiness.presenter.user.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/activity/login/login")
public class LoginActivity extends NotNetBaseActivity implements LoginPresenter.ILoginView, CodePresenter.ICodeView {

    @BindView(R.id.ivCha)
    ImageView ivCha;
    @BindView(R.id.etName)
    AutoCompleteTextView etName;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.tvCode)
    TextView tvCode;
    @BindView(R.id.tvXieyi)
    TextView tvXieyi;
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

    @Override
    protected void initData() {
        super.initData();
        loginPresenter = new LoginPresenter(this);
        codePresenter = new CodePresenter(this);
    }

    @OnClick({R.id.tvNoLogin, R.id.btLogin, R.id.ivCha, R.id.tvCode})
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
                codePresenter.getCode(etName.getText().toString(), 1);
                break;

        }
    }

    private void login() {
        loginPresenter.login(etName.getText().toString(), etCode.getText().toString());
    }

    @Override
    public void loginSuccess() {
        finish();
    }

    @Override
    public void codeSuccess() {
        Log.d("aaaaaaaa", "aaa");
    }
}
