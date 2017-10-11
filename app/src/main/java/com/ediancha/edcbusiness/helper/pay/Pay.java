package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;
import android.text.TextUtils;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public class Pay {
    protected IPayResultInterface iPayResultInterface;

    public Pay setiPayResultInterface(IPayResultInterface iPayResultInterface) {
        this.iPayResultInterface = iPayResultInterface;
        return this;
    }

    public void start(Activity activity, Object object) {
        if (iPayResultInterface == null) {
            throw new IllegalArgumentException("请设置 IPayResultInterface 监听");
        }
    }

    public static Pay getPay(int type) {
        return type == 0 ? new WeChatPayUtil() : new AliPayUtil();
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
}
