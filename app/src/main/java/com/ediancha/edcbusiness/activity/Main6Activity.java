package com.ediancha.edcbusiness.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.dmz.library.dmzapi.api.contract.BaseDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.Test1Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Admin
 */
public class Main6Activity extends SingleDataBaseActivity<Test1Bean, ArrayList<Test1Bean.Test>> implements BaseDataBuilder.OnMySuccessListener<ArrayList<Test1Bean.Test>> {
    @BindView(R.id.tvContent)
    TextView tvContent;
    private String url = "http://law.east-profit.com/app.php/home/buleline/allInfo";

    @Override
    protected void initDataBuilder() {
        mBuilder.setOnMySuccessListener(this).setCanRefresh(true).setSuccessRid(R.layout.activity_test);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(Test1Bean.class)
                .setUrl(url)
                .setParms("gid", "10000");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ArrayList<Test1Bean.Test> bean) {
        tvContent.setText(bean.get(0).getAddress());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar
                .setText("单数据请求")
                .addItemView(new DmzBar.DmzBarItemInfo().setTitle("测试"))
                .addItemView(new DmzBar.DmzBarItemInfo().setTitle("测试"));

    }

}
