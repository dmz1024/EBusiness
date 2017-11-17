package com.ediancha.edcbusiness.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.List;

/**
 * Created by Admin on 2017/10/9.
 */

public class SpecialBean extends BaseListBean<SpecialBean.Data> {

    public static class Data extends ViewBaseType {
        /**
         * id : 1
         * title : test
         * image : s.east-profit.com/assets/img/qrcode.png
         * introduce : 1222223321
         * createtime : 1499769482
         * html : http://s.east-profit.com/api.php/article/showSpecialDetails?id=1
         */

        public String id;
        public String title;
        public String image;
        public String introduce;
        public int createtime;
        public String html;

        public String getId() {
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
    }
}
