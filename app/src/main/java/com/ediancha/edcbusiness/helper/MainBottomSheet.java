package com.ediancha.edcbusiness.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.LinearLayout;

import com.dmz.library.dmzapi.utils.AnimationUtil;

/**
 * Created by dengmingzhi on 2017/9/20.
 */

public class MainBottomSheet extends BottomSheetBehavior.BottomSheetCallback {

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {
        if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
            AnimationUtil.arrowsAnimation(view, false);
        } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
            AnimationUtil.arrowsAnimation(view, true);
        }
    }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }

    private BottomSheetBehavior bottomSheetBehavior;
    private Context ctx;
    private View view;

    public MainBottomSheet(LinearLayout ll, View view) {
        bottomSheetBehavior = BottomSheetBehavior.from(ll);
        this.ctx = ll.getContext();
        this.view = view;
        bottomSheetBehavior.setBottomSheetCallback(this);
        ll.postDelayed(new Runnable() {
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


    public void close() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }


    public void open() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
