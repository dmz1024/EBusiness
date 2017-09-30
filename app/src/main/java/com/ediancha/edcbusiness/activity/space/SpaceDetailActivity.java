package com.ediancha.edcbusiness.activity.space;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.adapter.UltraPagerAdapter;
import com.ediancha.edcbusiness.bean.SpaceDetailBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.tmall.ultraviewpager.UltraViewPager;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/9/28.
 * 空间详情
 */
@Route(path = "/activity/space/spaceDetail")
public class SpaceDetailActivity extends SingleDataBaseActivity<SpaceDetailBean, SpaceDetailBean.Data> implements AdapterHelper.OnConvertInterface {

    @BindView(R.id.tv_envir)
    TextView mTvEnvir;
    @BindView(R.id.tv_sname)
    TextView mTvSname;
    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_local)
    TextView mTvLocal;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.wv_webview)
    WebView mWvWebview;
    @BindView(R.id.ry_user)
    RecyclerView mRyUser;
    @BindView(R.id.ry_equip)
    RecyclerView mRyEquip;
    @BindView(R.id.tv_xfdetail)
    TextView mTvXfdetail;
    @BindView(R.id.tv_notice)
    TextView mTvNotice;
    @BindView(R.id.uvp_pager)
    UltraViewPager mUvpPager;

    UltraPagerAdapter mPagerAdapter;

    @Autowired
    public String id;

    @Override
    public void onSuccess(IBasePresenter presenter, SpaceDetailBean.Data bean) {
        mTvSname.setText(bean.getSpaceName());
        mTvStatus.setText(bean.getSpaceStatus() == 1 ? "空闲" : "使用中");
        mTvTime.setText(bean.getSpaceMoney() + "元/小时");
        mTvLocal.setText(bean.getSpaceAreaPath()+"km");
        mTvNumber.setText("最多容纳" + bean.getSpaceLoadNumber() + "人");
        mTvXfdetail.setText(bean.getCostStatement());
        mTvNotice.setText(bean.getCostStatement());

        initUltraViewPager(bean.getSpaceImage());
        initRecyclerView(bean);
    }


    private void initUltraViewPager(String img) {

        ArrayList<String> mRrr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mRrr.add(img);
        }
        mUvpPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        mPagerAdapter = new UltraPagerAdapter(this, mRrr);
        mUvpPager.setAdapter(mPagerAdapter);
        mUvpPager.setInfiniteLoop(true);
        mUvpPager.setAutoScroll(5000);
    }

    private void initRecyclerView(SpaceDetailBean.Data bean) {

        LogUtil.e("getFacilities"+bean.getFacilities());
        LogUtil.e("getPurpose"+bean.getPurpose());
        //室内
        AdapterHelper._instance(this, mRyUser)._initData(bean.getFacilities()).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_space_textview).setConvertInterface(this));
        //用途
        AdapterHelper._instance(this, mRyEquip)._initData(bean.getPurpose()).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_space_textview).setConvertInterface(this));
    }


    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.success_spacedetail);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceDetailBean.class)
                .setUrl(ApiContant.SPACEDETAIL_URL)
                .setParms("id", id);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("云集空间");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        switch (viewType) {
            case 0:

                SpaceDetailBean.FacilitiesBean facilities = (SpaceDetailBean.FacilitiesBean) iType;
                holder
                        .setText(R.id.tv_type, facilities.getTargetName());

                break;
            case 1:
                SpaceDetailBean.PurposeBean purpose = (SpaceDetailBean.PurposeBean) iType;
                holder
                        .setText(R.id.tv_type, purpose.getTargetName());
                break;
        }
    }
}
