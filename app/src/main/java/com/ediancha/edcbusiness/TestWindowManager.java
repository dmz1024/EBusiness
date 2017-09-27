package com.ediancha.edcbusiness;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.ediancha.edcbusiness.router.Go;

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

    private static void initManager() {
//        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        // 类型
//        params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        // WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
//        // 设置flag
//        int flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM|WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
//        params.flags = flags;
//        // 不设置这个弹出框的透明遮罩显示为黑色
//        params.format = PixelFormat.TRANSLUCENT;
//        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
//        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
//        // 不设置这个flag的话，home页的划屏会有问题
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.gravity = Gravity.RIGHT | Gravity.BOTTOM;
//        TextView textView = new TextView(context);
//        textView.setText("你好啊，悬浮窗大人");
//        textView.setTextSize(20);
//        textView.setPadding(50, 50, 50, 50);
//        textView.setBackgroundColor(Color.parseColor("#ff0000"));
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Go.goMyInfo();
//            }
//        });
//        windowManager.addView(textView, params);

    }

    private TestWindowManager() {

    }


}
