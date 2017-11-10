package com.ediancha.edcbusiness.helper.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import java.util.Map;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public class AliHandle extends Handler {

    public AliHandle(Activity activity){
        super(activity.getMainLooper());
    }

    public static final int ALI_WHAT=1;
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case ALI_WHAT:
                PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                String resultStatus = payResult.getResultStatus();
                onHandleMessage.handleMessage(Integer.parseInt(resultStatus));
                break;
        }
    }


    public interface OnHandleMessage {
        void handleMessage(int status);
    }

    private OnHandleMessage onHandleMessage;

    public AliHandle setOnHandleMessage(OnHandleMessage onHandleMessage) {
        this.onHandleMessage = onHandleMessage;
        return this;
    }
}
