package com.ediancha.edcbusiness.activity.walletbag;

import android.graphics.Color;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.CouponBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by Admin on 2017/9/21.
 * 优惠券
 */
@Route(path = "/activity/walletbag/coupon")
public class CouponActivity extends MoreDataBaseActivity<CouponBean.Data,CouponBean> {

    @Override
    protected void initView() {
        super.initView();
        rvRoot.setBackgroundColor(Color.parseColor("#f6f6f6"));
    }

    @Override
    protected void initMoreBuilder() {

        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_coupon)
                .setConvertInterface(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(CouponBean.class)
                .setUrl(ApiContant.COUPON)
                .setParms("userId","1");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, CouponBean.Data data, int position) {
        holder
                .setText(R.id.tv_name,data.getName())
                .setText(R.id.tv_money,data.getDiscountAmount()+"元")
                .setText(R.id.tv_date, "有效期至:"+TimeFormatUtils.stampToDate(data.getInvalidTime()))
                .setText(R.id.tv_user,"满"+data.getSatisfyAmount()+"元可用")
                .setText(R.id.tv_type,data.getIntroduction());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("优惠券");
    }
}
