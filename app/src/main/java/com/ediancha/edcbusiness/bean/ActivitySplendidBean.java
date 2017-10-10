package com.ediancha.edcbusiness.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.List;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

public class ActivitySplendidBean extends BaseListBean<ActivitySplendidBean.Data> {


    public static class Data extends ViewBaseType {
        /**
         * id : 7
         * title : 国庆专享，充值即送精美礼品
         * image : s.east-profit.com/uploads/20170926/c13ec47a76a4ab497b67f0c2a9626e86.jpg
         * introduce : 国庆长假将至，一大波优惠像你飞来，你准备好了吗? 速来查看，过时不候哦。
         * createtime : 1506393869
         * html : http://s.east-profit.com/api.php/article/showActivityDetails?id=7
         */

        public int id;
        public String title;
        public String image;
        public String introduce;
        public int createtime;
        public String html;

        public boolean isShow;

        public boolean getIsShow() {
            return TextUtils.isEmpty(getImage()) ? false : true;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getIntroduce() {
            return introduce;
        }

        public int getCreatetime() {
            return createtime;
        }

        public String getHtml() {
            return html;
        }

        @Override
        public int getViewType() {
            return TextUtils.isEmpty(getImage()) ? 0 : 1;
        }
    }
}
