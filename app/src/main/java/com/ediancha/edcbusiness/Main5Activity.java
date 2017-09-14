package com.ediancha.edcbusiness;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.MoreDataBuilder;
import com.dmz.library.dmzapi.api.list.MoreDataContract;
import com.dmz.library.dmzapi.view.MyProgress;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class Main5Activity extends AppCompatActivity implements AdapterHelper.OnConvertInterface<TestBean.Test>, OnMySuccessListener<TestBean> {
    private String url = "http://law.east-profit.com/app.php/home/buleline/allInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        SwipeRefreshLayout wsRoot = findViewById(R.id.swRoot);
        RecyclerView rvRoot = findViewById(R.id.rvRoot);

        DmzBuilder dmzBuilder = DmzBuilder._builder()
                .setaClass(TestBean.class)
                .setiLoadingView(new MyProgress(this))
                .setUrl(url)
                .setParms("gid", "10000");

        MoreDataBuilder moreDataBuilder = MoreDataBuilder._build()
                .setSize(20)
                .setDmzBuilder(dmzBuilder)
                .setOnMySuccessListener(this)
                .addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_test)
                        .setConvertInterface(this));

        MoreDataContract moreDataContract = MoreDataContract.<TestBean>_instance(this, rvRoot, wsRoot).setMoreDataBuilder(moreDataBuilder)._init(true);


    }

    @Override
    public void convert(int viewType, ViewHolder holder, TestBean.Test test, int position) {
        holder.setText(R.id.tvContent, test.getAddress());
    }

    @Override
    public void onSuccess(TestBean bean) {
        Log.d("内容", bean.getCode() + "");
    }
}
