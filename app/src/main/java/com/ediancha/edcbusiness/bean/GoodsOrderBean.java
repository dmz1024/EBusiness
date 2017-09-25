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
        public String title;
        public Goods goods;
        public String orderId;

        public String getOrderId() {
            return orderId;
        }

        public Data setStatusInfo(String statusInfo) {
            this.statusInfo = statusInfo;
            return this;
        }

        public Data setTitle(String title) {
            this.title = title;
            return this;
        }

        public Goods getGoods() {
            return goods;
        }

        public String getStatus() {
            return statusInfo;
        }

        public String getStatusInfo() {
            return statusInfo + "订单";
        }

        public String getTitle() {
            return title;
        }


    }

    public static class Goods {

        public String goodImg;
        public String goodName;
        public String goodPrice;
        public String goodNum;
        public String goodInfo;

        public String getGoodImg() {
            return goodImg;
        }

        public String getGoodInfo() {
            return goodInfo;
        }

        public String getGoodName() {
            return goodName;
        }

        public String getGoodNum() {
            return "x" + goodNum;
        }

        public String getGoodPrice() {
            return "￥" + goodPrice;
        }

    }
}
