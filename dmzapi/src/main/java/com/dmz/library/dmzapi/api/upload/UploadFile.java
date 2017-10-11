package com.dmz.library.dmzapi.api.upload;

import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.utils.MyToast;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dengmingzhi on 2017/10/10.
 */

public class UploadFile {

    private String key = "file[]";
    private DmzBuilder dmzBuilder;
    private boolean isAll = true;


    public UploadFile setFilePath(ArrayList<File> files) {
        this.files = files;
        return this;
    }

    public UploadFile setDmzBuilder(DmzBuilder dmzBuilder) {
        this.dmzBuilder = dmzBuilder;
        return this;
    }

    public UploadFile setAll(boolean all) {
        isAll = all;
        return this;
    }

    private ArrayList<File> files;

    public UploadFile setFilePath(String... filePath) {
        if (files == null) {
            files = new ArrayList<>();
        }
        for (int i = 0; i < filePath.length; i++) {
            files.add(new File(filePath[i]));
        }
        return this;
    }

    public UploadFile setKey(String key) {
        this.key = key;
        return this;
    }

    public static UploadFile getInstance() {
        return new UploadFile();
    }

    private int currentPath;
    private boolean isSuccess = true;

    public UploadFile start() {
        if (dmzBuilder.getaClass() == null) {
            dmzBuilder.setaClass(UpLoadMoreBean.class);
        }

        dmzBuilder.setSign(this);
        OkGo.<String>post(dmzBuilder.getUrl())
                .tag(dmzBuilder.getSign())
                .isMultipart(true)
                .params(dmzBuilder.getMap())
                .addFileParams(key, isAll ? files : files.subList(currentPath, currentPath + 1))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d("上传图片", response.body());
                        IBaseBean iBaseBean = (IBaseBean) JSON.parseObject(response.body(), dmzBuilder.getaClass());
                        if (iBaseBean.getCode() == dmzBuilder.getCode()) {
                            if (dmzBuilder.getOnMySuccessListener() != null) {
                                dmzBuilder.getOnMySuccessListener().onSuccess(dmzBuilder.isAll() ? iBaseBean : (isAll?iBaseBean.getData(): ((ArrayList) iBaseBean.getData()).get(0)));
                            }
                        } else {
                            MyToast.warn(iBaseBean.getMsg());
                            if (dmzBuilder.getOnMyOtherCodeListener() != null) {
                                dmzBuilder.getOnMyOtherCodeListener().onOther(iBaseBean);
                            }
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        response.getException().printStackTrace();
                        isSuccess = false;
                    }

                    @Override
                    public void onFinish() {
                        if (iOnLoadFinish != null) {
                            iOnLoadFinish.result(currentPath, isSuccess);
                        }

                        if (iMoreOnLoadFinish != null) {
                            iMoreOnLoadFinish.result(isSuccess);
                        }

                        if (!isAll) {
                            currentPath += 1;
                            if (currentPath != files.size()) {
                                start();
                            }
                        }
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        if (iOnLoadProgress != null) {
                            iOnLoadProgress.progress(currentPath, progress.totalSize, progress.currentSize, ((int) (progress.fraction * 100)) + "%", progress.fraction);
                        }
                        if (iMoreOnLoadProgress != null) {
                            iMoreOnLoadProgress.progress(progress.totalSize, progress.currentSize, ((int) (progress.fraction * 100)) + "%", progress.fraction);
                        }
                    }
                });

        return this;
    }


    private IOnLoadProgress iOnLoadProgress;
    private IOnLoadFinish iOnLoadFinish;

    private IMoreOnLoadProgress iMoreOnLoadProgress;
    private IMoreOnLoadFinish iMoreOnLoadFinish;

    public UploadFile setiOnLoadFinish(IOnLoadFinish iOnLoadFinish) {
        this.iMoreOnLoadFinish = null;
        this.iMoreOnLoadProgress = null;
        this.iOnLoadFinish = iOnLoadFinish;
        this.isAll = false;
        return this;
    }

    public UploadFile setiOnLoadProgress(IOnLoadProgress iOnLoadProgress) {
        this.iMoreOnLoadProgress = null;
        this.iMoreOnLoadFinish = null;
        this.iOnLoadProgress = iOnLoadProgress;
        this.isAll = false;
        return this;
    }


    public UploadFile setiOnLoadFinish(IMoreOnLoadFinish iOnLoadFinish) {
        this.iOnLoadFinish = null;
        this.iOnLoadProgress = null;
        this.iMoreOnLoadFinish = iOnLoadFinish;
        this.isAll = true;
        return this;
    }

    public UploadFile setiOnLoadProgress(IMoreOnLoadProgress iOnLoadProgress) {
        this.iOnLoadFinish = null;
        this.iOnLoadProgress = null;
        this.iMoreOnLoadProgress = iOnLoadProgress;
        this.isAll = true;
        return this;
    }


    public interface IOnLoadProgress {
        void progress(int index, long totalSize, long currentSize, String fraction, float ffraction);
    }

    public interface IOnLoadFinish {
        void result(int index, boolean isSuccess);
    }

    public interface IMoreOnLoadProgress {
        void progress(long totalSize, long currentSize, String fraction, float ffraction);
    }

    public interface IMoreOnLoadFinish {
        void result(boolean isSuccess);
    }


    public static void cancel(Object object) {
        OkGo.getInstance().cancelTag(object);
    }


    public static class UpLoadMoreBean extends BaseBean<ArrayList<UpLoadMoreBean.Data>> {
        public static class Data {
            public String url;

            public String getUrl() {
                return url;
            }
        }

    }

//    public static class UpLoadSingleBean extends BaseBean<UpLoadSingleBean.Data> {
//        public static class Data {
//            public String url;
//
//            public String getUrl() {
//                return url;
//            }
//        }
//    }
}
