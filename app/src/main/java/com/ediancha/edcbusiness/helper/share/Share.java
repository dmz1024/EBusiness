package com.ediancha.edcbusiness.helper.share;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.connect.share.QQShare;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class Share {

    public interface ShareInfo {

        String getUrl();

        String getTitle();

        String getContent();

        int getType();

        String getAppName();

        String getLogo();
    }

    public void start(Activity activity, ShareInfo info) {

    }

    public static Share getShare(int type) {
        return type == 0 ? new WeChatShare() : new QqShare();
    }
}
