package com.ediancha.edcbusiness.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/7/5.
 * 防止滑动
 */

public class ViewpagerNoScroll extends ViewPager {
    public ViewpagerNoScroll(Context context) {
        super(context);
    }

    public ViewpagerNoScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
