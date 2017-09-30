package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

/**
 * Created by Admin on 2017/9/25.
 */

public class MoneyBean extends BaseBean<MoneyBean.Data> {

    public static class Data{

        public Money money;

        public int youhui;
        public int depositMoney;
        public int depositType;
        public int payPwd;

        public Money getMoney() {
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
    public static class Money {
        public int money;
        public int userMoney;
        public int giftAmount;

        public int getMoney() {
            return money;
        }

        public Money setMoney(int money) {
            this.money = money;
            return this;
        }

        public int getUserMoney() {
            return userMoney;
        }

        public Money setUserMoney(int userMoney) {
            this.userMoney = userMoney;
            return this;
        }

        public int getGiftAmount() {
            return giftAmount;
        }

        public Money setGiftAmount(int giftAmount) {
            this.giftAmount = giftAmount;
            return this;
        }
    }
}
