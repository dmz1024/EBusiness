package com.ediancha.edcbusiness.v1.fragment;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

/**
 * Created by Admin on 2017/11/13.
 */

public class ShopAllOrderFragment extends LazyLoadFragment{


    public static ShopAllOrderFragment newInstance(){

        return new ShopAllOrderFragment();
    }
    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_spaceorder;
    }

    @Override
    protected void lazyLoad() {

    }
}
