package com.ediancha.edcbusiness.v1.activity.order;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/11/8.
 */
@Route(path = "/v1/activity/order/spacepaydetail")
public class SpacePayDetailActivity extends NotNetBaseActivity {

    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.recy_item)
    RecyclerView mRecyItem;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("空间费用明细");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_spacepaydetail;
    }

    @Override
    protected void initData() {
        super.initData();
    }

}
