package com.dmz.library.dmzapi.view;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmz.library.dmzapi.api.IProgressInterface;
import com.dmz.library.dmzapi.utils.MyToast;

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
        MyToast.close();
        _instance = MyProgressFragment._instance(loading);
        if (listener != null) {
            _instance.setCancelable(true);
            _instance.setListener(listener);
        } else {
            _instance.setCancelable(false);
        }
        _instance.show(ctx);
    }

    @Override
    public void error(String error) {
        MyToast.error(error);
        dismiss();
    }


    @Override
    public void waring(String waring) {
        MyToast.warn(waring);
        dismiss();
    }

    @Override
    public void dismiss() {
        _instance.close();
    }

    @Override
    public void success(String success) {
        MyToast.normal(success);
        dismiss();
    }
}
