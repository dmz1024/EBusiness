package com.dmz.library.dmzapi.view.activity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/9/27.
 */

public class NotNetBaseActivity extends ToobarBaseActivity {

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        super.initView();
    }
}
