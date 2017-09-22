package com.dmz.library.dmzapi.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;

import java.lang.reflect.Field;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class ResUtil {


    public static Drawable setDra(Context ctx, int rid) {
        Drawable drawable = ctx.getResources().getDrawable(rid);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }


    /**
     * 将字符串转成资源id
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 将字符串转成资源id
     *
     * @param variableName
     * @return
     */
    public static int getMipResId(Context context, String variableName) {

        int resId = context.getResources().getIdentifier(variableName, "mipmap", context.getPackageName());
        //如果没有在"mipmap"下找到imageName,将会返回0
        return resId;
    }


    /**
     * 将字符串转成资源id
     *
     * @param variableName
     * @return
     */
    public static int getLayoutResId(String variableName) {
        return getResId(variableName, R.layout.class);
    }


    /**
     * 返回布局id
     *
     * @param type
     * @return
     */
    public static int getLayoutId(int type) {
        switch (type) {
            case 1:
                return R.layout.common_item_type_1;
        }
        return -1;
    }
}
