package com.ediancha.edcbusiness.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.TestWindowManager;
import com.ediancha.edcbusiness.activity.my.PersonCenterActivity;
import com.ediancha.edcbusiness.adapter.UltraPagerAdapter;
import com.ediancha.edcbusiness.bean.HomeBean;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.helper.MainBottomSheet;
import com.ediancha.edcbusiness.helper.MapHelper;
import com.ediancha.edcbusiness.helper.NotificationHelper;
import com.ediancha.edcbusiness.helper.QwHelper;

import com.ediancha.edcbusiness.helper.login.Login;
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
        mMapHelper=mMapHelper!=null?mMapHelper:new MapHelper(this);
        mMapHelper.setLatLongtudeListener(new MapHelper.LatLongtudeListener() {
            @Override
            public void setLatitude(Double latitude) {
                mLatitude=latitude;
            }

            @Override
            public void setLongtude(Double longtude) {
                mLongtude=longtude;
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
                qwHelper.openQw();
                //测试支付
//                Pay.getPay(1).setiPayResultInterface(new IPayResultInterface() {
//                    @Override
//                    public void onSuccess() {
//
//                    }
//
//                    @Override
//                    public void onCancel() {
//
//                    }
//
//                    @Override
//                    public void onFaile(String msg) {
//
//                    }
//                }).start(this, "app_id=2017083008461733&biz_content=%7B%22body%22%3A%22%5Cu7535%5Cu8bdd%5Cu54a8%5Cu8be2%5Cu5957%5Cu9910%5Cu4e0010%5Cu5206%5Cu949f%22%2C%22subject%22%3A%22%5Cu7535%5Cu8bdd%5Cu54a8%5Cu8be2%5Cu5957%5Cu9910%5Cu4e0010%5Cu5206%5Cu949f%22%2C%22out_trade_no%22%3A%22SN15077104633362%22%2C%22timeout_express%22%3A%221m%22%2C%22total_amount%22%3A0.01%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=law.east-profit.com%2Fapp.php%2Fhome%2Fdorder%2FaliPaySuccessOrder&sign_type=RSA2&timestamp=2017-10-11+20%3A28%3A08&version=1.0&sign=WM7JpkU3mk9nYk31ByJzqlOCNuTY1HZoOBuz8oyrDpA8V42zAexMCDN78NWiN64Vd2BKslBjXfhonVISDEtG6nzPQLXbDacRzk%2F5H05liaEWFfJe78Y6M2XF3jwTHAHZso2Kbxbu4v0ZwRW98eyz%2BqmZKi%2FjpobEJ7GMoKPwO961ZzM%2FUHU68xM%2Fee4mRODWYV2SR8bi0R5R8GSgRFZX9n2XJ17vbckqDAa4LVa9tMO0ROJldgMTU9X8PM0Eri0nBZQE7KZhjX95ulBZ0gYtb4J7%2FzmeJt%2B9NuEk4A87BeSemVxkO%2Fea5urK%2BfQdoMjl4e7ncEkqcTBQqC3HH2Lk0Q%3D%3D");
//                if (UserInfoUtil.checkLogin()) {
//                    qwHelper.openQw();
//                }


//                login = (QQLogin) Login.getLogin(1);
//                login.start(this);
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
    public static class ShareInfoBean implements Share.ShareInfo{

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
        Go.goSpaceDetail(spaceListBean.getId(),mLatitude+"",mLongtude+"");
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
        if (mMapHelper!=null){
            mMapHelper.getLocationClient().onDestroy();
        }
    }
}
