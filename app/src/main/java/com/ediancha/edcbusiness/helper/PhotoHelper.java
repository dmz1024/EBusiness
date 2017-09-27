package com.ediancha.edcbusiness.helper;
import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.dmz.library.dmzapi.utils.PermissionUtil;
import com.yanzhenjie.permission.Permission;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Admin on 2017/9/27.
 */

public class PhotoHelper {

    public static final int REQUEST_CODE_PICK_IMAGE = 3;
    public static final int CROP_PHOTO = 2;

    private Activity mActivity;

    public PhotoHelper(Activity mA){
        this.mActivity=mA;
    }
    /**
     * 打开选择相册
     */
    public void openPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        mActivity.startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }



    /**
     * 打开相机
     */

    public  void showCameraAction() {
        PermissionUtil.getInstance().setOnSuccessPermission(new PermissionUtil.OnCheckSuccessPermission() {
            @Override
            public void onSuccess(int result) {
                File mTmpFile=null;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(mActivity.getPackageManager()) != null) {
                    try {
                        mTmpFile = FileUtils.createTmpFile(mActivity);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (mTmpFile != null && mTmpFile.exists()) {
                 /*获取当前系统的android版本号*/
                        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                        Log.e("currentapiVersion", "currentapiVersion====>" + currentapiVersion);
                        if (currentapiVersion < 24) {
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mTmpFile));
                            mActivity.startActivityForResult(intent, CROP_PHOTO);
                        } else {
                            ContentValues contentValues = new ContentValues(1);
                            contentValues.put(MediaStore.Images.Media.DATA, mTmpFile.getAbsolutePath());
                            photoUri= mActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                            mActivity.startActivityForResult(intent, CROP_PHOTO);
                        }
                    }
                }
            }
        }).checkCameraAndFile(mActivity);



    }
    private Uri photoUri;
    public String onActivityResult(int request ,Intent data) {
        Uri uri;
        if(request==REQUEST_CODE_PICK_IMAGE){
            uri = data.getData();
        }else {
            uri=photoUri;
        }
        return FilePathUtils.getRealFilePath(mActivity, uri);
    }

    public boolean chcckPhoto(int requestCode,int resultCode){
        return resultCode==RESULT_OK &&(requestCode==REQUEST_CODE_PICK_IMAGE||requestCode==CROP_PHOTO);
    }
}
