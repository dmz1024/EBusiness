package com.ediancha.edcbusiness.v1.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.dialog.DatePickerFragment;
import com.dmz.library.dmzapi.utils.DateUtils;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.v1.bean.BalanceDescBean;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by dengmingzhi on 2017/11/14.
 */
@Route(path = "/v1/activity/my/balanceDesc")
public class BalanceDescActivity extends MoreDataBaseActivity<BalanceDescBean.Data, BalanceDescBean> implements View.OnClickListener {

    private TextView tvTime;
    private TextView tvClassify;

    @Override
    protected void initMoreBuilder() {
        mBuilder.addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_balan_desc)
                .setConvertInterface(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(BalanceDescBean.class)
                .setUrl(ApiContant.BALANCEDESC)
                .setParms("userId", "1");
    }

    @Override
    protected void initView() {
        super.initView();
        tvTime = findViewById(R.id.tvTime);
        tvClassify = findViewById(R.id.tvClassify);
        tvTime.setOnClickListener(this);
        tvClassify.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        tvTime.setText(DateUtils.getYMD());
    }

    @Override
    public void convert(int viewType, ViewHolder holder, BalanceDescBean.Data data, int position) {
        ImageLoader.loadImageOvel(this, ApiContant.IMAGE, holder.<ImageView>getView(R.id.ivTitle));
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("余额明细");
    }

    @Override
    protected int getRid() {
        return R.layout.activity_balance_desc;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                DatePickerFragment.getInstance(tvTime.getText().toString()).setDateListener(new DatePickerFragment.DateListener() {
                    @Override
                    public void date(int year, int month, int day) {
                        tvTime.setText(year + "-" + month + "-" + day);
                    }
                }).show(getFragmentManager(), "dialogTime");


                break;
            case R.id.tvClassify:
                ChooseStringDialog.getInstance()
                        .setShowCancel(false)
                        .setiChooseItem(new ChooseStringView.IChooseItemTitle() {
                            @Override
                            public void content(int position, ChooseStringView.IChooseString title) {
                                tvClassify.setText(title.getTitle());

                            }
                        })
                        .addData("全部分类", "空间消费", "充值", "赠送", "商品消费", "其他").show(this);
                break;
        }
    }
}
