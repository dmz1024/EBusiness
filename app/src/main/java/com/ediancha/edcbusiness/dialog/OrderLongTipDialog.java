package com.ediancha.edcbusiness.dialog;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dengmingzhi on 2017/9/26.
 */

public class OrderLongTipDialog extends NoTitleDialoggFragment {
    @BindView(R.id.ivCha)
    ImageView ivCha;

    @Override
    protected int getRid() {
        return R.layout.dialog_order_long_tip;
    }


    @Override
    protected int getWPadding() {
        return 150;
    }

    @OnClick(R.id.btOut)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btOut:
                OrderMoneyNotEnoughDialog dialog = new OrderMoneyNotEnoughDialog();
                dialog.show(getChildFragmentManager(), "orderDialog");
                break;
        }
    }
}
