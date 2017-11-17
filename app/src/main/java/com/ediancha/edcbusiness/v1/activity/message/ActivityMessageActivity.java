package com.ediancha.edcbusiness.v1.activity.message;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ActivityMessageBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/v1/activity/message/activityMessage")
public class ActivityMessageActivity extends SingleDataBaseActivity<ActivityMessageBean, ActivityMessageBean.Data> implements AdapterHelper.OnConvertInterface<IType>, AdapterHelper.OnClickListener {
    @BindView(R.id.rvActivity)
    RecyclerView rvActivity;
    @BindView(R.id.tvShape)
    TextView tvShape;
    @BindView(R.id.tvChong)
    TextView tvChong;
    @BindView(R.id.tvDui)
    TextView tvDui;
    @BindView(R.id.rvMessage)
    RecyclerView rvMessage;
    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("活动精选");
    }

    @Override
    protected void initData() {
        super.initData();
        initSuccessView();
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setCanRefresh(false)
                .setSuccessRid(R.layout.success_activity_message)
                .setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(ActivityMessageBean.class).setUrl(ApiContant.ACTIIVTY_MESSAGE_URL);
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ActivityMessageBean.Data bean) {
        initActivity(bean.getTop());
        initMessage(bean.getNotice());
    }

    private void initSuccessView() {
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(rvActivity);
        initMessage(null);
    }

    private int activityCount;

    private void initActivity(ArrayList<ActivityMessageBean.Activity> activities) {
        activityCount = activities.size();
        AdapterHelper._instance(this, rvActivity)._initData(activities).setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_activity_message_activity).setConvertInterface(this).setOnClickListener(this));


    }

    private AdapterHelper messageHelper;

    private void initMessage(ArrayList<ActivityMessageBean.Message> messages) {
        if (messages == null) {
            ArrayList<ActivityMessageBean.Message> datas = new ArrayList<>();
            datas.add(new ActivityMessageBean.Message().setType("SPACE通知").setImg(R.mipmap.icon_news_notice));
            datas.add(new ActivityMessageBean.Message().setType("交易通知").setImg(R.mipmap.icon_news_transaction));
            datas.add(new ActivityMessageBean.Message().setType("活动精选").setImg(R.mipmap.icon_news_selected));
            messageHelper = AdapterHelper._instance(this, rvMessage)._initData(datas).setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            }).setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.item_activity_message_message).setConvertInterface(this).setOnClickListener(this));
        } else {
            List<ActivityMessageBean.Message> datas = (List<ActivityMessageBean.Message>) messageHelper.getDatas();
            for (int i = 0; i < datas.size(); i++) {
                datas.get(i).title = messages.get(i).title;
                datas.get(i).createtime = messages.get(i).createtime;
            }
            messageHelper.notifyDataSetChanged();
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
                        Go.goExpenseTips();//交易通知
                        break;
                    case 1:
                        Go.goActivitySplendid();//活动精选
                        break;
                    case 2:
                        Go.goSpecial();//专题
                        break;
                }
                break;
        }

    }
}
