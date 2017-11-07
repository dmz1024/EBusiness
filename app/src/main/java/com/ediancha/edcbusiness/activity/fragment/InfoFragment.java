package com.ediancha.edcbusiness.activity.fragment;

import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.LazyLoadFragment;

/**
 * Created by Admin on 2017/11/6.
 */

public class InfoFragment extends LazyLoadFragment {

    public static InfoFragment newInstance(){
        return new InfoFragment();
    }

    @Override
    public void initBaseView() {

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_info;
    }

    @Override
    protected void lazyLoad() {

    }
}
