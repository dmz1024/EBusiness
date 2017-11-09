package com.dmz.library.dmzapi.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dengmingzhi on 2017/9/4.
 */

public class DmzBuilder {
    private boolean isShowSuccess;//加载框显示时如果请求的数据是自己想要的是否调用加载框的success方法
    private boolean isShowInfo = true;//加载框显示时如果请求的数据不是自己想要的是否调用加载框的waring方法
    private boolean isCancel = true;//请求是否能够取消
    private String successMsg = "请求成功";//请求成功时的显示数据  比如 登录成功
    private String loadMsg = "正在请求";//加载时的显示数据，比如 正在加载中...
    private Map<Integer, String> mapInfo;//根据code值显示waring数据
    private String url;//请求网址
    private Map<String, String> map;//请求参数
    private boolean method=true;//请求方法
    private Object sign;//请求标识，用于取消请求
    private int code = 10000;//跟后台约定的成功返回码
    private IProgressInterface.OnProgressCancelListener progressCancelListener;
    private OnMyErrorListener onMyErrorListener;//请求错误时的回调，比如连接超时等
    private OnMyOtherCodeListener onMyOtherCodeListener;//请求code码不是默认的code时，比如返回的是10001，但是我们约定的是10000
    private OnMySuccessListener onMySuccessListener;//请求成功时的回调
    private IProgressInterface iLoadingView;//请求网络时的加载框
    private boolean isAll;//在成功时是否返回主类对象
    private Class aClass;
    private int loginCode = 30001;

    public DmzBuilder setLoginCode(int loginCode) {
        this.loginCode = loginCode;
        return this;
    }

    public DmzBuilder clear() {
        isShowSuccess = false;
        isShowInfo = true;
        isCancel = true;
        successMsg = "请求成功";
        loadMsg = "正在请求";
        mapInfo = null;
        url = "";
        map = null;
        method = false;
        code = 10000;
        progressCancelListener = null;
        onMyErrorListener = null;
        onMyOtherCodeListener = null;
        onMySuccessListener = null;
        iLoadingView = null;
        isAll = false;
        aClass = null;
        loginCode = 60001;
        return this;
    }

    public int getLoginCode() {
        return loginCode;
    }

    public DmzBuilder setaClass(Class aClass) {
        this.aClass = aClass;
        return this;
    }

    public Class getaClass() {
        return aClass;
    }

    public DmzBuilder setAll(boolean all) {
        isAll = all;
        return this;
    }

    public boolean isAll() {
        return isAll;
    }

    public boolean isShowSuccess() {
        return isShowSuccess;
    }

    public DmzBuilder setShowSuccess(boolean showSuccess) {
        isShowSuccess = showSuccess;
        return this;
    }

    public boolean isShowInfo() {
        return isShowInfo;
    }

    public DmzBuilder setShowInfo(boolean showInfo) {
        isShowInfo = showInfo;
        return this;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public DmzBuilder setCancel(boolean cancel) {
        isCancel = cancel;
        return this;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public DmzBuilder setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
        return this;
    }

    public String getLoadMsg() {
        return loadMsg;
    }

    public DmzBuilder setLoadMsg(String loadMsg) {
        this.loadMsg = loadMsg;
        return this;
    }

    public String getMapInfo(int code) {
        if (mapInfo != null) {
            return mapInfo.get(code);
        }
        return null;
    }

    public DmzBuilder setMapInfo(Map<Integer, String> mapInfo) {
        this.mapInfo = mapInfo;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DmzBuilder setUrl(String url) {
        this.url = url;
        return this;
    }


    public Map<String, String> getMap() {
        return map;
    }


    public boolean isPost() {
        return method;
    }

    public DmzBuilder setMethod(boolean method) {
        this.method = method;
        return this;
    }

    public Object getSign() {
        return sign;
    }

    public DmzBuilder setSign(Object sign) {
        this.sign = sign;
        return this;
    }

    public int getCode() {
        return code;
    }

    public DmzBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public IProgressInterface.OnProgressCancelListener getProgressCancelListener() {
        return progressCancelListener;
    }

    public DmzBuilder setProgressCancelListener(IProgressInterface.OnProgressCancelListener progressCancelListener) {
        this.progressCancelListener = progressCancelListener;
        return this;
    }

    public OnMyErrorListener getOnMyErrorListener() {
        return onMyErrorListener;
    }

    public DmzBuilder setOnMyErrorListener(OnMyErrorListener onMyErrorListener) {
        this.onMyErrorListener = onMyErrorListener;
        return this;
    }

    public OnMyOtherCodeListener getOnMyOtherCodeListener() {
        return onMyOtherCodeListener;
    }

    public DmzBuilder setOnMyOtherCodeListener(OnMyOtherCodeListener onMyOtherCodeListener) {
        this.onMyOtherCodeListener = onMyOtherCodeListener;
        return this;
    }

    public OnMySuccessListener getOnMySuccessListener() {
        return onMySuccessListener;
    }

    public DmzBuilder setOnMySuccessListener(OnMySuccessListener onMySuccessListener) {
        this.onMySuccessListener = onMySuccessListener;
        return this;
    }

    public IProgressInterface getiLoadingView() {
        return iLoadingView;
    }

    public DmzBuilder setiLoadingView(IProgressInterface iLoadingView) {
        this.iLoadingView = iLoadingView;
        return this;
    }


    public DmzBuilder setParms(String... parms) {
        if (parms != null && parms.length > 0) {
            if (map == null) {
                this.map = new HashMap<>();
            }
//            if(parms.length%2!=0){
//                throw new IllegalArgumentException("parms 长度需为偶数");
//            }
            for (int i = 0; i < parms.length - 1; i += 2) {
                map.put(parms[i], parms[i + 1]);
            }
        }
        return this;
    }


    public DmzBuilder setParms(Map<String, String> map) {
        this.map = map;
        return this;
    }

    public static DmzBuilder _builder() {
        return new DmzBuilder();
    }
}
