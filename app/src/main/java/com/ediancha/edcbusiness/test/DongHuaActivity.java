package com.ediancha.edcbusiness.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.dialog.DealDialog;

/**
 * Created by dengmingzhi on 2017/11/7.
 */

public class DongHuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);

    }

    public void yajin(View v) {
        Go.goCashPledgeActivity();
    }

    public void yuer(View v) {
        Go.goMoney();
    }

    public void wodeqianbao(View v) {
        Go.goMyPackage();
    }


    public void dengluxieyi(View v) {
        DealDialog.getInstance().setTitle("用户注册协议").setUrl("https://www.baidu.com").show(this);
    }

    public void shezhi(View v) {
        Go.goSetActivity();
    }

    public void login(View v) {
        Go.goLogin();
    }
}
