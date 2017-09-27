package com.ediancha.edcbusiness.activity.help;


import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.FanKuaiType;
import com.ediancha.edcbusiness.helper.FilePathUtils;
import com.ediancha.edcbusiness.helper.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


/**
 * Created by Admin on 2017/9/27.
 */
@Route(path = "/activity/help/fankui")
@RuntimePermissions
public class FanKuiActivity extends ToobarBaseActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 3;
    private static final int CROP_PHOTO = 2;

    private TextView mSpChose;
    private EditText mEtContent;
    private ImageView mIvImage;
    private LinearLayout mLnImage;
    private TextView mTvSubmit;

    private ArrayList<String> mPicPaths = new ArrayList<>();
    private File mTakePhoto;
    private Uri mTakePhotoURI;
    private File mTmpFile;


    @Override
    protected void initView() {
        super.initView();

        mSpChose = findViewById(R.id.tv_type);
        mTvSubmit = findViewById(R.id.tv_submit);
        mLnImage = findViewById(R.id.ln_image);
        mIvImage = findViewById(R.id.iv_image);
        initSpinner();

        click();
    }

    private void click() {
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseStringDialog.getInstance()
                        .setiChooseItem(new ChooseStringView.IChooseItem() {
                            @Override
                            public void position(int position) {
                                FanKuiActivityPermissionsDispatcher.showCameraActionWithPermissionCheck(FanKuiActivity.this);
                                switch (position) {
                                    case 0:
                                        openPhoto();
                                        break;
                                    case 1:
                                        showCameraAction();
                                        break;
                                }
                            }
                        }).addData("相册选择", "拍照").show(FanKuiActivity.this);
            }
        });
    }

    private void initSpinner() {

        final ArrayList<FanKuaiType> mList = new ArrayList<>();
        mList.add((FanKuaiType) new FanKuaiType().setTitle("门锁损毁"));
        mList.add((FanKuaiType) new FanKuaiType().setTitle("设备损毁"));

        mSpChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseStringDialog.getInstance()
                        .setiChooseItem(new ChooseStringView.IChooseItem() {
                            @Override
                            public void position(int position) {
                                mSpChose.setText(mList.get(position).getTitle());
                            }
                        }).addData(mList).show(FanKuiActivity.this);
            }
        });
    }


    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("在线反馈");
    }


    @Override
    protected int getRid() {
        return R.layout.activity_fankui;
    }

    private void openPhoto() {
        /**
         * 打开选择图片的界面
         */
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CROP_PHOTO:
                if (resultCode == RESULT_OK) {
                    showPhoto(mTakePhotoURI);
                }
                break;
            case REQUEST_CODE_PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    showPhoto(uri);
                }
                break;
        }
    }

    private void showPhoto(Uri uri) {
        Bitmap bit = null;
        try {
            bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            String realPathFromUri = FilePathUtils.getRealFilePath(FanKuiActivity.this, uri);
            mPicPaths.add(realPathFromUri);
            View inflate = View.inflate(this, R.layout.item_imageview, null);
            ImageView viewById = inflate.findViewById(R.id.iv_image);
            viewById.setLayoutParams(mIvImage.getLayoutParams());
            viewById.setImageBitmap(bit);
            mLnImage.addView(inflate);
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"程序崩溃",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Open camera
     */
    @NeedsPermission({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE})
    public void showCameraAction() {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(this.getPackageManager()) != null) {
                try {
                    mTmpFile= FileUtils.createTmpFile(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (mTmpFile != null && mTmpFile.exists()) {
                 /*获取当前系统的android版本号*/
                    int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                    Log.e("currentapiVersion","currentapiVersion====>"+currentapiVersion);
                    if (currentapiVersion<24){
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mTmpFile));
                        startActivityForResult(intent, CROP_PHOTO);
                    }else {
                       try {
                           ContentValues contentValues = new ContentValues(1);
                           contentValues.put(MediaStore.Images.Media.DATA, mTmpFile.getAbsolutePath());
                           mTakePhotoURI = getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues);
                           intent.putExtra(MediaStore.EXTRA_OUTPUT, mTakePhotoURI);
                           startActivityForResult(intent, CROP_PHOTO);
                       }catch (Exception e){
                           Toast.makeText(this, "没有权限访问相机,请到后台开启权限", Toast.LENGTH_SHORT).show();
                       }
                    }
                } else {
                    Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this,"没有相机", Toast.LENGTH_SHORT).show();
            }

    }

    @OnShowRationale({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("是否授予相机，读写文件权限?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.cancel();
                    }
                })
                .show();
    }

    @OnPermissionDenied({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE})
    void showDeniedForCamera() {
        Toast.makeText(this,"相机权限被拒，打开相机需要授予权限!", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE})
    void showNeverAskForCamera() {
        Toast.makeText(this, "相机权限被据，不在询问权限!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        FanKuiActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }
}
