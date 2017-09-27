package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;

/**
 * Created by Admin on 2017/9/27.
 */

public class FanKuaiType extends ChooseStringView.ChooseStringBean {
    public String id;



    public FanKuaiType setId(String id) {
        this.id = id;
        return this;
    }
}
