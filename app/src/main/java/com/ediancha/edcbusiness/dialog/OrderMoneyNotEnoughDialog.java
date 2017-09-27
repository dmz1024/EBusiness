package com.ediancha.edcbusiness.dialog;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

/**
 * Created by dengmingzhi on 2017/9/26.
 */

public class OrderMoneyNotEnoughDialog extends NoTitleDialoggFragment {
    @Override
    protected int getRid() {
        return R.layout.dialog_order_money_not_enough;
    }


    @Override
    protected int getWPadding() {
        return 150;
    }

}
