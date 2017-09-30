package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;


/**
 * Created by Admin on 2017/9/25.
 */

public class MyPackageBean extends BaseBean<MyPackageBean.Data> {

    /**
     * data : {"money":{"money":0,"userMoney":0,"giftAmount":0},"youhui":0,"depositMoney":0,"depositType":0,"payPwd":1}
     */

    public static class Data {
        /**
         * money : {"money":0,"userMoney":0,"giftAmount":0}
         * youhui : 0
         * depositMoney : 0
         * depositType : 0
         * payPwd : 1
         */

        public MoneyBean money;
        public int youhui;
        public int depositMoney;
        public int depositType;
        public int payPwd;

        public MoneyBean getMoney() {
            return money;
        }

        public int getYouhui() {
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
        /**
         * money : 0
         * userMoney : 0
         * giftAmount : 0
         */

        public int money;
        public int userMoney;
        public int giftAmount;

        public int getMoney() {
            return money;
        }

        public int getUserMoney() {
            return userMoney;
        }

        public int getGiftAmount() {
            return giftAmount;
        }
    }
}
