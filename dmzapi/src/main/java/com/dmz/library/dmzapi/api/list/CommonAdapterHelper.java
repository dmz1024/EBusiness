package com.dmz.library.dmzapi.api.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.bean.IBaseBean;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.dmz.library.dmzapi.utils.FileUtil;
import com.dmz.library.dmzapi.utils.ResUtil;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class CommonAdapterHelper {
//    private ArrayList<IType> datas;
//
//    private CommonAdapterHelper(ArrayList<IType> datas) {
//        this.datas = datas;
//    }
//
//    public static CommonAdapterHelper getHelper(ArrayList<IType> datas){
//        return new CommonAdapterHelper(datas);
//    }
//
//    public CommonAdapterHelper _init(RecyclerView rvContent){
//        dapterHelper adapterHelper = AdapterHelper._instance(this, rvContent)
//                ._initData(datas)
//                .setLayoutManager(new LinearLayoutManager(this))
//                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_person_center_info).setConvertInterface(this))
//                .setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.item_title_view).setConvertInterface(this));
//    }
//
//

    public static class CommonBean extends ViewBaseType {
        public String title;
        public String leftImage;
        public String content;
        public int layout;
        public int icon;

        public CommonBean setIcon(int icon) {
            this.icon = icon;
            return this;
        }

        public int getIcon() {
            return icon;
        }

        public CommonBean setLayout(int layout) {
            this.layout = layout;
            return this;
        }

        public CommonBean setLeftImage(String leftImage) {
            this.leftImage = leftImage;
            return this;
        }

        public CommonBean setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public CommonBean setContent(String content) {
            this.content = content;
            return this;
        }

        public int getLayoutId() {
            if (layout == 0) {
                return ResUtil.getLayoutId(getViewType());
            }
            return layout;
        }

        public String getTitle() {
            return title;
        }

        public String getLeftImage() {
            return leftImage;
        }

        @Override
        public CommonBean setViewType(int type) {
            super.setViewType(type);
            return this;
        }
    }


    public static ArrayList<CommonBean> getDatas(Context ctx, String jsonName) {
        String json = FileUtil.getJson(ctx, jsonName);
        return (ArrayList<CommonBean>) JSON.parseArray(json, CommonBean.class);
    }

}
