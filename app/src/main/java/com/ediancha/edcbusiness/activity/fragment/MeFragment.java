package com.ediancha.edcbusiness.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/9.
 */

public class MeFragment extends LazyLoadFragment {

    @BindView(R.id.tv_center)
    TextView mTvCenter;
    @BindView(R.id.img_userhead)
    ImageView mImgUserhead;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_detail)
    TextView mTvDetail;
    @BindView(R.id.tv_rz)
    TextView mTvRz;


    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_me;
    }

    @Override
    protected void lazyLoad() {
        ImageLoader.loadImageOvel(getContext(),"http://img1.imgtn.bdimg.com/it/u=4113217746,822807257&fm=27&gp=0.jpg",mImgUserhead);
    }

    @OnClick({R.id.tv_order,R.id.tv_bag,R.id.tv_friend,R.id.tv_help,R.id.img_userhead,R.id.tv_setting})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tv_order:
                Go.goOrderingActivity();
                break;
            case R.id.tv_bag:
                Go.goMyPackage();
                break;
            case R.id.tv_friend:
                Go.goSpaceOrderEndActivity();
                break;
            case R.id.tv_help:
                Go.goHelpCenter();
                break;
            case R.id.img_userhead:
                Go.goMyInfo();
                break;
            case R.id.tv_setting:
                Go.goSetActivity();
                break;
        }
    }


}
