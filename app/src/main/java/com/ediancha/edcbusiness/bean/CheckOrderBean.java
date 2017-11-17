package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class CheckOrderBean extends BaseBean<CheckOrderBean.Data> {
    public static class Data {
        public String spaceId;
        public String spaceName;
        public long orderStartTime;
        public long NonstopTime;
        public int orderStatus;//1进行中 2外出中
        public String orderId;

        public String getOrderId() {
            return orderId;
        }

        public String getSpaceId() {
            return spaceId;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public long getOrderStartTime() {
            return orderStartTime;
        }

        public long getNonstopTime() {
            return NonstopTime;
        }

        public int getOrderStatus() {
            return orderStatus;
        }
    }
}
