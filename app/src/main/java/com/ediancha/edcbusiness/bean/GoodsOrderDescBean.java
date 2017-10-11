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
        public String goodsOut;
        public String spaceName;
        public ArrayList<PayInfo> payInfo;
        public ArrayList<OrderInfo> orderLog;
        public int gOrderStatus;

        public int getgOrderStatus() {
            return gOrderStatus;
        }

        public ArrayList<OrderInfo> getOrderInfos() {
            orderLog.get(0).setCopy(true);
            return orderLog;
        }

        public ArrayList<PayInfo> getPayInfo() {
            payInfo.get(payInfo.size() - 1).setColor("#ff0000");
            return payInfo;
        }

        public String getStatus() {
            return goodsOut;
        }

        public String getStatusInfo() {
            return goodsOut + "订单";
        }

        public String getTitle() {
            return spaceName;
        }
        public String goodsImage;
        public String goodsName;
        public String needPay;
        public String goodsNum;
        public String goodsWeight;
        public String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

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
