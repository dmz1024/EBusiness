package com.dmz.library.dmzapi.api;


/**
 * Created by dengmingzhi on 2017/7/7.
 */

public class ApiPageConfig {
    private int page = 1;
    private int size = 10;
    private String pageKey = "page";
    private String sizeKey = "size";


    private ApiPageConfig() {
    }


    public ApiPageConfig setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getPageKey() {
        return pageKey;
    }

    public String getSizeKey() {
        return sizeKey;
    }

    public static ApiPageConfig.Builder build() {
        return new ApiPageConfig.Builder();
    }


    private ApiPageConfig(Builder builder) {
        this.page = builder.page;
        this.size = builder.size;
        this.pageKey = builder.pageKey;
        this.sizeKey = builder.sizeKey;
    }

    public static class Builder {
        private int page = 1;
        private int size = 5;
        private String pageKey = "page";
        private String sizeKey = "size";


        public Builder setPage(int page) {
            this.page = page;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPageKey(String pageKey) {
            this.pageKey = pageKey;
            return this;
        }

        public Builder setSizeKey(String sizeKey) {
            this.sizeKey = sizeKey;
            return this;
        }

        public ApiPageConfig creat() {
            return new ApiPageConfig(this);
        }
    }

}
