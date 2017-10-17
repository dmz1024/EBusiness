package com.ediancha.edcbusiness.helper.login;

import android.app.Activity;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public class Login {

    protected ILoginResultInterface iLoginResultInterface;

    public Login setListener(ILoginResultInterface iLoginResultInterface) {
        this.iLoginResultInterface = iLoginResultInterface;
        return this;
    }

    public void start(Activity activity) {
        if (iLoginResultInterface == null) {
            throw new IllegalArgumentException("请设置 iLoginResultInterface 监听");
        }
    }


    public static Login getLogin(int type) {
        return type == 0 ? new WeChatLogin() : new QQLogin();
    }



}
