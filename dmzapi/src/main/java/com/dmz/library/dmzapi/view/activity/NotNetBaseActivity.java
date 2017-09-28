package com.dmz.library.dmzapi.view.activity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/9/27.
 */

public class NotNetBaseActivity extends ToobarBaseActivity {
    private Unbinder unbinder;

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        super.initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
