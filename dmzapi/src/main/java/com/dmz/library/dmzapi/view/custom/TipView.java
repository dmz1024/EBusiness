package com.dmz.library.dmzapi.view.custom;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;

import java.util.ArrayList;


/**
 * Created by dengmingzhi on 2017/11/7.
 */

public class TipView extends NoTitleDialoggFragment {
    private TextView tvTitle;
    private TextView tvContent;
    private LinearLayout llBottom;

    public static TipView getInstance() {
        return new TipView();
    }


    @Override
    protected int getWPadding() {
        return 300;
    }

    @Override
    protected float dimAmount() {
        return 0.7f;
    }

    @Override
    protected int getRid() {
        return R.layout.dmz_tip_view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        setCancelable(false);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.tvContent);
        llBottom = view.findViewById(R.id.llBottom);
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvTitle.setText(title);
        tvContent.setText(content);

        if (isShowCancel) {
            infos.add(0,new BottomInfo("取消"));
        }

        llBottom.setWeightSum(infos.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1;

        TypedValue typedValue = new TypedValue();
        getContext().getTheme()
                .resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        int[] attribute = new int[]{android.R.attr.selectableItemBackground};
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(typedValue.resourceId, attribute);

        for (int i = 0; i < infos.size(); i++) {
            final BottomInfo info = infos.get(i);
            TextView tv = new TextView(getContext());
            tv.setText(info.getContent());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (info.isDismiss()) {
                        dismiss();
                    }
                    if (info.getClickListener() != null) {
                        info.getClickListener().OnClick();
                    }
                }
            });

            tv.setGravity(Gravity.CENTER);
            tv.setBackgroundDrawable(typedArray.getDrawable(0));
            tv.setTextSize(15);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setLayoutParams(layoutParams);
            llBottom.addView(tv);
        }
    }


    private boolean isShowCancel = true;

    public TipView setShowCancel(boolean showCancel) {
        isShowCancel = showCancel;
        return this;
    }

    private String title = "提示";

    public TipView setTitle(String title) {
        this.title = title;
        return this;
    }

    private String content;

    public TipView setContent(String content) {
        this.content = content;
        return this;
    }

    private ArrayList<BottomInfo> infos = new ArrayList<>();

    public TipView setBottom(ArrayList<BottomInfo> infos) {
        this.infos.addAll(infos);
        return this;
    }

    public TipView setBottom(BottomInfo info) {
        this.infos.add(info);
        return this;
    }

    public TipView setBottom(String... info) {
        for (int i = 0; i < info.length; i++) {
            setBottom(new BottomInfo(info[i]));
        }
        return this;
    }

    public static class BottomInfo {
        private String content;
        private OnClickListener clickListener;
        private boolean isDismiss = true;

        public BottomInfo(String content, OnClickListener clickListener) {
            this.content = content;
            this.clickListener = clickListener;
        }

        public BottomInfo(String content) {
            this.content = content;
        }

        public BottomInfo(String content, OnClickListener clickListener, boolean isDismiss) {
            this.content = content;
            this.clickListener = clickListener;
            this.isDismiss = isDismiss;
        }

        public BottomInfo(String content, boolean isDismiss) {
            this.content = content;
            this.isDismiss = isDismiss;
        }

        public String getContent() {
            return content;
        }

        public OnClickListener getClickListener() {
            return clickListener;
        }

        public boolean isDismiss() {
            return isDismiss;
        }
    }

    public interface OnClickListener {
        void OnClick();
    }

}
