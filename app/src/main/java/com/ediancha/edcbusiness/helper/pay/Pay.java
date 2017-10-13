package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;
import android.text.TextUtils;

import com.dmz.library.dmzapi.api.bean.BaseBean;

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




}
