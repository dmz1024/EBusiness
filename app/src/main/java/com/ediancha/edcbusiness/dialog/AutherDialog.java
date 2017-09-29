package com.ediancha.edcbusiness.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/9/28.
 * <p>
 * 认证Dialog
 */

public class AutherDialog extends NoTitleDialoggFragment {


    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_card)
    TextView mTvCard;
    @BindView(R.id.tv_info)
    TextView mTvInfo;
    @BindView(R.id.tv_back)
    TextView mTvBack;
    @BindView(R.id.tv_ok)
    TextView mTvOk;

    private backClickListner mBackClickListner;
    private okClickListner mOkClickListner;

    String name;
    String card;

    @Override
    protected void initData(View view) {
        super.initData(view);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mTvName.setText("真实姓名  " + name);
        mTvCard.setText("身份证号  " + card);
    }


    public AutherDialog setOkClickListner(okClickListner okClickListner) {
        mOkClickListner = okClickListner;
        return this;
    }

    @Override
    protected int getRid() {
        return R.layout.dialog_auther;
    }

    @Override
    protected int getWPadding() {
        return 100;
    }


    public AutherDialog setCard(String card) {
        this.card = card;
        return this;
    }

    public AutherDialog setName(String name) {
        this.name = name;
        return this;
    }

    @OnClick({R.id.tv_back,R.id.tv_ok})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                dismiss();
                break;
            case R.id.tv_ok:
                if (mOkClickListner != null) {
                    mOkClickListner.setOnOkListener();
                }
                break;
        }
    }

    public interface backClickListner {
        void setOnBackListener();
    }

    public interface okClickListner {
        void setOnOkListener();
    }


}
