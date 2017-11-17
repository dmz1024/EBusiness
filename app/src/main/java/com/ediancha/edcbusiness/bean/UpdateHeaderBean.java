package com.ediancha.edcbusiness.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by Admin on 2017/10/11.
 */

public class UpdateHeaderBean extends BaseBean<UpdateHeaderBean.Data> {

    public String url;
    public int wait;


    public String getUrl() {
        return url;
    }

    public UpdateHeaderBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getWait() {
        return wait;
    }


    public static class Data{

        public String url;

        public String getUrl() {
            return url;
        }
    }
}
