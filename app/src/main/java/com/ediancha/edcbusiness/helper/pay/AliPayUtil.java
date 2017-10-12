package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;

import com.alipay.sdk.app.AuthTask;

import java.util.Map;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public class AliPayUtil extends Pay {

    @Override
    public void start(final Activity activity, Object object) {
        super.start(activity, object);
        final String orderInfo = (String) object;
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(activity);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(orderInfo, true);
                Message msg = new Message();
                msg.what = AliHandle.ALI_WHAT;
                msg.obj = result;
                new AliHandle(activity).setOnHandleMessage(new AliHandle.OnHandleMessage() {
                    @Override
                    public void handleMessage(int status) {
                        switch (status) {
                            case 9000:
                                //TODO 支付成功
                                iPayResultInterface.onSuccess();
                                break;
                            case 8000:
                                //TODO 系统处理中
                                iPayResultInterface.onFaile("系统处理中");
                                break;
                            case 6001:
                                //TODO 用户取消
                                iPayResultInterface.onCancel();
                                break;
                            case 6002:
                                //TODO 网络错误
                                iPayResultInterface.onFaile("网络错误");
                                break;
                            default: {
                                iPayResultInterface.onFaile("支付失败，请联系客服");
                                //TODO 支付失败
                            }
                        }
                    }
                }).sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
