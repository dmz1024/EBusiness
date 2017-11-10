package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;


/**
 * Created by Admin on 2017/9/25.
 */

public class MyPackageBean extends BaseBean<MyPackageBean.Data> {

    public static class Data {


        public MoneyBean money;
        public String youhui;
        public int depositMoney;
        public int depositType;
        public int payPwd;

        public MoneyBean getMoney() {
            return money;
        }

        public String getYouhui() {
            return youhui;
        }

        public int getDepositMoney() {
            return depositMoney;
        }

        public int getDepositType() {
            return depositType;
        }

        public int getPayPwd() {
            return payPwd;
        }
    }

    public static class MoneyBean {
        public String money;
        public String userMoney;
        public String giftAmount;

        public String getMoney() {
            return money;
        }

        public String getUserMoney() {
            return userMoney;
        }

        public String getGiftAmount() {
            return giftAmount;
        }
    }
}
