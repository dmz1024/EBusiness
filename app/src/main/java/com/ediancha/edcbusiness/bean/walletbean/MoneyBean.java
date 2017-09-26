package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by Admin on 2017/9/25.
 */

public class MoneyBean extends BaseBean<MoneyBean.Data> {

    public static class Data {
        public String totalMoney;

        public String cMoney;

        public String zMoney;

        public String xiyi;

        public String getTotalMoney() {
            return totalMoney;
        }

        public Data setTotalMoney(String totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public String getcMoney() {
            return cMoney;
        }

        public Data setcMoney(String cMoney) {
            this.cMoney = cMoney;
            return this;
        }

        public String getzMoney() {
            return zMoney;
        }

        public Data setzMoney(String zMoney) {
            this.zMoney = zMoney;
            return this;
        }

        public String getXiyi() {
            return xiyi;
        }

        public Data setXiyi(String xiyi) {
            this.xiyi = xiyi;
            return this;
        }
    }

}
