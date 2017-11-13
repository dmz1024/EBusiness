package com.ediancha.edcbusiness.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.api.LogUtil;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.HomeBean;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.presenter.HomePresenter;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/9.
 */

public class HomeFragment extends LazyLoadFragment implements HomePresenter.IHomeView {


    @BindView(R.id.tv_center)
    ImageView mTvCenter;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.banner)
    MZBannerView mBanner;
    @BindView(R.id.img_pic)
    ImageView mImgPic;
    @BindView(R.id.recy_label)
    RecyclerView mRecyLabel;
    @BindView(R.id.ln_label)
    LinearLayout mLnLabel;
    @BindView(R.id.tv_money)
    TextView mTvMoney;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.img_ue_pic)
    ImageView mImgUePic;
    @BindView(R.id.tv_label)
    TextView mTvLabel;
    @BindView(R.id.rl_ue_show)
    RelativeLayout mRlUeShow;
    @BindView(R.id.img_head)
    ImageView mImgHead;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_office)
    TextView mTvOffice;
    @BindView(R.id.rl_ue_user)
    RelativeLayout mRlUeUser;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.recy)
    RecyclerView mRecy;

    private HomePresenter mHomePresenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initBaseView() {
        mHomePresenter = mHomePresenter != null ? mHomePresenter : new HomePresenter(this);
        mHomePresenter.getHomeView();
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {

//        mTvName.setText("0000");
//
//        ImageLoader.loadImageOvel(getContext(), "http://img1.imgtn.bdimg.com/it/u=4113217746,822807257&fm=27&gp=0.jpg", mImgHead);



    }

    @Override
    protected void setListener() {
        mImgPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Go.goSpaceDetail("1", null, null);
            }
        });
    }

    @Override
    public void successHome(HomeBean.Data homeBean) {


        ArrayList<HomeBean.AdsBean> ads = homeBean.getAds();
        mBanner.setPages(ads, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mBanner.start();
    }


    private void initRecyclerView() {

    }


    public static class BannerViewHolder implements MZViewHolder<HomeBean.AdsBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, HomeBean.AdsBean data) {
            // 数据绑定
            Log.e("加载网址",data.getImages());
            ImageLoader.loadImageRec(context, data.getImages(), mImageView);
        }
    }

}
