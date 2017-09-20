package com.ediancha.edcbusiness.helper;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dmz.library.dmzapi.utils.AnimationUtil;
import com.ediancha.edcbusiness.R;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class MainBottomSheet extends BottomSheetBehavior.BottomSheetCallback {

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {
        if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
            AnimationUtil.rotationX(iv_arrows, false);
        } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
            AnimationUtil.rotationX(iv_arrows, true);
        }
    }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }

    private BottomSheetBehavior bottomSheetBehavior;
    private Context ctx;
    private ImageView iv_arrows;

    public MainBottomSheet(LinearLayout ll) {
        bottomSheetBehavior = BottomSheetBehavior.from(ll);
        this.ctx = ll.getContext();
        this.iv_arrows = ((Activity) this.ctx).findViewById(R.id.iv_arrows);
        bottomSheetBehavior.setBottomSheetCallback(this);
        iv_arrows.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }, 500);
    }


    public void toggle() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
