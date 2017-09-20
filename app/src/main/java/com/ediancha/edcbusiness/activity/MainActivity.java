package com.ediancha.edcbusiness.activity;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.MainBottomSheet;
import com.ediancha.edcbusiness.helper.QwHelper;

public class MainActivity extends ToobarBaseActivity implements View.OnClickListener {
    private View fg_arrows;
    private View fg_qw;
    private ImageView iv_bottom_header;
    private MainBottomSheet bottomSheet;
    private QwHelper qwHelper;

    @Override
    protected void init() {
        initView();
    }

    private void initView() {
        fg_qw = findViewById(R.id.fg_qw);
        iv_bottom_header = findViewById(R.id.iv_bottom_header);
        fg_arrows = findViewById(R.id.fg_arrows);
        fg_arrows.setOnClickListener(this);
        fg_qw.setOnClickListener(this);
        iv_bottom_header.setOnClickListener(this);
        bottomSheet = new MainBottomSheet(((LinearLayout) findViewById(R.id.llBottom)));
        qwHelper = new QwHelper(this);
    }


    @Override
    protected int getRid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        qwHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_arrows:
                bottomSheet.toggle();
                break;
            case R.id.iv_bottom_header:
                toCenter();
                break;
            case R.id.fg_qw:
                qwHelper.openQw();
                break;
        }
    }

    private void toCenter() {
        Intent intent = new Intent(getContext(), PersonCenterActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


}
