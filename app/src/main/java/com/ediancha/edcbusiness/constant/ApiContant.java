package com.ediancha.edcbusiness.constant;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public interface ApiContant {

    String IMAGE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506064152495&di=d1e79176fd2c398ceefddc37efbab7aa&imgtype=jpg&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb7003af33a87e9502dc8fa921a385343faf2b474.jpg";

    String BASE_URL = "http://law.east-profit.com/app.php/home/";

    String BASE_API ="http://s.east-profit.com/api.php/";

    /**
     * 活动消息
     */
    String ACTIVITY_MESSAGE = BASE_URL + "buleline/getData";


    /**
     * 活动精选
     */
    String ACTIVITY_SPLENDID = BASE_API + "article/getActivity";

    /**
     * 交易提醒
     */
    String EXPENSE_TIPS = BASE_URL + "buleline/getData";

    /**
     * 空间订单
     */
    String SPACE_ORDER = BASE_URL + "buleline/getData";

    /**
     * 商品订单
     */
    String GOOD_ORDER = BASE_URL + "buleline/getData";

    /**
     * 商品订单详情
     */
    String GOOD_ORDER_DESC = BASE_URL + "buleline/getData";

    /**
     * 我的钱包
     */
    String MYPACKAGE = BASE_API + "users/account_info";


    /**
     * 余额
     */
    String MONEY = BASE_API + "users/account_info";

    /**
     * 优惠券
     */
    String COUPON = BASE_API + "coupon/usercoupon";

    /**
     * 优惠券兑换
     */
    String COUPON_CHANGE = BASE_API + "coupon/exchangeCoupon";

    /**
     * 我的资料
     */
    String MY_INFO = BASE_URL + "buleline/getData";

    /**
     * 帮助中心
     */
    String HELPCENTER_URL = BASE_API + "article/helpcenter";

    /**
     * 帮助中心--问题分类
     */
    String HELPCENTER_NEXT_URL = BASE_API + "article/getarticle";

    /**
     * 我的进行中订单
     */
    String SPACE_ORDER_IN_PROGRESS = BASE_URL + "buleline/getData";
    /**
     * 空间详情
     */
    String SPACEDETAIL_URL= BASE_API + "space/detail";
    /**
     * 实名认证
     */
    String AUTHER_URL= BASE_API + "users/authentication";


    String BASEAPI = "http://s.east-profit.com/api.php/";


    /**
     * 登录
     */
    String LOGIN = BASEAPI + "users/toLogin";


    /**
     * 获取验证码
     */
    String GET_CODE = BASEAPI + "users/getPhoneVerifyCode";


    /**
     * 充值
     */
    String CHARGE = BASEAPI + "marketin/antiscour";

    /**
     * 退押金
     */
    String EXITDEPOSIT_URL = BASE_API + "users/return_deposit";

    /**
     * 空间列表
     */
    String HOME_URL = BASE_API + "index/index";

    /**
     * 专题
     */
    String SPECIAL_URL = BASE_API + "article/getSpecial";
    /**
     * 扫码返规则
     */
    String SCANCODE = BASE_API + "space/scancode";
}
