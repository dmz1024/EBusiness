package com.ediancha.edcbusiness.helper.share;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class QqShare extends Share {
    @Override
    public void start(Activity activity,ShareInfo info) {
        super.start(activity,info);

        Tencent mTencent = Tencent.createInstance("1106484834", activity.getApplicationContext());
        Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, info.getTitle());
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, info.getContent());
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, info.getUrl());
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, info.getLogo());
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, info.getAppName());
        if (info.getType()==1) {
            //分享到空间
            params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
        } else {
            //分享到好友
            params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE);
        }
        mTencent.shareToQQ(activity, params, null);
    }
}
