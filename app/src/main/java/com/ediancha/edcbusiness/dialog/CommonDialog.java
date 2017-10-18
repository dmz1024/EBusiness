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
 * Created by Admin on 2017/10/18.
 */

public class CommonDialog extends NoTitleDialoggFragment {


    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_ok)
    TextView mTvOk;


    private String title, mOk, mCancel;
    private OnClickListener mOnClickListener;


    public CommonDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CommonDialog setOk(String ok) {
        mOk = ok;
        return this;
    }

    public CommonDialog setCancel(String cancel) {
        mCancel = cancel;
        return this;
    }

    @Override
    protected void initData(View view) {
        super.initData(view);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        mTvCancel.setText(mCancel != null ? mCancel : "取消");
        mTvOk.setText(mOk != null ? mOk : "确定");
        mTvTitle.setText(title!=null?title:"提示信息!");
    }

    @Override
    protected int getRid() {
        return R.layout.dialog_common;
    }

    public CommonDialog setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
        return this;
    }

    @Override
    protected int getWPadding() {
        return 150;
    }

    @OnClick({R.id.tv_ok, R.id.tv_cancel})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_ok:
                mOnClickListener.setOnClickRightListener();
                break;
        }
    }

    public interface OnClickListener {

        void setOnClickRightListener();
    }

}
