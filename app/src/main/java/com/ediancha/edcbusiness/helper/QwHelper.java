package com.ediancha.edcbusiness.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.dmz.library.dmzapi.utils.PermissionUtil;
import com.ediancha.edcbusiness.activity.QwActivity;
import com.ediancha.edcbusiness.router.Go;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;


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
        PermissionUtil.getInstance().setOnSuccessPermission(new PermissionUtil.OnCheckSuccessPermission() {
            @Override
            public void onSuccess(int result) {
                Go.goQw(activity, QW_REQUEST_CODE);
            }
        }).checkCamera(activity);
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

//    @Override
//    public void onPermissionsGranted(int i, List<String> list) {
//        Toast.makeText(activity, "有权限", Toast.LENGTH_SHORT).show();
//        Go.goQw(activity, QW_REQUEST_CODE);
//    }
//
//    @Override
//    public void onPermissionsDenied(int i, List<String> list) {
//        Toast.makeText(activity, "没有权限", Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
//    }
}
