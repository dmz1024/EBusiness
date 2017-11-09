package com.ediancha.edcbusiness.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.router.Go;

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
}
