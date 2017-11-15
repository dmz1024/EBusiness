package com.ediancha.edcbusiness.v1.activity.order;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.v1.bean.SpaceOrderEndBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/11/15.
 */

@Route(path = "/v1/activity/order/spaceorderend")
public class SpaceOrderEndAcitivity extends SingleDataBaseActivity<SpaceOrderEndBean, ArrayList<SpaceOrderEndBean.Data>> {
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
    @BindView(R.id.tv_totaltime)
    TextView mTvTotaltime;
    @BindView(R.id.recy_item)
    RecyclerView mRecyItem;
    @BindView(R.id.tv_endtime)
    TextView mTvEndtime;

    @Override
    public void onSuccess(IBasePresenter presenter, ArrayList<SpaceOrderEndBean.Data> bean) {

        ImageLoader.loadCircu(ctx, ApiContant.IMAGE_URL, mImgShow);
        mTvName.setText("共享空间");
        mTvLocation.setText("东方明珠大厦·5KM");
        mTvNum.setText("可容纳16人");

        mTvStarttime.setText("16:20\n2017-9-25");
        mTvEndtime.setText("16:20\n2017-9-25");
        mTvTotaltime.setText("16小时");


    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.activity_spaceorderend);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceOrderEndBean.class)
                .setUrl(ApiContant.SPACE_END_ORDER)
                .setParms("userId", "1");
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("订单详情")
                .addItemView(new DmzBar.DmzBarItemInfo().setIid(R.mipmap.share_icon))
                .setOnItemOnClickListener(new DmzBar.OnItemOnClickListener() {
                    @Override
                    public void itemClick(int index) {

                    }
                });
    }
}
