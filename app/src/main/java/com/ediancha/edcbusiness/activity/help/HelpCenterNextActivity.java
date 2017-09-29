package com.ediancha.edcbusiness.activity.help;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.view.activity.MoreDataBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.walletbean.HelpCenterBean;
import com.ediancha.edcbusiness.bean.walletbean.HelpCenterNextBean;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by Admin on 2017/9/29.
 */
@Route(path = "/activity/help/helpCenterNext")
public class HelpCenterNextActivity extends MoreDataBaseActivity<HelpCenterNextBean.Data,HelpCenterNextBean>{

    @Override
    protected void initMoreBuilder() {

        mBuilder
                .addView(new AdapterHelper.ViewTypeInfo().setRid(R.layout.item_helpcenter_go).setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
//        dBuilder.setaClass(HelpCenterNextBean.class)
//                .setUrl()
//                .setParms();
    }

    @Override
    public void convert(int viewType, ViewHolder holder, HelpCenterNextBean.Data data, int position) {

        holder.setText(R.id.tv_title,"");
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

        Go.goWebView();
    }
}
