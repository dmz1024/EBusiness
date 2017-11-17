package com.ediancha.edcbusiness.bean.walletbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/9/26.
 * 帮助中心
 */

public class HelpCenterBean extends BaseBean<HelpCenterBean.Data> {


    /**
     * data : {"hots":[{"id":3,"title":"新用户如何充值？"},{"id":4,"title":"如何进行手机号修改？"},{"id":5,"title":"是否支持国外用户认证？"},{"id":6,"title":"押金交纳方式？"}],"categorys":[{"pid":16,"name":"充值问题"},{"pid":17,"name":"使用问题"},{"pid":18,"name":"注册问题"},{"pid":19,"name":"订单问题"},{"pid":20,"name":"认证问题"}]}
     */

    public static class Data{
        public ArrayList<HotsBean> hots;
        public ArrayList<CategorysBean> categorys;

        public ArrayList<HotsBean> getHots() {
            ArrayList<HotsBean> datas=new ArrayList<>();
            datas.addAll(hots);
            datas.addAll(hots);
            datas.addAll(hots);
            return datas;
        }

        public ArrayList<CategorysBean> getCategorys() {
            return categorys;
        }

    }

    public static class HotsBean extends ViewBaseType{
        /**
         * id : 3
         * title : 新用户如何充值？
         */

        public String id;
        public String title;
        public String html;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getHtml() {
            return html;
        }

        @Override
        public int getViewType() {
            return 0;
        }
    }

    public static class CategorysBean extends ViewBaseType{
        /**
         * pid : 16
         * name : 充值问题
         */

        public String pid;
        public String name;

        public String getPid() {
            return pid;
        }

        public String getName() {
            return name;
        }

        @Override
        public int getViewType() {
            return 1;
        }
    }
}
