package com.ediancha.edcbusiness.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dengmingzhi on 2017/9/26.
 */

public class OrderMoneyNotEnoughDialog extends NoTitleDialoggFragment {
    @BindView(R.id.ivCha)
    ImageView ivCha;
    @BindView(R.id.tvMoney)
    TextView tvMoney;

    @Override
    protected int getRid() {
        return R.layout.dialog_order_money_not_enough;
    }


    @Override
    protected int getWPadding() {
        return 150;
    }

    @OnClick({R.id.btChoog})
    void choose(View view) {
        switch (view.getId()) {
            case R.id.btChoog:
                ChooseStringDialog stringDialog = new ChooseStringDialog();
                stringDialog.show(getChildFragmentManager(), "choose");
                break;
        }
    }
}
