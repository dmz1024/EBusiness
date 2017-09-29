package com.ediancha.edcbusiness.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.ediancha.edcbusiness.R;

/**
 * Created by dengmingzhi on 2017/9/29.
 */

public class SpaceOrderInfoVIew extends FrameLayout {
    private ImageView ivLogo;
    private TextView tvTitle;
    private TextView tvContent;

    public SpaceOrderInfoVIew(Context context) {
        this(context, null);
    }

    public SpaceOrderInfoVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        View.inflate(context, R.layout.window_manager_order_info, this);
        tvTitle = findViewById(R.id.tvTitle);
    }

    public SpaceOrderInfoVIew setTitle(String title) {
        tvTitle.setText(title);
        return this;
    }
}
