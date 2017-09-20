package com.ediancha.edcbusiness.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ediancha.edcbusiness.activity.QwActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class QwHelper {
    public static final int QW_REQUEST_CODE = 1;
    private Activity activity;

    public QwHelper(Activity activity) {
        this.activity = activity;
    }

    public void openQw() {
        Intent intent = new Intent(activity, QwActivity.class);
        activity.startActivityForResult(intent, QW_REQUEST_CODE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == QW_REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    //TODO 获取二维码扫描结果
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Log.d("二维码", result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == QwActivity.WRITE_NUM) {
                    //TODO 手动输入门牌号
                    Log.d("二维码", "手动输入");
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(activity, "二维码扫描出错，请重试", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
