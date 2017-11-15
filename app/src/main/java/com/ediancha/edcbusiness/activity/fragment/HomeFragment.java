package com.ediancha.edcbusiness.activity.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.HomeBean;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.helper.TextStylesHelper;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.presenter.HomePresenter;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/9.
 */

public class HomeFragment extends LazyLoadFragment implements HomePresenter.IHomeView, AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener {


    @BindView(R.id.tv_center)
    ImageView mTvCenter;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.banner)
    MZBannerView mBanner;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_detail)
    TextView mTvDetail;
    @BindView(R.id.ln_title)
    LinearLayout mLnTitle;
    @BindView(R.id.space_item)
    RecyclerView mSpaceItem;
    @BindView(R.id.tv_tiyan)
    TextView mTvTiyan;
    @BindView(R.id.tv_tydetail)
    TextView mTvTydetail;
    @BindView(R.id.recy_tiyan)
    RecyclerView mRecyTiyan;
    Unbinder unbinder;
    private HomePresenter mHomePresenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {

        if (mHomePresenter==null){
            mHomePresenter = new HomePresenter(this);
            mHomePresenter.getHomeView();
        }
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void successHome(HomeBean.Data homeBean) {

        ArrayList<HomeBean.AdsBean> ads = homeBean.getAds();
        Log.e("加载网址成功", ads.toString());
        mBanner.setPages(ads, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mBanner.start();
        initRecyclerView(homeBean);
    }

    AdapterHelper mSpaceAdapter;
    AdapterHelper mTiyanAdapter;

    private void initRecyclerView(HomeBean.Data homeBean) {
        HomeBean.SpaceBean space = homeBean.getSpace();
        mTvTitle.setText(space.getTitle());
        mTvDetail.setText(space.getSubTitle());
        mSpaceAdapter = AdapterHelper._instance(getActivity(), mSpaceItem)
                ._initData(homeBean.space.getSpaceList())
                .setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
                                      @Override
                                      public boolean canScrollVertically() {
                                          return false;
                                      }
                                  }
                ).setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.adapter_space_item).setConvertInterface(this)
                        .setOnClickListener(this));

        HomeBean.CommentBean comment = homeBean.getComment();
        mTvTiyan.setText(comment.getTitle());
        mTvTydetail.setText(comment.getSubTitle());
        mTiyanAdapter = AdapterHelper._instance(getContext(), mRecyTiyan)._initData(comment.getSpaceComment())
                .setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                }).setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.adapter_ue_item).setConvertInterface(this));
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        if (viewType == 1) {
            HomeBean.SpaceListBean spaceListBean = (HomeBean.SpaceListBean) iType;
            String label = "可容纳" + spaceListBean.spaceLoadNumber + "人|" + spaceListBean.getHowFar()+"KM";
            holder.setText(R.id.tv_label, label);
            SpannableString spannable=new SpannableString(" "+spaceListBean.getIs_tui()+"  "+spaceListBean.getSpaceName());
            BackgroundColorSpan colorSpan=new BackgroundColorSpan(Color.parseColor("#ffc730"));
            spannable.setSpan(colorSpan,0,spaceListBean.getIs_tui().length()+2, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            holder.<TextView>getView(R.id.tv_name).setText(spannable);
            ImageLoader.loadImageRec(getContext(), spaceListBean.getSpaceImage(), holder.<ImageView>getView(R.id.img_pic));
            String[] labelname = spaceListBean.getLabelname();
            for (int i = 0; i < labelname.length; i++) {
                TextView tvLabel = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_text_label, null, false);
                tvLabel.setText(labelname[i]);
                holder.<LinearLayout>getView(R.id.ln_label)
                        .addView(tvLabel);
            }
        } else if (viewType == 2) {
            HomeBean.SpaceCommentBean comment = (HomeBean.SpaceCommentBean) iType;
            holder.setText(R.id.tv_name, comment.getNickname());
            holder.setText(R.id.tv_office, "UI设计师|东方盈");
            holder.setText(R.id.tv_content, comment.getContent());
            ImageLoader.loadImageRec(getContext(), comment.getImages(), holder.<ImageView>getView(R.id.img_ue_pic));
            ImageLoader.loadImageOvel(getContext(), comment.getImages(), holder.<ImageView>getView(R.id.img_head));
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        HomeBean.SpaceListBean spaceBean = adapterHelper.<HomeBean.SpaceListBean>getT(position);
        Go.goSpaceDetail(spaceBean.getId(), null, null);
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

            ImageLoader.loadImageRec(context, data.getImages(), mImageView);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.pause();
        }
    }

}
