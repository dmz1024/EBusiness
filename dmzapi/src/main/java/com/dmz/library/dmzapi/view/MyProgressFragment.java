package com.dmz.library.dmzapi.view;

import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.TextView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.IProgressInterface;


/**
 * Created by dengmingzhi on 2017/8/25.
 */

public class MyProgressFragment extends DialogFragment {
    private String loading;

    public static MyProgressFragment _instance(String loading) {
        MyProgressFragment fragment = new MyProgressFragment();
        Bundle bundle = new Bundle();
        bundle.putString("loading", loading);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();

        windowParams.dimAmount = 0.0f;
        window.setAttributes(windowParams);

//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//        getDialog().getWindow().setLayout(0, 0);
    }

    private TextView tv_content;
    private ImageView iv_loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_my_progress, null);
        tv_content = view.findViewById(R.id.tv_content);
        iv_loading = view.findViewById(R.id.iv_loading);
        tv_content.setVisibility(View.GONE);
        iv_loading.setImageResource(R.drawable.my_progress_loading);

        tv_content.setText(loading);
        loading = getArguments().getString("loading");

        isSelf = false;
        Animation circle_anim = AnimationUtils.loadAnimation(getContext(), R.anim.anim_progress_round_rotate);
        LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
        circle_anim.setInterpolator(interpolator);
        if (circle_anim != null) {
            iv_loading.startAnimation(circle_anim);  //开始动画
        }
        return view;
    }


    public void error(String error) {
        isSelf = true;
        setCancelable(true);
        iv_loading.setImageResource(R.drawable.my_progress_err);
        tv_content.setText(error);
        tv_content.setVisibility(View.VISIBLE);
        iv_loading.clearAnimation();
    }


    public void waring(String waring) {
        isSelf = true;
        setCancelable(true);
        iv_loading.setImageResource(R.drawable.my_progress_warning);
        tv_content.setText(waring);
        tv_content.setVisibility(View.VISIBLE);
        iv_loading.clearAnimation();
    }


    public void success(String success) {
        isSelf = true;
        setCancelable(true);
        iv_loading.setImageResource(R.drawable.my_progress_success);
        tv_content.setText(success);
        tv_content.setVisibility(View.VISIBLE);
        iv_loading.clearAnimation();
    }

    private boolean isSelf;

    public void close() {
        isSelf = true;
        dismiss();
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
