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
        public ArrayList<Activity> top;
        public ArrayList<Message> notice;

        public ArrayList<Activity> getTop() {
            return top;
        }

        public ArrayList<Message> getNotice() {
            return notice;
        }
    }

    public static class Activity extends ViewBaseType {
        public String id;
        public String image;
        public String html;

        @Override
        public int getViewType() {
            return 1;
        }

        public String getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getHtml() {
            return html;
        }
    }

    public static class Message extends ViewBaseType {
        public String type;
        public long createtime;
        public String title;
        public int img;
        public String id;

        @Override
        public int getViewType() {
            return 2;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public int getImg() {
            return img;
        }

        public Message setType(String type) {
            this.type = type;
            return this;
        }

        public long getCreatetime() {
            return createtime;
        }

        public Message setCreatetime(long createtime) {
            this.createtime = createtime;
            return this;
        }

        public Message setTitle(String title) {
            this.title = title;
            return this;
        }

        public Message setImg(int img) {
            this.img = img;
            return this;
        }

        public String getId() {
            return id;
        }

        public Message setId(String id) {
            this.id = id;
            return this;
        }
    }
}
