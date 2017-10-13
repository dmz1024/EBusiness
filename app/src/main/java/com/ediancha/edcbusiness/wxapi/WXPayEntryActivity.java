package com.ediancha.edcbusiness.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dmz.library.dmzapi.utils.MyToast;
import com.ediancha.edcbusiness.helper.pay.WeChatPayUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;


public class WXPayEntryActivity extends Activity {

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
        int result = 1;
        if (resp.errCode == 0) {
            result = 1;
        } else if (resp.errCode == -2) {
            result = 2;
        } else {
            result = 3;
        }
        EventBus.getDefault().post(new WeChatPayUtil.WeChatPayEvent(result));
        finish();
    }


}
