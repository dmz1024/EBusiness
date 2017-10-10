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
     * 帮助中心————问题分类
     */
    String HELPCENTER_NEXT_ACTIVITY = "/activity/help/helpCenterNext";

    /**
     * 优惠兑换
     */
    String COUPONCHANGE_ACTIVITY = "/activity/coupon/couponChange";

    /**
     * 我的资料
     */
    String MY_INFO_ACTIVITY = "/activity/my/myInfo";

    /**
     * 我的资料
     */
    String FANKUI_ACTIVITY = "/activity/help/fankui";
    /**
     * H5页面
     */
    String WEBVIEW_ACTIVITY = "/activity/help/webview";

    /**
     * 缴纳押金
     */
    String SUBMITDEPOSIT_ACTIVITY = "/activity/walletbag/submitdeposit";

    /**
     * 空间详情
     */
    String SPACEDETAIL_ACTIVITY = "/activity/space/spaceDetail";

    /**
     * 用户认证
     */
    String USERAUTHER_ACTIVITY = "/activity/my/auther";

    /**
     * 空间订单详情
     */
    String SPACE_ORDER_IN_PROGERESS_DESC_ACTIVITY = "/activity/order/spaceOrderInProgeressDesc";

    /**
     * 修改支付密码
     */
    String PAYPW_ACTIVITY = "/activity/walletbag/payPassWord";
    /**
     * 专题
     */
    String SPECIAL_ACTIVITY = "/activity/special";



    /**
     * 扫码返回规则(开锁确认)
     */
    String MONEY_AFFIRM_ACTIVITY = "/activity/sapce/moneyAffirm";

    /**
     * 修改信息
     */
    String UPDATEINFO_ACTIVITY = "/activity/my/updateInfo";
}
