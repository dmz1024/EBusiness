package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.List;

/**
 * Created by Admin on 2017/9/25.
 */

public class CouponBean extends BaseListBean<CouponBean.Data> {
    
    public static class Data extends ViewBaseType {
        /**
         * userId : 1
         * couponId : 1
         * name : 新用户专享代金券
         * discountAmount : 10
         * satisfyAmount : 100
         * useOrderType : 2
         * useTel : 
         * isFirstOrder : 0
         * startTime : 1506603746
         * invalidTime : 1506700800
         * Stringroduction : 仅限首单使用
         * status : 1
         */
        public String userId;
        public String couponId;
        public String name;
        public String discountAmount;
        public String satisfyAmount;
        public String useOrderType;
        public String useTel;
        public String isFirstOrder;
        public String startTime;
        public String invalidTime;
        public String introduction;
        public String status;

        public String getUserId() {
            return userId;
        }

        public String getCouponId() {
            return couponId;
        }

        public String getName() {
            return name;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public String getSatisfyAmount() {
            return satisfyAmount;
        }

        public String getUseOrderType() {
            return useOrderType;
        }

        public String getUseTel() {
            return useTel;
        }

        public String getIsFirstOrder() {
            return isFirstOrder;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getInvalidTime() {
            return invalidTime;
        }

        public String getIntroduction() {
            return introduction;
        }

        public String getStatus() {
            return status;
        }
    }
}
