package com.ediancha.edcbusiness.v1.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/11/14.
 */

public class SpaceOrderEndBean extends BaseBean<ArrayList<SpaceOrderEndBean.Data>> {


    public static class Data extends ViewBaseType{

        public int userId;
        public int couponId;
        public String name;
        public int discountAmount;
        public int satisfyAmount;
        public int useOrderType;
        public String useTel;
        public int isFirstOrder;
        public int startTime;
        public int invalidTime;
        public String introduction;
        public int status;

        @Override
        public int getViewType() {
            return 1;
        }

        public int getUserId() {
            return userId;
        }

        public int getCouponId() {
            return couponId;
        }

        public String getName() {
            return name;
        }

        public int getDiscountAmount() {
            return discountAmount;
        }

        public int getSatisfyAmount() {
            return satisfyAmount;
        }

        public int getUseOrderType() {
            return useOrderType;
        }

        public String getUseTel() {
            return useTel;
        }

        public int getIsFirstOrder() {
            return isFirstOrder;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getInvalidTime() {
            return invalidTime;
        }

        public String getIntroduction() {
            return introduction;
        }

        public int getStatus() {
            return status;
        }
    }
}
