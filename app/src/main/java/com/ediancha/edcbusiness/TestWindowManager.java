package com.ediancha.edcbusiness;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.dmz.library.dmzapi.utils.AnyPref;
import com.dmz.library.dmzapi.utils.PermissionUtil;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.view.SpaceOrderInfoVIew;

/**
 * Created by dengmingzhi on 2017/9/27.
 */

public class TestWindowManager {
    private static TestWindowManager manager;
    private static Context context;
    private static WindowManager windowManager;

    public static void _init(Context context) {
        TestWindowManager.context = context;
    }


    public static synchronized TestWindowManager getInstance() {
        if (manager == null) {
            manager = new TestWindowManager();
            initManager();
        }
        return manager;
    }

    final static WindowManager.LayoutParams params = new WindowManager.LayoutParams();

    private static void initManager() {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT > 24) {
            params.type = WindowManager.LayoutParams.TYPE_PHONE;
        } else {
            params.type = WindowManager.LayoutParams.TYPE_TOAST;
        }

        // 类型
        // WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        // 设置flag
        int flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
        // 不设置这个flag的话，home页的划屏会有问题
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.x = AnyPref.instance("xy").getInt("x", -350);
        params.y = AnyPref.instance("xy").getInt("y", (ScreenUtil.getScreenHeight() / 2) - 100);
    }

    private TestWindowManager() {

    }

    private SpaceOrderInfoVIew view;

    public void addView() {

        if (this.view != null) {
            windowManager.removeView(this.view);
        }
        this.view = new SpaceOrderInfoVIew(context);
        this.view.findViewById(R.id.llBottom).setOnTouchListener(new View.OnTouchListener() {
            // 触屏监听
            float lastX, lastY;
            int oldOffsetX, oldOffsetY;
            int tag = 0;// 悬浮球 所需成员变量

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int action = event.getAction();
                float x = event.getX();
                float y = event.getY();
                if (tag == 0) {
                    oldOffsetX = params.x; // 偏移量
                    oldOffsetY = params.y; // 偏移量
                }


                if (action == MotionEvent.ACTION_DOWN) {
                    lastX = x;
                    lastY = y;
                } else if (action == MotionEvent.ACTION_MOVE) {
                    params.x += (int) (x - lastX) / 3; // 减小偏移量,防止过度抖动
                    params.y += (int) (y - lastY) / 3; // 减小偏移量,防止过度抖动
                    tag = 1;
                    windowManager.updateViewLayout(view, params);
                } else if (action == MotionEvent.ACTION_UP) {
                    int newOffsetX = params.x;
                    int newOffsetY = params.y;
                    // 只要按钮一动位置不是很大,就认为是点击事件
                    if (Math.abs(oldOffsetX - newOffsetX) <= 20
                            && Math.abs(oldOffsetY - newOffsetY) <= 20) {
//                        onFloatViewClick();
                        Log.d("打印", "哈哈哈哈");

                    } else {
                        tag = 0;
                        AnyPref.instance("xy").putInt("x", params.x).putInt("y", params.y).commit();
                    }
                }
                return true;
            }
        });
        windowManager.addView(view, params);
    }

    public SpaceOrderInfoVIew getView() {
        return view;
    }

}
