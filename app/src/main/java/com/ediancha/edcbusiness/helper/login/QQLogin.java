package com.ediancha.edcbusiness.helper.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class QQLogin extends Login {
    private Tencent instance;

    @Override
    public void start(Activity activity) {
        super.start(activity);
        instance = Tencent.createInstance("1106484834", activity.getApplicationContext());
        if (!instance.isSessionValid()) {
            instance.login(activity, "all", iUiListener);
        }

    }


    private IUiListener iUiListener = new IUiListener() {
        @Override
        public void onComplete(Object o) {
            try {
                JSONObject jsonObject = new JSONObject(o.toString());
                iLoginResultInterface.onSuccess(jsonObject.getString(Constants.PARAM_OPEN_ID));
            } catch (JSONException e) {
                e.printStackTrace();
                iLoginResultInterface.onFaile();
            }
        }

        @Override
        public void onError(UiError uiError) {
            iLoginResultInterface.onFaile();
        }

        @Override
        public void onCancel() {
            iLoginResultInterface.onCancel();
        }
    };

    public void onActivity(int requestCode, int resultCode, Intent intent) {
        if (instance != null) {
            instance.handleLoginData(intent, iUiListener);
        }
    }
}
