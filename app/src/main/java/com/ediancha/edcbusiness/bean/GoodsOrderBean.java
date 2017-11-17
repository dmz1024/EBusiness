package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

public class GoodsOrderBean extends BaseListBean<GoodsOrderBean.Data> {
    public static class Data extends ViewBaseType {
        public String statusInfo;
        public String spaceName;
        public String gOrderId;
        public int gOrderStatus;

        public int getgOrderStatus() {
            return gOrderStatus;
        }

        public String getOrderId() {
            return gOrderId;
        }

        public Data setStatusInfo(String statusInfo) {
            this.statusInfo = statusInfo;
            return this;
        }

        public Data setTitle(String title) {
            this.spaceName = title;
            return this;
        }

        public String getStatus() {
            return statusInfo;
        }

        public String getStatusInfo() {
            return statusInfo + "订单";
        }

        public String getTitle() {
            return spaceName;
        }

        public String goodsImage;
        public String goodsName;
        public String needPay;
        public String goodsNum;
        public String goodsWeight;

        public String getGoodImg() {
            return goodsImage;
        }

        public String getGoodInfo() {
            return goodsWeight;
        }

        public String getGoodName() {
            return goodsName;
        }

        public String getGoodNum() {
            return "x" + goodsNum;
        }

        public String getGoodPrice() {
            return "￥" + needPay;
        }
    }

}
