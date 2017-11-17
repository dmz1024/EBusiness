package com.ediancha.edcbusiness.v1.activity.my;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.CommonAdapterHelper;
import com.dmz.library.dmzapi.utils.PermissionUtil;
import com.dmz.library.dmzapi.utils.ResUtil;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/11/14.
 */
@Route(path = "/v1/activity/my/limits")
public class LimitsActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface<CommonAdapterHelper.CommonBean>, AdapterHelper.OnClickListener {
    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    private ArrayList<CommonAdapterHelper.CommonBean> datas;
    private AdapterHelper adapterHelper;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("应用权限管理");
    }

    @Override
    protected void initData() {
        super.initData();
        datas = CommonAdapterHelper.getDatas(this, "my_limits.json");
        adapterHelper = AdapterHelper._instance(this, rvContent)._initData(datas).setLayoutManager(new LinearLayoutManager(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(4).setRid(ResUtil.getLayoutId(4)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(9).setRid(ResUtil.getLayoutId(9)).setConvertInterface(this).setOnClickListener(this));
    }


    @Override
    protected int getRid() {
        return R.layout.activity_my_limits;
    }

    @Override
    public void convert(int viewType, ViewHolder holder, CommonAdapterHelper.CommonBean commonBean, int position) {
        holder.setText(R.id.tvTitle, commonBean.getTitle()).setText(R.id.tvContent, commonBean.getContent());
        TextView textView = holder.getView(R.id.tvTitle);
        textView.setCompoundDrawables(null, null, ResUtil.setDra(this, ResUtil.getMipResId(this, commonBean.getRightImage())), null);
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        PermissionUtil.goAppDetailSettingIntent(this);
    }
}
