package com.dmz.library.dmzapi.view;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by dengmingzhi on 2017/8/27.
 */

public class NoTitleDialoggFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        int rid = getRid();
        View view;
        if (rid == 0) {
            view = getmView();
        } else {
            view = inflater.inflate(getRid(), container, false);
        }

        initBundle(getArguments());
        initView(view);
        initData(view);
        return view;
    }

    protected void initData(View view) {
    }

    protected void initBundle(Bundle arguments) {
    }

    protected View getmView() {
        return null;
    }

    protected void initView(View view) {
    }

    protected int getRid() {
        return 0;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable(new ColorDrawable());

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = getGravity();
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕


        params.width = getWH(getContext())[0] - getWPadding();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        win.setAttributes(params);
    }

    protected int getWPadding() {
        return 0;
    }

    protected int getGravity() {
        return Gravity.CENTER;
    }


    public int[] getWH(Context ctx) {
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return new int[]{width, height};
    }
}
