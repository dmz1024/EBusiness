package com.ediancha.edcbusiness.v1.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Admin on 2017/11/8.
 */

public class DepositDialog extends NoTitleDialoggFragment {

    private okClickListner mOkClickListner;

    @Override
    protected int getRid() {
        return R.layout.dialog_deposit;
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
    }

    @OnClick({R.id.tv_ok, R.id.tv_cancel})
    void click(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                if (mOkClickListner!=null){
                    mOkClickListner.setOnOkListener();
                }
                break;
            case R.id.tv_cancel:
                if (mOkClickListner!=null){
                    mOkClickListner.setOnCancelListener();
                }
                break;
        }
    }

    @Override
    protected int getWPadding() {
        return 150;
    }

    public DepositDialog setOkClickListner(okClickListner okClickListner) {
        mOkClickListner = okClickListner;
        return this;
    }

    public interface okClickListner {
        void setOnOkListener();


        void setOnCancelListener();
    }
}

