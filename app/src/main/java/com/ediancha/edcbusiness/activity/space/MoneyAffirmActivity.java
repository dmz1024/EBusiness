package com.ediancha.edcbusiness.activity.space;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.CheckOrderBean;
import com.ediancha.edcbusiness.bean.MoneyAffirmBean;
import com.ediancha.edcbusiness.bean.OpenLockBean;
import com.ediancha.edcbusiness.presenter.order.CheckOrderPresenter;
import com.ediancha.edcbusiness.presenter.order.LongOpenLockPresenter;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/10/9.
 */

@Route(path = "/activity/sapce/moneyAffirm")
public class MoneyAffirmActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface<MoneyAffirmBean.Time>, LongOpenLockPresenter.IOpenLockView {
    @Autowired
    MoneyAffirmBean.Data data;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.tvShopName)
    TextView tvShopName;
    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("费用确认").addItemView(new DmzBar.DmzBarItemInfo().setTitle("分享"));
    }

    @Override
    protected int getRid() {
        return R.layout.activity_money_affirm;
    }


    @Override
    protected void initData() {
        super.initData();
        tvShopName.setText(data.getSpaceName());
        Log.d("size值", data.getTime().size() + "");
        AdapterHelper
                ._instance(this, rvContent)
                ._initData(data.getTime())
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_money_affirm_time).setConvertInterface(this))
                .setType(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_money_affirm_time_one).setType(2).setConvertInterface(this))
                .setType(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_test).setType(1));
    }

    @Override
    public void convert(int viewType, ViewHolder holder, MoneyAffirmBean.Time time, int position) {
        if (data.getTime().size() != 1) {
            holder.getView(R.id.view2).setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
        }
        holder.setText(R.id.tvMoney, time.getFifteenCharging() + "").setText(R.id.tvTime, time.getChargingEndTime() + "");
    }

    private LongOpenLockPresenter presenter;

    @OnClick(R.id.btUse)
    void userSpace() {
        presenter = presenter == null ? new LongOpenLockPresenter(this) : presenter;
        presenter.openLock(data.getSpaceId());
    }

    @Override
    public void openSuccess(OpenLockBean.Data data) {
        Go.goSpaceOrderInProgeressDesc(data.getOrderId());
        finish();
    }

    @Override
    public void onOtherCode(OpenLockBean data) {
        switch (data.getCode()) {
            case 80003://余额不足

                break;
            case 70003://不可重复下单
                checkOrderPresenter = checkOrderPresenter == null ? new CheckOrderPresenter() : checkOrderPresenter;
                checkOrderPresenter.check();
                break;
        }
    }

    private CheckOrderPresenter checkOrderPresenter;

}
