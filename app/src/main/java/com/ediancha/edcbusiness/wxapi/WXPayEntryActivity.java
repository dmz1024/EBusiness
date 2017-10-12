package com.ediancha.edcbusiness.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dmz.library.dmzapi.utils.MyToast;
import com.tencent.mm.opensdk.modelmsg.SendAuth;


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
        if (resp.errCode == 0) {
//            MyToast.showToast("支付成功");

        } else if (resp.errCode == -2) {
//            MyToast.showToast("用户取消");

        } else {
//            MyToast.showToast("支付失败");

        }
        finish();
    }



}
