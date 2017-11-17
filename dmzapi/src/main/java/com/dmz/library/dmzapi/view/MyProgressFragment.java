package com.dmz.library.dmzapi.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.IProgressInterface;


/**
 * Created by dengmingzhi on 2017/8/25.
 */

public class MyProgressFragment extends NoTitleDialoggFragment {
    private String loading;

    public static MyProgressFragment _instance(String loading) {
        MyProgressFragment fragment = new MyProgressFragment();
        Bundle bundle = new Bundle();
        bundle.putString("loading", loading);
        fragment.setArguments(bundle);
        return fragment;
    }


//    @Override
//    protected float dimAmount() {
//        return 0.0f;
//    }

    @Override
    protected void initBundle(Bundle arguments) {
        super.initBundle(arguments);
        loading = arguments.getString("loading");
    }

    @Override
    protected int getRid() {
        return R.layout.fragment_my_progress;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        ((RelativeLayout.LayoutParams) view.findViewById(R.id.fgRoot).getLayoutParams()).topMargin = (int) (getWH(getContext())[1] * 0.1f);

        iv_loading = view.findViewById(R.id.iv_loading);
        iv_loading.setImageResource(R.drawable.my_progress_loading);
        isSelf = false;
        Animation circle_anim = AnimationUtils.loadAnimation(getContext(), R.anim.anim_progress_round_rotate);
        LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
        circle_anim.setInterpolator(interpolator);
        if (circle_anim != null) {
            iv_loading.startAnimation(circle_anim);  //开始动画
        }
    }

    private ImageView iv_loading;


    private boolean isSelf;

    public void close() {
        isSelf = true;
        dismiss();
    }

    @Override
    protected int getH() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!isSelf && listener != null) {
            listener.cancel();
        }
    }

    private IProgressInterface.OnProgressCancelListener listener;

    public void setListener(IProgressInterface.OnProgressCancelListener listener) {
        this.listener = listener;

    }
}
