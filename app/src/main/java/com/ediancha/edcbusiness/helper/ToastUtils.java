package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by Admin on 2017/9/29.
 */

public class ToastUtils {


    private static ToastUtils mToastUtils;

    private static Toast mToast;
    private Context mContext;

    public static ToastUtils getInstance() {
        return mToastUtils != null ? mToastUtils : new ToastUtils();
    }

    /**
     * 错误提示
     */
    public void error(Context mContext, String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toasty.error(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }

    /**
     * 警告
     */
    public void warn(Context mContext, String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toasty.warning(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }

    /**
     * 警告
     */
    public void normal(Context mContext, String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toasty.normal(mContext, msg, Toast.LENGTH_LONG);
        mToast.show();
    }
}
