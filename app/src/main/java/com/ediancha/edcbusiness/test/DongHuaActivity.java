package com.ediancha.edcbusiness.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.ediancha.edcbusiness.R;

/**
 * Created by dengmingzhi on 2017/11/7.
 */

public class DongHuaActivity extends AppCompatActivity {
    private LottieAnimationView animation_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);
        animation_view = findViewById(R.id.animation_view);
        animation_view.setProgress(0.2f);

        animation_view.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation_view.playAnimation(0.1f,0.9f);
            }
        },2000);
    }
}
