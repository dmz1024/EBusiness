package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.ediancha.edcbusiness.helper.ValidatorUtils;

/**
 * Created by Admin on 2017/10/11.
 */

public class SoftwareBean extends ViewBaseType {

    public String key;

    public String getKey() {
        return key;
    }

    public SoftwareBean setKey(String key) {
        this.key = key;
        return this;
    }
}
