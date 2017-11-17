package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

/**
 * Created by Admin on 2017/11/14.
 */

public class SpaceOrderDataBean extends BaseListBean<SpaceOrderDataBean.Data> {


    public static class Data extends ViewBaseType{

        public String goodsName;
        public String goodsImage;
        public String units;
        public String originalPrice;
        public int status;
        public String productTitle;
        public String space;
        public String gridTitle;
        public String spec;

        @Override
        public int getViewType() {
            return 1;
        }

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

        public String getProductTitle() {
            return productTitle;
        }

        public String getSpace() {
            return space;
        }

        public String getGridTitle() {
            return gridTitle;
        }

        public String getSpec() {
            return spec;
        }
    }
}
