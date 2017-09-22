package com.ediancha.edcbusiness.router;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by dengmingzhi on 2017/9/21.
 */

public class Go {

    /**
     * 个人中心
     */
    public static void goPersonCenter() {
        ARouter.getInstance().build(RouterUrl.PERSON_CENTER_ACTIVITY).navigation();
    }

    /**
     * 空间详情
     */
    public static void goSpaceDesc() {
        ARouter.getInstance().build(RouterUrl.SPACE_DESC_ACTIVITY).navigation();
    }

    /**
     * 活动消息
     */
    public static void goActivityMessage() {
        ARouter.getInstance().build(RouterUrl.ACTIVITY_MESSAGE_ACTIVITY).navigation();
    }


    /**
     * 二维码扫描
     */
    public static void goQw(Activity ctx, int request) {
        ARouter.getInstance().build(RouterUrl.QW_ACTIVITY).navigation(ctx, request);
    }


    /**
     * 活动精选
     */
    public static void goActivitySplendid() {
        ARouter.getInstance().build(RouterUrl.ACTIVITY_SPLENDID_ACTIVITY).navigation();
    }

    /**
     * 活动精选
     */
    public static void goExpenseTips() {
        ARouter.getInstance().build(RouterUrl.EXPENSE_TIPS_ACTIVITY).navigation();
    }

    /**
     * 活动精选
     */
    public static void goLogin() {
        ARouter.getInstance().build(RouterUrl.LOGIN_ACTIVITY).navigation();
    }

    /**
     * 空间订单
     */
    public static void goSpaceOrder() {
        ARouter.getInstance().build(RouterUrl.SPACE_ORDER_ACTIVITY).navigation();
    }


}
