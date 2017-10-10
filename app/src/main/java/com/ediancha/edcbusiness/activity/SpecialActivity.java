package com.ediancha.edcbusiness.activity;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.SpecialBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.TimeFormatUtils;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Admin on 2017/10/9.
 */
@Route(path = "/activity/special")
public class SpecialActivity extends MoreDataBaseActivity<SpecialBean.Data, SpecialBean> {
    @Override
    protected void initMoreBuilder() {
        mBuilder.setCanRefresh(true)
                .addView(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_activity_splendid_have_image)
                        .setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpecialBean.class)
                .setUrl(ApiContant.SPECIAL_URL);
    }

    @Override
    public void convert(int viewType, ViewHolder holder, SpecialBean.Data specialBean, int position) {
        Glide.with(this)
                .load(specialBean.getImage())
                .into(holder.<ImageView>getView(R.id.ivView));
        holder
                .setVisible(R.id.ivShow, false)
                .setText(R.id.tvTime, TimeFormatUtils.stampToDate(specialBean.getCreatetime()))
                .setText(R.id.tvContent, specialBean.getIntroduce())
                .setText(R.id.tvTitle, specialBean.getTitle());
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        SpecialBean.Data special = (SpecialBean.Data) adapterHelper.getDatas().get(position);
        Go.goWebView(special.getHtml());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("专题");
    }
}
