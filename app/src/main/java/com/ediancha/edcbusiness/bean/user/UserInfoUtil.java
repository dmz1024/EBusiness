package com.ediancha.edcbusiness.bean.user;

import android.text.TextUtils;

import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.utils.AnyPref;
import com.ediancha.edcbusiness.router.Go;

/**
 * Created by dengmingzhi on 2017/9/29.
 */

public class UserInfoUtil {

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserInfoUtil.userId = userId;
    }

    public static String getUserPhoto() {
        AnyPref anyPref = AnyPref.instance("userInfo");
        if (anyPref != null) {
            userPhoto = anyPref.getString("userPhoto");
        }
        return userPhoto;
    }

    public static void setUserPhoto(String userPhoto) {
        UserInfoUtil.userPhoto = userPhoto;
    }

    public static String getUserName() {
        AnyPref anyPref = AnyPref.instance("userInfo");
        if (anyPref != null) {
            userName = anyPref.getString("userName");
        }
        return userName;
    }

    public static void setUserName(String userName) {
        UserInfoUtil.userName = userName;
    }

    public static String getUserPhone() {
        return userPhone;
    }

    public static void setUserPhone(String userPhone) {
        UserInfoUtil.userPhone = userPhone;
    }

    public static String getBrithday() {
        return brithday;
    }

    public static void setBrithday(String brithday) {
        UserInfoUtil.brithday = brithday;
    }

    public static String getUserSex() {
        return userSex;
    }

    public static void setUserSex(String userSex) {
        UserInfoUtil.userSex = userSex;
    }

    public static long getCreateTime() {
        return createTime;
    }

    public static void setCreateTime(long createTime) {
        UserInfoUtil.createTime = createTime;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        UserInfoUtil.status = status;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserInfoUtil.token = token;
    }

    public static int getRz() {
        return rz;
    }

    public static String getRzInfo() {
        return rz == 1 ? "未认证" : "已认证";
    }

    public static void setRz(int rz) {
        UserInfoUtil.rz = rz;
    }

    public static float getMoney() {
        return money;
    }

    public static void setMoney(float money) {
        UserInfoUtil.money = money;
    }

    public static int getDepositMoney() {
        return depositMoney;
    }

    public static void setDepositMoney(int depositMoney) {
        UserInfoUtil.depositMoney = depositMoney;
    }

    public static int getWx() {
        AnyPref anyPref = AnyPref.instance("userInfo");
        if (anyPref != null) {
            wx = anyPref.getInt("wx");
        }
        return wx;
    }

    public static void setWx(int wx) {
        UserInfoUtil.wx = wx;
    }

    public static int getQq() {
        AnyPref anyPref = AnyPref.instance("userInfo");
        if (anyPref != null) {
            qq = anyPref.getInt("qq");
        }
        return qq;
    }

    public static String getQqInfo() {
        return qq == 1 ? "未绑定" : "已绑定";
    }

    public static String getWxInfo() {
        return wx == 1 ? "未绑定" : "已绑定";
    }

    public static void setQq(int qq) {
        UserInfoUtil.qq = qq;
    }

    public static String userId;
    public static String userPhoto;
    public static String userName;
    public static String userPhone;
    public static String brithday;
    public static String userSex;
    public static long createTime;
    public static String status;
    public static String token;
    public static int rz;// 认证 1 未认证 2 已认证
    public static float money;
    public static int depositMoney;
    public static int wx;
    public static int qq;


    public static void saveInfo(LoginBean.Data data) {

        setUserId(data.getUserId());
        setBrithday(data.getBrithday());
        setCreateTime(data.getCreateTime());
        setDepositMoney(data.getDepositMoney());
        setMoney(data.getMoney());
        setQq(data.getQq());
        setWx(data.getWx());
        setRz(data.getRz());
        setStatus(data.getStatus());
        setToken(data.getToken());
        setUserName(data.getUserName());
        setUserPhoto(data.getUserPhoto());
        setUserPhone(data.getUserPhone());
        setUserSex(data.getUserSex());

        AnyPref.instance("userInfo")
                .putString("userId", data.getUserId())
                .putString("userPhoto", data.getUserPhoto())
                .putString("userName", data.getUserName())
                .putString("userPhone", data.getUserPhone())
                .putString("brithday", data.getBrithday())
                .putString("userSex", data.getUserSex())
                .putLong("createTime", data.getCreateTime())
                .putString("status", data.getStatus())
                .putString("token", data.getToken())
                .putInt("rz", data.getRz())
                .putInt("depositMoney", data.getDepositMoney())
                .putInt("wx", data.getWx())
                .putInt("qq", data.getQq())
                .putFloat("money", data.getMoney())
                .commit();
    }

    public static void readInfo() {
        AnyPref anyPref = AnyPref.instance("userInfo");
        setUserId(anyPref.getString("userId"));
        setBrithday(anyPref.getString("brithday"));
        setCreateTime(anyPref.getLong("createTime"));
        setDepositMoney(anyPref.getInt("depositMoney", 0));
        setMoney(anyPref.getFloat("money", 0));
        setQq(anyPref.getInt("qq", 1));
        setWx(anyPref.getInt("wx", 1));
        setRz(anyPref.getInt("rz"));
        setStatus(anyPref.getString("status"));
        setToken(anyPref.getString("token"));
        setUserName(anyPref.getString("userName"));
        setUserPhoto(anyPref.getString("userPhoto"));
        setUserPhone(anyPref.getString("userPhone"));
        setUserSex(anyPref.getString("userSex"));
    }

    public static boolean checkLogin() {
        if (TextUtils.isEmpty(getUserId()) || TextUtils.isEmpty(getToken())) {
            Go.goLogin(0);
            return false;
        }

        return true;
    }

    public static void clear() {
        AnyPref.instance("userInfo").clear();
        readInfo();
    }


    public static String[] getUserToken() {
        return new String[]{"userId", "212114", "token", "Mzc0NjM4NA=="};
    }


    public static void saveProperty(Object... userName) {
        AnyPref userInfo = AnyPref.instance("userInfo");
        for (int i = 0; i < userName.length - 1; i += 2) {
            Object value = userName[i + 1];
            String key = (String) userName[i];
            if (value instanceof String) {
                userInfo.putString(key, (String) value);
            } else if (value instanceof Integer) {
                userInfo.putString(key, String.valueOf(value));
            }
        }
        userInfo.commit();

    }

}
