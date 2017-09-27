package com.ediancha.edcbusiness.activity.help;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.FanKuaiType;
import com.ediancha.edcbusiness.helper.PhotoHelper;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Admin on 2017/9/27.
 */
@Route(path = "/activity/help/fankui")
public class FanKuiActivity extends NotNetBaseActivity {

    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.ln_image)
    LinearLayout mLnImage;
    @BindView(R.id.iv_image)
    ImageView mIvImage;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    private ArrayList<String> mPicPaths = new ArrayList<>();
    private PhotoHelper mHelper;

    @Override
    protected void initView() {
        super.initView();
        initSpinner();
        click();
        mHelper = mHelper == null ? new PhotoHelper(this) : mHelper;
    }

    private void click() {
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseStringDialog.getInstance()
                        .setiChooseItem(new ChooseStringView.IChooseItem() {
                            @Override
                            public void position(int position) {
                                switch (position) {
                                    case 0:
                                        mHelper.openPhoto();
                                        break;
                                    case 1:
                                        mHelper.showCameraAction();
                                        break;
                                }
                            }
                        }).addData("相册选择", "拍照").show(FanKuiActivity.this);
            }
        });
    }

    private void initSpinner() {
        mTvType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseStringDialog.getInstance().setiChooseItem(new ChooseStringView.IChooseItemTitle() {
                    @Override
                    public void content(int position, ChooseStringView.IChooseString title) {
                        mTvType.setText(title.getTitle());
                    }
                }).addData("门锁损毁", "设备损毁").show(FanKuiActivity.this);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mHelper.chcckPhoto(requestCode,resultCode)){
           String path= mHelper.onActivityResult(requestCode,data);
            mPicPaths.add(path);
            View inflate = View.inflate(this, R.layout.item_imageview, null);
            ImageView viewById = inflate.findViewById(R.id.iv_image);
            viewById.setLayoutParams(mIvImage.getLayoutParams());
            Glide.with(this)
                    .load(path)
                    .into(viewById);
            mLnImage.addView(inflate);
        }
    }
}
