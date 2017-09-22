package com.ediancha.edcbusiness.activity.login;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.view.activity.BaseActivity;
import com.ediancha.edcbusiness.R;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/activity/login/login")
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getRid() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.ivCha).setOnClickListener(this);
        AnimationUtil.chaAnimatio(findViewById(R.id.ivCha));
    }


    @Override
    protected void initData() {
        super.initData();
    }


    @Override
    public void onClick(View view) {
        finish();
    }
}
