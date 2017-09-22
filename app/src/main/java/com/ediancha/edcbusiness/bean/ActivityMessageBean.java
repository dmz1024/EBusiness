package com.ediancha.edcbusiness.bean;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.ediancha.edcbusiness.constant.ApiContant;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/13.
 */

public class ActivityMessageBean extends BaseBean<ActivityMessageBean.Data> {
    public static class Data {
        public ArrayList<Activity> data1;
        public ArrayList<Message> data2;

        public ArrayList<Activity> getData1() {
            return data1;
        }

        public ArrayList<Message> getData2() {
            return data2;
        }
    }

    public static class Activity extends ViewBaseType {
        public String title;
        public String ivUrl;

        @Override
        public int getViewType() {
            return 1;
        }

        public String getIvUrl() {
            return ApiContant.IMAGE;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class Message extends ViewBaseType {
        public String content;
        public String time;
        public String title;
        public int img;

        public String getTitle() {
            return title;
        }

        public int getImg() {
            return img;
        }

        public Message setTitle(String title) {
            this.title = title;
            return this;
        }

        public Message setImg(int img) {
            this.img = img;
            return this;
        }

        @Override
        public int getViewType() {
            return 2;
        }


        public String getContent() {
            return TextUtils.isEmpty(content) ? "无" : content;
        }

        public String getTime() {
            return TextUtils.isEmpty(time) ? "无" : time;
        }
    }
}
