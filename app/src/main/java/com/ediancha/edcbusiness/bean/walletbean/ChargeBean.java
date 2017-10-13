package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/9/25.
 */

public class ChargeBean extends BaseBean<ChargeBean.Data> {



    public static class Data  {
        public String zvMoney;
        public ArrayList<Moneys> moneys;

        public ArrayList<Moneys> getMoneys() {
            if(moneys.size()>0){
                moneys.get(0).check=true;
            }
            moneys.add((Moneys) new Moneys().setViewType(1));
            return moneys;
        }

        public String getSurplus() {
            return zvMoney;
        }

        public void setSurplus(String surplus) {
            this.zvMoney = surplus;
        }
    }

    public static class Moneys extends ViewBaseType {
        public String id;
        public String rechargeAmount;
        public String giftAmount;

        public boolean check;

        public String getId() {
            return id;
        }

        public boolean getCheck() {
            return check;
        }

        public Moneys setCheck(boolean check) {
            this.check = check;
            return this;
        }

        public String getcMoney() {
            return "充"+rechargeAmount+"元";
        }

        public Moneys setcMoney(String cMoney) {
            this.rechargeAmount = cMoney;
            return this;
        }

        public String getsMoney() {
            return "赠送"+giftAmount+"元";
        }

        public Moneys setsMoney(String sMoney) {
            this.giftAmount = sMoney;
            return this;
        }
    }
}
