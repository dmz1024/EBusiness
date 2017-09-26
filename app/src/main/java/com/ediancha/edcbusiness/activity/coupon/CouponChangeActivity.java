package com.ediancha.edcbusiness.activity.coupon;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;


/**
 * Created by Admin on 2017/9/26.
 */
@Route(path = "/activity/coupon/couponChange")
public class CouponChangeActivity extends ToobarBaseActivity {


    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("优惠兑换");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_couponchange;
    }
}
