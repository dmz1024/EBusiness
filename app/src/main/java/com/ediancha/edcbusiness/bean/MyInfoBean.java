package com.ediancha.edcbusiness.bean;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/9/26.
 */

public class MyInfoBean extends BaseBean<MyInfoBean.Data> {
    public static class Data {
        public String header;
        public String nickName;
        public int sex;
        public String birthday;
        public int role;
        public String tel;
        public int wx;
        public int qq;
        public String qqName;
        public String wxName;

        public String getTel() {
            return tel;
        }

        public int getRole() {
            return role;
        }

        public int getSex() {
            return sex;
        }

        public String getSexInfo() {
            return sex == 0 ? "未知" : (sex == 1 ? "男" : "女");
        }

        public String getRoleInfo() {
            return role == 0 ? "未认证" : "认证用户";
        }


        public String getBirthday() {
            return birthday;
        }

        public String getHeader() {
            return header;
        }


        public String getNickName() {
            return nickName;
        }

        public int getQq() {
            return qq;
        }

        public String getQQInfo() {
            return qq == 0 ? "未绑定" : "已绑定 " + qqName;
        }

        public int getWx() {
            return wx;
        }

        public String getWxInfo() {
            return wx == 0 ? "未绑定" : "已绑定 " + wxName;
        }
    }
}
