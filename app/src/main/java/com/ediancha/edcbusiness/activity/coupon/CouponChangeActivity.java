package com.ediancha.edcbusiness.activity.coupon;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.NormalContant;
import com.ediancha.edcbusiness.presenter.coupon.CouponChangePresenter;
import com.ediancha.edcbusiness.router.Go;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Admin on 2017/9/26.
 */
@Route(path = "/activity/coupon/couponChange")
public class CouponChangeActivity extends NotNetBaseActivity implements CouponChangePresenter.ICouponChangeView {


    @BindView(R.id.et_number)
    EditText mEtNumber;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;

    private CouponChangePresenter mCouponChangePresenter;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        mCouponChangePresenter = new CouponChangePresenter(this);
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


    @Override
    public void successCode(BaseBean bean) {
        if (bean.getCode()== NormalContant.SUCCESS_CODE){
            MyToast.normal("兑换成功!");
            Go.goCoupon();
            finish();
        }else {
            MyToast.error(bean.msg);
        }
    }

    @OnClick(R.id.tv_submit)
    void onclick(){
        String number = mEtNumber.getText().toString().trim();
        if (TextUtils.isEmpty(number)){
            MyToast.error("兑换码不能为空!");
        }else {
            mCouponChangePresenter.exchangeCoupon("1",number);
        }
    }
}
