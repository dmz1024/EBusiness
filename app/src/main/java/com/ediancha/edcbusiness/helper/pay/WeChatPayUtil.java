package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public class WeChatPayUtil extends Pay {
    @Override
    public void start(Activity activity, Object object) {
        super.start(activity, object);
        Data data= (Data) object;
        IWXAPI api = WXAPIFactory.createWXAPI(activity, null);
        api.registerApp("wxd930ea5d5a258f4f");
        PayReq request = new PayReq();
        request.appId = data.getAppid();
        request.partnerId = data.getPartnerid();
        request.prepayId= data.getPrepayid();
        request.packageValue = "Sign=WXPay";
        request.nonceStr= data.getNoncestr();
        request.timeStamp= data.getTimestamp();
        request.sign= data.getSign();
        api.sendReq(request);
    }

}
