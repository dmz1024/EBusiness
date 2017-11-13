package com.ediancha.edcbusiness.v1.activity.help;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.HelpCenterBean;
import com.ediancha.edcbusiness.bean.walletbean.HelpCenterNextBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Admin on 2017/9/29.
 */
@Route(path = "/v1/activity/help/helpCenterNext")
public class HelpCenterNextActivity extends MoreDataBaseActivity<HelpCenterNextBean.Data,HelpCenterNextBean>{

    @Autowired
    public String pid;
    @Autowired
    public String name;
    @Override
    protected void initMoreBuilder() {

        mBuilder
                .addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_helpcenter_go).setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(HelpCenterNextBean.class)
                .setUrl(ApiContant.HELPCENTER_NEXT_URL)
                .setParms("pid",pid);
    }

    @Override
    public void convert(int viewType, ViewHolder holder, HelpCenterNextBean.Data data, int position) {

        holder.setText(R.id.tv_title,data.getTitle());
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

        HelpCenterNextBean.Data helpCenterNextBean = (HelpCenterNextBean.Data) adapterHelper.getDatas().get(position);
        Go.goWebView(helpCenterNextBean.getHtml());
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText(name);
    }
}
