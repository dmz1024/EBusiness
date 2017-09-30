package com.ediancha.edcbusiness.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.TestWindowManager;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.helper.MainBottomSheet;
import com.ediancha.edcbusiness.helper.QwHelper;
import com.ediancha.edcbusiness.helper.MyToast;
import com.ediancha.edcbusiness.router.Go;

public class MainActivity extends ToobarBaseActivity implements View.OnClickListener {
    private View fg_arrows;
    private View fg_qw;
    private ImageView iv_bottom_header;
    private MainBottomSheet bottomSheet;
    private QwHelper qwHelper;
    private ImageView iv_bottom_message;

    @Override
    protected void initView() {
        super.initView();
        TestWindowManager.getInstance().addView();
        fg_qw = findViewById(R.id.fg_qw);
        iv_bottom_header = findViewById(R.id.iv_bottom_header);
        fg_arrows = findViewById(R.id.fg_arrows);
        iv_bottom_message = findViewById(R.id.iv_bottom_message);
        fg_arrows.setOnClickListener(this);
        iv_bottom_message.setOnClickListener(this);
        fg_qw.setOnClickListener(this);
        iv_bottom_header.setOnClickListener(this);
        bottomSheet = new MainBottomSheet(((LinearLayout) findViewById(R.id.llBottom)), ((View) findViewById(R.id.iv_arrows)));
        qwHelper = new QwHelper(this);

        UserInfoUtil.readInfo();
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
                Go.goPersonCenter();
//                MyToast.normal("你好啊");
                break;
            case R.id.fg_qw:

//                MyToast.error("你好啊");

                qwHelper.openQw();
                break;
            case R.id.iv_bottom_message:
                if (UserInfoUtil.checkLogin()) {
                    Go.goActivityMessage();
                }
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
