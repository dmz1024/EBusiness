package com.ediancha.edcbusiness.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.adapter.UltraPagerAdapter;
import com.ediancha.edcbusiness.bean.HomeBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.helper.MainBottomSheet;
import com.ediancha.edcbusiness.helper.location.MapHelper;
import com.ediancha.edcbusiness.helper.QwHelper;

import com.ediancha.edcbusiness.helper.login.QQLogin;
import com.ediancha.edcbusiness.helper.share.Share;
import com.ediancha.edcbusiness.presenter.HomePresenter;

import com.ediancha.edcbusiness.router.Go;
import com.tmall.ultraviewpager.UltraViewPager;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Admin
 */
@Route(path = "/activity/main")
public class MainActivity extends NotNetBaseActivity implements View.OnClickListener, AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener, HomePresenter.IHomeView {
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_center)
    TextView mTvCenter;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.iv_arrows)
    ImageView mIvArrows;
    @BindView(R.id.fg_arrows)
    RelativeLayout mFgArrows;
    @BindView(R.id.fg_qw)
    FrameLayout mFgQw;
    @BindView(R.id.iv_bottom_header)
    ImageView mIvBottomHeader;
    @BindView(R.id.iv_bottom_message)
    ImageView mIvBottomMessage;
    @BindView(R.id.llBottom)
    LinearLayout mLlBottom;
    @BindView(R.id.uvp_pager)
    UltraViewPager mUvpPager;

    private double mLatitude;
    private double mLongtude;

    private HomePresenter mHomePresenter;
    private MainBottomSheet bottomSheet;
    private QwHelper qwHelper;
    UltraPagerAdapter mUltraPagerAdapter;

    private MapHelper mMapHelper;

    @Override
    protected void initView() {
        super.initView();

        UserInfoUtil.readInfo();
        initUltraViewPager(null);
//        TestWindowManager.getInstance().addView();

        bottomSheet = new MainBottomSheet((mLlBottom), mIvArrows);
        qwHelper = new QwHelper(this);
        mMapHelper = mMapHelper != null ? mMapHelper : new MapHelper(this);
        mMapHelper.setLatLongtudeListener(new MapHelper.LatLongtudeListener() {
            @Override
            public void setLatitude(Double latitude) {
                mLatitude = latitude;
            }

            @Override
            public void setLongtude(Double longtude) {
                mLongtude = longtude;
            }

            @Override
            public void getLocaionInfo(AMapLocation amapLocation) {

            }
        }).getLocation();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setVisibility(View.GONE);
    }

    private void initUltraViewPager(String img) {

        ArrayList<String> mRrr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mRrr.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507553467082&di=9b65f154e4d078d6c0431f1309ccd1ba&imgtype=0&src=http%3A%2F%2Fwww.tupian1.cn%2Fuploads%2Fallimg%2F150322%2F1-150322162644.jpg");
        }
        mUvpPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        mUltraPagerAdapter = new UltraPagerAdapter(this, mRrr);
        mUvpPager.setAdapter(mUltraPagerAdapter);
        mUvpPager.setInfiniteLoop(true);
        mUvpPager.setAutoScroll(5000);
    }


    private void initRecyclerView(ArrayList<HomeBean.SpaceListBean> spaceList) {

        AdapterHelper._instance(this, mRecy)._initData(spaceList)
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                })
                .setType(new AdapterHelper.ViewTypeInfo().setType(0).setRid(R.layout.item_home_space).setConvertInterface(this)
                        .setOnClickListener(this));
    }

    @Override
    protected void initData() {
        super.initData();
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.getHomeView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        qwHelper.onActivityResult(requestCode, resultCode, data);
        if (login != null) {
            login.onActivity(requestCode, resultCode, data);
        }
    }

    QQLogin login;

    @Override
    @OnClick({R.id.fg_arrows, R.id.iv_bottom_header, R.id.fg_qw, R.id.iv_bottom_message, R.id.llBottom, R.id.tv_left, R.id.tv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_arrows:
                bottomSheet.toggle();
                break;
            case R.id.iv_bottom_header:
                if (UserInfoUtil.checkLogin()) {
                    Go.goPersonCenter();
                }
                break;
            case R.id.fg_qw:
//                qwHelper.openQw();
                MyToast.normal("哈哈哈哈");
                ShareInfoBean shareInfo = new ShareInfoBean();
                Share.getShare(1).start(this, shareInfo);
                break;
            case R.id.iv_bottom_message:
                if (UserInfoUtil.checkLogin()) {
                    Go.goActivityMessage();
                }
                break;
                /*打开二维码*/
            case R.id.tv_left:
                qwHelper.openQw();
                break;
            //通知
            case R.id.tv_right:

                break;
            default:
        }

    }

    /**
     * 测试用
     */
    public static class ShareInfoBean implements Share.ShareInfo {

        @Override
        public String getUrl() {
            return "https://www.baidu.com";
        }

        @Override
        public String getTitle() {
            return "这是分享的标题";
        }

        @Override
        public String getContent() {
            return "这是分享的内容";
        }

        @Override
        public int getType() {
            return 1;
        }

        @Override
        public String getAppName() {
            return "ALL IN";
        }

        @Override
        public String getLogo() {
            return "http://media-cdn.tripadvisor.com/media/photo-s/01/3e/05/40/the-sandbar-that-links.jpg";
        }
    }


    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        HomeBean.SpaceListBean spaceListBean = (HomeBean.SpaceListBean) iType;

        holder.setText(R.id.tv_name, spaceListBean.getSpaceName());
        holder.setText(R.id.tv_local, spaceListBean.getSpaceAreaPath() + spaceListBean.getHowFar());
        holder.setText(R.id.tv_content, spaceListBean.getSpaceDesc());
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507553467082&di=9b65f154e4d078d6c0431f1309ccd1ba&imgtype=0&src=http%3A%2F%2Fwww.tupian1.cn%2Fuploads%2Fallimg%2F150322%2F1-150322162644.jpg").into((ImageView) holder.getView(R.id.img_show));
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        HomeBean.SpaceListBean spaceListBean = (HomeBean.SpaceListBean) adapterHelper.getDatas().get(position);
        Go.goSpaceDetail(spaceListBean.getId(), mLatitude + "", mLongtude + "");
    }

    @Override
    public void successHome(HomeBean.Data homeBean) {
        ArrayList<HomeBean.SpaceListBean> spaceList = homeBean.getSpaceList();
        initRecyclerView(spaceList);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("主页", "回来了");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMapHelper != null) {
            mMapHelper.getLocationClient().onDestroy();
        }
    }
}
