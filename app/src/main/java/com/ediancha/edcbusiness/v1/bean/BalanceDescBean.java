package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

/**
 * Created by dengmingzhi on 2017/11/14.
 */

public class BalanceDescBean extends BaseListBean<BalanceDescBean.Data> {
    public static class Data extends ViewBaseType {
        public String title;
        public String time;
        public String money;
        public boolean isJia;

        public boolean isJia() {
            return isJia;
        }

        public String getMoney() {
            return money;
        }

        public String getTitle() {
            return title;
        }

        public String getTime() {
            return time;
        }
    }
}
