package com.dmz.library.dmzapi.view.custom;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by dengmingzhi on 2017/11/8.
 */

public class MyAnimaToast extends Toast {

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public MyAnimaToast(Context context) {
        super(context);
    }

    /**
     * 调用有动画的Toast
     */
    public static Toast makeTextAnim(Context context, int styleId) {

        Toast toast = new Toast(context);
        try {
            Object mTN ;
            mTN = getField(toast, "mTN");
            if (mTN != null) {
                Object mParams = getField(mTN, "mParams");
                if (mParams != null
                        && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.windowAnimations = styleId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toast;
    }

    /**
     * 反射字段
     * @param object 要反射的对象
     * @param fieldName 要反射的字段名称
     */
    private static Object getField(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }
        return null;
    }
}
