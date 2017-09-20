package com.ediancha.edcbusiness.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.activity.BaseActivity;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class QwActivity extends ToobarBaseActivity implements View.OnClickListener {
    private TextView tvLight;
    private ImageView ivLight;


    @Override
    protected void init() {
        tvLight = findViewById(R.id.tvLight);
        ivLight = findViewById(R.id.ivLight);
        findViewById(R.id.rlWrite).setOnClickListener(this);
        findViewById(R.id.rlLight).setOnClickListener(this);
        /**
         * 执行扫面Fragment的初始化操作
         */
        CaptureFragment captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);

        captureFragment.setAnalyzeCallback(analyzeCallback);
        /**
         * 替换我们的扫描控件
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    @Override
    protected int getRid() {
        return R.layout.activity_qw;
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setRootColor("#00000000").setText("返回").setTextColor("#ffffff").setLeftImage(R.mipmap.icon_dmz_bar_back_white);
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            QwActivity.this.setResult(RESULT_OK, resultIntent);
            QwActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            QwActivity.this.setResult(RESULT_OK, resultIntent);
            QwActivity.this.finish();
        }
    };

    private boolean isLight;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlWrite:
                writeNum();
                break;
            case R.id.rlLight:
                CodeUtils.isLightEnable(isLight = !isLight);
                tvLight.setText(isLight ? "关闭手电筒" : "打开手电筒");
                ivLight.setImageResource(isLight ? R.mipmap.icon_open_light : R.mipmap.icon_colse_light);
                break;
        }
    }

    public static final int WRITE_NUM = 3;

    private void writeNum() {
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(CodeUtils.RESULT_TYPE, WRITE_NUM);
        resultIntent.putExtras(bundle);
        QwActivity.this.setResult(RESULT_OK, resultIntent);
        QwActivity.this.finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        CodeUtils.isLightEnable(false);
    }
}
