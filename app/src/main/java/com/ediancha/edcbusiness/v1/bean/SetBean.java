package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/11/13.
 */

public class SetBean extends BaseBean<SetBean.Data> {
    public static class Data{
        public int spaceMessage;
        public int moneyMessage;
        public int activityMessage;

        public int getActivityMessage() {
            return activityMessage;
        }

        public int getMoneyMessage() {
            return moneyMessage;
        }

        public int getSpaceMessage() {
            return spaceMessage;
        }
    }
}
