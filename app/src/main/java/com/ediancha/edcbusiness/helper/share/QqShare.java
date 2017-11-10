package com.ediancha.edcbusiness.helper.share;

import android.app.Activity;
import android.os.Bundle;

import com.dmz.library.dmzapi.utils.MyToast;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class QqShare extends Share {
    @Override
    public void start(Activity activity, ShareInfo info) {
        super.start(activity, info);

        Tencent mTencent = Tencent.createInstance("1106484834", activity.getApplicationContext());
        Bundle params = new Bundle();
        if (info.getType() == 1) {
            params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        } else {
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        }
        params.putString(info.getType() == 1 ? QzoneShare.SHARE_TO_QQ_TITLE : QQShare.SHARE_TO_QQ_TITLE, info.getTitle());
        params.putString(info.getType() == 1 ? QzoneShare.SHARE_TO_QQ_SUMMARY : QQShare.SHARE_TO_QQ_SUMMARY, info.getContent());
        params.putString(info.getType() == 1 ? QzoneShare.SHARE_TO_QQ_TARGET_URL : QQShare.SHARE_TO_QQ_TARGET_URL, info.getUrl());
        params.putString(info.getType() == 1 ? QzoneShare.SHARE_TO_QQ_APP_NAME : QQShare.SHARE_TO_QQ_APP_NAME, info.getAppName());
        if (info.getType() == 1) {
            ArrayList<String> imgUrlList = new ArrayList<>();
            imgUrlList.add("http://f.hiphotos.baidu.com/image/h%3D200/sign=6f05c5f929738bd4db21b531918a876c/6a600c338744ebf8affdde1bdef9d72a6059a702.jpg");
            params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imgUrlList);// 图片地址
            //分享到空间
            mTencent.shareToQzone(activity, params, new IUiListener() {
                @Override
                public void onComplete(Object o) {
                    MyToast.normal("分享成功!");
                }

                @Override
                public void onError(UiError uiError) {
                    MyToast.normal("分享失败!");
                }

                @Override
                public void onCancel() {
                    MyToast.normal("取消分享!");
                }
            });
        } else {
            //分享到好友
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, info.getLogo());
            params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE);
            mTencent.shareToQQ(activity, params, new IUiListener() {
                @Override
                public void onComplete(Object o) {
                    MyToast.normal("分享成功!");
                }

                @Override
                public void onError(UiError uiError) {
                    MyToast.normal("分享失败!");
                }

                @Override
                public void onCancel() {
                    MyToast.normal("取消分享!");
                }
            });
        }

    }
}
