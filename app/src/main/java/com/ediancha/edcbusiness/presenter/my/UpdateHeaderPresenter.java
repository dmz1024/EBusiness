package com.ediancha.edcbusiness.presenter.my;

import android.util.Log;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.upload.UploadFile;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.ediancha.edcbusiness.bean.UpdateHeaderBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/10.
 */

public class UpdateHeaderPresenter {

    private IUpdateHeaderView mIUpdateHeaderView;
    public UpdateHeaderPresenter(IUpdateHeaderView iUpdateHeaderView){
        this.mIUpdateHeaderView=iUpdateHeaderView;
    }
    public void updateHeader(String path){
//        上传图片
        UploadFile start = UploadFile.getInstance()
                .setFilePath(path)
                .setDmzBuilder(
                        DmzBuilder._builder()
                                .setOnMySuccessListener(new OnMySuccessListener<UploadFile.UpLoadMoreBean.Data>() {
                                    @Override
                                    public void onSuccess(UploadFile.UpLoadMoreBean.Data bean) {
                                        Log.d("上传图片地址", bean.getUrl() + "--");
                                        mIUpdateHeaderView.success(bean.getUrl());
                                    }
                                })
                                .setUrl("http://s.east-profit.com/api.php/Upload/uploadfile")
                )
                .setiOnLoadFinish(new UploadFile.IOnLoadFinish() {
                    @Override
                    public void result(int index, boolean isSuccess) {
                        Log.d("上传图片" + index, isSuccess ? "成功" : "失败");
                    }
                })
                .setiOnLoadProgress(new UploadFile.IOnLoadProgress() {
                    @Override
                    public void progress(int index, long totalSize, long currentSize, String fraction, float ffraction) {
                        Log.d("上传图片" + index, "上传进度：" + fraction);
                    }
                })
                .setKey("file")
                .start();
    }
    public interface IUpdateHeaderView extends IContextView{
        void success(String path);
    }
}
