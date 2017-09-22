package com.ediancha.edcbusiness.bean;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

public class ExpenseTipsBean extends BaseListBean<ExpenseTipsBean.Data> {
    public static class Data extends ViewBaseType {
        public String ivImg;
        public String url;
        public String title;
        public String content;
        public String time;
        public String money;
        public String[] info;

        public String getTime() {
            return time;
        }


        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getUrl() {
            return url;
        }

        public String getIvImg() {
            return ivImg;
        }

        public String getInfo() {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < info.length; i++) {
                sb.append(info[i]).append("\n");
            }
            return sb.substring(0, sb.length() - 1).toString();
        }

        public String getMoney() {
            return "￥" + money;
        }


    }
}
