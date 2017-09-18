package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.BaseListBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/13.
 */

public class Test1Bean extends BaseBean<ArrayList<Test1Bean.Test>> {
    public static class Test {
        public String address;

        public String getAddress() {
            return address;
        }
    }
}
