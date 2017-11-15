package com.ediancha.edcbusiness.v1.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dmz.library.dmzapi.api.LogUtil;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.ediancha.edcbusiness.view.ViewpagerNoLoad;


import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;

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
    protected void lazyLoad(){
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

//        Class aClass = mVpShow.getClass();
//        try {
//            Field default_offscreen_pages = aClass.getDeclaredField("DEFAULT_OFFSCREEN_PAGES");
//            default_offscreen_pages.setAccessible(true);
//            default_offscreen_pages.setInt(mVpShow,0);
//            LogUtil.e("修改成功");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        mVpShow.setOffscreenPageLimit(0);
        mVpShow.setAdapter(mViewPagerAdapter);
        mTabTitle.setupWithViewPager(mVpShow);

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
