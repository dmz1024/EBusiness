package com.ediancha.edcbusiness.activity;

import android.view.View;

import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.ediancha.edcbusiness.R;

/**
 * Created by Admin on 2017/9/30.
 */

public class HomeActivity extends NotNetBaseActivity {


    @Override
    protected void initView() {
        super.initView();
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
