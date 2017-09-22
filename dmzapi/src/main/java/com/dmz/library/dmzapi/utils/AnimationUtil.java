package com.dmz.library.dmzapi.utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class AnimationUtil {

    public static void arrowsAnimation(View view, boolean isColl) {
        view.clearAnimation();
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotationX", isColl ? 0f : 180f, isColl ? 180f : 0f);
        anim.setDuration(500);
        anim.start();
    }


    public static void chaAnimatio(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "X",
                ScreenUtil.getScreenWidth(), ScreenUtil.getScreenWidth() - ScreenUtil.dp2px(40));
        anim.setDuration(800);
        anim.start();
    }
}
