package com.ediancha.edcbusiness.helper.login;

import android.app.Activity;
import android.util.Log;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Date;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class WeChatLogin extends Login {
    @Override
    public void start(Activity activity) {
        super.start(activity);
        EventBus.getDefault().register(this);
        IWXAPI api = WXAPIFactory.createWXAPI(activity, null);
        api.registerApp("wx8917d124e0d8d9ff");
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = new Date().getTime() + "";
        api.sendReq(req);
    }


    public static class WeChatLoginEvent {
        private int type;
        private String code;

        public WeChatLoginEvent(int type) {
            this.type = type;
        }

        public WeChatLoginEvent(int type, String code) {
            this.type = type;
            this.code = code;
        }
    }

    @Subscribe
    public void onLoginResult(WeChatLoginEvent weChatLoginEvent) {
        EventBus.getDefault().unregister(this);
        switch (weChatLoginEvent.type) {
            case 1:
                iLoginResultInterface.onSuccess(weChatLoginEvent.code);
                break;
            case 2:
                iLoginResultInterface.onCancel();
                break;
            case 3:
                iLoginResultInterface.onFaile();
                break;
        }
    }
}
