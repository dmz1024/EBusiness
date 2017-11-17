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
import com.ediancha.edcbusiness.view.LazyLoadFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/11/13.
 */

public class SpaceOrderFragment extends LazyLoadFragment {

    @BindView(R.id.tab_title)
    TabLayout mTabTitle;
    @BindView(R.id.vp_show)
    ViewPager mVpShow;
    private SpaceAllOrderFragment mAllFragment;
    private SpaceOrderEndFragment mEndFragment;
    private SpaceOrderSubFragment mSubFragment;
    private SpaceOrderIngFragment mIngFragment;

    private String[] mArrayList = {"全部订单", "已预订", "进行中", "已完成"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private SpaceAdapter mViewPagerAdapter;

    public static SpaceOrderFragment newInstance() {

        return new SpaceOrderFragment();
    }

    @Override
    public void initBaseView() {


    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_orderall;
    }

    @Override
    protected void lazyLoad() {
        if (mFragments.size() <= 0) {
            mAllFragment = SpaceAllOrderFragment.newInstance();
            mEndFragment = SpaceOrderEndFragment.newInstance();
            mSubFragment = SpaceOrderSubFragment.newInstance();
            mIngFragment = SpaceOrderIngFragment.newInstance();
            mFragments.add(mAllFragment);
            mFragments.add(mSubFragment);
            mFragments.add(mIngFragment);
            mFragments.add(mEndFragment);

        }
        mViewPagerAdapter = mViewPagerAdapter != null ? mViewPagerAdapter : new SpaceAdapter(getChildFragmentManager());
        mVpShow.setAdapter(mViewPagerAdapter);
        mTabTitle.setupWithViewPager(mVpShow);
        mVpShow.setOffscreenPageLimit(4);

    }

    class SpaceAdapter extends FragmentPagerAdapter {

        public SpaceAdapter(FragmentManager fm) {
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
