package com.ediancha.edcbusiness.v1.activity.space;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/11/13.
 */
@Route(path = "/v1/activity/space/airQuality")
public class AirQualityActivity extends NotNetBaseActivity {


    @BindView(R.id.ivIn)
    ImageView ivIn;
    @BindView(R.id.tvInAir)
    TextView tvInAir;
    @BindView(R.id.tvInAirNum)
    TextView tvInAirNum;
    @BindView(R.id.tvInShiDu)
    TextView tvInShiDu;
    @BindView(R.id.tvInWenDu)
    TextView tvInWenDu;
    @BindView(R.id.tvInAddress)
    TextView tvInAddress;
    @BindView(R.id.ivOut)
    ImageView ivOut;
    @BindView(R.id.tvOutAir)
    TextView tvOutAir;
    @BindView(R.id.tvOutAirNum)
    TextView tvOutAirNum;
    @BindView(R.id.tvOutShiDu)
    TextView tvOutShiDu;
    @BindView(R.id.tvOutWenDu)
    TextView tvOutWenDu;
    @BindView(R.id.tvOutAddress)
    TextView tvOutAddress;

    @Override
    protected int getRid() {
        return R.layout.activity_air_quality;
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("空气质量");
    }

    @Override
    protected void initData() {
        super.initData();
        ImageLoader.loadCircu(this, ApiContant.IMAGE,ivIn);
        ImageLoader.loadCircu(this, ApiContant.IMAGE,ivOut);
    }
}
