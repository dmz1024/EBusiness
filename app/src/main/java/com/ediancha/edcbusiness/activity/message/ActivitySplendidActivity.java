package com.ediancha.edcbusiness.activity.message;

import android.graphics.Color;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ActivitySplendidBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/22.
 */

@Route(path = "/activity/message/activitySplendid")
public class ActivitySplendidActivity extends MoreDataBaseActivity<ActivitySplendidBean.Data, ActivitySplendidBean> {

    @Override
    protected void initView() {
        super.initView();
        rvRoot.setBackgroundColor(Color.parseColor("#f6f6f6"));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("活动精选");
    }

    @Override
    protected void initMoreBuilder() {
        mBuilder.setCanRefresh(false);
        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_activity_splendid_have_image).setConvertInterface(this).setOnClickListener(this));
        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_activity_splendid_no_image).setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(ActivitySplendidBean.class)
                .setUrl(ApiContant.ACTIVITY_SPLENDID);
    }


    @Override
    public void convert(int viewType, ViewHolder holder, ActivitySplendidBean.Data data, int position) {
        if (viewType == 1) {
            Glide.with(this)
                    .load(data.getImage())
                    .into(holder.<ImageView>getView(R.id.ivView));
        }
        holder
                .setVisible(R.id.ivShow,data.getIsShow())
                .setText(R.id.tvTime, TimeFormatUtils.stampToDate(data.getCreatetime()))
                .setText(R.id.tvContent, data.getIntroduce())
                .setText(R.id.tvTitle, data.getTitle());

    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        ActivitySplendidBean.Data data= (ActivitySplendidBean.Data) adapterHelper.getDatas().get(position);
        Go.goWebView(data.getHtml());
    }
}
