package com.ediancha.edcbusiness.activity.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.CommonAdapterHelper;
import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.dmz.library.dmzapi.utils.ResUtil;
import com.dmz.library.dmzapi.view.activity.BaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;


@Route(path = "/activity/my/personCenter")
public class PersonCenterActivity extends BaseActivity implements View.OnClickListener, AdapterHelper.OnConvertInterface<CommonAdapterHelper.CommonBean>, AdapterHelper.OnClickListener {
    private View ivCha;
    private RecyclerView rvContent;

    @Override
    protected void initView() {
        super.initView();
        ivCha = findViewById(R.id.ivCha);
        rvContent = findViewById(R.id.rvContent);
        ivCha.setOnClickListener(this);
        findViewById(R.id.iv_header).setOnClickListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        AnimationUtil.chaAnimatio(ivCha);
        initRv();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_person_center;
    }

    private AdapterHelper adapterHelper;

    private void initRv() {
        int a = 1;
        ArrayList<CommonAdapterHelper.CommonBean> datas = CommonAdapterHelper.getDatas(this, "person_center_item.json");
        datas.add(0, new CommonAdapterHelper.CommonBean().setTitle("183****7257").setIcon(a == 1 ? R.mipmap.icon_my_authentication : R.mipmap.icon_my_not_certified).setContent("信用分 100").setViewType(2));

        adapterHelper = AdapterHelper._instance(this, rvContent)._initData(datas).setLayoutManager(new LinearLayoutManager(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(ResUtil.getLayoutId(1)).setConvertInterface(this).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.item_person_center_info).setConvertInterface(this));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivCha:
                finish();
                break;
            case R.id.iv_header:
                Go.goLogin();
                break;
        }

    }


    @Override
    public void convert(int viewType, ViewHolder holder, CommonAdapterHelper.CommonBean commonBean, int position) {
        holder.setText(R.id.tvTitle, commonBean.getTitle());
        switch (viewType) {
            case 1:
                holder.setImageResource(R.id.ivLeft, ResUtil.getMipResId(this, commonBean.getLeftImage()));
                break;
            case 2:
                holder.setText(R.id.tvContent, commonBean.getContent());
                holder.<TextView>getView(R.id.tvTitle).setCompoundDrawables(null, null, ResUtil.setDra(this, commonBean.getIcon()), null);
                break;
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        switch (position) {
            case 1:
                Go.goSpaceOrder();
                break;
            case 2:
                Go.goGoodOrder();
                break;
            case 3:
                Go.goMyPackage();
                break;

            case 5:
                Go.goCouponChange();
                break;
            case 6:
                Go.goHelpCenter();
                break;

        }
    }
}
