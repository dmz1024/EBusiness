package com.ediancha.edcbusiness.constant;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public interface ApiContant {

    String IMAGE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506064152495&di=d1e79176fd2c398ceefddc37efbab7aa&imgtype=jpg&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb7003af33a87e9502dc8fa921a385343faf2b474.jpg";

    String BASE_URL = "http://law.east-profit.com/app.php/home/";

    String BASE_API = "http://s.east-profit.com/api.php/";
    String BASE_API_HOST = "http://s.east-profit.com/";

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
    String SPACE_ORDER = BASE_API + "orders/getorder";

    /**
     * 商品订单
     */
    String GOOD_ORDER = BASE_API + "gorders/getgorders";

    /**
     * 商品订单详情
     */
    String GOOD_ORDER_DESC = BASE_API + "gorders/getgdetail";

    /**
     * 我的钱包
     */
    String MYPACKAGE = BASE_API + "Users/myWallet";


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
    String SPACEDETAIL_URL = BASE_API + "space/detail";
    /**
     * 实名认证
     */
    String AUTHER_URL = BASE_API + "users/authentication";


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

    /**
     * 扫码返规则
     */
    String UPDATAEINFO = BASE_API + "users/update_user";
    /**
     * 修改头像
     */
    String UPLOAD_URL = BASE_API + "upload/upload";

    /**
     * 修改支付密码
     */
    String UPDATE_PAY_URL = BASE_API + "users/set_payPwd";

    /**
     * 长按开锁
     */
    String OPEN_LOCK = BASE_API + "orders/unlock";

    /**
     * 充值金额
     */
    String CHAREGE_MONEY_URL = BASE_API + "logrecharge/aggregationpay";
    /**
     * 检测充值是否成功
     */
    String CHECK_PAY_URL = BASE_API + "logrecharge/checkpay";


    /**
     * 检测用户是否有进行中订单
     */
    String HAND_ORDER = BASE_API + "orders/handorder";
    String ACTIIVTY_MESSAGE_URL=BASE_API+"article/activityMessage";

    /**
     * QQ登陆
     */
    String QQ_LOGIN_URL=BASE_API+"users/loginByQQ";

    /**
     * Wechat登陆
     */

    String WECHAT_LOGIN_URL=BASE_API+"users/loginByWechat";

    /**
     * 解除绑定
     */
    String THREAD_UNBIND_URL=BASE_API+"users/unBind";

    /**
     * 绑定QQ
     */
    String THREAD_BINDQQ_URL=BASE_API+"users/bindQQByUid";

    /**
     * 绑定微信
     */
    String THREAD_BINDWECHAT_URL=BASE_API+"users/bindWechatByUid";
    /**
     * 绑定账号
     */
    String BIND_URL=BASE_API+"users/bindThird";

    /**
     * 选择日期
     */
    String CHOSEDTAE_URL=BASE_API+"/space/reserve?type=3";


    /**
     * 押金状态
     */
    String CASHPLEDGE=BASE_API+"/space/reserve?type=3";


}
