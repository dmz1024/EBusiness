package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseBean;


/**
 * Created by Admin on 2017/9/25.
 */

public class MyPackageBean extends BaseBean<MyPackageBean.Data> {
    public static class Data {
        public int payPassWord;
        public String yMoney;
        public String count;
        public String yjMoney;

        public String getCount() {
            return count;
        }

        public String getYjMoney() {
            return yjMoney;
        }

        public int getPayPassWord() {
            return payPassWord;
        }

        public String getyMoney() {
            return yMoney;
        }

        public void setPayPassWord(int payPassWord) {
            this.payPassWord = payPassWord;
        }

        public void setyMoney(String yMoney) {
            this.yMoney = yMoney;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public void setYjMoney(String yjMoney) {
            this.yjMoney = yjMoney;
        }
    }
}
