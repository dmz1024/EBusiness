package com.ediancha.edcbusiness.activity.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.CommonAdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.ResUtil;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.MyInfoBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/9/26.
 */
@Route(path = "/activity/my/myInfo")
public class MyInfoActivity extends SingleDataBaseActivity<MyInfoBean, MyInfoBean.Data> implements AdapterHelper.OnConvertInterface<CommonAdapterHelper.CommonBean>, AdapterHelper.OnClickListener {

    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    @Override
    public void onSuccess(IBasePresenter presenter, MyInfoBean.Data bean) {

        ArrayList<CommonAdapterHelper.CommonBean> datas = CommonAdapterHelper.getDatas(this, "my_info.json");
        datas.get(0).setRightImage(bean.getHeader());
        datas.get(1).setContent(bean.getNickName());
        datas.get(2).setContent(bean.getSexInfo());
        datas.get(3).setContent(bean.getBirthday());
        datas.get(4).setContent(bean.getRoleInfo());
        datas.get(6).setContent(bean.getTel());
        datas.get(7).setContent(bean.getWxInfo());
        datas.get(8).setContent(bean.getQQInfo());
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setAutoMeasureEnabled(true);

        AdapterHelper._instance(this, rvContent)._initData(datas).setLayoutManager(manager)
                .setType(new AdapterHelper.ViewTypeInfo().setType(4).setRid(ResUtil.getLayoutId(4)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(6).setRid(ResUtil.getLayoutId(6)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(5).setRid(ResUtil.getLayoutId(5)).setConvertInterface(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(3).setRid(ResUtil.getLayoutId(3)).setConvertInterface(this).setOnClickListener(this));

    }

    @Override
    protected void initContract() {
        super.initContract();

    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.success_recyle_view);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(MyInfoBean.class).setUrl(ApiContant.MY_INFO).setParms("type", "12");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, CommonAdapterHelper.CommonBean commonBean, int position) {
        holder.setText(R.id.tvTitle, commonBean.getTitle());
        switch (viewType) {
            case 5:
                Glide.with(this).load(commonBean.getRightImage()).into(holder.<ImageView>getView(R.id.ivRight));
                break;
            case 3:
                holder.setText(R.id.tvContent, commonBean.getContent());
                TextView textView = holder.<TextView>getView(R.id.tvContent);
                textView.setCompoundDrawables(null, null, ResUtil.setDra(this, ResUtil.getMipResId(this, commonBean.getRightImage())), null);
                break;

        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

                switch (position){
                    case 4:
                        Go.goUserAuther();
                        break;
                }
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("我的资料");
    }

}
