package com.ediancha.edcbusiness.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

    FragmentTransaction mTransaction;

    @Override
    protected void lazyLoad() {
        mSpaceOrderFragment = new SpaceOrderFragment();
        mShopOrderFragment = new ShopOrderFragment();

        mTransaction = getChildFragmentManager().beginTransaction();
        mTransaction.add(R.id.frame, mSpaceOrderFragment)
                .add(R.id.frame, mShopOrderFragment)
                .hide(mShopOrderFragment)
                .commit();

        mRgOtype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_space:
                        mTransaction.hide(mShopOrderFragment)
                                .show(mSpaceOrderFragment)
                                .commit();
                        break;
                    case R.id.rb_shop:
                        mTransaction.hide(mSpaceOrderFragment)
                                .show(mShopOrderFragment)
                                .commit();
                        break;
                }
            }
        });
    }


}
