package com.dmz.library.dmzapi.api.upload;

import com.lzy.okgo.OkGo;

/**
 * Created by dengmingzhi on 2017/10/10.
 */

public class UploadFile {
    private String url;
    private String[] filePath;
    private String key = "file";

    public UploadFile setFilePath(String[] filePath) {
        this.filePath = filePath;
        return this;
    }

    public UploadFile setKey(String key) {
        this.key = key;
        return this;
    }

    public static UploadFile getInstance() {
        return new UploadFile();
    }

    public UploadFile setUrl(String url) {
        this.url = url;
        return this;
    }


    public void start(String... file) {
//        OkGo.get()
    }
}
