package com.dmz.library.dmzapi.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.view.custom.MyAnimaToast;


/**
 * Created by Admin on 2017/9/29.
 */

public class MyToast {

    private static Context mContext;

    public static void _init(Context context) {
        mContext = context;
    }

    private static View view;
    private static Toast toast;
    private static TextView tvContent;
    private static View viewLeft;
    private static View viewRight;

    /**
     * 错误提示
     */
    public static void error(String msg) {
        init(1);
        tvContent.setText(msg);
    }

    /**
     * 警告
     */
    public static void warn(String msg) {
        init(2);
        tvContent.setText(msg);
    }

    public static void close() {
        if (toast != null) {
            toast.cancel();
        }
    }

    private static void init(int type) {
        if (view == null) {
            view = View.inflate(mContext, R.layout.toast_view, null);
            tvContent = view.findViewById(R.id.tvContent);
            viewLeft = view.findViewById(R.id.viewLeft);
            viewRight = view.findViewById(R.id.viewRight);
        }
        if (toast != null) {
            toast.cancel();
        }
        toast = MyAnimaToast.makeTextAnim(mContext, R.style.ToastAnim);
        toast.setView(view);
        toast.setGravity(Gravity.TOP, 0, 4);
        toast.setDuration(Toast.LENGTH_SHORT);
        setColor(type);
        toast.show();
    }

    /**
     * 正确
     */
    public static void normal(String msg) {
        init(0);
        tvContent.setText(msg);
    }

    private static Drawable[] drawables;
    private static int[] colors;

    private static void setColor(int type) {
        if (drawables == null) {
            drawables = new Drawable[6];
            colors = new int[3];
            drawables[0] = getBounds(R.drawable.icon_toast_success);
            drawables[1] = getBounds(R.drawable.icon_toast_err);
            drawables[2] = getBounds(R.drawable.icon_toast_warn);
            drawables[3] = mContext.getResources().getDrawable(R.drawable.shape_toast_success);
            drawables[4] = mContext.getResources().getDrawable(R.drawable.shape_toast_error);
            drawables[5] = mContext.getResources().getDrawable(R.drawable.shape_toast_warn);
            colors[0] = Color.parseColor("#ffc730");
            colors[1] = Color.parseColor("#ed3f14");
            colors[2] = Color.parseColor("#ff9900");
        }
        tvContent.setCompoundDrawables(drawables[type], null, null, null);
        viewLeft.setBackgroundColor(colors[type]);
        viewRight.setBackgroundColor(colors[type]);
        tvContent.setBackgroundDrawable(drawables[type + 3]);
    }

    private static Drawable getBounds(int rid) {
        Drawable drawable = mContext.getResources().getDrawable(rid);
        drawable.setBounds(0, 0, ScreenUtil.dp2px(20), ScreenUtil.dp2px(20));
        return drawable;
    }
}
