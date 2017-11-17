package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/11/13.
 */

public class OrderShopBean extends BaseBean<OrderShopBean.Data> {


    public static class Data{
        public String goodsName;
        public String goodsImage;
        public String units;
        public String originalPrice;
        public int status;
        public String spec;

        ArrayList<OrderDetailsBean> orderDetails;

        public String getGoodsName() {
            return goodsName;
        }

        public String getGoodsImage() {
            return goodsImage;
        }

        public String getUnits() {
            return units;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public int getStatus() {
            return status;
        }

        public String getSpec() {
            return spec;
        }

        public ArrayList<OrderDetailsBean> getOrderDetails() {
            return orderDetails;
        }
    }


    public static class OrderDetailsBean extends ViewBaseType{
        public String name;
        public String value;

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getViewType() {
            return 1;
        }
    }
}
