package com.ediancha.edcbusiness.v1.fragment;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

/**
 * Created by Admin on 2017/11/13.
 */

public class SpaceOrderFragment extends LazyLoadFragment{


    public static SpaceOrderFragment newInstance(){

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

    }
}
