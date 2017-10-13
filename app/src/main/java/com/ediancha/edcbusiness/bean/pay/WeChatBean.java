package com.ediancha.edcbusiness.bean.pay;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by Admin on 2017/10/13.
 */

public class WeChatBean extends BaseBean<WeChatBean.Data>{



    public static class Data {

        public String appid;
        public String partnerid;
        public String prepayid;
        public String noncestr;
        public int timestamp;
        public String packageX;
        public String sign;

        public String info;

        public String getInfo() {
            return info;
        }

        public String getAppid() {
            return appid;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getPackageX() {
            return packageX;
        }

        public String getSign() {
            return sign;
        }
    }
}
