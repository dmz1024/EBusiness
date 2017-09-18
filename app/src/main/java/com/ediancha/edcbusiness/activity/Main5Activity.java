package com.ediancha.edcbusiness.activity;

import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.MyProgress;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.TestBean;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class Main5Activity extends MoreDataBaseActivity<TestBean.Test, TestBean> {
    private String url = "http://law.east-profit.com/app.php/home/buleline/allInfo";

    @Override
    protected void initDmzBuilder() {
        super.initDmzBuilder();
        dBuilder.setaClass(TestBean.class)
                .setUrl(url)
                .setParms("gid", "10000");
    }

    @Override
    protected void initMoreBuilder() {
        super.initMoreBuilder();
        mBuilder.setSize(20)
                .addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_test)
                        .setConvertInterface(this));
    }


    @Override
    public void convert(int viewType, ViewHolder holder, TestBean.Test test, int position) {
        holder.setText(R.id.tvContent, test.getAddress() + position);
    }


    @Override
    protected String getBarTitle() {
        return "地区";
    }

}
