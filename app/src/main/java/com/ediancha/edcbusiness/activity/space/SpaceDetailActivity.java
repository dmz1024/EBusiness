package com.ediancha.edcbusiness.activity.space;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.SpaceDetailBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.helper.OpenMapHelper;
import com.ediancha.edcbusiness.helper.share.Share;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.dialog.SpaceDescDialog;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/28.
 * 空间详情
 */
@Route(path = "/activity/space/spaceDetail")
public class SpaceDetailActivity extends SingleDataBaseActivity<SpaceDetailBean, SpaceDetailBean.Data> implements AdapterHelper.OnConvertInterface {


    TextView mTvStatus;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_local)
    TextView mTvLocal;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.ry_user)
    RecyclerView mRyUser;
    @BindView(R.id.tv_notice)
    TextView mTvNotice;
    @BindView(R.id.recy_activity)
    RecyclerView mRecyActivity;


    private OpenMapHelper mOpenMapHelper;
    private SpaceDetailBean.Data mSpaceDdetail;

    @Autowired
    public String id;
    @Autowired
    public String mLatitude;
    @Autowired
    public String mLongtude;

    @Override
    public void onSuccess(IBasePresenter presenter, SpaceDetailBean.Data bean) {
        mSpaceDdetail = bean;

        mTvTime.setText(bean.getSpaceMoney() + "元/小时");
        mTvLocal.setText(bean.getSpaceAreaPath() + "km");
        mTvNumber.setText("最多容纳" + bean.getSpaceLoadNumber() + "人");

        mTvNotice.setText(bean.getCostStatement());

        initRecyclerView(bean);
    }

    @Override
    protected void initView() {
        super.initView();


    }


    private void initRecyclerView(SpaceDetailBean.Data bean) {


        //室内
        AdapterHelper._instance(this, mRyUser)._initData(bean.getFacilities()).setLayoutManager(new GridLayoutManager(this, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_space_textview).setConvertInterface(this));
//        //用途
        AdapterHelper._instance(this, mRecyActivity)._initData(bean.getPurpose()).setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_space_activity).setConvertInterface(this));
    }

    @Override
    protected void initData() {
        super.initData();
        mOpenMapHelper = new OpenMapHelper(this);

    }

    @OnClick({R.id.tv_local, R.id.tv_number, R.id.tv_submit,R.id.tv_title,R.id.ln_pm})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_local:
//                mOpenMapHelper.openMap(mSpaceDdetail.getLatitude(), mSpaceDdetail.getLongitude(), mSpaceDdetail.getSpaceAreaPath());
                Go.goLocationActivity(mLatitude, mLongtude);
                break;
            case R.id.tv_number:
                break;
            case R.id.tv_submit:
                Go.goChoseDateActivity();
                break;
            case R.id.tv_title:
                SpaceDescDialog.getInstance().show(this);
                break;
            case R.id.ln_pm:
                Go.goAirQualityActivity();
                break;
            default:
        }
    }

    @Override
    protected void initDataBuilder() {
        //首次不加载设置
        mBuilder.setSuccessRid(R.layout.success_spacedetail);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(SpaceDetailBean.class)
                .setUrl(ApiContant.SPACEDETAIL_URL)
                .setParms("id", id, "longitude", mLongtude, "latitude", mLatitude);

    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("云集空间")
                .addItemView(new DmzBar.DmzBarItemInfo().setIid(R.mipmap.icon_gengduo))
                .setOnItemOnClickListener(new DmzBar.OnItemOnClickListener() {
                    @Override
                    public void itemClick(int index) {
                        if (mSpaceDdetail != null) {
                            mSpaceDdetail.getShare().setType(1).url = "https://www.baidu.com";
                            mSpaceDdetail.getShare().logo = "http://media-cdn.tripadvisor.com/media/photo-s/01/3e/05/40/the-sandbar-that-links.jpg";
                            Share.getShare(1).start(SpaceDetailActivity.this, mSpaceDdetail.getShare());
                        }
                    }
                });
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

                ImageLoader.loadImageRec(ctx, "http://img1.imgtn.bdimg.com/it/u=4113217746,822807257&fm=27&gp=0.jpg", holder.<ImageView>getView(R.id.img_type));
                break;
        }
    }

    @Override
    protected int getRid() {
        return R.layout.activity_choose_time;
    }
}
