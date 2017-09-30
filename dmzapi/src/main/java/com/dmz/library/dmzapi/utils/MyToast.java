package com.dmz.library.dmzapi.utils;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dmz.library.dmzapi.R;


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
    private static ImageView ivImg;

    /**
     * 错误提示
     */
    public static void error(String msg) {
        init();
        tvContent.setText(msg);
        ivImg.setImageResource(R.drawable.icon_toast_err);
        toast.show();
    }

    /**
     * 警告
     */
    public static void warn(String msg) {
        init();
        tvContent.setText(msg);
        ivImg.setImageResource(R.drawable.icon_toast_warn);
        toast.show();
    }

    private static void init() {
        if (view == null) {
            view = View.inflate(mContext, R.layout.toast_view, null);
            tvContent = view.findViewById(R.id.tvContent);
            ivImg = view.findViewById(R.id.ivImg);
        }
        if (Build.VERSION.SDK_INT > 22) {
            if (toast != null) {
                toast.cancel();
            }
            toast = new Toast(mContext);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            if (toast == null) {
                toast = new Toast(mContext);
                toast.setView(view);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
        }

    }

    /**
     * 正确
     */
    public static void normal(String msg) {
        init();
        tvContent.setText(msg);
        ivImg.setImageResource(R.drawable.icon_toast_success);
        toast.show();
    }
}
