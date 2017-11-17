package com.ediancha.edcbusiness.v1.activity.help;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.upload.UploadFile;
import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.ediancha.edcbusiness.helper.PhotoHelper;
import com.ediancha.edcbusiness.v1.bean.PicBean;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Admin on 2017/9/27.
 */
@Route(path = "/v1/activity/help/fankui")
public class FanKuiActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener {

    @BindView(R.id.dmzBar)
    DmzBar mDmzBar;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.ln_et)
    LinearLayout mLnEt;
    @BindView(R.id.recy_pic)
    RecyclerView mRecyPic;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    private ArrayList<PicBean> mPicPaths = new ArrayList<>();
    private PhotoHelper mHelper;
    AdapterHelper mAdapterHelper;

    @Override
    protected void initView() {
        super.initView();
        initSpinner();
        mHelper = mHelper == null ? new PhotoHelper(this) : mHelper;

        mPicPaths.add(new PicBean(R.mipmap.zxfk_tjtp_pic).setRight(true));
        mAdapterHelper = AdapterHelper._instance(ctx, mRecyPic)
                ._initData(mPicPaths).setLayoutManager(new GridLayoutManager(ctx, 3))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_imageview)
                        .setConvertInterface(this)
                        .setOnClickListener(this));
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
                }).setGravity(Gravity.CENTER).addData("门锁损毁", "设备损毁").show(FanKuiActivity.this);
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

    private UploadFile uploadFile;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mHelper.chcckPhoto(requestCode, resultCode)) {
            String path = mHelper.onActivityResult(requestCode, data);
            mPicPaths.add(mPicPaths.size() - 1, new PicBean(path));
            mAdapterHelper.notifyDataSetChanged();

            //上传图片
//            uploadFile = UploadFile.getInstance()
//                    .setFilePath(path, path)
//                    .setDmzBuilder(
//                            DmzBuilder._builder()
//                                    .setOnMySuccessListener(new OnMySuccessListener<UploadFile.UpLoadMoreBean.Data>() {
//                                        @Override
//                                        public void onSuccess(UploadFile.UpLoadMoreBean.Data bean) {
//                                            Log.d("上传图片地址", bean.getUrl() + "--");
//                                        }
//                                    })
//                                    .setParms("param", "feedback")
//                                    .setUrl("http://s.east-profit.com/api.php/Upload/uploadfile")
//                    )
//                    .setiOnLoadFinish(new UploadFile.IOnLoadFinish() {
//                        @Override
//                        public void result(int index, boolean isSuccess) {
//                            Log.d("上传图片" + index, isSuccess ? "成功" : "失败");
//                        }
//                    })
//                    .setiOnLoadProgress(new UploadFile.IOnLoadProgress() {
//                        @Override
//                        public void progress(int index, long totalSize, long currentSize, String fraction, float ffraction) {
//                            Log.d("上传图片" + index, "上传进度：" + fraction);
//                        }
//                    })
//                    .start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UploadFile.cancel(uploadFile);
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, final int position) {
        final PicBean picBean = (PicBean) iType;
        holder.setVisible(R.id.img_delete, picBean.isRight() == true ? false : true);
        ImageLoader.loadImageRec(ctx, picBean.isRight() ? picBean.getRes() : picBean.getUrl(), holder.<ImageView>getView(R.id.iv_image));
        holder.<ImageView>getView(R.id.img_delete)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPicPaths.remove(position);
                        mAdapterHelper.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        if (position == mAdapterHelper.getDatas().size() - 1) {
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
    }
}
