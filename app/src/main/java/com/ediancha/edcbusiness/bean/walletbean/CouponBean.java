package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

/**
 * Created by Admin on 2017/9/25.
 */

public class CouponBean extends BaseListBean<CouponBean.Data> {

    public static class Data extends ViewBaseType {

        public String title;

        public String yMoney;

        public String mMoney;

        public String mMoneyInfo;

        public String endTime;

        public String useRole;

        public String ID;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getyMoney() {
            return yMoney;
        }

        public void setyMoney(String yMoney) {
            this.yMoney = yMoney;
        }

        public String getMoney() {
            return mMoney;
        }

        public void setMoney(String money) {
            mMoney = money;
        }

        public String getMoneyInfo() {
            return mMoneyInfo;
        }

        public void setMoneyInfo(String moneyInfo) {
            mMoneyInfo = moneyInfo;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getUseRole() {
            return useRole;
        }

        public void setUseRole(String useRole) {
            this.useRole = useRole;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }
    }
}
