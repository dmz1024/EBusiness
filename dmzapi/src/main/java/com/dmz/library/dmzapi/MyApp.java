package com.dmz.library.dmzapi;

import android.app.Application;

import com.dmz.library.dmzapi.utils.ScreenUtil;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtil._init(this);

    }
}
