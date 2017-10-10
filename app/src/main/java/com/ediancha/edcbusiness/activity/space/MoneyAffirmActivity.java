package com.ediancha.edcbusiness.activity.space;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.MoneyAffirmBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengmingzhi on 2017/10/9.
 */

@Route(path = "/activity/sapce/moneyAffirm")
public class MoneyAffirmActivity extends NotNetBaseActivity {
    @Autowired
    MoneyAffirmBean.Data data;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.tvShopName)
    TextView tvShopName;

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("费用确认").addItemView(new DmzBar.DmzBarItemInfo().setTitle("分享"));
    }

    @Override
    protected int getRid() {
        return R.layout.activity_money_affirm;
    }


    @Override
    protected void initData() {
        super.initData();
        tvShopName.setText(data.getSpaceName());
    }


}
