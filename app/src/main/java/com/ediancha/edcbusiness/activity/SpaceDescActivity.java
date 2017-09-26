package com.ediancha.edcbusiness.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.BaseDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.Test1Bean;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

@Route(path = "/activity/space_desc")
public class SpaceDescActivity extends SingleDataBaseActivity<Test1Bean, ArrayList<Test1Bean.Test>> implements BaseDataBuilder.OnMySuccessListener<ArrayList<Test1Bean.Test>> {
    private String url = "http://law.east-profit.com/app.php/home/buleline/allInfo";

    @Override
    protected int getRid() {
        return R.layout.activity_space_desc;
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setOnMySuccessListener(this).setCanRefresh(false).setSuccessRid(R.layout.success_space_desc_view);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(Test1Bean.class)
                .setUrl(url)
                .setParms("gid", "10000");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ArrayList<Test1Bean.Test> bean) {

    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("云集空间");
    }
}
