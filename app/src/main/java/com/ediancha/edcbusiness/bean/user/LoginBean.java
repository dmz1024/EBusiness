package com.ediancha.edcbusiness.bean.user;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/9/28.
 */

public class LoginBean extends BaseBean<LoginBean.Data> {
    public static class Data {
        public String userId;
        public String userPhoto;
        public String userName;
        public String userPhone;
        public String brithday;
        public String userSex;
        public long createTime;
        public String status;
        public String token;
        public int rz;// 认证 1 未认证 2 已认证
        public float money;
        public int depositMoney;
        public int wx;
        public int qq;


        public String getUserId() {
            return userId;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public String getUserName() {
            return userName;
        }

        public String getBrithday() {
            return brithday;
        }

        public String getUserSex() {
            return userSex;
        }

        public long getCreateTime() {
            return createTime;
        }

        public String getStatus() {
            return status;
        }

        public String getToken() {
            return token;
        }

        public int getRz() {
            return rz;
        }

        public float getMoney() {
            return money;
        }

        public int getWx() {
            return wx;
        }

        public int getQq() {
            return qq;
        }

        public int getDepositMoney() {
            return depositMoney;
        }

        public String getUserPhoto() {
            return userPhoto;
        }
    }
}
