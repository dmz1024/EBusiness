package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by Admin on 2017/9/29.
 */

public class MyToast {

    private static Toast mToast;
    private static Context mContext;

    public static void _init(Context context) {
        mContext = context;
    }

    /**
     * 错误提示
     */
    public static void error(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }

        mToast = Toasty.error(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }

    /**
     * 警告
     */
    public static void warn(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toasty.warning(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }

    /**
     * 正确
     */
    public static void normal(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toasty.info(mContext, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
