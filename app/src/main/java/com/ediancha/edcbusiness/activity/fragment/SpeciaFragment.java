package com.ediancha.edcbusiness.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;
import com.ediancha.edcbusiness.view.ViewpagerNoScroll;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/9.
 */

public class SpeciaFragment extends LazyLoadFragment {


    @BindView(R.id.rb_space)
    RadioButton mRbSpace;
    @BindView(R.id.rb_shop)
    RadioButton mRbShop;
    @BindView(R.id.rg_otype)
    RadioGroup mRgOtype;
    @BindView(R.id.tab_name)
    TableLayout mTabName;
    @BindView(R.id.vp_show)
    ViewpagerNoScroll mVpShow;
    Unbinder unbinder;

    public static SpeciaFragment newInstance() {

        return new SpeciaFragment();
    }

    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_special;
    }

    @Override
    protected void lazyLoad() {

    }
}
