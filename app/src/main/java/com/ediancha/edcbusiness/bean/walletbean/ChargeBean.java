package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/9/25.
 */

public class ChargeBean extends BaseBean<ChargeBean.Data> {



    public static class Data  {
        public String surplus;
        public ArrayList<Moneys> moneys;

        public ArrayList<Moneys> getMoneys() {
            moneys.add((Moneys) new Moneys().setcMoney("其他金额").setsMoney("不赠送").setViewType(1));
            return moneys;
        }

        public String getSurplus() {
            return surplus;
        }

        public void setSurplus(String surplus) {
            this.surplus = surplus;
        }
    }

    public static class Moneys extends ViewBaseType {
        public String cMoney;

        public String sMoney;

        public int check;

        public String wMoney;


        public String getwMoney() {
            return wMoney;
        }

        public Moneys setwMoney(String wMoney) {
            this.wMoney = wMoney;
            return this;
        }

        public int getCheck() {
            return check;
        }

        public void setCheck(int check) {
            this.check = check;

        }

        public String getcMoney() {
            return cMoney;
        }

        public Moneys setcMoney(String cMoney) {
            this.cMoney = cMoney;
            return this;
        }

        public String getsMoney() {
            return sMoney;
        }

        public Moneys setsMoney(String sMoney) {
            this.sMoney = sMoney;
            return this;
        }
    }
}
