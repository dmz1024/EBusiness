package com.ediancha.edcbusiness.activity.fragment;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

/**
 * Created by Admin on 2017/10/9.
 */

public class SpeciaFragment extends LazyLoadFragment {


    public static SpeciaFragment newInstance(){

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
