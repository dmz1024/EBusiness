package com.dmz.library.dmzapi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dmz.library.dmzapi.R;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public abstract class ToobarBaseActivity extends BaseActivity {
    protected Toolbar tbRoot;
    protected AppBarLayout AlRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRid());
//        initHeader();
        init();
    }

    protected abstract void init();

    private void initHeader() {
//        AlRoot = findViewById(R.id.AlRoot);
//        tbRoot = findViewById(R.id.tbRoot);
        if (AlRoot != null) {
            initAlRoot();
        }
        if (tbRoot != null) {
            initToolBar();
        }
    }

    protected void initToolBar() {

    }


    public void leftOnclick() {
        finish();
    }

    private int getLeftIcon() {
        return 0;
    }

    protected String getBarTitle() {
        return "";
    }

    protected void initAlRoot() {

    }

    protected abstract int getRid();
}
