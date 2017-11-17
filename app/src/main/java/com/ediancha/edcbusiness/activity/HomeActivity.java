package com.ediancha.edcbusiness.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.activity.fragment.HomeFragment;
import com.ediancha.edcbusiness.activity.fragment.InfoFragment;
import com.ediancha.edcbusiness.activity.fragment.MeFragment;
import com.ediancha.edcbusiness.activity.fragment.OrderFragment;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.view.ViewpagerNoScroll;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/9/30.
 */

public class HomeActivity extends NotNetBaseActivity {

    @BindView(R.id.vp_show)
    ViewpagerNoScroll mVpShow;
    @BindView(R.id.rb_one)
    RadioButton mRbOne;
    @BindView(R.id.rb_two)
    RadioButton mRbTwo;
    @BindView(R.id.rb_three)
    RadioButton mRbThree;
    @BindView(R.id.rg_chose)
    RadioGroup mRgChose;

    private HomeFragment mHomeFragment;
    private OrderFragment mSpeciaFragment;
    private MeFragment mMeFragment;
    private InfoFragment mInfoFragment;

    private ArrayList<Fragment> mFragments;

    @Override
    protected void initView() {
        super.initView();

        initFragment();
        initListener();
    }

    private void initListener() {
        mRgChose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_one:
                        mVpShow.setCurrentItem(0, false);
                        break;
                    case R.id.rb_two:
                        mVpShow.setCurrentItem(1, false);
                        break;
                    case R.id.rb_three:
                        mVpShow.setCurrentItem(2, false);
                        break;
                    case R.id.rb_four:
                        mVpShow.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }


    int type = 0;

    @OnClick(R.id.fgQw)
    void qw() {
        Go.goQw(this,1000);
    }

    private void initFragment() {
        mSpeciaFragment = new OrderFragment();
        mHomeFragment = new HomeFragment();
        mMeFragment = new MeFragment();
        mInfoFragment = new InfoFragment();

        mFragments = new ArrayList<>();
        mFragments.add(mHomeFragment);
        mFragments.add(mSpeciaFragment);
        mFragments.add(mInfoFragment);
        mFragments.add(mMeFragment);

        mVpShow.setOffscreenPageLimit(4);
        mVpShow.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setVisibility(View.GONE);
    }

    @Override
    protected int getRid() {
        return R.layout.activity_home;
    }
}
