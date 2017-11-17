package com.ediancha.edcbusiness.bean.pay;


import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.ediancha.edcbusiness.helper.pay.WeChatPayUtil;

/**
 * Created by Admin on 2017/10/13.
 */

public class PayInfoBean<T> extends BaseBean<T> {

    public String info;
    public String getInfo() {
        return info;
    }

    public static class WeChatPayInfoBean extends PayInfoBean<WeChatPayUtil.Data>{}

    public static class AliPayInfoBean extends PayInfoBean<String>{}
}
