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
     * 主页
     */
    String MAIN_ACTIVITY = "/activity/main";

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
    String ACTIVITY_MESSAGE_ACTIVITY = "/v1/activity/message/activityMessage";

    /**
     * 活动精选
     */
    String ACTIVITY_SPLENDID_ACTIVITY = "/v1/activity/message/activitySplendid";

    /**
     * 交易通知
     */
    String EXPENSE_TIPS_ACTIVITY = "/v1/activity/message/expenseTips";


    /**
     * 登陆
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
    String WALLET_ACTIVITY = "/v1/activity/my/mypackage";

    /**
     * 余额
     */
    String MONEY_ACTIVITY = "/v1/activity/my/money";
    /**
     * 优惠券
     */
    String Coupon_ACTIVITY = "/v1/activity/my/coupon";

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
    String HELPCENTER_ACTIVITY = "/v1/activity/help/helpCenter";

    /**
     * 帮助中心————问题分类
     */
    String HELPCENTER_NEXT_ACTIVITY = "/v1/activity/help/helpCenterNext";

    /**
     * 优惠兑换
     */
    String COUPONCHANGE_ACTIVITY = "/v1/activity/coupon/couponChange";

    /**
     * 我的资料
     */
    String MY_INFO_ACTIVITY = "/v1/activity/my/myInfo";

    /**
     * 我的资料
     */
    String FANKUI_ACTIVITY = "/v1/activity/help/fankui";
    /**
     * H5页面
     */
    String WEBVIEW_ACTIVITY = "/v1/activity/help/webview";

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

    /**
     * 余额明细
     */
    String ORDERITEM_ACTIVITY = "/activity/orderdetail/orderItem";
    /**
     * 消费详情
     */
    String CONSUME_DETAIL_ACTIVITY = "/activity/orderdetail/consumeDetail";

    /**
     * 导航
     */
    String NAVIGATION_ACTIVITY = "/activity/space/navigation";
    /**
     * 定位
     */
    String LOACTION_ACTIVITY = "/activity/space/location";

    /**
     * 选择时段
     */
    String CHOSEDATE_ACTIVITY = "/v1/activity/space/chosedate";
    /**
     * 确认订单
     */
    String CHECKORDER_ACTIVITY = "/v1/activity/order/checkorder";

    /**
     * 费用明细
     */
    String SPACEPAYDETAIL_ACTIVITY = "/v1/activity/order/spacepaydetail";

    /**
     * v1押金
     */
    String CASH_PLEDGE_ACTIVITY = "/v1/activity/my/cashPledge";


    /**
     * 进行中订单
     */
    String ORDERING_ACTIVITY = "/v1/activity/order/ordering";


    /**
     * 空气质量
     */
    String AIR_QUALITY_ACTIVITY = "/v1/activity/space/airQuality";


    /**
     * 已完成订单
     */
    String ORDEREND_ACTIVITY = "/v1/activity/order/ordershop";

    /**
     * 输入门牌号开门
     */
    String OPEN_INPUT_ACTIVITY = "/v1/activity/space/openinput";
    /**
     * 设置
     */
    String SET_ACTIVITY = "/v1/activity/my/set";


    /**
     * 应用权限
     */
    String LIMITS_ACTIVITY = "/v1/activity/my/limits";
    /**
     * 余额明细
     */
    String BALANCE_DESC_ACTIVITY = "/v1/activity/my/balanceDesc";


    /**
     * 地图SPACE信息
     */
    String MAP_SPACE_ACTIVITY = "/v1/activity/space/mapSpace";


}
