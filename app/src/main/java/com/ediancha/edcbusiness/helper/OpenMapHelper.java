package com.ediancha.edcbusiness.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Admin on 2017/10/9.
 */

public class OpenMapHelper {

    private Activity mActivity;
    public OpenMapHelper(Activity mActivity){
        this.mActivity=mActivity;
    }

    /**
     * 打开手机应用地图
     */
    public void openMap(String latitude,String longitude,String name){
        Uri mUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + name);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, mUri);
        mActivity.startActivity(mIntent);
    }

}
