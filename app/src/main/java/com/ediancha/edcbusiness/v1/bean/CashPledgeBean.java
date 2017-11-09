package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/11/8.
 */

public class CashPledgeBean extends BaseBean<CashPledgeBean.Data> {
    public static class Data {
        public String money;
        public int status=1;

        public String getMoney() {
            return money;
        }

        public String getStatusInfo() {
            switch (getStatus()) {
                case 0:
                    return "未缴纳";
                case 1:
                    return "押金退还审核中";
                case 2:
                    return "已缴纳";
            }
            return "未知状态";
        }

        public String getShowStatusInfo() {
            switch (getStatus()) {
                case 0:
                    return "缴纳押金";
                case 1:
                    return "取消退押金";
                case 2:
                    return "退押金";
            }
            return "未知状态";
        }

        public int getStatus() {
            return status;
        }
    }
}
