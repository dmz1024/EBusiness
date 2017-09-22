package com.dmz.library.dmzapi.view.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.utils.ScreenUtil;

import java.security.acl.Group;
import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/14.
 */

public class DmzBar extends FrameLayout implements View.OnClickListener {
    private LayoutInflater layoutInflater;
    private FrameLayout fgBarLeft;
    private ImageView ivBarLeft;
    private LinearLayout llBarRight;
    private TextView tvBarTitle;

    public DmzBar(Context context) {
        this(context, null);
    }

    public DmzBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        layoutInflater = ((AppCompatActivity) context).getLayoutInflater();
        layoutInflater.inflate(R.layout.view_dmz_bar, this);
        fgBarLeft = findViewById(R.id.fgBarLeft);
        ivBarLeft = findViewById(R.id.ivBarLeft);
        llBarRight = findViewById(R.id.llBarRight);
        tvBarTitle = findViewById(R.id.tvBarTitle);
        initView(context);
        setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void initView(Context context) {
        fgBarLeft.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        ((Activity) getContext()).finish();
    }


    public DmzBar setText(String text) {
        tvBarTitle.setText(text);
        return this;
    }

    public RelativeLayout getRoot() {
        return ((RelativeLayout) getChildAt(0));
    }

    public DmzBar setRootColor(String color) {
        setBackgroundColor(Color.parseColor(color));
        return this;
    }


    public DmzBar setText(int id) {
        return setText(getContext().getString(id));
    }

    public FrameLayout getFgBarLeft() {
        return fgBarLeft;
    }

    public ImageView getIvBarLeft() {
        return ivBarLeft;
    }

    public TextView getTvBarTitle() {
        return tvBarTitle;
    }

    public DmzBar setTextColor(String color) {
        tvBarTitle.setTextColor(Color.parseColor(color));
        return this;
    }

    public LinearLayout getLlBarRight() {
        return llBarRight;
    }

    public DmzBar setLeftImage(int rid) {
        ivBarLeft.setImageResource(rid);
        return this;
    }

    private ViewGroup.LayoutParams itemLayoutParam;

    public DmzBar addItemView(DmzBarItemInfo info) {

        if (info.getIid() != 0) {
            if (itemLayoutParam == null) {
                itemLayoutParam = new ViewGroup.LayoutParams(ScreenUtil.dp2px(20), ScreenUtil.dp2px(20));
            }

            ImageView iv = new ImageView(getContext());
            iv.setLayoutParams(itemLayoutParam);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(info.getIid());
            llBarRight.addView(iv);
        } else {
            TextView tv = new TextView(getContext());
            tv.setText(info.getTitle());
            tv.setTextColor(Color.parseColor(info.getTvColor()));
            tv.setTextSize(info.getTvSize());
            llBarRight.addView(tv);
        }

        return this;
    }

    public DmzBar addItemView(ArrayList<DmzBarItemInfo> infos) {
        for (int i = 0; i < infos.size(); i++) {
            addItemView(infos.get(i));
        }
        return this;
    }


    public static class DmzBarItemInfo {
        private String title;
        private int iid;
        private boolean isLine;
        private String tvColor = "#666666";
        private float tvSize = 12;

        public DmzBarItemInfo setTvColor(String tvColor) {
            this.tvColor = tvColor;
            return this;
        }

        public DmzBarItemInfo setTvSize(float tvSize) {
            this.tvSize = tvSize;
            return this;
        }

        public float getTvSize() {
            return tvSize;
        }

        public String getTvColor() {
            return tvColor;
        }

        public String getTitle() {
            return title;
        }

        public DmzBarItemInfo setTitle(String title) {
            this.title = title;
            return this;
        }


        public int getIid() {
            return iid;
        }

        public DmzBarItemInfo setIid(int iid) {
            this.iid = iid;
            return this;
        }

        public boolean isLine() {
            return isLine;
        }

        public DmzBarItemInfo setLine(boolean line) {
            isLine = line;
            return this;
        }
    }

}
