package com.ediancha.edcbusiness.helper.login;

/**
 * Created by dengmingzhi on 2017/10/17.
 */

public interface ILoginResultInterface {
    void onSuccess(String info);

    void onCancel();

    void onFaile();
}
