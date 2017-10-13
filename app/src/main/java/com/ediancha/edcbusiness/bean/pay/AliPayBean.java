package com.ediancha.edcbusiness.bean.pay;


import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by Admin on 2017/10/13.
 */

public class AliPayBean extends BaseBean {

    private int code;
    public String data;
    public String info;

    public String getInfo() {
        return info;
    }

    @Override
    public int getCode() {
        return code;
    }

    public AliPayBean setCode(int code) {
        this.code = code;
        return this;
    }

    @Override
    public String getData() {
        return data;
    }
}
