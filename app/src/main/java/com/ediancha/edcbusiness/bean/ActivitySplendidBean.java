package com.ediancha.edcbusiness.bean;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

public class ActivitySplendidBean extends BaseListBean<ActivitySplendidBean.Data> {
    public static class Data extends ViewBaseType {
        public int isShow;
        public String ivImg;
        public String url;
        public String title;
        public String content;
        public String time;

        public String getTime() {
            return "今天10:00";
        }

        @Override
        public int getViewType() {
            return TextUtils.isEmpty(getIvImg()) ? 0 : 1;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return "国庆长假将至，一大波优惠向你飞来，你准备好了吗？速来查看，过时不候哦！";
        }

        public String getUrl() {
            return ApiContant.ACTIVITY_MESSAGE;
        }

        public String getIvImg() {
            return ivImg;
        }

        public boolean getIsShow() {
            return isShow == 0;
        }
    }
}
