package com.ediancha.edcbusiness.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.ediancha.edcbusiness.MyApp;

/**
 * Created by Admin on 2017/10/10.
 */

public class ShareHelper {

    private Activity mActivity;
    public ShareHelper(Activity mActivity){
        this.mActivity=mActivity;
    }

    /**
     * 分享文本信息
     * @param msg
     */
    public void shareTextInfo(String msg){
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, msg);
        mActivity.startActivity(Intent.createChooser(textIntent, "分享"));
    }

    /**
     * 分享图片
     * @param path
     */
    public void shareMapInfo(String path){
        Intent imageIntent = new Intent(Intent.ACTION_SEND);
        imageIntent.setType("image/jpeg");
        imageIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
        mActivity.startActivity(Intent.createChooser(imageIntent, "分享"));
    }
}
