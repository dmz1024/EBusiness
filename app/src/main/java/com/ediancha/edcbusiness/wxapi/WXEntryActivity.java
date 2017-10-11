package com.ediancha.edcbusiness.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;


public class WXEntryActivity extends Activity{

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
        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
            Intent wechat_intent = new Intent();
            wechat_intent.setAction("login_receiver");
            wechat_intent.putExtra("sdk", "wechat");
            wechat_intent.putExtra("code", resp.code);
            wechat_intent.putExtra("country", resp.country);
            sendBroadcast(wechat_intent);
        }

        finish();
    }

}
