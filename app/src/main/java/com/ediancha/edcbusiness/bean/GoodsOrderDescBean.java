package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

public class GoodsOrderDescBean extends BaseBean<GoodsOrderDescBean.Data> {

    public static class Data {
        public String statusInfo;
        public String title;
        public Goods goods;
        public ArrayList<PayInfo> payInfo;
        public ArrayList<OrderInfo> orderInfo;

        public Goods getGoods() {
            return goods;
        }

        public ArrayList<OrderInfo> getOrderInfos() {
            orderInfo.get(0).setCopy(true);
            return orderInfo;
        }

        public ArrayList<PayInfo> getPayInfo() {
            payInfo.get(payInfo.size() - 1).setColor("#ff0000");
            return payInfo;
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

    public static class PayInfo extends ViewBaseType {
        public String title;
        public String content;
        public String color = "#333333";

        public String getColor() {
            return color;
        }

        @Override
        public int getViewType() {
            return 1;
        }

        public PayInfo setColor(String color) {
            this.color = color;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }


    public static class OrderInfo extends ViewBaseType {
        public String content;
        public boolean isCopy;

        @Override
        public int getViewType() {
            return 2;
        }

        public OrderInfo setCopy(boolean copy) {
            isCopy = copy;
            return this;
        }

        public boolean isCopy() {
            return isCopy;
        }

        public String getContent() {
            return content;
        }
    }

}
