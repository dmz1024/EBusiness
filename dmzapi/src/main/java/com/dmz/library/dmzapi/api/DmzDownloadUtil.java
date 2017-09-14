package com.dmz.library.dmzapi.api;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;

/**
 * Created by dengmingzhi on 2017/9/8.
 */

public class DmzDownloadUtil {
    private RequestCall build;

    private DmzDownloadUtil(String url) {
        build = OkHttpUtils
                .get()
                .url(url)
                .build().connTimeOut(600000).readTimeOut(600000).writeTimeOut(600000);
    }

    public static DmzDownloadUtil _instance(String url) {
        return new DmzDownloadUtil(url);
    }

    public void call(DmzFileCallBack callBack) {
        build.execute(callBack);
    }


    public static class DmzFileCallBack extends FileCallBack {

        public DmzFileCallBack(String destFileDir, String destFileName) {
            super(destFileDir, destFileName);
        }

        @Override
        public void inProgress(float progress) {

        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(File response) {

        }
    }
}
