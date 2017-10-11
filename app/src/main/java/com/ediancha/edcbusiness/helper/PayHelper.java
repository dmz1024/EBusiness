package com.ediancha.edcbusiness.helper;

import com.alipay.sdk.app.PayTask;
import com.ediancha.edcbusiness.bean.ActivityMessageBean;

/**
 * Created by Admin on 2017/10/11.
 */

public class PayHelper {

    /**
     * 支付宝支付
     */

//    public void aliPay(){
//        String orderInfo = info;   // 订单信息
//        Runnable payRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                PayTask alipay = new PayTask(DemoActivity.this);
//                String result = alipay.payV2(orderInfo,true);
//
//                Message msg = new Message();
//                msg.what = SDK_PAY_FLAG;
//                msg.obj = result;
//                mHandler.sendMessage(msg);
//            }
//        };
//        // 必须异步调用
//        Thread payThread = new Thread(payRunnable);
//        payThread.start();
//    }
}
