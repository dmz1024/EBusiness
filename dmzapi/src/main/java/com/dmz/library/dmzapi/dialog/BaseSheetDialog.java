package com.dmz.library.dmzapi.dialog;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/27.
 */

public class BaseSheetDialog extends NoTitleDialoggFragment {
    protected LinearLayout llRoot;
    protected BottomSheetBehavior<LinearLayout> from;
    protected View itemView;
    @Override
    final protected int getRid() {
        return R.layout.dialog_base_sheet;
    }

    @Override
    final protected View getmView() {
        return super.getmView();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        llRoot = view.findViewById(R.id.llRoot);
        from = BottomSheetBehavior.from(llRoot);


        initSheet();

        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                if (isCanHidden()) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        dismiss();
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        if (getItemRid() != 0) {
            itemView = getLayoutInflater().inflate(getItemRid(), null);
        } else {
            itemView = getItemView();
        }

        llRoot.addView(itemView);
    }

    protected void initSheet() {

    }


    protected View getItemView() {
        return null;
    }

    protected int getItemRid() {
        return 0;
    }


    protected boolean isCanHidden() {
        return true;
    }
}
