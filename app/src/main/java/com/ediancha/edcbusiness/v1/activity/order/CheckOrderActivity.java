package com.ediancha.edcbusiness.v1.activity.order;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.router.Go;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/11/7.
 */

@Route(path = "/v1/activity/order/checkorder")
public class CheckOrderActivity extends NotNetBaseActivity {

    @BindView(R.id.img_show)
    ImageView mImgShow;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_location)
    TextView mTvLocation;
    @BindView(R.id.tv_num)
    TextView mTvNum;
    @BindView(R.id.tv_starttime)
    TextView mTvStarttime;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_endtime)
    TextView mTvEndtime;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_coupon)
    TextView mTvCoupon;
    @BindView(R.id.tv_deposit)
    TextView mTvDeposit;
    @BindView(R.id.tv_yue)
    RadioButton mTvYue;
    @BindView(R.id.tv_wechat)
    RadioButton mTvWechat;
    @BindView(R.id.tv_alipay)
    RadioButton mTvAlipay;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("确认订单");
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_checkorder;
    }

    @OnClick({R.id.tv_price,R.id.tv_coupon,R.id.tv_deposit})
    void click(View view){
        switch (view.getId()){
            case R.id.tv_price:
                break;
            case R.id.tv_coupon:
                Go.goCoupon();
                break;
            case R.id.tv_deposit:
                Go.goDeposit(null,0);
                break;
        }
    }
}
