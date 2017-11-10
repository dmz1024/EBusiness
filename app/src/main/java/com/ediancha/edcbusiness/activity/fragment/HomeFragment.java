package com.ediancha.edcbusiness.activity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.router.Go;
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

public class HomeFragment extends LazyLoadFragment {


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
    Unbinder unbinder;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initBaseView() {

        List<String> list = new ArrayList<>();
        list.add("http://img.ivsky.com/img/bizhi/pre/201709/27/mercedes_maybach_g650_landaulet-001.jpg");
        list.add("http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=e05fa110566034a83defb0c2a37a2321/5fdf8db1cb1349547059c0755c4e9258d1094a5f.jpg");
        list.add("http://imgsrc.baidu.com/imgad/pic/item/c8ea15ce36d3d539e829c8dc3087e950352ab09d.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=4113217746,822807257&fm=27&gp=0.jpg");
        // 设置数据
        mBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mBanner.start();
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {

        mTvName.setText("0000");

        ImageLoader.loadImageOvel(getContext(), "http://img1.imgtn.bdimg.com/it/u=4113217746,822807257&fm=27&gp=0.jpg", mImgHead);
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


    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            ImageLoader.loadImageRec(context, data, mImageView);
        }
    }

}
