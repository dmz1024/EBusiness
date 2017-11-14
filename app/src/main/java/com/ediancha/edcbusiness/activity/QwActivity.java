package com.ediancha.edcbusiness.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.router.Go;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;


@Route(path = "/activity/qw")
public class QwActivity extends ToobarBaseActivity implements View.OnClickListener {
    private TextView tvLight;
    private ImageView ivLight;


    @Override
    protected void initView() {
        super.initView();
        tvLight = findViewById(R.id.tvLight);
        ivLight = findViewById(R.id.ivLight);
        findViewById(R.id.rlWrite).setOnClickListener(this);
        findViewById(R.id.rlLight).setOnClickListener(this);
    }


    @Override
    protected void initData() {
        super.initData();
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
        dmzBar.setRootColor("#00000000").setText("返回").setTextColor("#ffffff");
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
                try {
                    CodeUtils.isLightEnable(!isLight);
                    isLight = !isLight;
                    tvLight.setText(isLight ? "关闭手电筒" : "打开手电筒");
                    ivLight.setImageResource(isLight ? R.mipmap.sd_open_icon : R.mipmap.sd_closs_icon);
                }catch (Exception e){
                    MyToast.error("没有摄像头权限");
                }

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
        Go.goOpenInputActivity();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            CodeUtils.isLightEnable(false);
        } catch (Exception e) {

        }
    }

}
