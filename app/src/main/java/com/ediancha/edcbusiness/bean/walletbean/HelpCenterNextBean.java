package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.List;

/**
 * Created by Admin on 2017/9/29.
 */

public class HelpCenterNextBean extends BaseListBean<HelpCenterNextBean.Data> {



    public static class Data extends ViewBaseType {
        /**
         * id : 3
         * title : 新用户如何充值？
         */

        public int id;
        public String title;

        public String html;
        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getHtml() {
            return html;
        }
    }
}
