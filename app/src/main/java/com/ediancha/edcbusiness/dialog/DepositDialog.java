package com.ediancha.edcbusiness.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/9/25.
 */

public class DepositDialog extends NoTitleDialoggFragment {


    @BindView(R.id.iv_style)
    ImageView mIvStyle;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.tv_ok)
    TextView mTvOk;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
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
                dismiss();
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
    }
}
