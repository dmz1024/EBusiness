package com.ediancha.edcbusiness.activity.order;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.OpenLockBean;
import com.ediancha.edcbusiness.bean.SpaceOrderInProgressBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/9/22.
 */


@Route(path = "/activity/order/spaceOrderInProgeressDesc")
public class SpaceOrderInProgeressDescActivity extends SingleDataBaseActivity<SpaceOrderInProgressBean, SpaceOrderInProgressBean.Data> {
    @Autowired
    String orderId;

    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.tvShopName)
    TextView tvShopName;
    @BindView(R.id.tvTimeTip)
    TextView tvTimeTip;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.btYan)
    Button btYan;
    @BindView(R.id.tvMoneyTip)
    TextView tvMoneyTip;
    @BindView(R.id.ivClose)
    ImageView ivClose;
    @BindView(R.id.fg_qw)
    FrameLayout fgQw;
    @BindView(R.id.ivMore)
    ImageView ivMore;
    @BindView(R.id.ivAd)
    ImageView ivAd;
    @BindView(R.id.tvOpen)
    TextView tvOpen;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("进行中");
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.success_order_in_progress)
                .setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW)
                .setFirstRequest(false);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceOrderInProgressBean.class)
                .setUrl(ApiContant.SPACE_ORDER_IN_PROGRESS)
                .setParms(UserInfoUtil.getUserToken())
                .setParms("type", "10")
                .setParms("orderId", orderId);
    }

    @Override
    public void onSuccess(IBasePresenter presenter, SpaceOrderInProgressBean.Data bean) {

    }

    @Override
    protected void initData() {
        super.initData();


    }
}
