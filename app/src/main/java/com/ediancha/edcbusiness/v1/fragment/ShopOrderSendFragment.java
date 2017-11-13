package com.ediancha.edcbusiness.v1.fragment;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

/**
 * Created by Admin on 2017/11/13.
 */

public class ShopOrderSendFragment extends LazyLoadFragment{

    public static ShopOrderSendFragment newInstance(){

        return new ShopOrderSendFragment();
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
