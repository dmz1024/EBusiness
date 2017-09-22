package com.dmz.library.dmzapi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by dengmingzhi on 2017/9/19.
 */

public class ScreenUtil {
    private static Context appContext;
    private static int mWidth;
    private static int mHeight;

    public static void _init(Context context) {
        appContext = context.getApplicationContext();
    }

    /**
     * 获得屏幕高度
     *
     * @return by Hankkin at:2015-10-07 21:15:59
     */
    public static int getScreenWidth() {
        if (mWidth != 0) {
            return mWidth;
        }
        WindowManager wm = (WindowManager) appContext
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return mWidth = outMetrics.widthPixels;
    }


    /**
     * 获得屏幕高度
     *
     * @return by Hankkin at:2015-10-07 21:16:13
     */
    public static int getScreenHeight() {
        if (mHeight != 0) {
            return mHeight;
        }
        WindowManager wm = (WindowManager) appContext
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return mHeight = outMetrics.heightPixels;
    }


    /**
     * 获取屏幕密度
     *
     * @param context
     * @return by Hankkin at:2015-10-07 21:16:29
     */
    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }


    /**
     * dip转px像素
     *
     * @param px
     * @return by Hankkin at:2015-10-07 21:16:43
     */
    public static int dp2px(float px) {
        final float scale = getScreenDensity(appContext);
        return (int) (px * scale + 0.5);
    }


    /**
     * 获得状态栏的高度
     *
     * @return by Hankkin at:2015-10-07 21:16:43
     */
    public static int getStatusHeight() {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = appContext.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }


    /**
     * 获取Layout截图
     *
     * @return 所需区域的截图
     */
    public static Bitmap getBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();  //启用DrawingCache并创建位图
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache()); //创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
        view.setDrawingCacheEnabled(false);  //禁用DrawingCahce否则会影响性能
        return bitmap;
    }

}
