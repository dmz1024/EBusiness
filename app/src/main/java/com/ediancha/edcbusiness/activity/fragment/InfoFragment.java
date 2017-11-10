package com.ediancha.edcbusiness.activity.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ActivityMessageBean;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.ediancha.edcbusiness.presenter.v1.activity.InfoPresenter;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/11/6.
 */

public class InfoFragment extends LazyLoadFragment implements InfoPresenter.IInfoView, AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener {

    @BindView(R.id.tv_center)
    TextView mTvCenter;
    @BindView(R.id.tv_setting)
    ImageView mTvSetting;
    @BindView(R.id.rvActivity)
    RecyclerView mRvActivity;
    @BindView(R.id.tvShape)
    TextView mTvShape;
    @BindView(R.id.tvChong)
    TextView mTvChong;
    @BindView(R.id.tvDui)
    TextView mTvDui;
    @BindView(R.id.rvMessage)
    RecyclerView mRvMessage;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    private InfoPresenter mInfoPresenter;

    @Override
    public void initBaseView() {
        initMessage(null);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_info;
    }

    @Override
    protected void lazyLoad() {
        mInfoPresenter = mInfoPresenter != null ? mInfoPresenter : new InfoPresenter(this);

        mInfoPresenter.getInfoView();
    }

    @Override
    public void success(ActivityMessageBean.Data homeBean) {

        initMessage(homeBean.getNotice());
        initRecyclerView(homeBean.getTop());
    }
    private int activityCount;
    private void initRecyclerView(ArrayList<ActivityMessageBean.Activity> top){
        activityCount = top.size();
        AdapterHelper._instance(getActivity(), mRvActivity)._initData(top).setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_activity_message_activity).setConvertInterface(this).setOnClickListener(this));
    }

    @OnClick({R.id.tvShape,R.id.tvChong,R.id.tvDui})
    void onclick(View view){
        switch (view.getId()){
            case R.id.tvShape://邀请好友
                break;
            case R.id.tvChong://充值返现
                Go.goCharge();
                break;
            case R.id.tvDui://优惠券兑换
                Go.goCouponChange();
                break;
        }
    }

    /**
     * 专题条目
     * @param messages
     */
    AdapterHelper mMessageadapterHelper;
    private void initMessage(ArrayList<ActivityMessageBean.Message> messages) {
        if (messages == null) {
            ArrayList<ActivityMessageBean.Message> datas = new ArrayList<>();
            datas.add(new ActivityMessageBean.Message().setType("交易通知").setImg(R.mipmap.news_jytz_icon));
            datas.add(new ActivityMessageBean.Message().setType("活动精选").setImg(R.mipmap.news_hdjx_icon));
            datas.add(new ActivityMessageBean.Message().setType("SPACE通知").setImg(R.mipmap.news_tzh_icon));
            mMessageadapterHelper= AdapterHelper._instance(getActivity(), mRvMessage)._initData(datas).setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            }).setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.item_activity_message_message).setConvertInterface(this).setOnClickListener(this));
        } else {
            List<ActivityMessageBean.Message> datas = (List<ActivityMessageBean.Message>) mMessageadapterHelper.getDatas();
            for (int i = 0; i < datas.size(); i++) {
                datas.get(i).title = messages.get(i).title;
                datas.get(i).createtime = messages.get(i).createtime;
            }
            mMessageadapterHelper.notifyDataSetChanged();
        }
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        switch (viewType) {
            case 1:
                if (activityCount > 1) {
                    holder.getConvertView().getLayoutParams().width = (ScreenUtil.getScreenWidth() / 3) * 2;
                }
                ActivityMessageBean.Activity activity = (ActivityMessageBean.Activity) iType;
                Glide.with(this)
                        .load(activity.getImage())
                        .into(holder.<ImageView>getView(R.id.ivView));
                break;
            case 2:
                ActivityMessageBean.Message message = (ActivityMessageBean.Message) iType;
                Glide.with(this)
                        .load(message.getImg())
                        .into(holder.<ImageView>getView(R.id.ivHeader));
                holder
                        .setText(R.id.tvTitle, message.getType())
                        .setText(R.id.tvContent, message.getTitle())
                        .setText(R.id.tvTime, TimeFormatUtils.stamp2Date(message.getCreatetime()));
                break;
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        switch (viewType) {
            case 1:
                ActivityMessageBean.Activity top = (ActivityMessageBean.Activity) adapterHelper.getT(position);
                Go.goWebView(top.getHtml());
                break;
            case 2:
                switch (position) {
                    case 0:
                        Go.goSpecial();
                        break;
                    case 1:
                        Go.goExpenseTips();
                        break;
                    case 2:
                        Go.goActivitySplendid();
                        break;
                }
                break;
        }
    }
}
