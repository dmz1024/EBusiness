package com.ediancha.edcbusiness;

import android.text.TextUtils;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;

/**
 * Created by dengmingzhi on 2017/9/13.
 */

public class HotUpdateModel implements MyApp.MsgDisplayListener {
    private int handlePatchVersion = 76;
    private OnHotUpdateRelaunch onHotUpdateRelaunch;

    public HotUpdateModel(OnHotUpdateRelaunch onHotUpdateRelaunch) {
        this.onHotUpdateRelaunch = onHotUpdateRelaunch;
        MyApp.msgDisplayListener = this;
    }

    public void checkUpdate(int handlePatchVersion) {
        if (handlePatchVersion != 0 && this.handlePatchVersion != handlePatchVersion) {
            SophixManager.getInstance().queryAndLoadNewPatch();
        }

    }

    @Override
    public void handle(int code, int handleVersion, String info) {
        if (code == PatchStatus.CODE_LOAD_RELAUNCH) {//需要冷启动才能更新
            this.handlePatchVersion = handleVersion;
            if (!TextUtils.equals("already loading a res patch, require restarting...", info)) {
                onHotUpdateRelaunch.onRelaunch(1);
            } else {
                onHotUpdateRelaunch.onRelaunch(2);
            }
        }
    }

}
/**
 * code: 1 补丁加载成功
 * code: 6 服务端没有最新可用的补丁
 * code: 11 RSASECRET错误，官网中的密钥是否正确请检查
 * code: 12 当前应用已经存在一个旧补丁, 应用重启尝试加载新补丁
 * code: 13 补丁加载失败, 导致的原因很多种, 比如UnsatisfiedLinkError等异常, 此时应该严格检查logcat异常日志
 * code: 16 APPSECRET错误，官网中的密钥是否正确请检查
 * code: 18 一键清除补丁
 * code: 19 连续两次queryAndLoadNewPatch()方法调用不能短于3s
 */
