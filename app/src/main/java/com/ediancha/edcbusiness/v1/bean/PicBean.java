package com.ediancha.edcbusiness.v1.bean;

import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/11/16.
 */

public class PicBean extends ViewBaseType {
    private String url;
    private String id;
    private boolean right=false;
    private int res;

    public PicBean(int res) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }

    public PicBean setRes(int res) {
        this.res = res;
        return this;
    }

    public boolean isRight() {
        return right;
    }

    public PicBean setRight(boolean right) {
        this.right = right;
        return this;
    }

    public PicBean(String url, String id) {
        this.url = url;
        this.id = id;
    }



    public PicBean(String url) {
        this.url = url;
    }

    @Override
    public int getViewType() {
        return 1;
    }

    public String getUrl() {
        return url;
    }

    public PicBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getId() {
        return id;
    }

    public PicBean setId(String id) {
        this.id = id;
        return this;
    }
}
