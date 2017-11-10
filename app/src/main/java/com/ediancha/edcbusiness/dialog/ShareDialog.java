package com.ediancha.edcbusiness.dialog;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/10/18.
 */

public class ShareDialog extends NoTitleDialoggFragment {


    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.recy)
    RecyclerView mRecy;

    @Override
    protected void initData(View view) {
        super.initData(view);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

    }

    @Override
    protected int getRid() {
        return R.layout.dialog_share;
    }

    @Override
    protected int getGravity() {
        return super.getGravity();
    }

}
