package com.ediancha.edcbusiness.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ediancha.edcbusiness.helper.login.WeChatLogin;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;


public class WXEntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        SendAuth.Resp resp = new SendAuth.Resp(intent.getExtras());
        Log.d("微信登录code", resp.errCode + "");
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                EventBus.getDefault().post(new WeChatLogin.WeChatLoginEvent(1, resp.code));
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                EventBus.getDefault().post(new WeChatLogin.WeChatLoginEvent(2));
                break;
            default:
                EventBus.getDefault().post(new WeChatLogin.WeChatLoginEvent(3));
                break;

        }
        finish();
    }

}
