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

    /**
     * 空间订单
     */
    public static void goGoodOrder() {
        ARouter.getInstance().build(RouterUrl.GOOD_ORDER_ACTIVITY).navigation();
    }

    /**
     * 空间订单详情
     */
    public static void goGoodOrderDesc(String orderId) {
        ARouter.getInstance().build(RouterUrl.GOOD_ORDER_DESC_ACTIVITY).withString("orderId", orderId).navigation();
    }

    /**
     * 我的钱包
     */
    public static void goMyPackage() {
        ARouter.getInstance().build(RouterUrl.WALLET_ACTIVITY).navigation();
    }

    /**
     * 余额
     */
    public static void goMoney() {
        ARouter.getInstance().build(RouterUrl.MONEY_ACTIVITY)
                .navigation();
    }
    /**
     * 优惠券
     */
    public static void goCoupon() {
        ARouter.getInstance().build(RouterUrl.Coupon_ACTIVITY).navigation();
    }


    /**
     * 押金
     */
    public static void goDeposit(String money,int status) {
        ARouter.getInstance().build(RouterUrl.DEPOSIT_ACTIVITY)
                .withString("money",money)
                .withInt("status",status)
                .navigation();
    }

    /**
     * 充值
     */
    public static void goCharge() {
        ARouter.getInstance().build(RouterUrl.CHARGE_ACTIVITY).navigation();
    }

    /**
     * 帮助中心
     */
    public static void goHelpCenter() {
        ARouter.getInstance().build(RouterUrl.HELPCENTER_ACTIVITY).navigation();
    }


    /**
     * 帮助中心---问题分类
     */
    public static void goHelpCenterNext(String pid,String name) {
        ARouter.getInstance().build(RouterUrl.HELPCENTER_NEXT_ACTIVITY)
                .withString("pid",pid)
                .withString("name",name)
                .navigation();
    }
    /**
     * 优惠兑换
     */
    public static void goCouponChange() {
        ARouter.getInstance().build(RouterUrl.COUPONCHANGE_ACTIVITY).navigation();
    }

    /**
     * 我的资料
     */
    public static void goMyInfo() {
        ARouter.getInstance().build(RouterUrl.MY_INFO_ACTIVITY).navigation();
    }

    /**
     * 在线反馈
     */
    public static void goFanKui() {
        ARouter.getInstance().build(RouterUrl.FANKUI_ACTIVITY).navigation();
    }

    /**
     * H5页面展示
     */
    public static void goWebView(String id) {
        ARouter.getInstance().build(RouterUrl.WEBVIEW_ACTIVITY)
                .withString("H5",id)
                .navigation();
    }
    /**
     *缴纳押金
     */
    public static void goSubmitDeposit() {
        ARouter.getInstance().build(RouterUrl.SUBMITDEPOSIT_ACTIVITY).navigation();
    }

    /**
     *空间详情
     */
    public static void goSpaceDetail(String id) {
        ARouter.getInstance().build(RouterUrl.SPACEDETAIL_ACTIVITY)
                .withString("id",id)
                .navigation();
    }

    /**
     * 空间订单详情
     */
    public static void goSpaceOrderInProgeressDesc(String orderId) {
        ARouter.getInstance().build(RouterUrl.SPACE_ORDER_IN_PROGERESS_DESC_ACTIVITY).withString("orderId", orderId).navigation();
    }


    /**
     *用户认证
     */
    public static void goUserAuther() {
        ARouter.getInstance().build(RouterUrl.USERAUTHER_ACTIVITY).navigation();
    }

    /**
     *修改支付密码
     */
    public static void goPayPassWord() {
        ARouter.getInstance().build(RouterUrl.PAYPW_ACTIVITY).navigation();
    }

    /**
     *专题
     */
    public static void goSpecial() {
        ARouter.getInstance().build(RouterUrl.SPECIAL_ACTIVITY).navigation();
    }




}
