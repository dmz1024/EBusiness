package com.ediancha.edcbusiness.v1.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmz.library.dmzapi.api.LogUtil;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.v1.presenter.ShopOrderPresenter;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/11/13.
 */

public class ShopOrderFragment extends LazyLoadFragment {


    @BindView(R.id.tab_title)
    TabLayout mTabTitle;
    @BindView(R.id.vp_show)
    ViewPager mVpShow;
    private ShopAllOrderFragment mAllOrderFragment;
    private ShopOrderEndFragment mEndFragment;
    private ShopOrderSendFragment mSendFragment;
    private ShopOrderExitFragment mExitFragment;
    private String[] mArrayList = {"全部订单", "已出货", "已完成", "已失效"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private ShopViewPager mViewPager;


    public static ShopOrderFragment newInstance() {

        return new ShopOrderFragment();
    }

    @Override
    public void initBaseView() {
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_ordershop;
    }

    @Override
    protected void lazyLoad() {
        if (mFragments.size() <= 0) {
            mAllOrderFragment = ShopAllOrderFragment.newInstance();
            mSendFragment = ShopOrderSendFragment.newInstance();
            mEndFragment = ShopOrderEndFragment.newInstance();
            mExitFragment = ShopOrderExitFragment.newInstance();
            mFragments.add(mAllOrderFragment);
            mFragments.add(mSendFragment);
            mFragments.add(mEndFragment);
            mFragments.add(mExitFragment);
        }
        mViewPager = mViewPager != null ? mViewPager : new ShopViewPager(getChildFragmentManager());
        mVpShow.setAdapter(mViewPager);
        mTabTitle.setupWithViewPager(mVpShow);
        mVpShow.setOffscreenPageLimit(4);
    }


    class ShopViewPager extends FragmentPagerAdapter {

        public ShopViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mArrayList.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mArrayList[position];
        }
    }

}
