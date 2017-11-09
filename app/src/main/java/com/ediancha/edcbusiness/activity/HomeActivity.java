package com.ediancha.edcbusiness.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.ediancha.edcbusiness.activity.fragment.SpeciaFragment;
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
    private SpeciaFragment mSpeciaFragment;
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

        switch (type) {
            case 0:
                MyToast.normal("这是正确的");
                break;
            case 1:
                MyToast.error("这是错误的");
                break;
            case 2:
                MyToast.warn("这是警告");
                break;
        }

        if (type == 0) {
            type = 1;
        } else if (type == 1) {
            type = 2;
        } else {
            type = 0;
        }

    }

    private void initFragment() {
        mSpeciaFragment = new SpeciaFragment();
        mHomeFragment = new HomeFragment();
        mMeFragment = new MeFragment();
        mInfoFragment = new InfoFragment();

        mFragments = new ArrayList<>();
        mFragments.add(mHomeFragment);
        mFragments.add(mSpeciaFragment);
        mFragments.add(mInfoFragment);
        mFragments.add(mMeFragment);

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
