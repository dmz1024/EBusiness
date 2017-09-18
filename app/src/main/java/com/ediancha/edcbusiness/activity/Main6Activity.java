package com.ediancha.edcbusiness.activity;

import android.view.View;
import android.widget.TextView;

import com.dmz.library.dmzapi.api.contract.BaseDataBuilder;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.view.MyProgress;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.Test1Bean;

import java.util.ArrayList;

public class Main6Activity extends SingleDataBaseActivity<Test1Bean, ArrayList<Test1Bean.Test>> implements BaseDataBuilder.OnMySuccessListener<ArrayList<Test1Bean.Test>> {
    private String url = "http://law.east-profit.com/app.php/home/buleline/allInfo";

    @Override
    protected void initMoreBuilder() {
        super.initMoreBuilder();
        mContract.getSuccessView(R.layout.activity_test);
        mBuilder.setOnMySuccessListener(this).setCanRefresh(true).setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW);
    }

    @Override
    protected void initDmzBuilder() {
        super.initDmzBuilder();
        dBuilder.setaClass(Test1Bean.class)
                .setUrl(url)
                .setiLoadingView(new MyProgress(this))
                .setParms("gid", "10000");
    }

    @Override
    public void onSuccess(IBasePresenter presenter, ArrayList<Test1Bean.Test> bean) {
        View successView = mContract.getSuccessView(R.layout.activity_test);
        TextView tvContent = successView.findViewById(R.id.tvContent);
        tvContent.setText(bean.get(0).getAddress());
    }
}
