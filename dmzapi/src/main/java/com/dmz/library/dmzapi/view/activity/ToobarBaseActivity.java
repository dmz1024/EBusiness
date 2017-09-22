package com.dmz.library.dmzapi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.view.custom.DmzBar;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public class ToobarBaseActivity extends BaseActivity {
    protected DmzBar dmzBar;

    @Override
    protected void initView() {
        super.initView();
        initBarView();

    }

    protected void initBarView() {
        dmzBar = findViewById(R.id.dmzBar);
    }

    protected int getRid() {
        return R.layout.view_base_bar;
    }

}
