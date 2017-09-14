package com.ediancha.edcbusiness;

import com.dmz.library.dmzapi.api.BaseListBean;
import com.dmz.library.dmzapi.api.ViewBaseType;

/**
 * Created by dengmingzhi on 2017/9/13.
 */

public class TestBean extends BaseListBean<TestBean.Test> {
    public static class Test extends ViewBaseType {
        public String address;

        public String getAddress() {
            return address;
        }
    }
}
