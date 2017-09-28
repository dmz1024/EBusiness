package com.dmz.library.dmzapi.utils;

import android.Manifest;
import android.content.Context;
import android.support.annotation.NonNull;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * Created by dengmingzhi on 2017/9/27.
 */

public class PermissionUtil {
    public static final int CAMERA_REQUEST = 0x1;
    public static final int FILE_WRITE_REQUEST = 0x2;


    public static PermissionUtil getInstance() {
        return new PermissionUtil();
    }

    public void check(final Context ctx, int request, final String... permission) {
        AndPermission.with(ctx)
                .requestCode(request)
                .permission(permission)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int i, Rationale rationale) {
                        AndPermission.rationaleDialog(ctx, rationale).show();
                    }
                }).callback(new PermissionListener() {
            @Override
            public void onSucceed(int i, @NonNull List<String> list) {
                if (AndPermission.hasPermission(ctx, permission)) {
                    if (onSuccessPermission != null) {
                        onSuccessPermission.onSuccess(i);
                    }
                } else {
                    if (onCheckFailedPermission != null) {
                        onCheckFailedPermission.onFailed();
                    } else {
                        AndPermission.defaultSettingDialog(ctx).show();
                    }

                }
            }

            @Override
            public void onFailed(int i, @NonNull List<String> list) {

                if (AndPermission.hasPermission(ctx, permission)) {
                    if (onSuccessPermission != null) {
                        onSuccessPermission.onSuccess(i);
                    }
                } else {
                    if (onCheckFailedPermission != null) {
                        onCheckFailedPermission.onFailed();
                    } else {
                        AndPermission.defaultSettingDialog(ctx).show();
                    }

                }
            }
        }).start();

    }

    public void checkCamera(Context ctx) {
        check(ctx, CAMERA_REQUEST, Permission.CAMERA);
    }

    public void checkCameraAndFile(Context ctx) {
        check(ctx,PermissionUtil.FILE_WRITE_REQUEST, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private OnCheckSuccessPermission onSuccessPermission;
    private OnCheckFailedPermission onCheckFailedPermission;

    public PermissionUtil setOnCheckFailedPermission(OnCheckFailedPermission onCheckFailedPermission) {
        this.onCheckFailedPermission = onCheckFailedPermission;
        return this;
    }

    public PermissionUtil setOnSuccessPermission(OnCheckSuccessPermission onSuccessPermission) {
        this.onSuccessPermission = onSuccessPermission;
        return this;
    }

    public interface OnCheckSuccessPermission {
        void onSuccess(int result);
    }

    public interface OnCheckFailedPermission {
        void onFailed();
    }
}
