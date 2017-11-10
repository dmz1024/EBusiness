package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public class WeChatPayUtil extends Pay {
    @Override
    public void start(Activity activity, Object object) {
        super.start(activity, object);

        EventBus.getDefault().register(this);

        Data data = (Data) object;
        IWXAPI api = WXAPIFactory.createWXAPI(activity, null);
        api.registerApp(data.appid);
        PayReq request = new PayReq();
        request.appId = data.getAppid();
        request.partnerId = data.getPartnerid();
        request.prepayId = data.getPrepayid();
        request.packageValue = "Sign=WXPay";
        request.nonceStr = data.getNoncestr();
        request.timeStamp = data.getTimestamp();
        request.sign = data.getSign();
        api.sendReq(request);
    }


    public static class Data {
        public String appid;
        public String noncestr;
        public String partnerid;
        public String prepayid;
        public String sign;
        public String timestamp;

        public String getAppid() {
            return appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public String getSign() {
            return sign;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }

    public static class WeChatPayEvent {
        private int type;

        public WeChatPayEvent(int type) {
            this.type = type;
        }
    }


    @Subscribe
    public void onPayResult(WeChatPayEvent weChatPayEvent) {
        EventBus.getDefault().unregister(this);
        switch (weChatPayEvent.type) {
            case 1:
                iPayResultInterface.onSuccess();
                break;
            case 2:
                iPayResultInterface.onCancel();
                break;
            case 3:
                iPayResultInterface.onFaile("支付失败,可联系客服咨询");
                break;
        }
    }
}
