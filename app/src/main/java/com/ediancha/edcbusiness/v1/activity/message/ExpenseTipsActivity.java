package com.ediancha.edcbusiness.v1.activity.message;

import android.graphics.Color;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ExpenseTipsBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by dengmingzhi on 2017/9/22.
 */


@Route(path = "/v1/activity/message/expenseTips")
public class ExpenseTipsActivity extends MoreDataBaseActivity<ExpenseTipsBean.Data, ExpenseTipsBean> {

    @Override
    protected void initView() {
        super.initView();
        rvRoot.setBackgroundColor(Color.parseColor("#f6f6f6"));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("交易提醒");
    }

    @Override
    protected void initMoreBuilder() {
        mBuilder.setCanRefresh(false)
                .addView(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_expense_tips).setConvertInterface(this));

    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(ExpenseTipsBean.class)
                .setUrl(ApiContant.EXPENSE_TIPS).setParms("type", "4");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, ExpenseTipsBean.Data data, int position) {
        Glide.with(this)
                .load(data.getIvImg())
                .into(holder.<ImageView>getView(R.id.ivAd));
        holder
                .setText(R.id.tvInfo, data.getInfo())
                .setText(R.id.tvMoney, data.getMoney())
                .setText(R.id.tvTime, data.getTime())
                .setText(R.id.tvContent, data.getContent())
                .setText(R.id.tvTitle, data.getTitle());
    }


}
