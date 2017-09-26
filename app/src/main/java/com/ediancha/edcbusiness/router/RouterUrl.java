package com.ediancha.edcbusiness.router;

/**
 * Created by dengmingzhi on 2017/9/21.
 */

/**
 * 路由地址
 */
public interface RouterUrl {


    /**
     * 个人中心
     */
    String PERSON_CENTER_ACTIVITY = "/activity/my/personCenter";

    /**
     * 空间详情
     */
    String SPACE_DESC_ACTIVITY = "/activity/space_desc";


    /**
     * 二维码扫描
     */
    String QW_ACTIVITY = "/activity/qw";

    /**
     * 活动消息
     */
    String ACTIVITY_MESSAGE_ACTIVITY = "/activity/message/activityMessage";

    /**
     * 活动精选
     */
    String ACTIVITY_SPLENDID_ACTIVITY = "/activity/message/activitySplendid";

    /**
     * 交易通知
     */
    String EXPENSE_TIPS_ACTIVITY = "/activity/message/expenseTips";


    /**
     * 交易通知
     */
    String LOGIN_ACTIVITY = "/activity/login/login";

    /**
     * 空间订单
     */
    String SPACE_ORDER_ACTIVITY = "/activity/order/spaceOrder";

    /**
     * 商品订单
     */
    String GOOD_ORDER_ACTIVITY = "/activity/order/goodOrder";

    /**
     * 商品订单详情
     */
    String GOOD_ORDER_DESC_ACTIVITY = "/activity/order/goodOrderDesc";


    /**
     * 我的钱包
     */
    String WALLET_ACTIVITY = "/activity/walletbag/mypackage";

    /**
     * 余额
     */
    String MONEY_ACTIVITY = "/activity/walletbag/money";
    /**
     * 优惠券
     */
    String Coupon_ACTIVITY = "/activity/walletbag/coupon";

    /**
     * 押金
     */
    String DEPOSIT_ACTIVITY = "/activity/walletbag/deposit";
    /**
     * 充值
     */
    String CHARGE_ACTIVITY = "/activity/walletbag/charge";
    /**
     * 帮助中心
     */
    String HELPCENTER_ACTIVITY = "/activity/help/helpCenter";

    /**
     * 优惠兑换
     */
    String COUPONCHANGE_ACTIVITY = "/activity/coupon/couponChange";

    /**
     * 我的资料
     */
    String MY_INFO_ACTIVITY = "/activity/my/myInfo";
}
