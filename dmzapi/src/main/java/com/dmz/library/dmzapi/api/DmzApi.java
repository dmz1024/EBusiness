package com.dmz.library.dmzapi.api;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.Set;


/**
 * Created by dengmingzhi on 2017/6/21.
 */

public class DmzApi {

    private DmzBuilder dmzBuilder;

    public static DmzApi _build() {
        return new DmzApi();
    }

    public DmzApi setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        return this;
    }

    private StringCallback stringCallback = new StringCallback() {

        @Override
        public void onSuccess(Response<String> response) {
            try {
                IBaseBean a = (IBaseBean) JSON.parseObject(response.body(), dmzBuilder.getaClass());
                if (a.getCode() == dmzBuilder.getCode()) {
                    if (dmzBuilder.getiLoadingView() != null) {
                        if (dmzBuilder.isShowSuccess()) {
                            dmzBuilder.getiLoadingView().success(dmzBuilder.getSuccessMsg());
                        } else {
                            dmzBuilder.getiLoadingView().dismiss();
                        }
                    }
                    if (dmzBuilder.getOnMySuccessListener() != null) {
                        dmzBuilder.getOnMySuccessListener().onSuccess(dmzBuilder.isAll() ? a : a.getData());
                    }

                } else {
                    if (dmzBuilder.getiLoadingView() != null) {
                        if (dmzBuilder.isShowInfo()) {
                            String msg = dmzBuilder.getMapInfo(a.getCode());
                            dmzBuilder.getiLoadingView().waring(TextUtils.isEmpty(msg) ? a.getMsg() : msg);
                        } else {
                            dmzBuilder.getiLoadingView().dismiss();
                        }
                    }
                    if (dmzBuilder.getOnMyOtherCodeListener() != null) {
                        dmzBuilder.getOnMyOtherCodeListener().onOther(a);
                    }
                }
            } catch (com.alibaba.fastjson.JSONException e) {
                Log.d("数据格式错误", "信息：" + e.getMessage());
                if (dmzBuilder.getOnMyErrorListener() != null) {
                    dmzBuilder.getOnMyErrorListener().onError();
                }

                if (dmzBuilder.getiLoadingView() != null) {
                    dmzBuilder.getiLoadingView().error("数据格式错误");
                }
            }
        }

        @Override
        public void onError(Response<String> response) {
            super.onError(response);
            response.getException().printStackTrace();

            if (dmzBuilder.getOnMyErrorListener() != null) {
                dmzBuilder.getOnMyErrorListener().onError();
            }

            if (dmzBuilder.getiLoadingView() != null) {
                dmzBuilder.getiLoadingView().error("请求错误");
            }
        }

        @Override
        public void onStart(Request<String, ? extends Request> request) {
            super.onStart(request);
            if (dmzBuilder.getiLoadingView() != null) {
                dmzBuilder.getiLoadingView().loading(dmzBuilder.getLoadMsg(), dmzBuilder.isCancel() ? new IProgressInterface.OnProgressCancelListener() {
                    @Override
                    public void cancel() {
                        DmzApi.cancel(dmzBuilder.getSign());
                        if (dmzBuilder.getProgressCancelListener() != null) {
                            dmzBuilder.getProgressCancelListener().cancel();
                        }

                    }
                } : null);
            }
        }
    };

    public void excute() {
        printUrl();
        if (dmzBuilder.isPost()) {
            OkGo.<String>post(dmzBuilder.getUrl()).tag(dmzBuilder.getSign()).params(dmzBuilder.getMap()).execute(stringCallback);
        } else {
            OkGo.<String>get(dmzBuilder.getUrl()).tag(dmzBuilder.getSign()).params(dmzBuilder.getMap()).execute(stringCallback);
        }
    }

    public static void cancel(Object sign) {
        OkGo.getInstance().cancelTag(sign);
    }


    private void printUrl() {
        StringBuilder sb = new StringBuilder(dmzBuilder.getUrl());
        if (dmzBuilder.getMap() != null) {
            Set<String> strings = dmzBuilder.getMap().keySet();
            for (String key : strings) {
                if (sb.length() == dmzBuilder.getUrl().length()) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }

                sb.append(key)
                        .append("=")
                        .append(dmzBuilder.getMap().get(key));

            }
        }
        Log.d("请求网址", sb.toString());
    }


    private void printJson(String response) {
        LogUtil.d("请求数据", response);
    }

}
