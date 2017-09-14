package com.dmz.library.dmzapi.view;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmz.library.dmzapi.api.IProgressInterface;

/**
 * Created by dengmingzhi on 2017/8/25.
 */

public class MyProgress implements IProgressInterface {
    private MyProgressFragment _instance;
    private Context ctx;

    public MyProgress(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    public void loading(String loading, OnProgressCancelListener listener) {
        _instance = MyProgressFragment._instance(loading);
        if (listener != null) {
            _instance.setCancelable(true);
            _instance.setListener(listener);
        } else {
            _instance.setCancelable(false);
        }
        _instance.show(((AppCompatActivity) ctx).getSupportFragmentManager(), "progress");
        timer.cancel();
    }

    @Override
    public void error(String error) {
        _instance.error(error);
        timer.start();
    }

    private CountDownTimer timer = new CountDownTimer(3000, 1000) {
        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            _instance.close();
        }
    };

    @Override
    public void waring(String waring) {
        _instance.waring(waring);
        timer.start();
    }

    @Override
    public void dismiss() {
        _instance.close();
    }

    @Override
    public void success(String success) {
        _instance.success(success);
        timer.start();
    }
}
