package com.ediancha.edcbusiness.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dmz.library.dmzapi.api.LogUtil;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.v1.fragment.ShopOrderFragment;
import com.ediancha.edcbusiness.v1.fragment.SpaceOrderFragment;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/9.
 */

public class OrderFragment extends LazyLoadFragment {


    @BindView(R.id.rb_space)
    RadioButton mRbSpace;
    @BindView(R.id.rb_shop)
    RadioButton mRbShop;
    @BindView(R.id.rg_otype)
    RadioGroup mRgOtype;
    @BindView(R.id.frame)
    FrameLayout mFrame;

    private SpaceOrderFragment mSpaceOrderFragment;
    private ShopOrderFragment mShopOrderFragment;

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_special;
    }


    FragmentManager mManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void lazyLoad() {
        mSpaceOrderFragment = SpaceOrderFragment.newInstance();
        mShopOrderFragment = ShopOrderFragment.newInstance();

        mRbSpace.setChecked(true);
        mManager = getChildFragmentManager();
        fragmentTransaction= mManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, mSpaceOrderFragment)
                .add(R.id.frame, mShopOrderFragment)
                .hide(mShopOrderFragment)
                .hide(mSpaceOrderFragment)
                .show(mSpaceOrderFragment)
                .commit();

        mRgOtype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_space:
                        replaceFragment(mSpaceOrderFragment, mShopOrderFragment);
                        break;
                    case R.id.rb_shop:
                        replaceFragment(mShopOrderFragment, mSpaceOrderFragment);
                        break;
                }
            }
        });
    }
    private void replaceFragment(Fragment showFragment, Fragment hideFragment) {
        FragmentTransaction mTransaction = mManager.beginTransaction();
        mTransaction.hide(hideFragment)
                .show(showFragment)
                .commit();
    }

}
